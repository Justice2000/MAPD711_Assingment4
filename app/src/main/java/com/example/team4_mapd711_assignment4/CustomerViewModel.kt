package com.example.team4_mapd711_assignment4


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

//provides data to the UI and acts as a communication center
// between the Repository and the UI.
class CustomerViewModel : ViewModel() {

    // calling repository tasks and
    // sending the results to the Activity
    var liveDataCustomer: LiveData<CustomerModel>? = null

    //
    fun insertCustomer(context: Context, username: String, password: String,
                       fullName: String, country: String, address: String, city: String,
                       postalCode: String, telephone: String, email: String) {
        CustomerRepository.insertCustomer(context, username, password, fullName,
            country, address, city, postalCode, telephone, email)
    }

    fun getCustomers(context: Context, username: String?) : LiveData<CustomerModel>? {
        liveDataCustomer = CustomerRepository.getCustomers(context, username.toString())
        return liveDataCustomer
    }

    fun getLogin(context: Context, username: String, password: String) : LiveData<CustomerModel>? {
        liveDataCustomer = CustomerRepository.getLogin(context, username.toString(), password.toString())
        return liveDataCustomer
    }
}