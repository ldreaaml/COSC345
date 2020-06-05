package com.example.gossip

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginMenu: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button_login.setOnClickListener {
            val email = editText_login_email.text.toString()
            val password = editText_login_password.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email or password is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener{
                    if(it.isSuccessful){
                        Log.d("Login", "Login Success")

                        val intent = Intent(this, MessagesMenu::class.java)

                        startActivity(intent)
                        finish()
                    } else {
                        Log.w("Login", "Sign in with email failed")
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()

                    }
                }


        }
    }
}