package com.example.team4_mapd711_assignment4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FifthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        //switch button to go to next activity
        val sixthActbutton = findViewById<Button>(R.id.sixth_act_btn)
        //when click on the button, we open the second activity window
        sixthActbutton.setOnClickListener {
            val intent6 = Intent(this, SixthActivity::class.java)
            startActivity(intent6)
        }
    }
}