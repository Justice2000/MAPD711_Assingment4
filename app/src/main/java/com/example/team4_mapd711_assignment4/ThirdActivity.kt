package com.example.team4_mapd711_assignment4

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class ThirdActivity : AppCompatActivity() {

    lateinit var option : Spinner
    lateinit var option2 : Spinner
    lateinit var option3 : Spinner
    lateinit var result : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        //doing spinner stuff
        option = findViewById(R.id.spinneradults) as Spinner
        option2 = findViewById(R.id.spinnerkids) as Spinner
        option3 = findViewById(R.id.spinnerseniors) as Spinner
        result = findViewById(R.id.tv_result) as TextView

        val options = arrayOf("0","1","2","3","4")
        val options2 = arrayOf("0","1","2","3","4")
        val options3 = arrayOf("0","1","2","3","4")
        option.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        option2.adapter =ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options2)
        option3.adapter =ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options3)

        var res = 0
        val sharedpref: SharedPreferences =this.getSharedPreferences("shared",0)
        val editor: SharedPreferences.Editor=sharedpref.edit()


        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val text1 = options.get(position)
                res = text1.toInt()
                findViewById<TextView>(R.id.tv_result).text = text1
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                result.text = "Please select an option"
            }
        }
        option2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                val text2 = options2.get(position)
                res += text2.toInt()
                findViewById<TextView>(R.id.tv_result).text = res.toString()
                //  editor.putString("res",res.toString())
                //  editor.commit()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                result.text = "Please select an option"
            }
        }
        option3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                val text3 = options2.get(position)
                res += text3.toInt()
                findViewById<TextView>(R.id.tv_result).text = res.toString()
                editor.putString("res",res.toString())
                editor.commit()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                result.text = "Please select an option"
            }
        }

        //going to 4th activity
        val fourthActbutton = findViewById<Button>(R.id.fourth_act_btn)
        //when click on the button, we open the second activity window
        fourthActbutton.setOnClickListener {
            val intent4 = Intent(this, CheckoutActivity::class.java)
            startActivity(intent4)
        }
    }
}