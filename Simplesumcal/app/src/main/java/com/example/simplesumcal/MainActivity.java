package com.example.simplesumcal;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
2
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
}