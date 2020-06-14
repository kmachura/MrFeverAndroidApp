package com.kmm.mrfever.views.index

import com.kmm.mrfever.ChildrenActivity
import com.kmm.mrfever.DoctorsActivity
import com.kmm.mrfever.MedicineActivity
import com.kmm.mrfever.UserActivity

class IndexPresenterImpl : IndexPresenter {

    private lateinit var view: IndexView

    override fun onMenuButton1Clicked() {
        view.navigateTo(ChildrenActivity::class.java)
    }

    override fun onMenuButton2Clicked() {
        view.navigateTo(DoctorsActivity::class.java)
    }

    override fun onMenuButton3Clicked() {
        view.navigateTo(MedicineActivity::class.java)
    }

    override fun onMenuButton4Clicked() {
        view.navigateTo(UserActivity::class.java)
    }

    override fun setView(view: IndexView) {
        this.view = view
    }

}
