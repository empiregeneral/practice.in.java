package cn.pintia.zjo.practice.test.problem1324;

import junitparams.mappers.DataMapper;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ListInStringMapper implements DataMapper {
    private final int lineToSkip;

    public ListInStringMapper() {
        this(1);
    }

    public ListInStringMapper(int lineToSkip) {
        this.lineToSkip = lineToSkip;
    }


    @Override
    public Object[] map(Reader reader) {
        BufferedReader br = new BufferedReader(reader);
        String line;
        List<Object[]> params = new ArrayList<>();
        int lineNo = 0;
        try {
            while((line = br.readLine()) != null) {
                if (++lineNo > lineToSkip) {
                    params.add(new Object[]{toList(line)});
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return params.toArray();
    }

    private List<String> toList(String strList) {
        String[] content = strList.split(" ");
        int capacityList = Integer.parseInt(content[0]);
        List<String> myList = new ArrayList<>(capacityList);
        for (int i = 1; i <= capacityList; i++) {
            myList.add(content[i]);
        }
        return myList;
    }
}
