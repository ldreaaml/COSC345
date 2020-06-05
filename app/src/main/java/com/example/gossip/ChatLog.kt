package com.example.gossip

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_chat_log.*
import kotlinx.android.synthetic.main.chat_log_from_row.view.*

class ChatLog : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_log)

        supportActionBar?.title = "Chat log"
        val s = "His"

        rv_chat_log.layoutManager = LinearLayoutManager(this)
        rv_chat_log.adapter = ChatLogAdapter(s)
    }
}

class ChatLogAdapter(private val temp: String) :
    RecyclerView.Adapter<ChatLogAdapter.ChatLogViewHolder>() {

    class ChatLogViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int) : ChatLogAdapter.ChatLogViewHolder {

        val textView = LayoutInflater.from(parent?.context)
        val cellRow = textView.inflate(R.layout.chat_log_from_row, parent, false)
        // set the view's size, margins, paddings and layout parameters

        return ChatLogViewHolder(cellRow)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: ChatLogAdapter.ChatLogViewHolder, position: Int) {
        holder.itemView.textView_chat_log.text = "123"
    }


}