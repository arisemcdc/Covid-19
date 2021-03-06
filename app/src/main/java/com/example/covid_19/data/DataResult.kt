package com.example.covid_19.data

import java.lang.Exception

sealed class DataResult <out R> {
    data class Success<out T>(val data: T, val isFromCache: Boolean=false): DataResult<T>()
    data class Error(val exception: Exception): DataResult<Nothing>()
}
