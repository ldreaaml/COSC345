package com.example.gossip

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_new_message.*
import kotlinx.android.synthetic.main.user_list.view.*


class NewMessagesActivity : AppCompatActivity() {
    private lateinit var mDatabase: DatabaseReference
    private lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_message)

        supportActionBar?.title = "Select User"

        //val adapter = GroupAdapter<GroupieViewHolder>()

        rv_select_user.layoutManager = LinearLayoutManager(this)
        fetchUser()

    }

    //Fetches users from the database
    private fun fetchUser() {
        val database = FirebaseDatabase.getInstance().getReference("/user")

        database.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(p0: DataSnapshot) {
                val userList = mutableListOf<Users>()
                p0.children.forEach{
                    val userItem = it.getValue(Users::class.java)
                    if (userItem != null) {
                        userList.add(userItem)
                    }
                }

                rv_select_user.adapter = MyAdapter(userList)
            }

            override fun onCancelled(p0: DatabaseError) {

            }
        })

    }
}

//Does the recycler view stuff. Messy stuff
class MyAdapter(private val userList: MutableList<Users>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener(){
                val intent = Intent(itemView.context, ChatLog::class.java)
                itemView.context.startActivity(intent)
            }
        }

    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        // create a new view
        val textView = LayoutInflater.from(parent?.context)
        val cellRow = textView.inflate(R.layout.user_list, parent, false)
        // set the view's size, margins, paddings and layout parameters

        return MyViewHolder(cellRow)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val i = userList[position]
        //holder.bind(i)
        holder.itemView.textView_username_new_messages?.text = i.username
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return userList.size
    }

}
