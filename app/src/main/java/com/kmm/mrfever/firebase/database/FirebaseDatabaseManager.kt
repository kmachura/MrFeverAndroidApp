package com.kmm.mrfever.firebase.database

import com.google.firebase.database.FirebaseDatabase
import com.kmm.mrfever.model.Child
import com.kmm.mrfever.model.DoctorsAppointment
import com.kmm.mrfever.model.MedicineDose
import com.kmm.mrfever.model.User
import javax.inject.Inject

class FirebaseDatabaseManager @Inject constructor(private val database: FirebaseDatabase) : FirebaseDatabaseInterface {

    val keyUser: String = "user"
    val keyChildren: String = "children"

    override fun listenToChildren(onChildAdded: (Child) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun addNewChild(child: Child, onResult: (Boolean) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getUserChildren(userId: String, onResult: (List<Child>) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun createUser(
        id: String,
        firstName: String,
        lastName: String,
        email: String,
        password: String
    ) {
        var children: List<Child> = listOf()
        val user = User(id, firstName, lastName, email)

        database
            .reference
            .child(keyUser)
            .child(id)
            .setValue(user)
    }

    override fun getProfile(id: String, onResult: (User) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun listenToDoctorsAppointment(onDoctorsAppointmentAdded: (DoctorsAppointment) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun addDoctorsAppointment(
        doctorsAppointment: DoctorsAppointment,
        onResult: (Boolean) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getChildsDoctorsAppointment(
        childName: String,
        onResult: (List<DoctorsAppointment>) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun listenToMedicineDose(onMedicineDoseAdded: (MedicineDose) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun addMedicineDose(medicineDose: MedicineDose, onResult: (Boolean) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun medicinesGivenToChild(childName: String, onResult: (List<MedicineDose>) -> Unit) {
        TODO("Not yet implemented")
    }
}