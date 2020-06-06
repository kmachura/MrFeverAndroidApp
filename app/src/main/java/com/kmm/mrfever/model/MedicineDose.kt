package com.kmm.mrfever.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class MedicineDose constructor(var medicine: String? = "", var dose: String? = "", var whichChild: String? = "", var whenAdded: String? = "", var whenNext: String? = "", val userId: String = "")
