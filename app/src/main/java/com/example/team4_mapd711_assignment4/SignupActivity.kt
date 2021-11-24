package com.example.team4_mapd711_assignment4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class SignupActivity : AppCompatActivity() {

    lateinit var customerViewModel: CustomerViewModel
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //creating a button variable and find button by using the button ID given in xml file
        val profileActbutton = findViewById<Button>(R.id.signup_btn)

        context = this@SignupActivity

        customerViewModel = ViewModelProvider(this).get(CustomerViewModel::class.java)

            //creating a shared preference object
            val sharedPref5: SharedPreferences = this.getSharedPreferences("shared", 0)
            val editor: SharedPreferences.Editor = sharedPref5.edit()

            val fullname2 = findViewById<EditText>(R.id.SUfullnameEditT)
            val username2 = findViewById<EditText>(R.id.SUusernameEditT)
            val password2 = findViewById<EditText>(R.id.SUpasswordEditT)
            val address2 = findViewById<EditText>(R.id.SUaddressEditT)
            val city2 = findViewById<EditText>(R.id.SUcityEditT)
            val country2 = findViewById<EditText>(R.id.SUcountryEditT)
            val postal2 = findViewById<EditText>(R.id.SUpostalEditT)
            val telephone2 = findViewById<EditText>(R.id.SUtelephoneEditT)
            val email2 = findViewById<EditText>(R.id.SUemailEditT)

        profileActbutton.setOnClickListener {
                var username = username2.text.toString().trim()
                var password = password2.text.toString().trim()
                var fullname = fullname2.text.toString()
                var address = address2.text.toString()
                var country = country2.text.toString()
                var city = city2.text.toString()
                var postalCode = postal2.text.toString().trim()
                var telephone = telephone2.text.toString().trim()
                var email = email2.text.toString().trim()

                if(username.isEmpty() || password.isEmpty() || fullname.isEmpty() || address.isEmpty() || country.isEmpty() || city.isEmpty() || postalCode.isEmpty() ||
                    telephone.isEmpty() || email.isEmpty()){
                    Toast.makeText(this, "Cannot leave any fields empty", Toast.LENGTH_SHORT).show()
                }
                else{
                    customerViewModel.insertCustomer(context, username, password, fullname, address, country, city, postalCode, telephone, email)
                    editor.putString("username", username)
                    editor.commit()
                    Toast.makeText(this, "Signing Up", Toast.LENGTH_SHORT).show()
                    intent = Intent(this@SignupActivity, ProfileActivity::class.java)
                    intent.putExtra("UserName", username)
                    Toast.makeText(applicationContext,"Sign Up Successful",Toast.LENGTH_LONG).show()
                    startActivity(intent)

                }


        }


    }
}