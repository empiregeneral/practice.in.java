package cn.pintia.zjo.practice.test.problem1093;

import cn.pintia.zjo.practice.problem1093.Box;
import cn.pintia.zjo.practice.problem1093.OrientedBox;
import junitparams.mappers.DataMapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.*;

public class ListOfBoxMapper implements DataMapper {
    private final int lineToSkip;

    public ListOfBoxMapper() {
        this(1);
    }

    public ListOfBoxMapper(int lineToSkip) {
        this.lineToSkip = lineToSkip;
    }

    @Override
    public Object[] map(Reader reader) {
        BufferedReader br = new BufferedReader(reader);
        List<Object[]> params = new LinkedList<>();
        String line;
        int lineNo = 0;
        try {
            while((line = br.readLine()) != null) {
                if (++lineNo > lineToSkip) {
                    String[] parts = line.split(",");
                    List<Box> boxes = new ArrayList<>();
                    List<OrientedBox> orientedBoxes = toOrientedBoxes(parts[0]);
                    for (OrientedBox orientedBox : orientedBoxes) {
                        for (Box box : orientedBox.getBoxesList()) {
                            boxes.add(box);
                        }
                    }
                    Collections.sort(boxes);
                    params.add(new Object[]{boxes, Integer.parseInt(parts[1])});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return params.toArray();
    }

    private List<OrientedBox> toOrientedBoxes(String info) {
        Scanner scanner = new Scanner(new ByteArrayInputStream(info.getBytes()));
        List<String> myList = new ArrayList<>();
        while(scanner.hasNext()) {
            myList.add(scanner.next());
        }
        final int COLUMNS = 3;
        final int ROWS = myList.size() / COLUMNS;
        List<OrientedBox> orientedBoxes = new ArrayList<>();

        Readable readable = new ReadableImp(myList, ROWS, COLUMNS);
        Scanner output = new Scanner(readable);

        while(output.hasNextLine()) {
            String txt = output.nextLine().trim();
            OrientedBox orientedBox = OrientedBox.valueOf(txt);
            orientedBoxes.add(orientedBox);
        }

        return orientedBoxes;
    }

    private static class ReadableImp implements Readable {
        private int count = 1;
        private List<String> inputList;
        private String[] arr;
        private int rows;
        private int columns;

        public ReadableImp(List<String> inputList, int rows, int columns) {
            this.inputList = inputList;
            this.arr = inputList.toArray(new String[this.inputList.size()]);
            this.rows = rows;
            this.columns = columns;
        }

        @Override
        public int read(CharBuffer cb) throws IOException {
            if (--count < 0) {
                return -1;
            }

            int startIndex = 0;
            int endIndex = columns;
            for (int i = 0; i < rows; i++) {
                String[] tmpArr = Arrays.copyOfRange(arr, startIndex, endIndex);
                for (String s : tmpArr) {
                    cb.append(s + " ");
                }
                cb.append("\n");
                startIndex += 3;
                endIndex += 3;
            }

            cb.append("");
            return 10;
        }
    }
}
