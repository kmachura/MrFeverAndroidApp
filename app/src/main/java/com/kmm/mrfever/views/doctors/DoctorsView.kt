package com.kmm.mrfever.views.doctors

import com.kmm.mrfever.base.BaseView
import com.kmm.mrfever.model.Child
import com.kmm.mrfever.model.DoctorsAppointment

/*
Interface providing required method for a view displaying doctors' appointments
 */
interface DoctorsView : BaseView {

    /*
     * Updating list of doctors' appointment by the added one
     * @param doctorsAppointment - the list of doctors' appointments that will replace exisiting one
     */
    fun updateListOfDoctorsAppointments(doctorsAppointments: List<DoctorsAppointment>)

    /*
     * Displays an error in the view
     * @param error - the error to display in the view
     */
    fun showError(error: String)

}