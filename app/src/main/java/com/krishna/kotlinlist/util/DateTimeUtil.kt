package com.krishna.kotlinlist.util

import android.util.Log
import androidx.annotation.NonNull
import java.text.SimpleDateFormat
import java.util.*

fun convertDob(@NonNull dob: String): String {
    return try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val date = inputFormat.parse(dob)
        val formattedDate = outputFormat.format(date!!)
        Log.d("DOB", formattedDate)
        formattedDate
    } catch (e: Exception) {
        dob
    }
}