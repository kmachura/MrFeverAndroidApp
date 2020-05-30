package com.kmm.mrfever

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import android.widget.EditText as TextView

class AddChildActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener,
    OnCompleteListener<Void> {

    private val paths = arrayOf("girl", "boy", "I do not want to tell")
    private var etChildName: TextView? = null
    private var etChildBirthday: TextView? = null
    private var etChildBloodType: TextView? = null
    private var childSex: Spinner? = null
    private var createChildProfile: Button? = null

    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null

    private val TAG = "AddChildActivity"

    private var childName: String? = null
    private var childBirthday: String? = null
    private var childBloodType: String? = null
    private var tvChildSex: String? = null
    private var selectedChildSex: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_child)

        val spinner = findViewById<Spinner>(com.kmm.mrfever.R.id.spinner_sex)
        val adapter = ArrayAdapter(
            this@AddChildActivity,
            R.layout.support_simple_spinner_dropdown_item, paths
        )

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinner.setAdapter(adapter)
        spinner.setOnItemSelectedListener(this)

        initialise()

    }

    private fun initialise() {
        etChildName = findViewById<View>(R.id.child_name) as android.widget.EditText
        etChildBirthday = findViewById<View>(R.id.child_birthday) as android.widget.EditText
        etChildBloodType = findViewById<View>(R.id.child_blood_type) as android.widget.EditText
        //child sex/?
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

        if (!TextUtils.isEmpty(childName) && !TextUtils.isEmpty(childBirthday)
            && !TextUtils.isEmpty(childBloodType) && !TextUtils.isEmpty(selectedChildSex)) {

            val userId = mAuth!!.currentUser!!.uid
            val createdChild = Child(childName, childBirthday, childBloodType, selectedChildSex, userId)
            mDatabaseReference
                ?.setValue(createdChild)
                ?.addOnCompleteListener(this)
                ?.addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "createChildProfile:success")
                        updateUserInfoAndUI()
                    } else {
                        Log.w(TAG, "createChildProfile:failure", task.exception)
                        Toast.makeText(this@AddChildActivity, "Creation of child's profile failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show()
        }

    }

    private fun updateUserInfoAndUI() {
        //start next activity
        val intent = Intent(this@AddChildActivity, ChildProfileCreatedActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    override fun onItemSelected(
        parent: AdapterView<*>?,
        v: View?,
        position: Int,
        id: Long
    ) {
        when (position) {
            0 -> { selectedChildSex = paths[0]
            }
            1 -> { selectedChildSex = paths[1]
            }
            2 -> { selectedChildSex = paths[2]
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // TODO Auto-generated method stub
    }

    override fun onComplete(p0: Task<Void>) {
        TODO("Not yet implemented")
    }

}