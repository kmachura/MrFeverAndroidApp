package com.kmm.mrfever

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class YourChildrenActivity : AppCompatActivity() {

    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null

    private var listView: ListView? = null

    var adapter: ArrayAdapter<Any>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your_children)
        initialise()

    }

    private fun initialise() {
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference!!.child("Children")
        mAuth = FirebaseAuth.getInstance()
        listView = findViewById<ListView>(R.id.children_list)
    }

    override fun onStart() {
        super.onStart()
        val mUser = mAuth!!.currentUser!!.uid!!

        val childrenRef = FirebaseDatabase.getInstance().reference.child("Children").child(mUser)
        childrenRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val children = dataSnapshot.children.map {
                    it.getValue(
                        Child
                        ::class.java
                    )!!
                }
                Log.d("TAG", "Value is: $children")

                var childNames = mutableListOf<String>()

                for (child in children) childNames.add(child.childName!!)

                val listItems = arrayOfNulls<String>(childNames.size)

                for (i in 0 until childNames.size) {
                    listItems[i] = childNames[i]
                }

                val adapter =
                    ArrayAdapter(this@YourChildrenActivity, R.layout.listview_item, childNames)
                listView?.setAdapter(adapter)

                listView?.setOnItemClickListener { parent, view, position, id ->
                    val element = parent.getItemAtPosition(position) // The item that was clicked
                    val intent = Intent(this@YourChildrenActivity, ChildProfileActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    intent.putExtra("name", element.toString())
                    startActivity(intent)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                throw databaseError.toException()
            }

        })
    }
}