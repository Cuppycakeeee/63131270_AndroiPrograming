package com.example.listview_additem;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtThongTin;
    ListView lvTen;
    ArrayList<String> dsTen;

    void AnhXa() {
        edtThongTin = (EditText) findViewById(R.id.edtThongTin);
        lvTen = (ListView) findViewById(R.id.lvTen);
    }


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
        AnhXa();
        dsTen = new ArrayList<String>();
        dsTen.add("Võ Tấn Thành");
        dsTen.add("Trần Trung Tín");
        dsTen.add("Lê Văn Luyện");
        dsTen.add("Trần Ngọc Phượng");

        ArrayAdapter<String> danhSachTen = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dsTen);
        lvTen.setAdapter(danhSachTen);

        lvTen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtThongTin.setText(dsTen.get(position));
            }
        });
    }


    public void ThemPhanTu(View view) {
        EditText edtThongTin = (EditText) findViewById(R.id.edtThongTin);
        String ten = edtThongTin.getText().toString();
        dsTen.add(ten);
        ArrayAdapter<String> danhSachTen = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dsTen);
        lvTen.setAdapter(danhSachTen);
        danhSachTen.notifyDataSetChanged();
        edtThongTin.setText("");
    }

}