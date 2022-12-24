package com.example.courses

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CourseTopic(
    @StringRes val courseNameResourceId: Int,
    val numberOfCourses: String,
    @DrawableRes val imageResourceId: Int
    )
