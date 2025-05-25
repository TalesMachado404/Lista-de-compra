package com.example.listacompras

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val txtProduto = findViewById<EditText>(R.id.txt_produto)
        val btnInserir = findViewById<Button>(R.id.btn_inserir)

        btnInserir.setOnClickListener {
            val produto = txtProduto.text.toString()
            if (produto.isNotBlank()) {
                val intent = Intent()
                intent.putExtra("produto", produto)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}

