package com.example.team4_mapd711_assignment4

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

//provides data to the UI and acts as a communication center
// between the Repository and the UI.
class BookingViewModel : ViewModel() {

    // calling repository tasks and
    // sending the results to the Activity
    var liveDataBooking: LiveData<BookingModel>? = null

    //
    fun insertBooking(context: Context, customerId: String, cruiseCode: String,
                      numberOfAdults: Int, numberOfKids: Int, amountPaid: Int, hasOldPeople: Boolean) {
        BookingRepository.insertBooking(context, customerId, cruiseCode, numberOfAdults,numberOfKids,
            amountPaid, hasOldPeople)
    }

    fun getBooking(context: Context, customerId: String) : LiveData<BookingModel>? {
        liveDataBooking = BookingRepository.getBooking(context, customerId)
        return liveDataBooking
    }
}