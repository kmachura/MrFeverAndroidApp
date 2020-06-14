package com.kmm.mrfever

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import android.widget.EditText
import com.kmm.mrfever.model.Child
import java.util.regex.Matcher
import java.util.regex.Pattern

class AddChildActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private val options = arrayOf("girl", "boy", "I do not want to tell")
    private var etChildName: EditText? = null
    private var etChildBirthday: EditText? = null
    private var etChildBloodType: EditText? = null
    private var createChildProfile: Button? = null

    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null

    private val TAG = "AddChildActivity"

    private var childName: String? = null
    private var childBirthday: String? = null
    private var childBloodType: String? = null
    private var selectedChildSex: String? = null

    private lateinit var pattern: Pattern
    private lateinit var matcher: Matcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_child)

        val spinner = findViewById<Spinner>(R.id.spinner_sex)
        val adapter = ArrayAdapter(
            this@AddChildActivity,
            R.layout.support_simple_spinner_dropdown_item, options
        )

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinner.setAdapter(adapter)
        spinner.setOnItemSelectedListener(this)

        initialise()

    }

    private fun initialise() {
        etChildName = findViewById<View>(R.id.child_name) as EditText
        etChildBirthday = findViewById<View>(R.id.child_birthday) as EditText
        etChildBloodType = findViewById<View>(R.id.child_blood_type) as EditText
        createChildProfile = findViewById<View>(R.id.create_child_profile_button) as Button
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference.child("Children")
        mAuth = FirebaseAuth.getInstance()
        createChildProfile!!.setOnClickListener { createNewChildAccount() }
    }

    private fun createNewChildAccount() {
        childName = etChildName?.text.toString()
        childBirthday = etChildBirthday?.text.toString()
        childBloodType = etChildBloodType?.text.toString()

        val birthdayPattern = "^(1[0-9]|0[1-9]|3[0-1]|2[1-9])/(0[1-9]|1[0-2])/[0-9]{4}\$"
        pattern = Pattern.compile(birthdayPattern)
        matcher = pattern.matcher(childBirthday)

        if(!matcher.matches()) {
            Toast.makeText(
                this,
                "Date of birth should be provided in format: DD/MM/YYYY.",
                Toast.LENGTH_SHORT
            ).show()
        }
        else if (!TextUtils.isEmpty(childName) && !TextUtils.isEmpty(childBirthday)
            && !TextUtils.isEmpty(selectedChildSex)) {

            val userId = mAuth!!.currentUser!!.uid
            val createdChild = Child(
                childName,
                childBirthday,
                childBloodType,
                selectedChildSex,
                userId
            )
            mDatabaseReference
                ?.child(userId)?.push()?.setValue(createdChild)
                ?.addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "createChildProfile:success")
                        Toast.makeText(this@AddChildActivity,
                                        "Profile of ${createdChild.childName} was created",
                                        Toast.LENGTH_SHORT).show()
                        updateUserInfoAndUI()
                    } else {
                        Log.w(TAG, "createChildProfile:failure", task.exception)
                        Toast.makeText(this@AddChildActivity, "Creation of child's profile failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(this, "Enter all the details. Only the blood type is not required.", Toast.LENGTH_SHORT).show()
        }

    }

    private fun updateUserInfoAndUI() {
        //start next activity
        val intent = Intent(this@AddChildActivity, ChildProfileActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("name", childName)
        startActivity(intent)
    }

    override fun onItemSelected(
        parent: AdapterView<*>?,
        v: View?,
        position: Int,
        id: Long
    ) {
        when (position) {
            0 -> { selectedChildSex = options[0]
            }
            1 -> { selectedChildSex = options[1]
            }
            2 -> { selectedChildSex = options[2]
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show()
    }

}