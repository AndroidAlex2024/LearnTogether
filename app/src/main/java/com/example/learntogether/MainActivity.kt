package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTogetherTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    //вызываем функцию при создании активити для устройства
                    Greeting(
                        title = stringResource(R.string.title),
                        text1= stringResource(R.string.text1),
                        text2 = stringResource(R.string.text2),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

//тело функции
@Composable
fun Greeting(title: String, text1: String,text2: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Box(modifier) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier
        ) {
            Image(
                painter = image,
                contentDescription = null,
                //contentScale = ContentScale.Crop,
                //alpha = 0.5F
            )

            Text(
                text = title,
                fontSize = 24.sp,//размер в масштабируемых пикселях
                modifier = modifier
                    .padding(16.dp)
                //.padding(
                    //    start = 16.dp,
                    //    top = 16.dp,
                    //    end = 16.dp,
                    //     bottom = 16.dp)
                //lineHeight = 116.sp,//размер строки если шрифт накладывается
                //textAlign = TextAlign.Center
            )
            Text(
                text = text1,
                textAlign = TextAlign.Justify,
                modifier = modifier
                    .padding(
                            start = 16.dp,
                            end = 16.dp)
            )
            Text(
                text = text2,
                textAlign = TextAlign.Justify,
                modifier = modifier
                    .padding(16.dp)
            )
        }
    }
}

//параметры предпросмотра
@Preview(
    showBackground = true,
    showSystemUi= true // показывает рамку устройства в првеью композа
)

//вызываем функцию для предпросмотра
@Composable
fun GreetingPreview() {
    LearnTogetherTheme {
        Greeting(stringResource(R.string.title),stringResource(R.string.text1),stringResource(R.string.text2))
    }
}