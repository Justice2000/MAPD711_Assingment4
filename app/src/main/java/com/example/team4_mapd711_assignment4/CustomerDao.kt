package com.example.team4_mapd711_assignment4


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.team4_mapd711_assignment4.CustomerModel

// Room DAO - Data Access Object Interface
// this interface declares database functions
// and does the mapping of SQL queries to functions
@Dao
interface CustomerDao {

    //defining an insert method using @Insert Annotation
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCustomer(customerModel: CustomerModel)

    //defining a query method using @Query Annotation
    @Query("SELECT * FROM customer WHERE userName=:username")
    fun getCustomers(username: String?) : LiveData<CustomerModel>

    @Query("SELECT * FROM customer WHERE userName=:username AND password=:password")
    fun getLogin(username: String?, password:String?) : LiveData<CustomerModel>
}