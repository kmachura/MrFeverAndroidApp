package com.kmm.mrfever.model

data class User (var firstName: String = "", var lastName: String = "", var email: String = "", var password: String = "", var children: List<Child> = listOf())
