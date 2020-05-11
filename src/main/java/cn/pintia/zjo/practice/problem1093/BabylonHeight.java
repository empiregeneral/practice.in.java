package cn.pintia.zjo.practice.problem1093;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

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
        for (int i = 0; i < boxes.length; i++) {
            int height = 0;
            for (int j = i - 1; j >= 0; j--) {
                if ((boxes[i].getLength() < boxes[j].getLength()) &&
                        (boxes[i].getWidth() < boxes[j].getWidth()) &&
                        height < heightArr[j]) {
                    height = heightArr[j];
                }
            }
            heightArr[i] = height + boxes[i].getHeight();
        }

        OptionalInt maxInArr = Arrays.stream(heightArr).max();
        return maxInArr.getAsInt();
    }
}
