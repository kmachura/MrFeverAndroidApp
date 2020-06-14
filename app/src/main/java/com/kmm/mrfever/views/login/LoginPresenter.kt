package com.kmm.mrfever.views.login

import com.kmm.mrfever.base.BasePresenter

interface LoginPresenter : BasePresenter<LoginView> {

    fun onLoginButtonTapped()

    fun onEmailChanged(email: String)

    fun onPasswordChanged(password: String)

}
