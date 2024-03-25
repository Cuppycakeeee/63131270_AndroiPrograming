package ntu_63131270;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BMICalculator extends JFrame implements ActionListener {
    private JLabel weightLabel, heightLabel, ageLabel, genderLabel, resultLabel;
    private JTextField weightField, heightField, ageField;
    private JRadioButton maleRadio, femaleRadio;
    private JButton calculateButton;
   
    public BMICalculator() {
        setTitle("BMI Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}