
// Adding the necessary packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator1 extends JFrame implements ActionListener {

    //Declaring the variables for the calculator's components
    private JTextField numField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, modButton, clearButton, equalsButton;
    private double previousNum;
    private String previousOperator;

    //
    public Calculator1() {
        // Set up the JFrame
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new GridLayout(5, 3));

        // Initializing components
        numField = new JTextField();
        numField.setEditable(false);
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        modButton = new JButton("%");
        clearButton = new JButton("C");
        equalsButton = new JButton("=");

        // Adding components to JFrame
        add(numField);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(new JButton("7"));
        add(new JButton("8"));
        add(new JButton("9"));
        add(divideButton);
        add(new JButton("4"));
        add(new JButton("5"));
        add(new JButton("6"));
        add(modButton);
        add(new JButton("1"));
        add(new JButton("2"));
        add(new JButton("3"));
        add(clearButton);
        add(new JButton("0"));
        add(new JButton("."));
        add(equalsButton);

        // Adding listeners to components
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        modButton.addActionListener(this);
        clearButton.addActionListener(this);
        equalsButton.addActionListener(this);
        Component[] numButtons = getContentPane().getComponents();
        for (Component component : numButtons) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                if (!button.getText().equals("+") && !button.getText().equals("-") && !button.getText().equals("*") &&
                        !button.getText().equals("/") && !button.getText().equals("%") && !button.getText().equals("C")
                        && !button.getText().equals("=")) {
                    button.addActionListener(this);
                }
            }
        }
     // Making the JFrame visible to the user
        setVisible(true);
    }


    // Handling the user input and performing the necessary calculations
    public void actionPerformed(ActionEvent e) {
        String buttonPressed = e.getActionCommand();
        switch (buttonPressed) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                previousOperator = buttonPressed;
                previousNum = Double.parseDouble(numField.getText());
                numField.setText("");
                break;
            case "C":
                numField.setText("");
                break;
            case "=":
                double currentNum = Double.parseDouble(numField.getText());
                double result = 0.0;
                switch (previousOperator) {
                    case "+":
                        result = previousNum + currentNum;
                        break;
                    case "-":
                        result = previousNum - currentNum;
                        break;
                    case "*":
                        result = previousNum * currentNum;
                        break;
                    case "/":
                        result = previousNum / currentNum;
                        break;
                    case "%":
                        result = previousNum % currentNum;
                        break;
                }
                numField.setText(String.valueOf(result));
                break;
            default:
                numField.setText(numField.getText() + buttonPressed);
        }
    }

    public static void main(String[] args) {
        new Calculator1();
    }
}


