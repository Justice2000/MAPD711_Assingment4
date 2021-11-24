package com.example.team4_mapd711_assignment4

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CheckoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        //created shared preference object
        val sharedPreferences: SharedPreferences =this.getSharedPreferences("shared",0)

        //created constants to view the cruise details using previous keys from second activity and spinner
        val cruisename = findViewById<TextView>(R.id.cruiseF_tv)
        cruisename.text = sharedPreferences.getString("cruise","")
        val price = findViewById<TextView>(R.id.price_tv)
        price.text = sharedPreferences.getString("price","")
        val nights = findViewById<TextView>(R.id.nights_tv)
        nights.text = sharedPreferences.getString("duration","")
        val guests = findViewById<TextView>(R.id.guest_tv)
        guests.text = sharedPreferences.getString("res","")

        //creating a button variable and find button by using the button ID given in main.xml file
        val fifthActbutton = findViewById<Button>(R.id.button2)
        //when click on the button, we open the next activity window
        fifthActbutton.setOnClickListener {
            val intent5 = Intent(this, FifthActivity::class.java)
            startActivity(intent5)
        }
    }


}