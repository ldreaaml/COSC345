package com.example.gossip

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.main_menu_activity.*

class MainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu_activity)

        button_Menu_Login.setOnClickListener{
            val loginIntent = Intent(this, LoginMenu::class.java)
            startActivity(loginIntent)
        }

        button_Menu_Register.setOnClickListener{
            val registerIntent = Intent(this, RegisterMenu::class.java)
            startActivity(registerIntent)
        }
    }
}