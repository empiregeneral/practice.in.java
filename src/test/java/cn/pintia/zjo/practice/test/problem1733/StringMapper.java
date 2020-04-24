package cn.pintia.zjo.practice.test.problem1733;

import junitparams.mappers.DataMapper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
        List<Object[]> params = new LinkedList<>();
        int lineNo = 0;
        try {
            while ((line = br.readLine()) != null) {
                if (++lineNo > lineToSkip) {
                    String[] parts = line.split(",");
                    params.add(new Object[]{inputLine(parts[0]).nextLine(), parts[1]});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params.toArray();
    }

    private Scanner inputLine(String line) {
        Scanner scanner = new Scanner(new ByteArrayInputStream(line.getBytes()));
        return scanner;
    }
}
