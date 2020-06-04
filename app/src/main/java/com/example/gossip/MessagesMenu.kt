package com.example.gossip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.PopupMenu
import com.google.firebase.auth.FirebaseAuth

class MessagesMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages_menu)

        verifyLogin()
    }

    //Verifies lf logged in by checking uid
    private fun verifyLogin() {
        val uid = FirebaseAuth.getInstance().uid
        if (uid == null) {
            Log.d("Session", "not logged in")
        } else {
            Log.d("Session", uid)
        }
    }

    //Creates a menu inflater
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    //Shows the menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.button_new_message -> {
                val intent = Intent(this, NewMessagesActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.button_sign_out -> {
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(this, MainMenu::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
