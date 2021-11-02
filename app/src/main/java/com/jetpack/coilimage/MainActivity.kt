package com.jetpack.coilimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.jetpack.coilimage.ui.theme.CoilImageTheme

@ExperimentalCoilApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoilImageTheme {
                Surface(color = MaterialTheme.colors.background) {
                    CoilImage()
                }
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun CoilImage() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .background(MaterialTheme.colors.primary),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Coil Image",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                //set the image url
                val painter = rememberImagePainter(
                    data = "https://i.imgur.com/uScTZH6.jpeg",
                    builder = {
                        //crossfade(true)
                        //placeholder(R.drawable.ic_android_black_24dp)
                        transformations(CircleCropTransformation())
                        error(R.drawable.ic_baseline_error_outline_24)
                    }
                )

                val state = painter.state
                if (state is ImagePainter.State.Loading) {
                    CircularProgressIndicator()
                }

                Image(
                    painter = painter,
                    contentDescription = "Coil Image"
                )
            }
        }
    }
}





















