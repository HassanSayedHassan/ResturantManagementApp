package com.example.cateringplatform.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

import com.example.cateringplatform.R
import com.example.cateringplatform.activity.ResturantName

class MainActivity : AppCompatActivity() {

    private var skipTV: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        skipTV = findViewById(R.id.tv_skip)

        skipTV!!.setOnClickListener {
            val intent = Intent(applicationContext, ResturantName::class.java)
            startActivity(intent)
        }
    }
}
