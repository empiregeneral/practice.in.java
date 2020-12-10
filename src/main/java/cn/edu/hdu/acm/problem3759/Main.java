package cn.edu.hdu.acm.problem3759;

import java.io.*;

/**
 * @Description
 * @Author lei.zhu
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        for (int i = 0; i < n; i++) {
            scanner.nextLine();
            String inputLine = scanner.line;
            IHandScore iHandScore = new ReadFromLine(inputLine);
            int hand = iHandScore.hand();
            Readable readable = new Solvable(hand);
            java.util.Scanner output = new java.util.Scanner(readable);
            while(output.hasNext()) {
                System.out.println(output.next());
            }
        }
    }

    static class Scanner {
        final BufferedReader in;
        String line = "";
        int pos;
        int lineNo;

        public Scanner(InputStream inputStream) {
            in = new BufferedReader(new InputStreamReader(inputStream));
            nextLine();
        }

        public void close() {
            assert line == null : "Extra data at the end of file";
            try {
                in.close();
            } catch (IOException e) {
                throw new AssertionError("Failed to close with " + e);
            }
        }

        public void nextLine() {
            assert line != null : "EOF";
            assert pos == line.length() : "Extra characters on line " + lineNo;
            try {
                line = in.readLine();
            } catch (IOException e) {
                throw new AssertionError("Failed to read line with " + e);
            }
            pos = 0;
            lineNo++;
        }

        public String next() {
            assert line != null : "EOF";
            assert line.length() > 0 : "Empty line " + lineNo;
            if (pos == 0) {
                assert line.charAt(0) > ' ' : "Line " + lineNo + " starts with whitespace";
            }
            else {
                assert pos < line.length() : "Line " + lineNo + " is over";
                assert line.charAt(pos) == ' ' : "Wrong whitespace on line " + lineNo;
                pos++;
                assert pos < line.length() : "Line " + lineNo + " is over";
                assert line.charAt(0) > ' ' : "Line " + lineNo + " has double whitespace";
            }
            StringBuilder sb = new StringBuilder();
            while (pos < line.length() && line.charAt(pos) > ' ') {
                sb.append(line.charAt(pos++));
            }
            return sb.toString();
        }
    }
}

