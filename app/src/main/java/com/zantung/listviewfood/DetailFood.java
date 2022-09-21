package com.zantung.listviewfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFood extends AppCompatActivity {
    ImageView imageViewChiTiet;
    TextView tvNameFoodCT;
    TextView tvMotaCT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);
        imageViewChiTiet = (ImageView) findViewById(R.id.imageViewDetail);
        tvNameFoodCT = (TextView) findViewById(R.id.tvNameFoodDetail);
        tvMotaCT = (TextView) findViewById(R.id.tvMotaDetail);

        Intent intent = getIntent();

        if(intent != null){
            Food food = (Food) intent.getSerializableExtra("data");
            imageViewChiTiet.setImageResource(food.getHinh());
            tvNameFoodCT.setText(food.getTen());
            tvMotaCT.setText(food.getMota());
        }
    }
}