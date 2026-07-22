import java.util.*;

public class BoxRanking {
    static class Box {
        int x1, y1, x2, y2, area;
        String str;

        Box(int x1, int y1, int x2, int y2, String str) {
            this.x1 = x1; this.y1 = y1;
            this.x2 = x2; this.y2 = y2;
            this.area = (x2 - x1) * (y2 - y1);
            this.str = str;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if(!sc.hasNextInt()) {
            System.out.println(0);
            sc.close();
            return;
        }
        int N = sc.nextInt(); // width
        int M = sc.nextInt(); // height
        if (sc.hasNextLine()) sc.nextLine();

        if(!sc.hasNextInt()) {
            System.out.println(0);
            sc.close();
            return;
        }
        int L = sc.nextInt(); // number of partition lines
        if (sc.hasNextLine()) sc.nextLine();

        TreeSet<Integer> verticalLines = new TreeSet<>();
        TreeSet<Integer> horizontalLines = new TreeSet<>();
        verticalLines.add(0);
        verticalLines.add(N);
        horizontalLines.add(0);
        horizontalLines.add(M);

        for (int i = 0; i < L; ) {
            if (!sc.hasNextLine()) break;
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            if(parts.length != 4) continue; // skip invalid lines
            int x1 = Integer.parseInt(parts[0]);
            int y1 = Integer.parseInt(parts[1]);
            int x2 = Integer.parseInt(parts[2]);
            int y2 = Integer.parseInt(parts[3]);

            if (x1 == x2) verticalLines.add(x1);
            else if (y1 == y2) horizontalLines.add(y1);

            i++;
        }

        if(!sc.hasNextInt()) {
            System.out.println(0);
            sc.close();
            return;
        }
        int R = sc.nextInt();
        if (sc.hasNextLine()) sc.nextLine();

        int vCount = verticalLines.size();
        int hCount = horizontalLines.size();
        int boxCount = (vCount - 1) * (hCount - 1);

        String[] boxStrings = new String[0];
        if (sc.hasNextLine()) boxStrings = sc.nextLine().split("\\s+");

        if (boxStrings.length != boxCount){
            System.out.println(0);
            sc.close();
            return;
        }

        List<Integer> vList = new ArrayList<>(verticalLines);
        List<Integer> hList = new ArrayList<>(horizontalLines);

        Box[] boxes = new Box[boxCount];

        int idx = 0;
        for (int y = 0; y < hCount -1; y++) {
            for (int x = 0; x < vCount -1; x++) {
                boxes[idx++] = new Box(vList.get(x), hList.get(y), vList.get(x+1), hList.get(y+1), boxStrings[idx-1]);
            }
        }

        Arrays.sort(boxes, (b1, b2) -> {
            if (b2.area != b1.area) return b2.area - b1.area;
            if (b1.x1 != b2.x1) return b1.x1 - b2.x1;
            return b1.y1 - b2.y1;
        });

        Box targetBox = boxes[R - 1];
        int asciiSum = 0;
        for (char c : targetBox.str.toCharArray()) {
            asciiSum += (int) c;
        }

        System.out.println(asciiSum);
        sc.close();
    }
}
