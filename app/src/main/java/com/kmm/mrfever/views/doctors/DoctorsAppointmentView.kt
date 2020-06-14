package com.kmm.mrfever.views.doctors

import com.kmm.mrfever.model.Child

/*
Interface providing required method for a view displaying child's profile
 */
interface ChildProfileView {

    /*
     * Updating details about child viewed in its profile
     * @param child - the child whose profile will be viewed
     */
    fun updateChildProfile(child: Child)

    /*
     * Displays an error in the view
     * @param error - the error to display in the view
     */
    fun showError(error: String)

}
