package com.kmm.mrfever.views.doctors

import com.kmm.mrfever.model.DoctorsAppointment

/*
Interface providing required method for a view adding a child profile
 */
interface AddDoctorsAppointmentView {

    /*
     * Adding doctors' appointment for a current chosen user's child
     * @param doctorsAppointment - the doctors' appointment that will be added
     */
    fun addDoctorsAppointment(doctorsAppointment: DoctorsAppointment)

    /*
     * Displays an error in the view
     * @param error - the error to display in the view
     */
    fun showError(error: String)

}
