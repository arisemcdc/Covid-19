package com.example.covid_19.ui.home

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:visibilityIfTrue")
fun View.visibilityIftrue(value: Boolean) {
    if (value == true) {
        visibility = View.VISIBLE
    }
    else
        visibility = View.GONE
}
@BindingAdapter("app:visibilityIfNotNull")
fun View.visibilityIfNotNull(value: Any?) {
    if (value == null) {
        visibility = View.GONE
    }
    else
        visibility = View.VISIBLE
}
