package think.in.java.concurrency;

import javax.swing.*;

public class EventDispatcherThreadDemo extends JApplet {
    public EventDispatcherThreadDemo() {
        add(new JLabel("Event dispatch thread"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("EventDispatcherThreadDemo");
                frame.add(new EventDispatcherThreadDemo());
                frame.setSize(200, 200);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
            }
        });
    }
}
