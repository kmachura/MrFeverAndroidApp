package com.kmm.mrfever.views.index

import com.kmm.mrfever.ChildrenActivity
import com.kmm.mrfever.DoctorsActivity
import com.kmm.mrfever.MedicineActivity
import com.kmm.mrfever.UserActivity
import com.kmm.mrfever.base.BasePresenter

class IndexPresenter(internal var indexView: IndexView) : BasePresenter<IndexView>(indexView) {

    fun onMenuButton1Clicked() {
        indexView.navigateTo(ChildrenActivity::class.java)
    }

    fun onMenuButton2Clicked() {
        indexView.navigateTo(DoctorsActivity::class.java)
    }

    fun onMenuButton3Clicked() {
        indexView.navigateTo(MedicineActivity::class.java)
    }

    fun onMenuButton4Clicked() {
        indexView.navigateTo(UserActivity::class.java)
    }

}