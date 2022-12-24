package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.ui.Datasource
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CourseGrid()
        }

    }
}

@Composable
fun CourseTopicCard(modifier: Modifier = Modifier, courseTopic: CourseTopic, @DrawableRes decorativeIcon: Int) {
    Card(modifier = modifier
        .padding(10.dp)
        .fillMaxWidth(),
        elevation = 5.dp,
        backgroundColor = Color.Green) {
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CourseGrid() {
    LazyVerticalGrid(cells = GridCells.Fixed(2)) {
        this.items(items = Datasource.courseTopics) { courseTopic ->
            CourseTopicCard(courseTopic = courseTopic, decorativeIcon = R.drawable.ic_grain)


        }

    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CoursesTheme {

    }
}