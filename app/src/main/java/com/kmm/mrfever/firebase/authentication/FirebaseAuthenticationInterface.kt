package com.kmm.mrfever.firebase.authentication

interface FirebaseAuthenticationInterface {

    fun login(email: String, password: String, onResult: (Boolean) -> Unit)

    fun register(email: String, password: String, firstName: String, lastName: String, onResult: (Boolean) -> Unit)

    fun getUserId(): String

    fun getUserFirstName(): String

    fun logOut(onResult: () -> Unit)

}
