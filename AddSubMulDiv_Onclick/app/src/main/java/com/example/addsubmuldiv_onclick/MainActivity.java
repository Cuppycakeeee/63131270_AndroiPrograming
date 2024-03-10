package com.example.addsubmuldiv_onclick;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void XuLyCong(View view){
        EditText txtA = (EditText) findViewById(R.id.edta);
        EditText txtB = (EditText) findViewById(R.id.edtb);
        EditText txtKQ = (EditText) findViewById(R.id.edtketqua);

        String StrA = txtA.getText().toString();
        String StrB = txtB.getText().toString();

        int a = Integer.parseInt(StrA);
        int b = Integer.parseInt(StrB);
        int kq = a + b;
        txtKQ.setText(String.valueOf(kq));
    }
    public void XuLyTru(View view){
        EditText txtA = (EditText) findViewById(R.id.edta);
        EditText txtB = (EditText) findViewById(R.id.edtb);
        EditText txtKQ = (EditText) findViewById(R.id.edtketqua);

        String StrA = txtA.getText().toString();
        String StrB = txtB.getText().toString();

        int a = Integer.parseInt(StrA);
        int b = Integer.parseInt(StrB);
        int kq = a - b;
        txtKQ.setText(String.valueOf(kq));
    }
    public void XuLyNhan(View view){
        EditText txtA = (EditText) findViewById(R.id.edta);
        EditText txtB = (EditText) findViewById(R.id.edtb);
        EditText txtKQ = (EditText) findViewById(R.id.edtketqua);

        String StrA = txtA.getText().toString();
        String StrB = txtB.getText().toString();

        int a = Integer.parseInt(StrA);
        int b = Integer.parseInt(StrB);
        int kq = a * b;
        txtKQ.setText(String.valueOf(kq));
    }
    public void XuLyChia(View view){
        EditText txtA = (EditText) findViewById(R.id.edta);
        EditText txtB = (EditText) findViewById(R.id.edtb);
        EditText txtKQ = (EditText) findViewById(R.id.edtketqua);

        String StrA = txtA.getText().toString();
        String StrB = txtB.getText().toString();

        Double a = Double.parseDouble(StrA);
        Double b = Double.parseDouble(StrB);
        if (b == 0){
            txtKQ.setText("Không thể chia cho 0");
            return;
        }else {
            Double kq = a / b;
            txtKQ.setText(String.valueOf(kq));
        }

    }
}