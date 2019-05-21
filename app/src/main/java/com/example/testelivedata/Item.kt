package com.example.testelivedata

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "item")
class Item(
    @PrimaryKey val descricao: String,
    val quantidade: Int
) : Parcelable