package com.kmm.mrfever.views.index

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.kmm.mrfever.MrFeverApplication
import com.kmm.mrfever.R
import javax.inject.Inject

class IndexActivity : AppCompatActivity(), IndexView {

//   TODO: ("implement in a MVP way")
//    private var mDatabaseReference: DatabaseReference? = null
//    private var mDatabase: FirebaseDatabase? = null
//    private var mAuth: FirebaseAuth? = null
//    private var tvFirstName: TextView? = null

    @Inject
    lateinit var presenter: IndexPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        (application as MrFeverApplication).component.inject(this)

        val menuButton1 = findViewById<ImageButton>(R.id.menu_button1)
        menuButton1.setOnClickListener{
            presenter.onMenuButton1Clicked()
        }

        val menuItem1 = findViewById<TextView>(R.id.menu_item1)
        menuItem1.setOnClickListener{
            presenter.onMenuButton1Clicked()
        }

        val menuButton2 = findViewById<ImageButton>(R.id.menu_button2)
        menuButton2.setOnClickListener{
            presenter.onMenuButton2Clicked()
        }

        val menuItem2 = findViewById<TextView>(R.id.menu_item2)
        menuItem2.setOnClickListener{
            presenter.onMenuButton2Clicked()
        }

        val menuButton3 = findViewById<ImageButton>(R.id.menu_button3)
        menuButton3.setOnClickListener{
            presenter.onMenuButton3Clicked()
        }

        val menuItem3 = findViewById<TextView>(R.id.menu_item3)
        menuItem3.setOnClickListener{
            presenter.onMenuButton3Clicked()
        }

        val menuButton4 = findViewById<ImageButton>(R.id.menu_button4)
        menuButton4.setOnClickListener{
            presenter.onMenuButton4Clicked()
        }

        val menuItem4 = findViewById<TextView>(R.id.menu_item4)
        menuItem4.setOnClickListener{
            presenter.onMenuButton4Clicked()
        }

//        TODO("part of previous TODO")
//        initialise()
//
//        val mUser = mAuth!!.currentUser
//        val mUserReference = mDatabaseReference!!.child(mUser!!.uid)
//        mUserReference.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                tvFirstName!!.text = snapshot.child("firstName").value as String
//            }
//            override fun onCancelled(databaseError: DatabaseError) {}
//        })
    }

//    TODO: ("part of previous TODO")
//    private fun initialise() {
//        mDatabase = FirebaseDatabase.getInstance()
//        mDatabaseReference = mDatabase!!.reference.child("Users")
//        mAuth = FirebaseAuth.getInstance()
//        tvFirstName = findViewById<View>(R.id.user_name) as TextView
//    }

    override fun navigateTo(target: Class<*>) {
        startActivity(Intent(this, target))
    }

}
