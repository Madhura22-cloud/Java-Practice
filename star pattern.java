public class Pattern {
    public static void main(String[] args) {
        for (int p = 1; p <= 4; p++) {
            for (int q = 1; q <= p; q++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
