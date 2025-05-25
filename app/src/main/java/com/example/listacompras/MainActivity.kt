package com.example.listacompras

import android.os.Bundle
import android.widget.ArrayAdapter
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.ActivityResult



class MainActivity : AppCompatActivity() {
    private lateinit var produtosAdapter: ArrayAdapter<String>
    private val listaProdutos = mutableListOf<String>()

    private val cadastroLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            val produto = result.data?.getStringExtra("produto")
            produto?.let {
                listaProdutos.add(it)
                produtosAdapter.notifyDataSetChanged()
            }
        }
    }

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
        val listView = findViewById<ListView>(R.id.list_view_produtos)
        val btn_adicionar = findViewById<Button>(R.id.btn_adicionar)
        val intent = Intent(this, CadastroActivity::class.java)

        //iniciando	a	atividade
        startActivity(intent)

        btn_adicionar.setOnClickListener	{
            //Criando	a	Intent	explícita
            val	intent	=	Intent(this,	CadastroActivity::class.java)
            //iniciando	a	atividade
            startActivity(intent)
        }

        // Adaptador da lista
        produtosAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaProdutos)
        listView.adapter = produtosAdapter


        //Delete da lista
        listView.setOnItemLongClickListener { parent, view, position, id ->
            val item = listaProdutos[position]
            listaProdutos.removeAt(position)
            produtosAdapter.notifyDataSetChanged()
            true
        }
    }
}