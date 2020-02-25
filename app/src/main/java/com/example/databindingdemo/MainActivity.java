package com.example.databindingdemo;

import android.os.Bundle;

import com.example.databindingdemo.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));


        binding.recyclerView.setAdapter(new EmployeeDataAdapter(this, prepareData()));
    }


    public List<Employee> prepareData() {

        List<String> names = Arrays.asList(getResources().getStringArray(R.array.names));
        List<String> emails = Arrays.asList(getResources().getStringArray(R.array.emails));

        int[] imageIds = {R.drawable.boy_img2, R.drawable.boy_img1, R.drawable.girl_img1, R.drawable.girl_img2, R.drawable.girl_img3, R.drawable.boy_img3, R.drawable.boy_img5, R.drawable.boy_img4, R.drawable.girl_img5, R.drawable.girl_img4};

        List<Employee> employeeList = new ArrayList<>();

        int count = 0;

        for (String name : names) {
            employeeList.add(new Employee(name, emails.get(count), imageIds[count]));
            count++;
        }

        return employeeList;
    }
}

