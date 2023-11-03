package com.myfirstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// This activity will show on the screen when we click on "Learn More" in one of the cards
// from home screen (main activity)

// AppCompatActivity -> we have to use this when creating a activity
class EngineeringDetailActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_engineering_detail)
    }
}