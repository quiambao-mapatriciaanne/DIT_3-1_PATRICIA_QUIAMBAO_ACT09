package com.example.firebasechat


import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val loginView = findViewById<LinearLayout>(R.id.loginLayout)
        val chatView = findViewById<LinearLayout>(R.id.chatLayout)
        val startBtn = findViewById<Button>(R.id.btnStartChat)


        val chatContainer = findViewById<LinearLayout>(R.id.chatContainer)
        val sendBtn = findViewById<Button>(R.id.btnSend)
        val messageInput = findViewById<EditText>(R.id.etMessage)


        startBtn.setOnClickListener {
            loginView.visibility = View.GONE
            chatView.visibility = View.VISIBLE
        }


        sendBtn.setOnClickListener {
            val msg = messageInput.text.toString()
            if (msg.isNotEmpty()) {
                val newBubble = TextView(this)
                newBubble.text = "You:\n$msg"
                newBubble.setTextColor(Color.WHITE)
                newBubble.setBackgroundResource(android.R.drawable.editbox_dropdown_dark_frame) // Temporary bubble look
                newBubble.setPadding(40, 20, 40, 20)


                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.gravity = Gravity.END
                params.setMargins(0, 0, 0, 20)
                newBubble.layoutParams = params


                chatContainer.addView(newBubble)
                messageInput.text.clear()
            }
        }
    }
}
