package com.example.cardbankcompose.domain.base

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Bank(
    val city: String?,
    val name: String?,
    val phone: String?,
    val url: String?
) : Parcelable