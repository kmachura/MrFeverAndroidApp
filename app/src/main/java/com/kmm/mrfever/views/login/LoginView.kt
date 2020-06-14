package com.kmm.mrfever.views.login

interface LoginView {

    fun onLoginSuccess()

    fun showLoginError()

    fun showEmailError()

    fun showPasswordError()

}