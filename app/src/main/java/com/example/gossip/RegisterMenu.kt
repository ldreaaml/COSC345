package com.example.gossip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

/**
 * The register menu
 */
class RegisterMenu : AppCompatActivity() {

    /**
     * Creates the register menu and page activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Register button action
        button_register.setOnClickListener {
            val email = editText_email.text.toString()
            val password = editText_password.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email or password is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //Firebase authentication
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {//return@addOnCompleteListener
                        //If successful
                        Log.d("Main", "success")
                        saveUserToFirebaseDatabase()
                    } else {
                        Log.w("Registration", "sign in with email: Failed", it.exception)
                        Toast.makeText(this, "Authentication Failed", Toast.LENGTH_SHORT).show()

                    }
                }
                .addOnFailureListener {
                    Log.d("Main", "failed to create user: ${it.message}")
                }

        }

        //Already got an account button. Takes you to login page
        aready_have_account_textView.setOnClickListener {
            val intent = Intent(this, LoginMenu::class.java)
            startActivity(intent)
        }
    }

    /**
     * Saves users to the Firebase data base
     */
    private fun saveUserToFirebaseDatabase() {
        val uid = FirebaseAuth.getInstance().uid ?:""
        val ref = FirebaseDatabase.getInstance().getReference("/user/$uid")

        val user = Users(uid, editText_username.text.toString(), editText_email.text.toString())

        //Actual save line
        ref.setValue(user)
            .addOnSuccessListener {
                val intent = Intent(this, LoginMenu::class.java)
                startActivity(intent)
            }
    }
}



