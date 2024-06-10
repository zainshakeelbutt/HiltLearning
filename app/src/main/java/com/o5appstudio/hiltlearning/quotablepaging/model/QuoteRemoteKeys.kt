package com.o5appstudio.hiltlearning.quotablepaging.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuoteRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val prevPage : Int?,
    val nextPage : Int?
)
