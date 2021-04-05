package com.thecheckpoint.roomcontactsapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(application: Application) : AndroidViewModel(application) {

    private val allData: LiveData<List<Contact>>
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