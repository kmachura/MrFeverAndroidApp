package com.kmm.mrfever

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class DoctorsAppointment constructor(var docName: String? = "", var docSpec: String? = "", var docAppDate: String? = "", var docAppDateHour: String? = "", var docAppRec: String? = "", var nextDocApp: String? = "", var prescMed: String? = "", val userId: String = "")
