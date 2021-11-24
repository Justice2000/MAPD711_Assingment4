package com.example.team4_mapd711_assignment4

import android.content.Context
import androidx.room.*

//Room database
@Database(entities = arrayOf(CustomerModel::class, CruiseModel::class, BookingModel::class), version = 1, exportSchema = false)
abstract class CustomerDatabase : RoomDatabase() {
    //instantiating Student DAO object
    abstract fun customerDao() : CustomerDao
    abstract fun cruiseDao() : CruiseDao
    abstract fun bookingDao() : BookingDao

    //companion object means an object declaration inside a class
    companion object {

        //Volatile object or property is immediately made visible to other threads.
        @Volatile
        private var INSTANCE: CustomerDatabase? = null

        //create a database name "STUDENTDB"
        fun getDataseClient(context: Context) : CustomerDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, CustomerDatabase::class.java, "CUSTOMERDB")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }
    }
}