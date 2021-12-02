package com.lymin.beentogetherpro.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

import com.lymin.beentogetherpro.R;
import com.lymin.beentogetherpro.Utils;
import com.lymin.beentogetherpro.databinding.ActivitySetupOneBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SetupOneActivity extends AppCompatActivity {

    private ActivitySetupOneBinding binding;
    private static String TAG = "SetupOneActivity";
    private String today;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_setup_one);
        today = Utils.getToday();
        binding.calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
               String sinceDay = (month+1)+"/"+dayOfMonth+"/"+year;
               if (isValidate((month+1),dayOfMonth,year)){
                   calculateDate(sinceDay,today);
               } else {
                   Toast.makeText(getApplicationContext(),"not Validate",Toast.LENGTH_SHORT).show();
                   binding.tvDays.setText("0 days");
               }

            }
        });

    }

    private boolean isValidate(int m1, int d1, int y1){
        Date date = Calendar.getInstance().getTime();
        Calendar currentDateTime = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("yyyy");
        String year = df.format(currentDateTime.getTime());

        int d2 = date.getDay()-2;
        int m2 = date.getMonth()+1;
        int y2 = Integer.parseInt(year);

        boolean b = false;
        Log.d(TAG, "isValidate: A ==> "+d1+"/"+m1+"/"+y1);
        Log.d(TAG, "isValidate: B ==> "+d2+"/"+m2+"/"+y2);
        if (y2==y1){
            if (m2==m1){
                if (d2>=d1){
                    b = true;
                }
            }else b = m2 > m1;
        } else b = y2 > y1;

        return b;
    }
    @SuppressLint("SetTextI18n")
    private void calculateDate(String sinceDay, String today){
        Log.d(TAG, "calculateDate: ==> "+sinceDay+"--> "+today);
        try {
            Date date1;
            Date date2;
            @SuppressLint("SimpleDateFormat") SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");
            date1 = dates.parse(sinceDay);
            date2 = dates.parse(today);
            long difference = Math.abs(date1.getTime() - date2.getTime());
            long differenceDates = difference / (24 * 60 * 60 * 1000);
            String dayDifference = Long.toString(differenceDates);
            binding.tvDays.setText(dayDifference+" days");
        } catch (Exception exception) {
            Toast.makeText(this, "Unable to find difference", Toast.LENGTH_SHORT).show();
        }
    }
}