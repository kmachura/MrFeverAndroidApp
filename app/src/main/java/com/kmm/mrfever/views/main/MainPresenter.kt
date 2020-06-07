package com.kmm.mrfever.views.main

import com.kmm.mrfever.LoginActivity
import com.kmm.mrfever.base.BasePresenter

class MainPresenter(internal var mainView: MainView) : BasePresenter<MainView>(mainView) {

    fun onEnterButtonClicked() {
        mainView.navigateTo(LoginActivity::class.java)
    }

}
