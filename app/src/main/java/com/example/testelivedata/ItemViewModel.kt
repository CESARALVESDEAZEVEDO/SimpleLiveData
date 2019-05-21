package com.example.testelivedata

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

class ItemViewModel(application: Application) : AndroidViewModel(application) {

    private val itemRepositorio: ItemRepositorio
    private val listaDeItens: LiveData<List<Item>>

    init {
        itemRepositorio = ItemRepositorio(application)
        listaDeItens = itemRepositorio.getItens()
    }

    fun getItens(): LiveData<List<Item>> {
        return listaDeItens
    }

    fun inserir(item: Item) {
        itemRepositorio.inserir(item)
    }

    fun remover(){
        itemRepositorio.delete()
    }
}