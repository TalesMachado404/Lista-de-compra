package com.example.listacompras

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var produtosAdapter: ArrayAdapter<String>
    private val listaProdutos = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referência dos componentes da UI
        val editText = findViewById<EditText>(R.id.txt_produto)
        val button = findViewById<Button>(R.id.btn_inserir)
        val listView = findViewById<ListView>(R.id.list_view_produtos)

        // Adaptador da lista
        produtosAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaProdutos)
        listView.adapter = produtosAdapter

        // Ação do botão
        button.setOnClickListener {
            val produto = editText.text.toString()
            if (produto.isNotBlank()) {
                listaProdutos.add(produto)
                produtosAdapter.notifyDataSetChanged()
                editText.text.clear()
            }
        }

        //
        button.setOnClickListener {
            val produto = editText.text.toString()
            if (produto.isNotBlank()) {
                listaProdutos.add(produto)
                produtosAdapter.notifyDataSetChanged()
                editText.text.clear()
            }
        }

        //Delete da lista
        listView.setOnItemLongClickListener { parent, view, position, id ->
            val item = listaProdutos[position]
            listaProdutos.removeAt(position)
            produtosAdapter.notifyDataSetChanged()
            true
        }


    }
}
// pag 152