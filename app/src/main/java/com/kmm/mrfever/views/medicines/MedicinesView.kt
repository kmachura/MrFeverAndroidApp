package com.kmm.mrfever.views.medicines

import com.kmm.mrfever.model.Child
import com.kmm.mrfever.model.MedicineDose

/*
Interface providing required method for a view displaying medicines given for a child after selecting the child
 */
interface MedicinesView {

    /*
     * Updating list of medicines given for selected child by the added one
     * @param medicinesGiven - the list of medicineDose that will replace exisiting one
     */
    fun updateListOfMedicinesGiven(medicinesGiven: List<MedicineDose>)

    /*
     * Displays an error in the view
     * @param error - the error to display in the view
     */
    fun showError(error: String)

}