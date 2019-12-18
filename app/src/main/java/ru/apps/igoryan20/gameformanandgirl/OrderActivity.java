package ru.apps.igoryan20.gameformanandgirl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class OrderActivity extends AppCompatActivity{


    private ListView mListView;
    private Button mSendToRestaraunt;
    private DatePicker mDatePicker;
    private CalendarView mCalendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        mListView = findViewById(R.id.list_item);
        mSendToRestaraunt = findViewById(R.id.sendToRestaraunt);
        mCalendarView = findViewById(R.id.calendarView);
        Bundle arguments = getIntent().getExtras();
        final ArrayList<String> orders = arguments.getStringArrayList("Content");
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                orders);
        mListView.setAdapter(itemsAdapter);

       mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
           @Override
           public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
               view.setVisibility(View.GONE);
           }
       });


        mSendToRestaraunt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OrderActivity.this, "Заказ оформлен", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }


}
