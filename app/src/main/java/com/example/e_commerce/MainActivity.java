package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e_commerce.adapter.CategoryAdapter;
import com.example.e_commerce.adapter.CourseAdapter;
import com.example.e_commerce.model.Category;
import com.example.e_commerce.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;

    CategoryAdapter categoryAdapter;

   static CourseAdapter courseAdapter;

    static List<Course> courseList = new ArrayList<>();

    static List<Course> fullCoursesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();

        categoryList.add(new Category(1, "Игры"));
        categoryList.add(new Category(2, "Сайты"));
        categoryList.add(new Category(3, "Языки"));
        categoryList.add(new Category(4, "Прочее"));

        setCategoryRecycler(categoryList);

        String java_desc = getString(R.string.java_desc);
        String python_desc = getString(R.string.python_desc);
        String unity_desc = getString(R.string.unity_desc);
        String front_desc = getString(R.string.front_desc);
        String stack_desc = getString(R.string.stack_desc);

        courseList.add(new Course(1, "java", "Profession Java\ndeveloper", "1 января", "начальный", "#424345", java_desc, 3));
        courseList.add(new Course(2, "python", "Profession Python\ndeveloper", "10 января", "начальный", "#9FA52D", python_desc, 3));
        courseList.add(new Course(3, "unity", "Profession Unity\ndeveloper", "5 января", "начальный", "#65173D", unity_desc, 1));
        courseList.add(new Course(4, "front_end", "Profession Front-end\ndeveloper", "10 января", "начальный", "#B04935", front_desc, 2));
        courseList.add(new Course(5, "full_stack", "Profession Full Stack\ndeveloper", "7 января", "начальный", "#FFC007", stack_desc, 4));

        fullCoursesList.addAll(courseList);

        setCourseRecycler(courseList);

    }

    public void openShoppingCart(View view){
        Intent intent = new Intent(this, order_page.class);
        startActivity(intent);
    }

    private void setCourseRecycler(List<Course> courseList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    public static void showCoursesByCategory(int category){

        courseList.clear();
        courseList.addAll(fullCoursesList);

        List<Course> filterCourses = new ArrayList<>();

        for (Course c:courseList){
            if (c.getCategory()==category){
                filterCourses.add(c);
            }
        }

        courseList.clear();
        courseList.addAll(filterCourses);

        courseAdapter.notifyDataSetChanged();
    }
}