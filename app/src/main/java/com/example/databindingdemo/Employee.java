package com.example.databindingdemo;

import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import de.hdodenhof.circleimageview.CircleImageView;

public class Employee {

    public String name, email;
    public int imageId;

    public Employee(String name, String email, int imageId) {
        this.name = name;
        this.email = email;
        this.imageId = imageId;
    }

    //code for loading image
    @BindingAdapter("android:imageUrl")
    public static void loadImage(View view, int imageId) {

        CircleImageView imageView = (CircleImageView) view;

        imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), imageId));
    }
}
