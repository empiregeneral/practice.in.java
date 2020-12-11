package cn.edu.hdu.acm.problem3759;

import junitparams.mappers.DataMapper;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

public class StringMapper implements DataMapper {
    private final int lineToSkip;

    public StringMapper() {
        this(1);
    }

    public StringMapper(int lineToSkip) {
        this.lineToSkip = lineToSkip;
    }


    @Override
    public Object[] map(Reader reader) {
        BufferedReader br = new BufferedReader(reader);
        String line;
        List<Object[]> params  = new LinkedList<>();
        int lineNo = 0;
        try {
            while((line = br.readLine()) != null) {
                if (++lineNo > lineToSkip) {
                    String[] parts = line.split(",");
                    params.add(new Object[]{parts[0], parts[1]});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params.toArray();
    }
}
