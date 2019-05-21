package com.example.testelivedata

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class MeuDataBase : RoomDatabase() {

    abstract fun getItemDao(): ItemDao

    companion object {
        private var instancia: MeuDataBase? = null

        fun getInstancia(contexto: Context): MeuDataBase {
            return instancia ?: synchronized(this) {
                instancia = Room.databaseBuilder(contexto.applicationContext, MeuDataBase::class.java, "bancoitem").build()
                instancia
            }!!
        }
    }
}