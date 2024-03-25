package ntu_63131270.cau2_doitien;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText amountEditText;
    Spinner currencySpinner;
    Button convertButton;
    TextView resultTextView;

    double usdRate = 0.000043; // 1 VND = 0.000043 USD
    double euroRate = 0.000039; // 1 VND = 0.000039 EUR
    double jpyRate = 0.0047; // 1 VND = 0.0047 JPY
    double gbpRate = 0.000031; // 1 VND = 0.000031 GBP
    double cnyRate = 0.00028; // 1 VND = 0.00028 CNY
    double audRate = 0.000056; // 1 VND = 0.000056 AUD
    double cadRate = 0.000052; // 1 VND = 0.000052 CAD
    double chfRate = 0.000041; // 1 VND = 0.000041 CHF

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountEditText = findViewById(R.id.amountEditText);
        currencySpinner = findViewById(R.id.currencySpinner);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currency_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencySpinner.setAdapter(adapter);

        currencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle currency selection
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountString = amountEditText.getText().toString();
                if (amountString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter an amount", Toast.LENGTH_SHORT).show();
                    return;
                }

                double amount = Double.parseDouble(amountString);
                double result = 0.0;

                String selectedCurrency = currencySpinner.getSelectedItem().toString();

                switch (selectedCurrency) {
                    case "USD":
                        result = amount * usdRate;
                        break;
                    case "Euro":
                        result = amount * euroRate;
                        break;
                    case "JPY":
                        result = amount * jpyRate;
                        break;
                    case "GBP":
                        result = amount * gbpRate;
                        break;
                    case "CNY":
                        result = amount * cnyRate;
                        break;
                    case "AUD":
                        result = amount * audRate;
                        break;
                    case "CAD":
                        result = amount * cadRate;
                        break;
                    case "CHF":
                        result = amount * chfRate;
                        break;
                }

                DecimalFormat df = new DecimalFormat("#.##");
                resultTextView.setText(df.format(result));
            }
        });
    }
}
