package br.com.decorafacil.ui.activity.form.newevent.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StepOneData(
    val clientName: String,
    val clientCpf: String,
    val clientPhoneNumber: String,
    val clientEmail: String
) : Parcelable
