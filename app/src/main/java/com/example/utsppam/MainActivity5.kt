package com.example.utsppam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val userId = intent.getStringExtra("USER_ID")
        val storeLocation = intent.getStringExtra("STORE_LOCATION")
        val foodName = intent.getStringExtra("FOOD_NAME")

        val submitButton = findViewById<Button>(R.id.submitButton)
        val backButton = findViewById<Button>(
            R.id.backButton
        )

        submitButton.setOnClickListener {
            val intent = Intent(this, MainActivity8::class.java)
            intent.putExtra("FOOD_NAME", foodName)
            intent.putExtra("USER_ID", userId)
            intent.putExtra("STORE_LOCATION", storeLocation)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("USER_ID", userId)
            intent.putExtra("STORE_LOCATION", storeLocation)
            startActivity(intent)
        }
    }
}
