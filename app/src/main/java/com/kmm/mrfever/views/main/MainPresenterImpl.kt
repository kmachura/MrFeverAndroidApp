package com.kmm.mrfever.views.main

import com.kmm.mrfever.views.login.LoginActivity

class MainPresenterImpl : MainPresenter {

    private lateinit var view: MainView

    override fun onEnterButtonClicked() {
        view.navigateTo(LoginActivity::class.java)
    }

    override fun setView(view: MainView) {
        this.view = view
    }
}
