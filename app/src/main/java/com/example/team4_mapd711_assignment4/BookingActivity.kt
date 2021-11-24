package com.example.team4_mapd711_assignment4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BookingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)
        //creating a button variable and find button by using the button ID given in main.xml file
        val secondActbutton = findViewById<Button>(R.id.second_act_btn)
        //when click on the button, we open the next activity window
        secondActbutton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }
}