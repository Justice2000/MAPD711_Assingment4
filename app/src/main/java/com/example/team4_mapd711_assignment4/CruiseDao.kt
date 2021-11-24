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
interface CruiseDao {

    //defining an insert method using @Insert Annotation
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCruise(cruiseModel: CruiseModel)

    //defining a query method using @Query Annotation
    @Query("SELECT * FROM cruise WHERE cruiseCode=:cruiseCode")
    fun getCruises(cruiseCode: String?) : LiveData<CruiseModel>
}