package com.kmm.mrfever.views.createaccount

import com.kmm.mrfever.common.isEmailValid
import com.kmm.mrfever.common.isPasswordValid
import com.kmm.mrfever.firebase.authentication.FirebaseAuthenticationInterface
import com.kmm.mrfever.firebase.database.FirebaseDatabaseInterface
import com.kmm.mrfever.model.RegisterRequest
import javax.inject.Inject

class CreateAccountPresenterImpl : CreateAccountPresenter {

    @Inject
    lateinit var database: FirebaseDatabaseInterface

    @Inject
    lateinit var authentication: FirebaseAuthenticationInterface

    private lateinit var view: CreateAccountView

    private val userData = RegisterRequest()

    override fun onUserFirstNameChanged(firstName: String) {
        userData.firstName = firstName
    }

    override fun onUserLastNameChanged(lastName: String) {
        userData.lastName = lastName
    }

    override fun onEmailChanged(email: String) {
        userData.email = email

        if (!isEmailValid(email)) {
            view.showEmailError()
        }
    }

    override fun onPasswordChanged(password: String) {
        userData.password = password

        if (!isPasswordValid(password)) {
            view.showPasswordError()
        }
    }

    override fun onCreateAccountButtonTapped() {
        if (userData.isValid()) {
            val (firstName, lastName, email, password) = userData
            authentication.register(email, password, firstName, lastName) { isSuccessful ->
                onRegisterResult(isSuccessful, firstName, lastName, email, password)
            }
        }
    }

    override fun setView(view: CreateAccountView) {
        this.view = view
    }

    private fun onRegisterResult(isSuccessful: Boolean, firstName: String, lastName: String, email: String, password: String) {
        if (isSuccessful) {
            createUser(firstName, lastName, email, password)
            view.onRegisterSuccess()
        } else {
            view.showSignUpError()
        }
    }

    private fun createUser(firstName: String, lastName: String, email: String, password: String) {
        val id = authentication.getUserId()

        return database.createUser(id, firstName, lastName, email, password)
    }

}
