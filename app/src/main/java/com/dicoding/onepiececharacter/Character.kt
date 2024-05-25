package com.dicoding.onepiececharacter

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val nama: String,
    val deskripsi: String,
    val foto: Int
): Parcelable