package com.kmm.mrfever

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.regex.Matcher
import java.util.regex.Pattern

class AddDoctorsAppointmentActivity : AppCompatActivity() {

    private var etDocName: EditText? = null
    private var etDocSpec: EditText? = null
    private var etDocAppDate: EditText? = null
    private var etDocAppHour: EditText? = null
    private var etDocAppRec: EditText? = null
    private var etNextDocApp: EditText? = null
    private var etPrescMed: EditText? = null
    private var addDocAppButton: Button? = null

    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null

    private val TAG = "AddDoctorsAppointment"

    private var docName: String? = null
    private var docSpec: String? = null
    private var docAppDate: String? = null
    private var docAppHour: String? = null
    private var docAppRec: String? = null
    private var nextDocApp: String? = null
    private var prescMed: String? = null

    private lateinit var pattern: Pattern
    private lateinit var matcher: Matcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_doctors_appointment)

        initialise()
    }

    private fun initialise() {
        etDocName = findViewById<View>(R.id.doc_name) as EditText
        etDocSpec = findViewById<View>(R.id.doc_spec) as EditText
        etDocAppDate = findViewById<View>(R.id.doc_app_date) as EditText
        etDocAppHour = findViewById<View>(R.id.doc_app_hour) as EditText
        etDocAppRec = findViewById<View>(R.id.doc_app_rec) as EditText
        etNextDocApp = findViewById<View>(R.id.next_doc_app) as EditText
        etPrescMed = findViewById<View>(R.id.presc_med) as EditText
        addDocAppButton = findViewById<View>(R.id.add_doc_app) as Button
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference.child("Doctors")
        mAuth = FirebaseAuth.getInstance()
        addDocAppButton!!.setOnClickListener { addDoctorsAppointment() }
    }

    private fun addDoctorsAppointment() {
        docName = etDocName?.text.toString()
        docSpec = etDocSpec?.text.toString()
        docAppDate = etDocAppDate?.text.toString()
        docAppHour = etDocAppHour?.text.toString()
        docAppRec = etDocAppRec?.text.toString()
        nextDocApp = etNextDocApp?.text.toString()
        prescMed = etPrescMed?.text.toString()

        val docAppDatePattern = "^(1[0-9]|0[1-9]|3[0-1]|2[1-9])/(0[1-9]|1[0-2])/[0-9]{4}\$"
        pattern = Pattern.compile(docAppDatePattern)
        matcher = pattern.matcher(docAppDate)

        if(!matcher.matches()) {
            Toast.makeText(
                this,
                "Appointment's date should be provided in format: DD/MM/YYYY.",
                Toast.LENGTH_SHORT
            ).show()
        }
        else if (!TextUtils.isEmpty(docName) && !TextUtils.isEmpty(docAppDate)) {

            val userId = mAuth!!.currentUser!!.uid
            val addedDoctorsAppointment = DoctorsAppointment (docName, docSpec, docAppDate, docAppHour, docAppRec, nextDocApp, prescMed, userId)
            mDatabaseReference
                ?.child(userId)?.push()?.setValue(addedDoctorsAppointment)
                ?.addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "Add Doctor's appointment: success")
                        Toast.makeText(this@AddDoctorsAppointmentActivity,
                            "Doctor's appointment ",
                            Toast.LENGTH_SHORT).show()
                        updateUserInfoAndUI()
                    } else {
                        Log.w(TAG, "Add Doctor's Appointment:failure", task.exception)
                        Toast.makeText(this@AddDoctorsAppointmentActivity, "Adding the doctors' appointment failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(this, "Enter the doctor's name and doctor's appointment hour", Toast.LENGTH_SHORT).show()
        }

    }

    private fun updateUserInfoAndUI() {
        //start next activity
        val intent = Intent(this@AddDoctorsAppointmentActivity, ChildProfileActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
     //   intent.putExtra("name", childName)
        startActivity(intent)
    }

}