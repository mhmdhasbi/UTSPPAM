package com.example.utsppam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast

class MainActivity8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        val submitButton = findViewById<Button>(R.id.submitButton)
        val doneButton = findViewById<Button>(R.id.submitButton)
        val takeawayCheckBox = findViewById<CheckBox>(R.id.CheckBox)
        val fastDeliveryCheckBox = findViewById<CheckBox>(R.id.CheckBox2)

        val userIdTextView = findViewById<TextView>(R.id.user_id)
        val locationTextView = findViewById<TextView>(R.id.store_location)
        val orderTextView = findViewById<TextView>(R.id.order_textView)

        val userId: String = intent.getStringExtra("USER_ID") ?: "User"
        val storeLocation = intent.getStringExtra("STORE_LOCATION")
        val foodItem: String = intent.getStringExtra("FOOD_NAME") ?: "Food"

        userIdTextView.text = userId
        locationTextView.text = "Store : $storeLocation"
        orderTextView.text = "Pesanan: $foodItem"

        // Handle submitButton click
        submitButton.setOnClickListener {
            // Tambahkan tindakan yang sesuai saat tombol "Done" diklik
        }

        // Handle doneButton click
        doneButton.setOnClickListener {
            if (takeawayCheckBox.isChecked && fastDeliveryCheckBox.isChecked) {
                showToast("Pilih hanya satu opsi: Ambil Sendiri atau Fast Delivery.")
            } else if (!takeawayCheckBox.isChecked && !fastDeliveryCheckBox.isChecked) {
                showToast("Pilih salah satu opsi: Ambil Sendiri atau Fast Delivery.")
            } else {
                val toastMessage = buildToastMessage(
                    userId,
                    foodItem,
                    takeawayCheckBox.isChecked,
                    fastDeliveryCheckBox.isChecked
                )
                showToast(toastMessage)
            }
        }
    }

    private fun buildToastMessage(
        userId: String,
        foodItem: String,
        ambilSendiriChecked: Boolean,
        fastDeliveryChecked: Boolean
    ): String {
        val stringBuilder =
            StringBuilder("Terima kasih $userId sudah memesan\nditoko kami. Pesanan $foodItem ")

        if (ambilSendiriChecked) {
            stringBuilder.append("akan anda ambil sendiri.\n")
        }

        if (fastDeliveryChecked) {
            stringBuilder.append(". Pesanan anda akan dikirim menggunakan Fast Delivery.\n")
        }

        return stringBuilder.toString()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}