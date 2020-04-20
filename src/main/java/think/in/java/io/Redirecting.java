package think.in.java.io;

import java.io.*;

/**
  * @Author lei.zhu
  * @Description 重定向功能，输入的文件流均可以通过文件来实现，
  *              比如FileInputstream redirect into System.in
 *               System.out redirect into PrintStream
  * @Date 22:05 2020/3/31
  * @Param
  * @return
 **/
public class Redirecting {
    public static void main(String[] args) {
        try {
            PrintStream console = System.out;
            BufferedInputStream in = new BufferedInputStream(new FileInputStream("C:\\Users\\Administrator\\Desktop\\warandpeace.txt"));
            PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\out.txt")));
            System.setIn(in);
            System.setOut(out);
            System.setErr(out);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s;
            while((s = br.readLine()) != null) {
                out.println(s);
            }
            out.close();
            System.setOut(console);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
