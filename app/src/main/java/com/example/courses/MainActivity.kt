package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CourseTopicCard(
                courseTopic = CourseTopic(
                    courseNameResourceId = R.string.architecture,
                    imageResourceId = R.drawable.architecture,
                    numberOfCourses = "45"
                ), decorativeIcon = R.drawable.ic_grain
            )
        }

    }
}

@Composable
fun CourseTopicCard(modifier: Modifier = Modifier, courseTopic: CourseTopic, decorativeIcon: Int) {
    Card(modifier = Modifier.padding(10.dp).fillMaxWidth(), elevation = 5.dp, backgroundColor = Color.Green) {
        Row() {
            Image(painter = painterResource(id = courseTopic.imageResourceId),
                contentDescription = null)
            Column() {
                Text(text = stringResource(id = courseTopic.courseNameResourceId))
                Row() {
                    Image(painter = painterResource(id = decorativeIcon), contentDescription = null)
                    Text(text = courseTopic.numberOfCourses )
                }
            }
        }
    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CoursesTheme {

    }
}