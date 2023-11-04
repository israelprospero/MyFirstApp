package com.myfirstapp

import java.io.Serializable

data class Engineering(
    // things that will be in each item of the recycler view
    // val id: String = "",
    // val headerImageResId: Int = 0,
    val engineeringName: String = "",
    val engineeringDescription: String = "",
    val engineeringLongDescription: String = "",
    val buttonText: String = "",
    val imageURL: String? = null,
    val imageDrawable: Int = 0,
    // resources such as drawables, strings,
    // layouts, and other assets in Android are
    // referenced using their unique integer IDs
    val engineeringLink: String = "",
    var isFavorite: Boolean = false
) : Serializable

// Serializable -> by using this, the systems knows how to read and write (and eventually, serialize) the
// data that exists in the Engineering class