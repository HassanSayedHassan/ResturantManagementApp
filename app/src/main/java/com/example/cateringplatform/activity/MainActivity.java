package com.example.cateringplatform.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cateringplatform.R;
import com.example.cateringplatform.activity.ResturantName;

public class MainActivity extends AppCompatActivity {

    private TextView skipTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skipTV = findViewById(R.id.tv_skip);

        skipTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResturantName.class);
                startActivity(intent);
            }
        });
    }
}
