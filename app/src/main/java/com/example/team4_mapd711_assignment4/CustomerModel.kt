package com.example.team4_mapd711_assignment4

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Room entity data class - model
//This class describes a database table
@Entity(tableName = "customer")
data class CustomerModel(
    @ColumnInfo(name="userName") var UserName: String,
    @ColumnInfo(name="password") var Password: String,
    @ColumnInfo(name="fullName") var FullName: String,
    @ColumnInfo(name="address") var Address: String,
    @ColumnInfo(name="country") var Country: String,
    @ColumnInfo(name="city") var City: String,
    @ColumnInfo(name="postalCode") var PostalCode: String,
    @ColumnInfo(name="Telephone") var Telephone: String,
    @ColumnInfo(name="Email") var Email: String

){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="customerId") var CustomerId: Int? = null
}

