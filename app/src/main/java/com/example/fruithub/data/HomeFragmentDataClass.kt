package com.example.fruithub.data

import androidx.annotation.DrawableRes

import androidx.annotation.StringRes

data class HomeFragmentDataClass(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int, val amountResourceId: Int,
)



