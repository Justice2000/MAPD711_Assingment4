package com.example.team4_mapd711_assignment4

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

//provides data to the UI and acts as a communication center
// between the Repository and the UI.
class CruiseViewModel : ViewModel() {

    // calling repository tasks and
    // sending the results to the Activity
    var liveDataCruise: LiveData<CruiseModel>? = null

    //
    fun insertCruise(context: Context, cruiseCode: String, cruiseName: String,
                     visitingPlaces: String, price: String, duration: String) {
        CruiseRepository.insertCruise(context, cruiseCode, cruiseName, visitingPlaces,
            price, duration)

    }

    fun getCruises(context: Context, cruiseCode: String) : LiveData<CruiseModel>? {
        liveDataCruise = CruiseRepository.getCruises(context, cruiseCode)
        return liveDataCruise
    }
}