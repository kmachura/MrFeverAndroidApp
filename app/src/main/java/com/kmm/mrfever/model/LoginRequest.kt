package com.kmm.mrfever.model

import com.kmm.mrfever.common.isEmailValid
import com.kmm.mrfever.common.isPasswordValid

data class LoginRequest(var email: String = "", var password: String = "") {

    fun isValid() = isEmailValid(email) && isPasswordValid(password)

}
