package com.example.utsppam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.store_location)
        ArrayAdapter.createFromResource(
            this,
            R.array.store_location,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        val btnSubmit = findViewById<Button>(R.id.submitButton)
        btnSubmit?.setOnClickListener {
            val selectedLocation = spinner.selectedItem.toString()

            val inputNama = findViewById<EditText>(R.id.user_id)
            val nama = inputNama.text.toString()

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("NAMA", nama)
            intent.putExtra("LOCATION", selectedLocation)
            startActivity(intent)
        }
    }
}
