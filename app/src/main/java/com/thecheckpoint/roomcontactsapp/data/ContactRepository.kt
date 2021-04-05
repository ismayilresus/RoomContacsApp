package com.thecheckpoint.roomcontactsapp.data

import androidx.lifecycle.LiveData

class ContactRepository(private val contactDao: ContactDao) {
    val allData: LiveData<List<Contact>> = contactDao.allData()

    suspend fun addContact(contact: Contact){
        contactDao.addContact(contact)
    }
}