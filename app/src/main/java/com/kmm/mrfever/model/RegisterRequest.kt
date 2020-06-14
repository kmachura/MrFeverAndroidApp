package com.kmm.mrfever.model

import com.kmm.mrfever.common.isEmailValid
import com.kmm.mrfever.common.isPasswordValid

data class RegisterRequest (var email: String = "", var firstName: String = "", var lastName: String = "", var password: String = "") {

    fun isValid(): Boolean = isEmailValid(email) && isPasswordValid(password)

}
