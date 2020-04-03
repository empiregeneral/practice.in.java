package cn.pintia.zjo.practice.problem1324;

import java.util.List;

/**
 * @author lei.zhu
 */
public class FormattedListInStringImp implements FormattedListInString {
    private Readable readable;

    public FormattedListInStringImp(List<String> inputList) {
        readable = new Formatted(inputList);
    }

    @Override
    public Readable formatted() {
        return readable;
    }
}