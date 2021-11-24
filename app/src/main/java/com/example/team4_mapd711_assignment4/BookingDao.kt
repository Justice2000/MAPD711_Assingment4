package com.example.team4_mapd711_assignment4

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// Room DAO - Data Access Object Interface
// this interface declares database functions
// and does the mapping of SQL queries to functions
@Dao
interface BookingDao {

    //defining an insert method using @Insert Annotation
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBooking(bookingModel: BookingModel)

    //defining a query method using @Query Annotation
    @Query("SELECT * FROM booking WHERE customerId=:customerId")
    fun getBooking(customerId: String?) : LiveData<BookingModel>
}