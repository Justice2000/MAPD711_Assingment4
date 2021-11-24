package com.example.team4_mapd711_assignment4
/*
Student1 Name: Ishtiaque Ahmed
Student1 ID: 301223010
Course: Android App Development
Date: 09/20/2021
Short description: This is the part 1 of Assignment 1, which is a simple text field excercise to take inputs from the user and click on the SEND button to display those inputs
in a second activity window.

*/
//importing necessary libraries and components
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //creating a button variable and find button by using the button ID given in main.xml file
        val signinActbutton = findViewById<Button>(R.id.signin_act_btn)
        //when click on the button, we open the next activity window
        signinActbutton.setOnClickListener {
            val intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)
        }
        //creating a button variable and find button by using the button ID given in main.xml file
        val signupActbutton = findViewById<Button>(R.id.signup_act_btn)
        //when click on the button, we open the next activity window
        signupActbutton.setOnClickListener {
            val intent2 = Intent(this, SignupActivity::class.java)
            startActivity(intent2)
        }

    }
}