package com.example.courses

import android.graphics.BlendModeColorFilter
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.ui.Datasource
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CourseGrid(Datasource.courseTopics)
        }

    }
}

@Composable
fun CourseTopicCard(modifier: Modifier = Modifier, courseTopic: CourseTopic, @DrawableRes decorativeIcon: Int) {
    Card(modifier = modifier
        .padding(3.dp),
        elevation = 5.dp
        ) {
        Row(modifier = Modifier.fillMaxHeight()) {
            Image(modifier = Modifier.size(68.dp), painter = painterResource(id = courseTopic.imageResourceId),
                contentDescription = null,
            )
            Column(modifier = Modifier
                .padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
                .fillMaxSize()
            ) {
                Text(text = stringResource(id = courseTopic.courseNameResourceId),
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.body2
                )
                Row() {
                    Icon(tint = Color.Black, modifier = Modifier.size(15.dp), painter = painterResource(id = decorativeIcon), contentDescription = null)
                    Text(modifier = Modifier
                        .padding(start = 8.dp),
                        text = courseTopic.numberOfCourses,
                        style = MaterialTheme.typography.caption)
                }
            }
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CourseGrid(courseTopicList: List<CourseTopic>) {
    LazyVerticalGrid(cells = GridCells.Fixed(2)) {
        items(courseTopicList) { courseTopic ->
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