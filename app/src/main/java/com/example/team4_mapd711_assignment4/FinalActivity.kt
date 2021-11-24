package com.example.team4_mapd711_assignment4

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FinalActivity : AppCompatActivity() {

    lateinit var customerViewModel: CustomerViewModel
    lateinit var bookingViewModel: BookingViewModel
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        //creating sharedpreference to store values from keys declared in other activities
        val sharedPref3: SharedPreferences =this.getSharedPreferences("shared",0)

        val fullname = findViewById<TextView>(R.id.customername_tv)
        fullname.text = sharedPref3.getString("fullname","")
        val address = findViewById<TextView>(R.id.customeradress_tv)
        address.text = sharedPref3.getString("paddress","")
        val country = findViewById<TextView>(R.id.citycountry_tv)
        country.text = sharedPref3.getString("pcountry","")
        val cruisef = findViewById<TextView>(R.id.cruiseF_tv)
        cruisef.text = sharedPref3.getString("cruise","")
        val placesF = findViewById<TextView>(R.id.visitF_tv)
        placesF.text = sharedPref3.getString("visits","")
        val durationF = findViewById<TextView>(R.id.durationF_tv)
        durationF.text = sharedPref3.getString("duration","")
        val guestF = findViewById<TextView>(R.id.guestsF_tv)
        guestF.text = sharedPref3.getString("res","")
        val nightsF = findViewById<TextView>(R.id.nightsF_tv)
        nightsF.text = sharedPref3.getString("duration","")
        val priceF = findViewById<TextView>(R.id.priceF_tv)
        priceF.text = sharedPref3.getString("price","")


    }
}