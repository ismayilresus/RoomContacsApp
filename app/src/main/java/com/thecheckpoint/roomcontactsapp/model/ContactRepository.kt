package com.thecheckpoint.roomcontactsapp.model

import androidx.lifecycle.LiveData
import com.thecheckpoint.roomcontactsapp.data.Contact
import com.thecheckpoint.roomcontactsapp.data.ContactDao

class ContactRepository(private val contactDao: ContactDao) {
    val allData: LiveData<List<Contact>> = contactDao.allData()

    suspend fun addContact(contact: Contact){
        contactDao.addContact(contact)
    }
}