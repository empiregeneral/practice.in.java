package cn.pintia.zjo.practice.problem1324;

import java.io.IOException;
import java.nio.CharBuffer;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
  * @Author lei.zhu
  * @Description 向unix系统的ls命令一样输出
  * @Date 22:47 2020/3/31
  * @Param
  * @return
 **/
public class Unixls implements Readable {

    private int count = 1;
    private FormattedListInString format;

    public Unixls(String files) {
        List<String> fileList = new ArrayList<>();
        this.format = new FormattedListInString(fileList);
    }


    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        return 10;
    }

    public static void main(String[] args) {

    }
}

class FormattedListInString {
    private List<String> outputList = new ArrayList<>();
    private List<String> inputList;
    private int paddedScale;

    public FormattedListInString(List<String> inputList) {
        this.inputList = inputList;
        this.paddedScale = findLongestStrLength(inputList) + 2;
        Collections.sort(this.inputList, Collator.getInstance());
        formatedStrList(this.inputList, this.paddedScale);
    }

    private int findLongestStrLength(List<String> inputList) {
        int maxlen = inputList.get(0).length();
        Iterator<String> iterator = inputList.listIterator();
        while(iterator.hasNext()) {
            int len =  iterator.next().length();
            if (len > maxlen) {
                maxlen = len ;
            }
        }
        return maxlen;
    }

    private void formatedStrList(List<String> list, int paddedScale) {
        Iterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String tmpStr = iterator.next();
            int scale = paddedScale - tmpStr.length();
            String formattedStr = paddedCharSequence(tmpStr, scale);
            outputList.add(formattedStr);
        }
    }

    public List<String> getFormatedStrList() {
        return this.outputList;
    }

    @Override
    public String toString() {
        return outputList.toString();
    }

    private String paddedCharSequence(CharSequence seq, int scale) {
        StringBuilder sb = new StringBuilder("");
        char[] tmpChars = new char[scale];
        for (int i = 0; i < scale; i++) {
            tmpChars[i] = ' ';
        }
        sb.append(seq).append(tmpChars);
        return sb.toString();
    }
}