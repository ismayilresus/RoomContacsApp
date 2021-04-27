package com.thecheckpoint.roomcontactsapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thecheckpoint.roomcontactsapp.data.Contact
import com.thecheckpoint.roomcontactsapp.data.ContactDatabase
import com.thecheckpoint.roomcontactsapp.model.ContactRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(application: Application) : AndroidViewModel(application) {

    val allData: LiveData<List<Contact>>
    private val repository: ContactRepository

    init{
        val contactDao = ContactDatabase.getDatabase(application).contactDao()
        repository = ContactRepository(contactDao)
        allData = repository.allData
        }

    fun addContact(contact: Contact){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addContact(contact)
        }
    }

}