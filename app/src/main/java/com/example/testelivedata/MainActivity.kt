package com.example.testelivedata

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private var meuViewModel: ItemViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        meuViewModel = ViewModelProviders.of(this).get(ItemViewModel::class.java)
        meuViewModel?.getItens()?.observe(this, Observer { itens ->
            if (itens != null) {
                val sb = StringBuilder()
                for (item in itens) {
                    sb.appendln("${item.descricao} - ${item.quantidade}")
                }
                meu_text_view.text = sb.toString()
            }
        })

        button.setOnClickListener {
            val quantidade = meuViewModel?.getItens()?.value?.size ?: 0
            meuViewModel?.inserir(Item("ITEM${quantidade}", quantidade))
        }

        button2.setOnClickListener {
            meuViewModel?.remover()
        }
    }
}
