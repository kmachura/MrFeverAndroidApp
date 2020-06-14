package com.kmm.mrfever.views.createaccount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.kmm.mrfever.MrFeverApplication
import com.kmm.mrfever.R
import com.kmm.mrfever.UserCreatedActivity
import com.kmm.mrfever.common.onClick
//import com.kmm.mrfever.UserCreatedActivity
import java.util.regex.Matcher
import java.util.regex.Pattern
import com.kmm.mrfever.common.onTextChanged
import javax.inject.Inject

class CreateAccountActivity : AppCompatActivity(), CreateAccountView {

    private var etFirstName: EditText? = null
    private var etLastName: EditText? = null
    private var etEmail: EditText? = null
    private var etPassword: EditText? = null
    private var btnCreateAccount: Button? = null

    @Inject
    lateinit var presenter: CreateAccountPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        (application as MrFeverApplication).component.inject(this)

        presenter.setView(this)

        initUi()

    }

    private fun initUi() {
        etFirstName?.onTextChanged { presenter.onUserFirstNameChanged(it) }
        etLastName?.onTextChanged { presenter.onUserLastNameChanged(it) }
        etEmail?.onTextChanged { presenter.onEmailChanged(it) }
        etPassword?.onTextChanged { presenter.onPasswordChanged(it) }

        btnCreateAccount?.onClick { presenter.onCreateAccountButtonTapped() }
    }

    override fun onRegisterSuccess() = startActivity(UserCreatedActivity.getLaunchIntent(this))

    override fun showSignUpError() {
    }

    override fun showEmailError() {
        etEmail!!.error = getString(R.string.email_error)
    }

    override fun showPasswordError() {
        etPassword!!.error = getString(R.string.password_error)
    }

}
