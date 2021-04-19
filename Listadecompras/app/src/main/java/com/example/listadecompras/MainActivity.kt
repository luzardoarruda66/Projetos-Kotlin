package com.example.listadecompras

import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ProdutosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        val lista_view_produto = findViewById<ListView>(R.id.lista_view_produto)
        lista_view_produto.adapter = ProdutosAdapter
        val btn_inserir = findViewById<Button>(R.id.button)
        lista_view_produto.adapter = ProdutosAdapter
        val produto = findViewById<TextInputEditText>(R.id.txt_produto) as TextInputEditText
        btn_inserir.setOnClickListener(){
            if (produto.text.toString().isNotEmpty()){
                ProdutosAdapter.add(produto.text.toString())
                produto.text?.clear()
            }else{
                produto.setError("Preencha o nome do produto!")
            }

        }
        lista_view_produto.setOnLongClickListener {adapterView: AdapterView<*>, View, position : Int, id : Long ->
            val item = ProdutosAdapter.getItem(position)
            ProdutosAdapter.remove(item)
        }

    }
}

private fun ListView.setOnLongClickListener(function: (AdapterView<*>, View, Int, Long) -> Unit) {

}
