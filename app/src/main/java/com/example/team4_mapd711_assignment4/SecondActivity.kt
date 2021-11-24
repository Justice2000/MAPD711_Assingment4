package com.example.team4_mapd711_assignment4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class SecondActivity : AppCompatActivity() {

    lateinit var customerViewModel: CustomerViewModel
    lateinit var cruiseViewModel: CruiseViewModel
    lateinit var bookingViewModel: BookingViewModel
    lateinit var context: Context


    var isBahamasBooked:Boolean=false
    var isCaribbeanBooked:Boolean=false
    var isCubaBooked:Boolean=false
    var isSamplerBooked:Boolean=false
    var isStarBooked:Boolean=false

    public fun onCheckboxClicked(view: View)
    {

        context = this@SecondActivity

        cruiseViewModel = ViewModelProvider(this).get(CruiseViewModel::class.java)

        //creating sharedpreferences object to store cruise details
        val sharedpref:SharedPreferences=this.getSharedPreferences("shared",0)
        val editor:SharedPreferences.Editor=sharedpref.edit()

        //created if statements to check if clicked on check boxes
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.bahamasCB -> {
                    if (checked) {
                        val cruiseCode = "CR0001"
                        val cruiseName = findViewById<TextView>(R.id.bahamas).text.toString()
                        val price = findViewById<TextView>(R.id.bahamaPrice).text.toString()
                        val duration = findViewById<TextView>(R.id.bahamasDuration).text.toString()
                        val visitingPlaces = findViewById<TextView>(R.id.bahamasVisit).text.toString()

                        cruiseViewModel.insertCruise(context, cruiseCode, cruiseName, visitingPlaces, price, duration)

                    }
                }
                R.id.caribbeanCB -> {
                    if (checked) {
                        val cruiseCode = "CR0002"
                        val cruiseName = findViewById<TextView>(R.id.caribbean).text.toString()
                        val price = findViewById<TextView>(R.id.caribbeanPrice).text.toString()
                        val duration = findViewById<TextView>(R.id.caribbeanDuration).text.toString()
                        val visitingPlaces = findViewById<TextView>(R.id.caribbeanVisit).text.toString()

                        cruiseViewModel.insertCruise(context, cruiseCode, cruiseName, visitingPlaces, price, duration )

                        /*editor.putString("cruise",bookedCruises)
                        editor.putString("price",price)
                        editor.putString("duration",duration)
                        editor.putString("visits",visits)
                        editor.commit()*/
                    }
                }
                R.id.cubaCB -> {
                    if (checked) {
                        val cruiseCode = "CR0003"
                        val bookedCruises = findViewById<TextView>(R.id.cuba).text.toString()
                        val price = findViewById<TextView>(R.id.cubaPrice).text.toString()
                        val duration = findViewById<TextView>(R.id.cubaDuration).text.toString()
                        val visits = findViewById<TextView>(R.id.cubaVisit).text.toString()

                        editor.putString("cruise",bookedCruises)
                        editor.putString("price",price)
                        editor.putString("duration",duration)
                        editor.putString("visits",visits)
                        editor.commit()

                    }
                }
                R.id.samplerCB -> {
                    if (checked) {

                        val cruiseCode = "CR0004"
                        val bookedCruises = findViewById<TextView>(R.id.sampler).text.toString()
                        val price = findViewById<TextView>(R.id.samplerPrice).text.toString()
                        val duration = findViewById<TextView>(R.id.samplerDuration).text.toString()
                        val visits = findViewById<TextView>(R.id.samplerVisit).text.toString()

                        editor.putString("cruise",bookedCruises)
                        editor.putString("price",price)
                        editor.putString("duration",duration)
                        editor.putString("visits",visits)
                        editor.commit()

                    }
                } R.id.starCB -> {
                if (checked) {

                    val cruiseCode = "CR0005"
                    val bookedCruises = findViewById<TextView>(R.id.star).text.toString()
                    val price = findViewById<TextView>(R.id.starPrice).text.toString()
                    val duration = findViewById<TextView>(R.id.starDuration).text.toString()
                    val visits = findViewById<TextView>(R.id.starVisit).text.toString()

                    editor.putString("cruise",bookedCruises)
                    editor.putString("price",price)
                    editor.putString("duration",duration)
                    editor.putString("visits",visits)
                    editor.commit()

                }
            }
            }
            //println("🔥" + bookedCruises)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //Add confirm button
        val confirmbutton = findViewById<Button>(R.id.confirmbt)

        // Locate Check Buttons
        val BahamasCheckbox = findViewById<CheckBox>(R.id.bahamasCB)
        val CaribbeanCheckbox = findViewById<CheckBox>(R.id.caribbeanCB)
        val CubaCheckbox = findViewById<CheckBox>(R.id.cubaCB)
        val SamplerCheckbox = findViewById<CheckBox>(R.id.samplerCB)
        val StarCheckBox = findViewById<CheckBox>(R.id.starCB)

        //setting onclick listener for confirm button to open the third activity
        confirmbutton.setOnClickListener {
            val intent2 = Intent(this@SecondActivity, ThirdActivity::class.java)

            intent2.putExtra("test",123)
            startActivity(intent2) }

    }

    //creating the menu option
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    //creating the menu items and if statement to replace item on click
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId== R.id.BahamasCruise) {
            var a = supportFragmentManager.beginTransaction()
            var b = BahamasCruise()
            //setting the fragments to replace the previous option on click
            a.replace(R.id.container, b)
            a.commit()

        }

        if(item.itemId== R.id.CaribbeanCruise) {
            var a = supportFragmentManager.beginTransaction()
            var b = CaribbeanCruise()
            a.replace(R.id.container, b)
            a.commit()
        }

        if(item.itemId== R.id.CubaCruise) {
            var a = supportFragmentManager.beginTransaction()
            var b = CubaCruise()
            a.replace(R.id.container, b)
            a.commit()
        }

        if(item.itemId== R.id.SamplerCruise) {
            var a = supportFragmentManager.beginTransaction()
            var b = SamplerCruise()
            a.replace(R.id.container, b)
            a.commit()
        }

        if(item.itemId== R.id.StarCruise) {
            var a = supportFragmentManager.beginTransaction()
            var b = StarCruise()
            a.replace(R.id.container, b)
            a.commit()
        }
        return super.onOptionsItemSelected(item)
    }
}