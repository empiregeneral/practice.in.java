package cn.pintia.zjo.practice.test.problem1095;

import junitparams.mappers.DataMapper;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class NumberMapper implements DataMapper {
    private final int lineToSkip;

    public NumberMapper() {
        this(1);
    }

    public NumberMapper(int lineToSkip) {
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
                    String[] parts = line.split(",");
                    params.add(new Object[]{Integer.parseInt(parts[0]),parts[1]});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params.toArray();
    }
}
