package com.kmm.mrfever.views.children

import com.kmm.mrfever.model.Child

/*
Interface providing required method for a view adding a child profile
 */
interface AddChildView {

    /*
     * Adding child for a current user
     * @param child - the Child that will be added
     */
    fun addChild(child: Child)

    /*
     * Displays an error in the view
     * @param error - the error to display in the view
     */
    fun showError(error: String)

}
