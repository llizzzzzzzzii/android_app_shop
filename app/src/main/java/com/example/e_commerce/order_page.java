package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.e_commerce.model.Course;
import com.example.e_commerce.model.Order;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("MissingInflatedId")

public class order_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        ListView orders_list = findViewById(R.id.orders_list);

        List<String> coursesTitle = new ArrayList<>();

        for (Course c : MainActivity.fullCoursesList){
            if (Order.items_id.contains(c.getId())){
                coursesTitle.add(c.getTitle());
            }
        }

        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coursesTitle));
    }
}