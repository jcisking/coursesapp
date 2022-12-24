package com.example.courses

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CourseTopic(
    @StringRes val courseNameResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val numberOfCoursesResourceId: Int
)
