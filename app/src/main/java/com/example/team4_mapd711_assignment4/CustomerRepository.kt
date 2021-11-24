package com.example.team4_mapd711_assignment4


import android.content.Context
import androidx.lifecycle.LiveData
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//a class for managing multiple data sources
class CustomerRepository {

    //defining database and live data object as companion objects
    companion object {
        var customerDatabase: CustomerDatabase? = null
        var customerModel: LiveData<CustomerModel>? = null

        //initialize database
        fun initializeDB(context: Context) : CustomerDatabase {
            return CustomerDatabase.getDataseClient(context)
        }

        //Initialize insertStudent()
        fun insertCustomer(context: Context, username: String, password: String,
                           fullName: String, country: String, address: String, city: String,
                           postalCode: String, telephone: String, email: String) {
            customerDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                val customerDetails = CustomerModel(username, password, fullName, country,
                    address, city, postalCode, telephone, email)
                customerDatabase!!.customerDao().insertCustomer(customerDetails)
            }

        }

        //Initialize getStudents()
        fun getCustomers(context: Context, username: String) : LiveData<CustomerModel>? {

            customerDatabase = initializeDB(context)
            customerModel = customerDatabase!!.customerDao().getCustomers(username)
            return customerModel
        }

        fun getLogin(context: Context, username: String, password: String) : LiveData<CustomerModel>? {
            customerDatabase = initializeDB(context)
            customerModel = customerDatabase!!.customerDao().getLogin(username, password)
            return customerModel
        }

    }
}