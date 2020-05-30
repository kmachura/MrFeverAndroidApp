package com.kmm.mrfever

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class IndexActivity : AppCompatActivity() {

    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null
    private var tvFirstName: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        val menuButton1 = findViewById<ImageButton>(R.id.menu_button1)
        menuButton1.setOnClickListener{
            val intent = Intent(this, ChildrenActivity::class.java)
            startActivity(intent)
        }

        val menuItem1 = findViewById<TextView>(R.id.menu_item1)
        menuItem1.setOnClickListener{
            val intent = Intent(this, ChildrenActivity::class.java)
            startActivity(intent)
        }

        val menuButton2 = findViewById<ImageButton>(R.id.menu_button2)
        menuButton2.setOnClickListener{
            val intent = Intent(this, DoctorsActivity::class.java)
            startActivity(intent)
        }

        val menuItem2 = findViewById<TextView>(R.id.menu_item2)
        menuItem2.setOnClickListener{
            val intent = Intent(this, DoctorsActivity::class.java)
            startActivity(intent)
        }

        val menuButton3 = findViewById<ImageButton>(R.id.menu_button3)
        menuButton3.setOnClickListener{
            val intent = Intent(this, MedicineActivity::class.java)
            startActivity(intent)
        }

        val menuItem3 = findViewById<TextView>(R.id.menu_item3)
        menuItem3.setOnClickListener{
            val intent = Intent(this, MedicineActivity::class.java)
            startActivity(intent)
        }

        val menuButton4 = findViewById<ImageButton>(R.id.menu_button4)
        menuButton4.setOnClickListener{
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
        }

        val menuItem4 = findViewById<TextView>(R.id.menu_item4)
        menuItem4.setOnClickListener{
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
        }

        initialise()

        val mUser = mAuth!!.currentUser
        val mUserReference = mDatabaseReference!!.child(mUser!!.uid)
        mUserReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                tvFirstName!!.text = snapshot.child("firstName").value as String
            }
            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }

    private fun initialise() {
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference.child("Users")
        mAuth = FirebaseAuth.getInstance()
        tvFirstName = findViewById<View>(R.id.user_name) as TextView
    }

}