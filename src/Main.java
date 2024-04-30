import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel inputNumsPanel = new JPanel();

        JTextField nText = new JTextField(10);
        JTextField precisionText = new JTextField(10);

        inputNumsPanel.setLayout(new GridLayout(2, 2));
        inputNumsPanel.add(new JLabel("Enter N Value"));
        inputNumsPanel.add(nText);
        inputNumsPanel.add(new JLabel("Enter Precision Value"));
        inputNumsPanel.add(precisionText);

        JButton button = new JButton("Start");

        frame.setLayout(new FlowLayout());
        frame.add(inputNumsPanel);
        frame.add(button);
        frame.pack();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.addActionListener(e -> {
            int n = Integer.parseInt(nText.getText());
            int precision = Integer.parseInt(precisionText.getText());

            System.out.println(calc(n, precision));
        });
    }

    private static BigDecimal calc(int n, int precision) {
        BigDecimal e = ECalculator.calcE(n, precision);
        return SinCalculator.calcSinX(e, n / 10, precision);
    }
}