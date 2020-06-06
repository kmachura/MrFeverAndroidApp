package com.kmm.mrfever.views.medicines

import com.kmm.mrfever.base.BaseView
import com.kmm.mrfever.model.MedicineDose

/*
Interface providing required method for a view adding a medicine dose
 */
interface AddMedicineDoseView : BaseView {

    /*
     * Adding medicine's dose for a current chosen user's child
     * @param medicine - the medicine's dose that will be added
     */
    fun addMedicinesDose(medicineDose: MedicineDose)

    /*
     * Displays an error in the view
     * @param error - the error to display in the view
     */
    fun showError(error: String)

}
