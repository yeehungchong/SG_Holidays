package com.yeehungchong.sgholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> typesList;
    ArrayAdapter<String> aaTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listViewTypes);

        typesList = new ArrayList();
        typesList.add("Secular");
        typesList.add("Ethnic & Religion");

        aaTypes = new ArrayAdapter(this, android.R.layout.simple_list_item_1, typesList);
        lv.setAdapter(aaTypes);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedTypes = typesList.get(position);

                // start the SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("selectedTypes", selectedTypes);
                startActivity(intent);
            }
        });
    }
}