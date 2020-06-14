package com.kmm.mrfever

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.kmm.mrfever.model.Child

class ChildProfileActivity : AppCompatActivity() {

    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null

    private var tvBirthday: TextView? = null
    private var tvBloodType: TextView? = null
    private var tvLastDoctorsAppointment: TextView? = null
    private var tvLastMedicineGiven: TextView? = null
    private var tvName: TextView? = null
    private var ivAvatar: ImageView? = null

    private var value: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child_profile)

        var bundle = intent.extras
        value = bundle!!.getString("name")
        tvName = findViewById<View>(R.id.name) as TextView
        tvName!!.text = value

        val addMedButton = findViewById<Button>(R.id.add_med_button)
        addMedButton.setOnClickListener{
            val intent = Intent(this, AddMedActivity::class.java)
            startActivity(intent)
        }

        val addDoctorsAppointmentButton = findViewById<Button>(R.id.add_doc_app_button)
        addMedButton.setOnClickListener{
            val intent = Intent(this, AddDoctorsAppointmentActivity::class.java)
            startActivity(intent)
        }

        initialise()
    }

    private fun initialise() {
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference.child("Children")
        mAuth = FirebaseAuth.getInstance()
        tvBirthday = findViewById<View>(R.id.ch_birthday) as TextView
        tvBloodType = findViewById<View>(R.id.ch_blood_type) as TextView
        tvLastDoctorsAppointment = findViewById<View>(R.id.ch_last_doc_app) as TextView
        tvLastMedicineGiven = findViewById<View>(R.id.ch_last_med) as TextView
        ivAvatar = findViewById<View>(R.id.avatar) as ImageView
    }

    override fun onStart() {
        super.onStart()
        val mUser = mAuth!!.currentUser!!.uid

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

                var selectedChild: Child? = null

                for (child in children) {
                    if (child.childName.equals(value)) {
                        selectedChild = child
                    }
                }

                tvBirthday!!.text = selectedChild!!.childBirthday
                tvBloodType!!.text = selectedChild!!.childBloodType

                when (selectedChild.selectedChildSex) {
                            "girl" -> {
                                ivAvatar!!.setImageResource(R.drawable.girl)
                            }
                            "boy" -> {
                                ivAvatar!!.setImageResource(R.drawable.boy)
                            }
                            "I do not want to tell" -> {
                                ivAvatar!!.setImageResource(R.drawable.undefined)
                            }
                        }
                        print(selectedChild)
                    }

            override fun onCancelled(databaseError: DatabaseError) {
                throw databaseError.toException()
            }
        })

    }

}
