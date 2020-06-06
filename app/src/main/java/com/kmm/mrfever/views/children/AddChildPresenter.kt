package com.kmm.mrfever.views.children

import com.kmm.mrfever.base.BasePresenter

/**
 * The Presenter that will present the AddChild view.
 * @param addChildView the addChild view to be presented by the presenter
 */
class AddChildPresenter(addChildView: AddChildView) : BasePresenter<AddChildView>(addChildView) {

    override fun onViewCreated() {
        TODO("not implemented")
    }

    override fun onViewDestroyed() {
        fun saveChildProfile() {}
    }

    /*
     * Save the created Child's profile or shows error.
     */
    fun saveChildProfile() {
        TODO("not implemented")
    }
}