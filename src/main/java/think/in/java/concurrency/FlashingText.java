package think.in.java.concurrency;

import javax.swing.*;


/**
 * @Description 打印闪烁的文本
 */
public class FlashingText extends JFrame implements Runnable {
    private JLabel jblText = new JLabel("Welcome", JLabel.CENTER);

    public FlashingText() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.add(jblText);
        jFrame.setSize(100, 100);
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {

            try {
                if (jblText.getText() != null) {
                    jblText.setText(null);
                } else {
                    jblText.setText("Welcome");
                }

                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FlashingText frame = new FlashingText();
    }
}
