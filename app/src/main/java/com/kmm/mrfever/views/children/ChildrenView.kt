package com.kmm.mrfever.views.children

import com.kmm.mrfever.base.BaseView
import com.kmm.mrfever.model.Child

/*
Interface providing required method for a view displaying children
 */
interface ChildrenView : BaseView {

    /*
     * Updating list of children by the added one
     * @param children - the list of children that will replace exisiting one
     */
    fun updateListOfChildren(children: List<Child>)

    /*
     * Displays an error in the view
     * @param error - the error to display in the view
     */
    fun showError(error: String)

}
