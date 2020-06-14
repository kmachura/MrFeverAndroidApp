package com.kmm.mrfever.views.children

import com.kmm.mrfever.model.DoctorsAppointment

/*
Interface providing required method for a view displaying doctors' appointment details
 */
interface DoctorsAppointmentView {

    /*
     * Updating details about doctors' appointment viewed
     * @param doctorsAppointment - the doctors' appointment which details will be viewed
     */
    fun updateDoctorsAppointment(doctorsAppointment: DoctorsAppointment)

    /*
     * Displays an error in the view
     * @param error - the error to display in the view
     */
    fun showError(error: String)

}
