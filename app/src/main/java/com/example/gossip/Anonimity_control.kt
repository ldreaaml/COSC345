package com.example.gossip

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Anonimity_control : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.chat_log_settings)
        val button_full = findViewById(R.id.btn_Full_Anonimity) as Button
        val button_half = findViewById(R.id.btn_Full_Anonimity) as Button
        val button_no = findViewById(R.id.btn_Full_Anonimity) as Button

    setContentView(R.layout.chat_log_from_row)
        val textReceived = findViewById(R.id.textView_chat_log) as TextView

    setContentView(R.layout.chat_log_from_row)
        val textSent = findViewById(R.id.textView_chat_log) as TextView

    //Set message received and sent in same colour
    button_full.setOnClickListener(){
            textReceived.setBackgroundColor(Color.argb(255, 255, 255, 255))
            textSent.setBackgroundColor(Color.argb(255, 255, 255, 255))
    }

        //Set message received and and sent in different colours
    button_half.setOnClickListener(){
            textReceived.setBackgroundColor(Color.argb(255, 0, 255, 255))
            textSent.setBackgroundColor(Color.argb(255, 255, 0, 255))
    }

        //Dont change anything if there is a no button clicked
    button_no.setOnClickListener(){
            //This will show the full user id and etc
    }
    }
}