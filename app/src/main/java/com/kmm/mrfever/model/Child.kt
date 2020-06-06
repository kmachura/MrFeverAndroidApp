package com.kmm.mrfever.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Child constructor(var childName: String? = "", var childBirthday: String? = "", var childBloodType: String? = "", var selectedChildSex: String? = "", val userId: String = "")