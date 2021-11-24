package com.example.team4_mapd711_assignment4

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

//a class for managing multiple data sources
class CruiseRepository {

    //defining database and live data object as companion objects
    companion object {
        var customerDatabase: CustomerDatabase? = null
        var cruiseModel: LiveData<CruiseModel>? = null

        //initialize database
        fun initializeDB(context: Context) : CustomerDatabase {
            return CustomerDatabase.getDataseClient(context)
        }

        //Initialize insertStudent()
        fun insertCruise(context: Context, cruiseCode: String, cruiseName: String,
                         visitingPlaces: String, price: String, duration: String) {
            customerDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                val cruiseDetails = CruiseModel(cruiseCode, cruiseName, visitingPlaces, price,
                    duration)
                customerDatabase!!.cruiseDao().insertCruise(cruiseDetails)
            }

        }

        //Initialize getStudents()
        fun getCruises(context: Context, cruiseCode: String) : LiveData<CruiseModel>? {

            customerDatabase = initializeDB(context)
            cruiseModel = customerDatabase!!.cruiseDao().getCruises(cruiseCode)
            return cruiseModel
        }
    }
}