package com.example.databindingdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.databindingdemo.databinding.EmployeeListItemBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeDataAdapter extends RecyclerView.Adapter<EmployeeDataAdapter.EmployeeViewHolder> {


    Context context;
    List<Employee> employeeList;


    public EmployeeDataAdapter(Context context, List<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        EmployeeListItemBinding employeeListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.employee_list_item, parent, false);

        return new EmployeeViewHolder(employeeListItemBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {

        Employee employee = employeeList.get(position);

        holder.employeeListItemBinding.setEmployee(employee);


    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private EmployeeListItemBinding employeeListItemBinding;

        public EmployeeViewHolder(@NonNull EmployeeListItemBinding employeetListItemBinding) {
            super(employeetListItemBinding.getRoot());

            this.employeeListItemBinding = employeetListItemBinding;
        }
    }
}
