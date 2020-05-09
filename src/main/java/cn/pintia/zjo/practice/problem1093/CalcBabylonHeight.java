package cn.pintia.zjo.practice.problem1093;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalcBabylonHeight implements Readable{
    private List<OrientedBox> orientedBoxes;
    private List<Box> blocks = new ArrayList<>();
    private int caseNo = 0;
    private int count = 1;

    public CalcBabylonHeight(List<OrientedBox> orientedBoxes, int caseNo) {
        this.orientedBoxes = orientedBoxes;
        for (OrientedBox orientedBox : orientedBoxes) {
            for (Box box : orientedBox.getBoxesList()) {
                blocks.add(box);
            }
        }
        Collections.sort(blocks);
        this.caseNo = caseNo;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        cb.append(String.format("Case %d: maximum height = %d", new Object[]{caseNo,BabylonHeight.height(blocks)}));

        return 10;
    }
}
