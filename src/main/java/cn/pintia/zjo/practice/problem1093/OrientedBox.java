package cn.pintia.zjo.practice.problem1093;

import java.io.ByteArrayInputStream;
import java.util.*;
import java.util.regex.Pattern;


/**
 * 获取6个不同排列的Box
 * @author Administrator
 */
public class OrientedBox {
    private int x;
    private int y;
    private int z;
    private List<Box> boxesList;
    private static int infinity = Integer.MAX_VALUE;
//    private static String pattern = "[1-9]\\d* ";

    public OrientedBox(int x, int y, int z) {
        Box one = new Box(x, y, z);
        Box two = new Box(x, z, y);
        Box three = new Box(y, x, z);
        Box four = new Box(y, z, x);
        Box five = new Box(z, y, x);
        Box six = new Box(z, x, y);
        boxesList = Arrays.asList(new Box[]{one, two, three, four, five, six});
        Collections.sort(boxesList);
    }

    public List<Box> getBoxesList() {
        return boxesList;
    }

    public static OrientedBox valueOf(String txt) {
        if (txt == null || txt.isEmpty()) {
            throw new IllegalArgumentException("Invalid argument");
        }

//        if (!txt.matches(pattern)) {
//            throw new IllegalArgumentException("Argument must be positive integer");
//        }

        int x = infinity;
        int y = infinity;
        int z = infinity;
        txt = txt.trim();
        Scanner scanner = new Scanner(new ByteArrayInputStream(txt.getBytes()));
        while(scanner.hasNext()) {
            x = Integer.parseInt(scanner.next());
            y = Integer.parseInt(scanner.next());
            z = Integer.parseInt(scanner.next());
        }
        return new OrientedBox(x, y, z);
    }

    public static void main(String[] args) {
        OrientedBox orientedBox = OrientedBox.valueOf("7 7 7");
        System.out.println(orientedBox.getBoxesList());
    }
}
