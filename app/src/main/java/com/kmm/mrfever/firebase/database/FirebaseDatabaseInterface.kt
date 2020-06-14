package com.kmm.mrfever.firebase.database

import com.kmm.mrfever.model.Child
import com.kmm.mrfever.model.DoctorsAppointment
import com.kmm.mrfever.model.MedicineDose
import com.kmm.mrfever.model.User

interface FirebaseDatabaseInterface {

    fun listenToChildren(onChildAdded: (Child) -> Unit)

    fun addNewChild(child: Child, onResult: (Boolean) -> Unit)

    fun getUserChildren(userId: String, onResult: (List<Child>) -> Unit)

    fun createUser(id: String, firstName: String, lastName: String, email: String, password: String)

    fun getProfile(id: String, onResult: (User) -> Unit)

    fun listenToDoctorsAppointment(onDoctorsAppointmentAdded: (DoctorsAppointment) -> Unit)

    fun addDoctorsAppointment(doctorsAppointment: DoctorsAppointment, onResult: (Boolean) -> Unit)

    fun getChildsDoctorsAppointment(childName: String, onResult: (List<DoctorsAppointment>) -> Unit)

    fun listenToMedicineDose(onMedicineDoseAdded: (MedicineDose) -> Unit)

    fun addMedicineDose(medicineDose: MedicineDose, onResult: (Boolean) -> Unit)

    fun medicinesGivenToChild(childName: String, onResult: (List<MedicineDose>) -> Unit)

}
