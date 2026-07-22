import java.util.*;
import java.util.regex.*;

public class EquationOptimizer {
    static int A, B, C, D, E, F; // Coefficients for x^2, xy, y^2, x, y, constant

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) {
            System.out.println(0);
            sc.close();
            return;
        }
        String expr = sc.nextLine().replaceAll("\\s+", ""); // remove spaces

        parseExpression(expr);

        int originalOps = countOpsOriginal();
        int minOps = originalOps;

        int f1 = tryForm1();
        if (f1 != -1 && f1 < minOps) minOps = f1;

        int f2 = tryForm2();
        if (f2 != -1 && f2 < minOps) minOps = f2;

        int f3 = tryForm3();
        if (f3 != -1 && f3 < minOps) minOps = f3;

        System.out.println(minOps);
        sc.close();
    }

    static void parseExpression(String expr) {
        A = B = C = D = E = F = 0;
        expr = expr.replaceAll("([0-9])([xy])", "$1*$2");
        expr = expr.replaceAll("([xy])([xy])", "$1*$2");

        List<String> terms = new ArrayList<>();
        Matcher m = Pattern.compile("[+-]?[^+-]+").matcher(expr);
        while (m.find()) {
            terms.add(m.group());
        }

        for (String term : terms) {
            if (term.isEmpty()) continue;
            int sign = 1;
            if (term.startsWith("+")) term = term.substring(1);
            else if (term.startsWith("-")) {
                sign = -1;
                term = term.substring(1);
            }

            if (term.matches("\\d+")) {
                F += sign * Integer.parseInt(term);
                continue;
            }

            String[] factors = term.split("\\*");
            int coeff = 1;
            int xCount = 0, yCount = 0;

            for (String factor : factors) {
                if (factor.equals("x")) xCount++;
                else if (factor.equals("y")) yCount++;
                else coeff *= Integer.parseInt(factor);
            }

            if (xCount == 2 && yCount == 0) A += sign * coeff;
            else if (xCount == 1 && yCount == 1) B += sign * coeff;
            else if (xCount == 0 && yCount == 2) C += sign * coeff;
            else if (xCount == 1 && yCount == 0) D += sign * coeff;
            else if (xCount == 0 && yCount == 1) E += sign * coeff;
            else if (xCount == 0 && yCount == 0) F += sign * coeff;
        }
    }

    static int countOpsOriginal() {
        int mult = 0, add = 0;
        if (A != 0) mult++;
        if (B != 0) mult++;
        if (C != 0) mult++;
        int terms = 0;
        if (A != 0) terms++;
        if (B != 0) terms++;
        if (C != 0) terms++;
        if (D != 0) terms++;
        if (E != 0) terms++;
        if (F != 0) terms++;
        if (D != 0) add++;
        if (E != 0) add++;
        if (terms > 1) add += (terms - 1);
        return mult + add;
    }

    static int tryForm1() {
        if (B != 0 || C != 0 || E != 0) return -1;
        for (int a1 : factors(A)) {
            for (int a2 : factors(A)) {
                if (a1 * a2 != A) continue;
                for (int b1 : factors(F)) {
                    for (int b2 : factors(F)) {
                        if (b1 * b2 != F) continue;
                        if (D == a1 * b2 + a2 * b1) {
                            return evalFormOps(a1 != 0, a2 != 0, b1 != 0, b2 != 0);
                        }
                    }
                }
            }
        }
        return -1;
    }

    static int tryForm2() {
        if (A != 0 || C != 0) return -1;
        for (int a1 : factors(B)) {
            for (int a2 : factors(B)) {
                if (a1 * a2 != B) continue;
                for (int b1 : factors(F)) {
                    for (int b2 : factors(F)) {
                        if (b1 * b2 != F) continue;
                        if (D == a1 * b2 && E == a2 * b1) {
                            return evalFormOps(a1 != 0, a2 != 0, b1 != 0, b2 != 0);
                        }
                    }
                }
            }
        }
        return -1;
    }

    static int tryForm3() {
        if (C != 0 || F != 0) return -1;
        for (int a1 : factors(A)) {
            for (int a2 : factors(A)) {
                if (a1 * a2 != A) continue;
                for (int b1 : factors(E)) {
                    for (int b2 : factors(E)) {
                        if (b1 * b2 != E) continue;
                        if (B == a2 * b1 && D == a1 * b2) {
                            return evalFormOps(a1 != 0, a2 != 0, b1 != 0, b2 != 0);
                        }
                    }
                }
            }
        }
        return -1;
    }

    static int evalFormOps(boolean a1mul, boolean a2mul, boolean b1add, boolean b2add) {
        int ops = 1; // one multiplication of brackets
        if (a1mul) ops++;
        if (a2mul) ops++;
        if (b1add) ops++;
        if (b2add) ops++;
        return ops;
    }

    static List<Integer> factors(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        int absn = Math.abs(n);
        for (int i = 1; i <= absn; i++) {
            if (absn % i == 0) {
                res.add(i);
                res.add(-i);
            }
        }
        return res;
    }
}
