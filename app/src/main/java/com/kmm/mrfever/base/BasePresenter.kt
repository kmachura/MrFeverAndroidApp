package com.kmm.mrfever.base

interface BasePresenter<in T> {

    fun setView(view: T)

}
