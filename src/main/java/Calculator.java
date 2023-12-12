/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GULL SHER
 */
import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.awt.event.*;
import java.util.*;
 
import javax.swing.event.*;

public class Calculator extends JFrame {
 
    JTextField textField;
    private boolean startNumber= true;
    private int resultTotal;
    private String operator= "=";
 
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.setVisible(true);
    }
 
    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,400);
        setLayout(new BorderLayout());
 
        JPanel textPanel= new JPanel();
        textPanel.setLayout(new FlowLayout());
        textField= new JTextField("0", 20);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setBackground(Color.WHITE);
        textPanel.add(textField);
        add(textPanel, BorderLayout.NORTH);
 
        JPanel arithmeticFunctions= new JPanel();
        arithmeticFunctions.setBackground(Color.WHITE);
        arithmeticFunctions.setLayout(new GridLayout(5,1));
 
        JButton divideButton= new JButton("/");
        divideButton.addActionListener(new operatorListener());
        arithmeticFunctions.add(divideButton);
        JButton multiplyButton= new JButton("x");
        multiplyButton.addActionListener(new operatorListener());
        arithmeticFunctions.add(multiplyButton);
        JButton subtractButton= new JButton("-");
        subtractButton.addActionListener(new operatorListener());
        arithmeticFunctions.add(subtractButton);        
        JButton addButton= new JButton("+");
        addButton.addActionListener(new operatorListener());
        arithmeticFunctions.add(addButton);
        JButton equalButton= new JButton("=");
        equalButton.addActionListener(new operatorListener());
        arithmeticFunctions.add(equalButton);
        add(arithmeticFunctions, BorderLayout.EAST);
 
        JPanel numberPad= new JPanel();
        numberPad.setBackground(Color.WHITE);
        numberPad.setLayout(new GridLayout(4,3));
 
        JButton seven= new JButton("7");
        seven.addActionListener(new numberListener());
        numberPad.add(seven);
        JButton eight= new JButton("8");
        eight.addActionListener(new numberListener());
        numberPad.add(eight);
        JButton nine= new JButton("9");
        nine.addActionListener(new numberListener());
        numberPad.add(nine);
        JButton four= new JButton("4");
        four.addActionListener(new numberListener());
        numberPad.add(four);
        JButton five= new JButton("5");
        five.addActionListener(new numberListener());
        numberPad.add(five);
        JButton six= new JButton("6");
        six.addActionListener(new numberListener());
        numberPad.add(six);
        JButton one= new JButton("1");
        one.addActionListener(new numberListener());
        numberPad.add(one);
        JButton two= new JButton("2");
        two.addActionListener(new numberListener());
        numberPad.add(two);
        JButton three= new JButton("3");
        three.addActionListener(new numberListener());
        numberPad.add(three);
        JButton zero= new JButton("0");
        zero.addActionListener(new numberListener());
        numberPad.add(zero);
        JButton decimal= new JButton(".");
        decimal.addActionListener(new numberListener());
        numberPad.add(decimal);
        JButton posNeg= new JButton("+/=");
        numberPad.add(posNeg);
        add(numberPad, BorderLayout.WEST);
 
 
        JPanel cent= new JPanel();
        cent.setBackground(Color.WHITE);
        cent.setLayout(new FlowLayout());
 
        JButton c= new JButton("C");
        cent.add(c);
        add(cent, BorderLayout.CENTER);
    }
 
    private void actionClear() {
        startNumber= true;
        textField.setText("0");
        resultTotal=0;
        operator= "=";
    }
 
    public class numberListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String number= e.getActionCommand();
            if (startNumber) {
                textField.setText(number);
                startNumber= false;
            }
            else {
                textField.setText(textField.getText()+ number);
            }   
        }
    }
 
    public class operatorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
 
            if (startNumber)
                actionClear();
            else
                startNumber= true;
 
            try {
                String numOperator= textField.getText();
                int currentTotal= Integer.parseInt(numOperator);
 
                if (operator.equals("/")) {
                    resultTotal /= currentTotal;
                }
                else if (operator.equals("x")) {
                    resultTotal *= currentTotal;
                }
                else if (operator.equals("-")) {
                    resultTotal -= currentTotal;
                }
                else if (operator.equals("+")) {
                    resultTotal += currentTotal;
                }
 
                    if (operator.equals("=")) {
                    resultTotal= currentTotal;
                }
                textField.setText("" + resultTotal);
            }      
 
            catch (NumberFormatException ex) {
                actionClear();
            }
 
            operator= e.getActionCommand();
 
        }
    }
 
 
}    
