package com.example.team4_mapd711_assignment4

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SixthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sixth)

        val confirmbutton = findViewById<Button>(R.id.sixbutton)

        confirmbutton.setOnClickListener {

            //creating intent object to switch activities
            val intent = Intent(this, FinalActivity::class.java)

            //creating a shared preference object
            val sharedpref2:SharedPreferences = this.getSharedPreferences("shared", 0)
            val editor:SharedPreferences.Editor = sharedpref2.edit()

            val fullname = findViewById<EditText>(R.id.fullname).text.toString()
            val address = findViewById<EditText>(R.id.address).text.toString()
            val city = findViewById<EditText>(R.id.city).text.toString()
            val country = findViewById<EditText>(R.id.country).text.toString()
            val postal = findViewById<EditText>(R.id.postal).text.toString()
            val telephone = findViewById<EditText>(R.id.telephone).text.toString()
            val email = findViewById<EditText>(R.id.email).text.toString()

            //creating shareprefrence editor keys
            editor.putString("fullname", fullname)
            editor.putString("address", address)
            editor.putString("city", city)
            editor.putString("country", country)
            editor.putString("postal", postal)
            editor.putString("telephone", telephone)
            editor.putString("email", email)
            editor.commit()

            startActivity(intent)
        }
    }
}