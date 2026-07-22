import java.util.*;

public class DigitalArtist {
    static int M, N; // M: height (y-axis), N: width (x-axis)
    static ArrayList<Rectangle> rectangles = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();

        List<String> invalidCommands = new ArrayList<>();

        for (int i = 0; i < C; i++) {
            String cmdLine = sc.nextLine();
            String[] parts = cmdLine.split(" ");
            String cmd = parts[0];

            int x = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);
            int w = Integer.parseInt(parts[3]);
            int h = Integer.parseInt(parts[4]);

            boolean valid = false;

            switch (cmd) {
                case "draw":
                    valid = draw(x, y, w, h);
                    break;
                case "shrink":
                    valid = shrink(x, y, w, h);
                    break;
                case "extend":
                    valid = extend(x, y, w, h);
                    break;
                case "remove":
                    valid = remove(x, y, w, h);
                    break;
                default:
                    valid = false;
            }

            if (!valid) {
                invalidCommands.add(cmdLine);
            }
        }

        // Print invalid commands
        for (String s : invalidCommands) {
            System.out.println(s);
        }
        // Print count of rectangles remaining
        System.out.println(rectangles.size());
    }

    static boolean draw(int x, int y, int w, int h) {
        Rectangle newRect = new Rectangle(x, y, w, h);
        if (!newRect.inBounds()) return false;
        if (overlapsAny(newRect)) return false;
        rectangles.add(newRect);
        return true;
    }

    static boolean shrink(int x, int y, int w, int h) {
        Rectangle r = findRectangle(x, y, true);
        if (r == null) return false;
        // Shrink means new dimensions must be less or equal to current
        if (!(w <= r.w && h <= r.h)) return false;
        Rectangle shrunk = new Rectangle(x, y, w, h);
        if (!shrunk.inBounds()) return false;
        // Temporarily remove old rectangle
        rectangles.remove(r);
        if (overlapsAny(shrunk)) {
            // Restore old if overlap found
            rectangles.add(r);
            return false;
        }
        rectangles.add(shrunk);
        return true;
    }

    static boolean extend(int x, int y, int w, int h) {
        Rectangle r = findRectangle(x, y, true);
        if (r == null) return false;
        // Extend means new dimensions must be greater or equal
        if (!(w >= r.w && h >= r.h)) return false;
        Rectangle extended = new Rectangle(x, y, w, h);
        if (!extended.inBounds()) return false;
        rectangles.remove(r);
        if (overlapsAny(extended)) {
            rectangles.add(r);
            return false;
        }
        rectangles.add(extended);
        return true;
    }

    static boolean remove(int x, int y, int w, int h) {
        Rectangle r = findRectangle(x, y, true);
        if (r == null) return false;
        if (r.w != w || r.h != h) return false;
        rectangles.remove(r);
        return true;
    }

    static Rectangle findRectangle(int x, int y, boolean matchPosOnly) {
        for (Rectangle r : rectangles) {
            if (r.x == x && r.y == y) {
                return r;
            }
        }
        return null;
    }

    // Returns true if newRect overlaps or touches any existing rectangle or is enclosed
    static boolean overlapsAny(Rectangle newRect) {
        for (Rectangle r : rectangles) {
            if (newRect.overlapsOrTouches(r)) return true;
            if (r.encloses(newRect) || newRect.encloses(r)) return true;
        }
        return false;
    }

    static class Rectangle {
        int x, y, w, h;
        Rectangle(int x, int y, int w, int h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }

        // Check if rectangle is within canvas bounds
        boolean inBounds() {
            // x,y is top-left, width=w along x, height=h along y
            return x >= 0 && y >= 0 && w >= 1 && h >= 1 && (x + w) <= N && (y + h) <= M;
        }

        // Check if this rectangle overlaps or touches another rectangle
        boolean overlapsOrTouches(Rectangle other) {
            // if two rectangles are separated by at least 1 unit space, they don't touch/overlap
            // So no overlap/touch if one rectangle is completely to one side of other (with gap 0)
            // If they share an edge or corner, it's touching - invalid

            // Because touching is not allowed, use <= / >= for check
            if (this.x + this.w <= other.x) return false; // this entirely left
            if (other.x + other.w <= this.x) return false; // other entirely left
            if (this.y + this.h <= other.y) return false; // this entirely above
            if (other.y + other.h <= this.y) return false; // other entirely above

            return true; // rectangles touch or overlap
        }

        // Check if this rectangle completely encloses other
        boolean encloses(Rectangle other) {
            return this.x < other.x && this.y < other.y
                    && this.x + this.w > other.x + other.w
                    && this.y + this.h > other.y + other.h;
        }

        public String toString() {
            return String.format("(%d,%d) %dx%d", x, y, w, h);
        }
    }
}
