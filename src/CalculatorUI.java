import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorUI {
    private Calculator calculator;
    private JFrame frame;
    private JTextField input1, input2;
    private JButton addButton, subButton, mulButton, divButton;
    private JLabel resultLabel;

    public CalculatorUI() {
        calculator = new Calculator();
        frame = new JFrame("Calculator");
        frame.setSize(300, 300);
        frame.setLayout(null);

        input1 = new JTextField();
        input1.setBounds(50, 50, 80, 25);
        frame.add(input1);

        input2 = new JTextField();
        input2.setBounds(150, 50, 80, 25);
        frame.add(input2);

        addButton = new JButton("+");
        addButton.setBounds(50, 100, 50, 25);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation(Operation.ADD);
            }
        });
        frame.add(addButton);

        subButton = new JButton("-");
        subButton.setBounds(110, 100, 50, 25);
        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation(Operation.SUBTRACT);
            }
        });
        frame.add(subButton);

        mulButton = new JButton("*");
        mulButton.setBounds(170, 100, 50, 25);
        mulButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation(Operation.MULTIPLY);
            }
        });
        frame.add(mulButton);

        divButton = new JButton("/");
        divButton.setBounds(230, 100, 50, 25);
        divButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation(Operation.DIVIDE);
            }
        });
        frame.add(divButton);

        resultLabel = new JLabel("Result: ");
        resultLabel.setBounds(50, 150, 200, 25);
        frame.add(resultLabel);

        frame.setVisible(true);
    }

    private void performOperation(Operation op) {
        try {
            double num1 = Double.parseDouble(input1.getText());
            double num2 = Double.parseDouble(input2.getText());
            double result = 0;

            switch (op) {
                case ADD:
                    result = calculator.add(num1, num2);
                    break;
                case SUBTRACT:
                    result = calculator.subtract(num1, num2);
                    break;
                case MULTIPLY:
                    result = calculator.multiply(num1, num2);
                    break;
                case DIVIDE:
                    result = calculator.divide(num1, num2);
                    break;
            }
            resultLabel.setText("Result: " + result);
        } catch (Exception e) {
            resultLabel.setText("Invalid input.");
        }
    }

    enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }

    public static void main(String[] args) {
        new CalculatorUI();
    }
}
