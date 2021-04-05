package com.thecheckpoint.roomcontactsapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_table")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val mail: String,
    val number: String
)