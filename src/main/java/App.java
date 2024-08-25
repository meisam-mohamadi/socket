import javax.swing.*;

public class App {
    public static void main(String[] args) {


        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1000, 500);
        JLabel damaLabel = new JLabel("temp");
        damaLabel.setBounds(50 , 20 , 100 , 30);
        frame.add(damaLabel);
        frame.setVisible(true);

    }
}
