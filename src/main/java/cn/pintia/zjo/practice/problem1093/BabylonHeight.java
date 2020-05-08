package cn.pintia.zjo.practice.problem1093;

import java.util.List;

/**
 * @author lei.zhu
 */
public class BabylonHeight {
    /**
     * 计算巴比伦塔的高度
     *
     * @return int
     * @Date 22:08 2020/5/8
     * @Param [blocks]
     **/
    public static int height(List<Box> blocks) {
        Box[] boxes = blocks.toArray(new Box[blocks.size()]);

        int[] heightArr = new int[boxes.length];
        heightArr[0] = boxes[0].getHeight();
        for (int i = 1; i < boxes.length; i++) {
            int height = 0;
            for (int j = 0; j < i; j++) {
                if ((boxes[j].getLength() > boxes[i].getLength()) &&
                        (boxes[j].getWidth() > boxes[j].getWidth()) &&
                        (heightArr[j] > height)) {
                    height = heightArr[j];
                }
                heightArr[i] = height + boxes[i].getHeight();
            }
        }

        int result = heightArr[0];
        for (int i = 1; i < heightArr.length; i++) {
            result = Math.max(result, heightArr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        OrientedBox orientedBox = new OrientedBox(10, 20, 30);
        List<Box> boxesList = orientedBox.getBoxesList();
        System.out.println(BabylonHeight.height(boxesList));
    }
}
