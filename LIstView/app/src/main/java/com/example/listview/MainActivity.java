package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

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
        ArrayList<String> dulieu = new ArrayList<>();
        dulieu.add("ngay hom ay" );
        dulieu.add("pho real");
        dulieu.add("ghen");
        dulieu.add("từng quen");

        ListView listViewBH = (ListView) findViewById(R.id.listbaihatyt);

        ArrayAdapter<String> baihat_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dulieu);

        listViewBH.setAdapter(baihat_adapter);

        listViewBH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long j) {
                String baihat = baihat_adapter.getItem(i);
                Toast.makeText(MainActivity.this, baihat, Toast.LENGTH_SHORT).show();
            }
        });



    }

}