package com.example.ontap;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Question1Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question1, container, false);

        // Find the UI components
        EditText heightEditText = view.findViewById(R.id.heightEditText);
        EditText weightEditText = view.findViewById(R.id.weightEditText);
        Button calculateButton = view.findViewById(R.id.calculateButton);
        TextView resultTextView = view.findViewById(R.id.resultTextView);

        // Set the click listener for the button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the height and weight from the EditTexts
                String heightStr = heightEditText.getText().toString();
                String weightStr = weightEditText.getText().toString();

                // Check if the inputs are valid
                if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
                    // Convert the input to float
                    float height = Float.parseFloat(heightStr) / 100; // Convert cm to meters
                    float weight = Float.parseFloat(weightStr);

                    // Calculate BMI
                    float bmi = weight / (height * height);

                    // Display the result
                    resultTextView.setText("BMI của bạn là: " + String.format("%.2f", bmi));
                } else {
                    // Show an error message if inputs are invalid
                    resultTextView.setText("Vui lòng nhập chiều cao và cân nặng hợp lệ.");
                }
            }
        });

        return view;
    }
}