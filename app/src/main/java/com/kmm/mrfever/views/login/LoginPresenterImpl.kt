package com.kmm.mrfever.views.login

import com.kmm.mrfever.common.isEmailValid
import com.kmm.mrfever.common.isPasswordValid
import com.kmm.mrfever.firebase.authentication.FirebaseAuthenticationInterface
import com.kmm.mrfever.model.LoginRequest
import javax.inject.Inject

class LoginPresenterImpl : LoginPresenter {

    @Inject
    lateinit var authentication: FirebaseAuthenticationInterface

    private lateinit var view: LoginView

    private val loginRequest = LoginRequest()

    override fun onLoginButtonTapped() {
        if (loginRequest.isValid()) {
            authentication.login(loginRequest.email, loginRequest.password) { isSuccess ->
                if (isSuccess) {
                    view.onLoginSuccess()
                } else {
                    view.showLoginError()
                }
            }
        }
    }

    override fun onEmailChanged(email: String) {
        loginRequest.email = email

        if (!isEmailValid(email)) {
            view.showEmailError()
        }
    }

    override fun onPasswordChanged(password: String) {
        loginRequest.password = password

        if (!isPasswordValid(password)) {
            view.showPasswordError()
        }
    }

    override fun setView(view: LoginView) {
        this.view = view
    }

}