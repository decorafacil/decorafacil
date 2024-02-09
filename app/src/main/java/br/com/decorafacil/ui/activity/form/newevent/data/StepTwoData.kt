package br.com.decorafacil.ui.activity.form.newevent.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StepTwoData(
    val eventStreet: String,
    val eventPlaceNumber: String,
    val eventDistrict: String,
    val eventCity: String,
    val eventState: String,
    val eventComplement: String,
    val eventDate: String,
    val eventTimeStart: String,
    val eventTimeEnd: String,
    val birthdayPersonName: String,
    val birthdayPersonAgeToComplete: String,
) : Parcelable
