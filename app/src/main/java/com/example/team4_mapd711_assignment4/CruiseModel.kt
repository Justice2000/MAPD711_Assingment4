package com.example.team4_mapd711_assignment4

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Room entity data class - model
//This class describes a database table
@Entity(tableName = "cruise")
data class CruiseModel(

    @PrimaryKey val cruiseCode: String,
    @ColumnInfo(name = "cruiseName") var CruiseName: String,
    @ColumnInfo(name = "visitingPlaces") var VisitingPlaces: String,
    @ColumnInfo(name = "price") var Price: String,
    @ColumnInfo(name = "duration") var TotalDuration: String

){

}

