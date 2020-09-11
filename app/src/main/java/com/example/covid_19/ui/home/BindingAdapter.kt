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