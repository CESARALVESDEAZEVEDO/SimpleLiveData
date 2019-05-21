package com.example.testelivedata

import android.app.Application
import android.arch.lifecycle.LiveData
import org.jetbrains.anko.doAsync

class ItemRepositorio(application: Application) {

    private var itemDao: ItemDao
    private var liveDataItens: LiveData<List<Item>>

    init {
        itemDao = MeuDataBase.getInstancia(application).getItemDao()
        liveDataItens = itemDao.listar()
    }

    fun getItens(): LiveData<List<Item>> {
        return liveDataItens
    }

    fun inserir(item: Item) {
        doAsync { itemDao.insert(item) }
    }

    fun delete(){
        doAsync { itemDao.remover() }
    }
}