package com.kmm.mrfever

import com.google.firebase.database.IgnoreExtraProperties
import java.time.Instant.now
import java.time.LocalDate.now
import java.util.*

@IgnoreExtraProperties
data class Child constructor(var childName: String?, var childBirthday: String?, var childBloodType: String?, var selectedChildSex: String?, val userId: String)