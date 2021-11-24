package com.example.team4_mapd711_assignment4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class ProfileActivity : AppCompatActivity() {

    lateinit var customerViewModel: CustomerViewModel
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val updatebutton = findViewById<Button>(R.id.profileUpdate_bt)
        val bookbutton = findViewById<Button>(R.id.profileBook_bt)

        //creating a shared preference object
        val sharedpref4: SharedPreferences = this.getSharedPreferences("shared", 0)
        val editor: SharedPreferences.Editor = sharedpref4.edit()

        val username = sharedpref4.getString("username","").toString()
        val usernameTV = findViewById<TextView>(R.id.username_tv1)
        usernameTV.setText(username)
        val fullname = findViewById<EditText>(R.id.profileName)
        //fullname.setText(sharedpref4.getString("fullname",""))
        val address = findViewById<EditText>(R.id.profileAddress)
        //address.setText(sharedpref4.getString("address",""))
        val city = findViewById<EditText>(R.id.profileCity)
        //city.setText(sharedpref4.getString("city",""))
        val country = findViewById<EditText>(R.id.profileCountry)
        //country.setText(sharedpref4.getString("country",""))
        val postal = findViewById<EditText>(R.id.profilePostal)
        //postal.setText(sharedpref4.getString("postal",""))
        val telephone = findViewById<EditText>(R.id.profileTelephone)
        //telephone.setText(sharedpref4.getString("telephone",""))
        val email = findViewById<EditText>(R.id.profileEmail)
        //email.setText(sharedpref4.getString("email",""))

        customerViewModel = ViewModelProvider(this).get(CustomerViewModel::class.java)

        context = this@ProfileActivity

        customerViewModel.getCustomers(context, username)!!.observe(this, Observer {
            if (it == null){
                fullname.setText(" ")
                address.setText(" ")
                city.setText(" ")
                country.setText(" ")
                postal.setText(" ")
                telephone.setText(" ")
                email.setText(" ")
            }
            else
            {
                fullname.setText(it.FullName)
                address.setText(it.Address)
                city.setText(it.City)
                country.setText(it.Country)
                postal.setText(it.PostalCode)
                telephone.setText(it.Telephone)
                email.setText(it.Email)
            }
        })

        updatebutton.setOnClickListener {

            /*
            //creating intent object to switch activities
            val intent = Intent(this, FinalActivity::class.java)

            //creating shareprefrence editor keys
            editor.putString("paddress", address.text.toString())
            editor.putString("pcity", city.text.toString())
            editor.putString("pcountry", country.text.toString())
            editor.putString("ppostal", postal.text.toString())
            editor.putString("ptelephone", telephone.text.toString())
            editor.putString("pemail", email.text.toString())
            editor.commit()*/

            Toast.makeText(applicationContext,"Profile Updated Successfully",Toast.LENGTH_LONG).show()
        }

        bookbutton.setOnClickListener {

            //creating intent object to switch to booking screen
            val intent = Intent(this, BookingActivity::class.java)

            startActivity(intent)
        }

    }
}