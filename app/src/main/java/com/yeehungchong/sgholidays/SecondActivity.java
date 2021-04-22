package com.yeehungchong.sgholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    TextView tvTitle;
    ArrayAdapter aa;
    ArrayList<Holiday> holiday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = findViewById(R.id.listViewHolidays);
        tvTitle = findViewById(R.id.textViewTitle);

        Intent i = getIntent();
        String type = i.getStringExtra("selectedTypes");
        tvTitle.setText(type);

        holiday = new ArrayList<Holiday>();

        if (type.equals("Secular")) {
            holiday.add(new Holiday("New Year's Day", "1 Jan 2017", "newYear"));
            holiday.add(new Holiday("Labour Day", "1 May 2017", "labourDay"));
        } else if (type.equals("Ethnic & Religion")) {
            holiday.add(new Holiday("Chinese New Year", "28-29 Jan 2017", "cny"));
            holiday.add(new Holiday("Good Friday", "14 April 2017", "goodFriday"));
        }

        aa = new HolidayAdapter(this, R.layout.row, holiday);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedHoliday = holiday.get(position);
                Toast.makeText(SecondActivity.this, selectedHoliday.getNama() + ": " + selectedHoliday.getDate(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}