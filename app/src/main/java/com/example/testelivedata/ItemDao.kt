package com.example.testelivedata

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ItemDao {

    @Insert
    fun insert(item: Item)

    @Query("SELECT * FROM item ORDER BY quantidade")
    fun listar(): LiveData<List<Item>>

    @Query("DELETE FROM item")
    fun remover()

    @Query("DELETE FROM item WHERE quantidade = :quantidade ")
    fun removeItem(quantidade : Int)
}