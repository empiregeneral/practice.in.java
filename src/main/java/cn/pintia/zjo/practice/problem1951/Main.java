package cn.pintia.zjo.practice.problem1951;

import java.io.*;

import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        System.setIn(new FileInputStream(args[0]));
//        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        byte[] bufferByte = readFileByNio(args[0]);
        Scanner scanner = new Scanner(new ByteArrayInputStream(bufferByte), "utf-8").useDelimiter("\r\n");

        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n == 0 ) {
                break;
            }

            try {
                Readable readable = new FindGoldbachEquationImp(n);
                Scanner output = new Scanner(readable);
                while(output.hasNextLine()) {
                    System.out.println(output.nextLine());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static byte[] readFileByNio(String path) {
        long fileLength = 0;
        final int BUFFER_SIZE = 0x50000;// 0.5M的缓冲
        File file = new File(path);
        fileLength = file.length();
        byte[] dst = new byte[BUFFER_SIZE];
        try {
            MappedByteBuffer inputBuffer = new RandomAccessFile(file, "r").getChannel().map(FileChannel.MapMode.READ_ONLY, 0, fileLength);// 读取大文件

            for (int offset = 0; offset < fileLength; offset+=BUFFER_SIZE) {
                if (fileLength - offset >= BUFFER_SIZE) {
                    for (int i = 0; i < BUFFER_SIZE; i++) {
                        dst[i] = inputBuffer.get(offset + i);
                    }
                } else {
                    for (int i = 0; i < fileLength - offset; i++) {
                        dst[i] = inputBuffer.get(offset + i);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dst;
    }
}
