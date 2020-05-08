package cn.pintia.zjo.practice.problem1093;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrientedBox {
    private int x;
    private int y;
    private int z;
    private List<Box> boxesList;

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

    public static void main(String[] args) {
        OrientedBox orientedBox = new OrientedBox(10, 20, 30);
        List<Box> boxesList = orientedBox.getBoxesList();
        System.out.println(boxesList.toString());
    }
}
