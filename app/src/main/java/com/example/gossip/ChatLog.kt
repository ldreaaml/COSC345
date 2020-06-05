package com.example.gossip

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class ChatLog : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_log)

        supportActionBar?.title = "Chat log"

        Log.d("Chatlog", "Did come here")
    }
}

class ChatLogAdapter(private val temp: Array<String>) : RecyclerView.Adapter<ChatLogAdapter.ChatLogViewHolder>() {

    class ChatLogViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ChatLogAdapter.ChatLogViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ChatLogAdapter.ChatLogViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}