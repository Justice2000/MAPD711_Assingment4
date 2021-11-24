package com.example.team4_mapd711_assignment4

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

//a class for managing multiple data sources
class BookingRepository {

    //defining database and live data object as companion objects
    companion object {
        var customerDatabase: CustomerDatabase? = null
        var bookingModel: LiveData<BookingModel>? = null

        //initialize database
        fun initializeDB(context: Context) : CustomerDatabase {
            return CustomerDatabase.getDataseClient(context)
        }


        fun insertBooking(context: Context, customerId: String, cruiseCode: String,
                          numberOfAdults: Int, numberOfKids: Int, amountPaid: Int, hasOldPeople: Boolean ) {
            customerDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                val bookingDetails = BookingModel(customerId, cruiseCode, numberOfAdults, numberOfKids, amountPaid, hasOldPeople)
                customerDatabase!!.bookingDao().insertBooking(bookingDetails)
            }

        }


        fun getBooking(context: Context, customerId: String) : LiveData<BookingModel>? {
            customerDatabase = initializeDB(context)
            bookingModel = customerDatabase!!.bookingDao().getBooking(customerId)
            return bookingModel
        }
    }
}