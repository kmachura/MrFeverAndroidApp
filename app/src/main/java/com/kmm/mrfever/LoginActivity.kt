package com.kmm.mrfever

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private val TAG = "LoginActivity"
    private var email: String? = null
    private var password: String? = null
    private var tvForgotPassword: TextView? = null
    private var etEmail: EditText? = null
    private var etPassword: EditText? = null
    private var loginButton: Button? = null
    private var createAccountButton: Button? = null

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val registerButton = findViewById<Button>(R.id.register_button)
        registerButton.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
        }

        initialise()
    }
    private fun initialise() {
        tvForgotPassword = findViewById<View>(R.id.forgot_password) as TextView
        etEmail = findViewById<View>(R.id.email) as EditText
        etPassword = findViewById<View>(R.id.password) as EditText
        loginButton = findViewById<View>(R.id.sign_in_button) as Button
        createAccountButton = findViewById<View>(R.id.register_button) as Button
        mAuth = FirebaseAuth.getInstance()

        tvForgotPassword!!
            .setOnClickListener { startActivity(Intent(this@LoginActivity,
                ForgotPasswordActivity::class.java)) }
        createAccountButton!!
            .setOnClickListener { startActivity(Intent(this@LoginActivity,
                CreateAccountActivity::class.java)) }
        loginButton!!.setOnClickListener { loginUser() }
    }

    private fun loginUser() {
        email = etEmail?.text.toString()
        password = etPassword?.text.toString()
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            Log.d(TAG, "Logging in user.")
            mAuth!!.signInWithEmailAndPassword(email!!, password!!)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        updateUI()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.e(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(this@LoginActivity, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI() {
        val intent = Intent(this@LoginActivity, IndexActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}