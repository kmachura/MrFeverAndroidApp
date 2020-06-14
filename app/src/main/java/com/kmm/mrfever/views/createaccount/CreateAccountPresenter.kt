package com.kmm.mrfever.views.createaccount

import com.kmm.mrfever.base.BasePresenter
import com.kmm.mrfever.common.isEmailValid
import com.kmm.mrfever.common.isPasswordValid
import com.kmm.mrfever.firebase.authentication.FirebaseAuthenticationInterface
import com.kmm.mrfever.firebase.database.FirebaseDatabaseInterface
import com.kmm.mrfever.model.RegisterRequest
import com.kmm.mrfever.views.createaccount.CreateAccountView
import dagger.Provides
import javax.inject.Inject

interface CreateAccountPresenter : BasePresenter<CreateAccountView> {

    fun onUserFirstNameChanged(firstName: String)

    fun onUserLastNameChanged(firstName: String)

    fun onEmailChanged(email: String)

    fun onPasswordChanged(password: String)

    fun onCreateAccountButtonTapped()

}
