package com.yeehungchong.sgholidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {

    private ArrayList<Holiday> holiday;
    private Context context;
    private TextView tvName;
    private TextView tvDate;
    private ImageView ivIcon;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        holiday = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvName = rowView.findViewById(R.id.textViewHoliday);
        tvDate = rowView.findViewById(R.id.textViewDate);
        ivIcon = rowView.findViewById(R.id.imageView);

        Holiday currentHoliday = holiday.get(position);
        String currentIcon = currentHoliday.getIconCode();

        tvName.setText(currentHoliday.getNama());
        tvDate.setText(currentHoliday.getDate());

        if (currentHoliday.getIconCode() == "cny") {
            ivIcon.setImageResource(R.drawable.cny);
        } else if (currentHoliday.getIconCode() == "goodFriday") {
            ivIcon.setImageResource(R.drawable.good_friday);
        } else if (currentHoliday.getIconCode() == "labourDay") {
            ivIcon.setImageResource(R.drawable.labour_day);
        } else if (currentHoliday.getIconCode() == "newYear") {
            ivIcon.setImageResource(R.drawable.new_year);
        }

        return rowView;
    }
}
