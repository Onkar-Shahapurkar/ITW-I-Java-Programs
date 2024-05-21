import java.awt.*;
import java.awt.event.*;

public class Assi_15 {
    public static void main(String[] args) {
        Frame frame = new Frame("AWT Event Handling Example");

        Button button = new Button("Click me");

        frame.add(button);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked!");
            }
        });
        
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}