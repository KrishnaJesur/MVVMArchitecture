package com.krishna.kotlinlist.util

import com.krishna.kotlinlist.R


//Activity result request code
const val REQUEST_CODE_ENABLE_GPS = 0x001
const val REQUEST_IMAGE_CAPTURE = 0x002
const val REQUEST_IMAGE_GALLERY = 0x003

//Permission request
const val REQUEST_CODE_LOCATION_PERMISSION = 0x011
const val REQUEST_CODE_STORAGE_CAMERA_PERMISSION = 0x012
const val REQUEST_CODE_STORAGE_PERMISSION = 0x013

//Api result code
const val SUCCESS = 1

//Common default values
const val PLATFORM = "ANDROID"

//Google api's base usr
const val GOOGLE_API_BASE_URL = "https://maps.googleapis.com"

//Header values
const val HEADER_APP_VERSION_CODE = "app-version-code"
const val HEADER_APP_VERSION_NAME = "app-version-name"
const val HEADER_APP_PLATFORM = "app-platform"
//const val HEADER_ACCESS_TOKEN = "x-access-token"
const val HEADER_ACCESS_TOKEN = "Authorization"

//Locales name and code list add according in future more language if require
val locales = arrayOf("English", "Arabic")
val localesCodes = arrayOf("en", "ar")

val GOOGLE_MAP_MODE_DRIVING = "driving"
val GOOGLE_MAP_MODE_WALKING = "walking"
val GOOGLE_MAP_MODE_TRANSIT = "transit"

typealias ProjectColors = R.color
typealias ProjectLayouts = R.layout
typealias ProjectStrings = R.string