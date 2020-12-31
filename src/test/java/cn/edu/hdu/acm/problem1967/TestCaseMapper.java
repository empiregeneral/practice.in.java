package cn.edu.hdu.acm.problem1967;

import junitparams.mappers.DataMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

public class TestCaseMapper implements DataMapper {
    private final int lineToSkip;

    public TestCaseMapper() {
        this(0);
    }

    public TestCaseMapper(int lineToSkip) {
        this.lineToSkip = lineToSkip;
    }

    @Override
    public Object[] map(Reader reader) {
        BufferedReader br = new BufferedReader(reader);
        List<Object> params = new LinkedList<>();
        List<String> lastWeek = new LinkedList<>();
        List<String> thisWeek = new LinkedList<>();
        try {
            for (int i = 0; i < 9; i++) {
                lastWeek.add(br.readLine());
            }

            for (int i = 0; i < 9; i++) {
                thisWeek.add(br.readLine());
            }
            TestCase testCase = new TestCase(lastWeek, thisWeek);
            params.add(new Object[]{testCase});
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return params.toArray();
    }
}
