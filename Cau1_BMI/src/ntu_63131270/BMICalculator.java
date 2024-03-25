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
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        weightLabel = new JLabel("Weight (kg):");
        weightField = new JTextField();
        heightLabel = new JLabel("Height (cm):");
        heightField = new JTextField();
        ageLabel = new JLabel("Age:");
        ageField = new JTextField();
        genderLabel = new JLabel("Gender:");
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        resultLabel = new JLabel("");

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        panel.add(weightLabel);
        panel.add(weightField);
        panel.add(heightLabel);
        panel.add(heightField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(genderLabel);
        panel.add(maleRadio);
        panel.add(new JLabel());
        panel.add(femaleRadio);
        panel.add(calculateButton);
        panel.add(resultLabel);

        add(panel);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText()) / 100; // convert cm to m
            int age = Integer.parseInt(ageField.getText());
            double bmi = weight / (height * height);
            String status;
            if (bmi < 18.5)
                status = "Underweight";
            else if (bmi < 24.9)
                status = "Normal weight";
            else if (bmi < 29.9)
                status = "Overweight";
            else
                status = "Obesity";
            String gender = maleRadio.isSelected() ? "Male" : "Female";

            resultLabel.setText(String.format("BMI: %.2f - Status: %s - Gender: %s - Age: %d", bmi, status, gender, age));
        }
}