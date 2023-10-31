package com.example.utsppam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val fabButton = findViewById<FloatingActionButton>(R.id.fab)

        fabButton.setOnClickListener {
            // TODO: Handle FAB button click (e.g., open a new activity)
        }

        setFoodItemClickListener(R.id.pizza, "Pepperoni Pizza")
        setFoodItemClickListener(R.id.spaghetti, "Spaghetti")
        setFoodItemClickListener(R.id.burger, "Burger")
        setFoodItemClickListener(R.id.steak, "Steak")
    }

    private fun setFoodItemClickListener(foodItemId: Int, foodName: String) {
        val foodItemLayout = findViewById<LinearLayout>(foodItemId)
        val userId = intent.getStringExtra("USER_ID")
        val userIdTextView = findViewById<TextView>(R.id.user_id)
        userIdTextView.text = "Hello, $userId"
        val storeLocation = intent.getStringExtra("STORE_LOCATION")

        foodItemLayout.setOnClickListener {
            when (foodName) {
                "Pepperoni Pizza" -> {
                    val intent = Intent(this, MainActivity4::class.java)
                    intent.putExtra("FOOD_NAME", foodName)
                    intent.putExtra("USER_ID", userId)
                    intent.putExtra("STORE_LOCATION", storeLocation)
                    startActivity(intent)
                }

                "Spaghetti" -> {
                    val intent = Intent(this, MainActivity5::class.java)
                    intent.putExtra("FOOD_NAME", foodName)
                    intent.putExtra("USER_ID", userId)
                    intent.putExtra("STORE_LOCATION", storeLocation)
                    startActivity(intent)
                }

                "Burger" -> {
                    val intent = Intent(this, MainActivity6::class.java)
                    intent.putExtra("FOOD_NAME", foodName)
                    intent.putExtra("USER_ID", userId)
                    intent.putExtra("STORE_LOCATION", storeLocation)
                    startActivity(intent)
                }

                "Steak" -> {
                    val intent = Intent(this, MainActivity7::class.java)
                    intent.putExtra("FOOD_NAME", foodName)
                    intent.putExtra("USER_ID", userId)
                    intent.putExtra("STORE_LOCATION", storeLocation)
                    startActivity(intent)
                }
            }
        }
    }
}