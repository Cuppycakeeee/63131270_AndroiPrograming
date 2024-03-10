package com.example.addsubmuldiv_anynomous;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editTextA, editTextB, editKQ;
    Button btnCong, btnTru, btnNhan, btnChia;

    public void TimDieuKhien(){
        editTextA = findViewById(R.id.edta);
        editTextB = findViewById(R.id.edtb);
        editKQ = findViewById(R.id.edtketqua);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        View.OnClickListener BoXuLyAnDanh = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double a = Double.parseDouble(editTextA.getText().toString());
                Double b = Double.parseDouble(editTextB.getText().toString());
                Double kq = 0.0;
                if (v.getId() == R.id.btnCong) {
                    kq = a + b;
                } else if (v.getId() == R.id.btnTru) {
                    kq = a - b;
                } else if (v.getId() == R.id.btnNhan) {
                    kq = a * b;
                } else if (v.getId() == R.id.btnChia) {
                    if (b != 0){ kq = a / b;}
                    else{
                        editKQ.setText("Không thể chia cho 0");
                        return;
                    }
                }
                editKQ.setText(kq + "");
            }
        };

        btnCong.setOnClickListener(BoXuLyAnDanh);
        btnTru.setOnClickListener(BoXuLyAnDanh);
        btnNhan.setOnClickListener(BoXuLyAnDanh);
        btnChia.setOnClickListener(BoXuLyAnDanh);

    }
}