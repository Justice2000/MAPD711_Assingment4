package com.example.team4_mapd711_assignment4

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.team4_mapd711_assignment4.CustomerModel

//Room entity data class - model
//This class describes a database table
@Entity(tableName = "booking")
data class BookingModel(
    @ColumnInfo(name="customerId") var CustomerId: String,
    @ColumnInfo(name="cruiseCode") var CruiseCode: String,
    @ColumnInfo(name="numberOfAdults") var NumberOfAdults: Int,
    @ColumnInfo(name="numberOfKids") var NumberOfKids: Int,
    @ColumnInfo(name="totalAmount") var TotalAmount: Int,
    @ColumnInfo(name="hasOldPeople") var HasOldPeople: Boolean
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="bookingId") var BookingId: Int? = null
}