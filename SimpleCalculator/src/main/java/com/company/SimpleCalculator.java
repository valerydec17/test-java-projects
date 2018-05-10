package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JPanel
        implements ActionListener {

    private JButton calculateButton;
    private JTextField dividendField;
    private JTextField dividerField;
    private JTextArea resultArea;

    public void setDividendField(String dividendString) {
        dividendField.setText(dividendString);
    }

    public void setDividerField(String dividerString) {
        dividerField.setText(dividerString);
    }

    public String getResultArea() {
        return resultArea.getText();
    }

    public SimpleCalculator() {
        super(new BorderLayout());

        calculateButton = new JButton("=");
        calculateButton.addActionListener(this);

        dividendField = new JTextField(15);
        dividerField = new JTextField(15);

        resultArea = new JTextArea(2, 15);
        resultArea.setEditable(false);

        JLabel dividendLabel = new JLabel("Dividend:");
        JLabel dividerLabel = new JLabel("Divider:");
        JLabel resultLabel = new JLabel("Result:");

        JPanel buttonPanel = new JPanel(); //use FlowLayout

        buttonPanel.add(dividendLabel);
        buttonPanel.add(dividendField);
        buttonPanel.add(dividerLabel);
        buttonPanel.add(dividerField);
        buttonPanel.add(calculateButton);
        buttonPanel.add(resultLabel);
        buttonPanel.add(resultArea);

        add(buttonPanel, BorderLayout.CENTER  );
    }

    public void calculate(){
        resultArea.setText("result");

        String dividendString = dividendField.getText();
        String dividerString = dividerField.getText();

        if (dividendString.isEmpty()) {
            resultArea.setText("Error. Fields are not filled.");
        } else if (dividerString.isEmpty()) {
            resultArea.setText("Error. Fields are not filled.");
        } else {

            try {
                Double dividendDouble = Double.parseDouble(dividendString);
                Double dividerDouble = Double.parseDouble(dividerString);

                Double resultDouble = dividendDouble/dividerDouble;

                if (resultDouble.isInfinite()) {
                    resultArea.setText("Error. Division by zero.");
                } else {
                    resultArea.setText(resultDouble.toString());
                }

            } catch (NumberFormatException e1) {
                resultArea.setText("Error. Not a number.");
            }
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == calculateButton) {
            this.calculate();
        }
    }

}