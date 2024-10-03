package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : androidx.activity.ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    var step by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }
    val bgcolor= Color.Transparent
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .background(bgcolor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        when (step) {
            1 -> {
                Image(painter = painterResource(id = R.drawable.lemon_tree),
                    contentDescription = "lemon tree",
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            step = 2
                            squeezeCount = (2..4).random()
                        })
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Tap the lemon tree to select a lemon")


            }

            2 -> {
                Image(painter = painterResource(id = R.drawable.lemon_squeeze),
                    contentDescription = "lemon",
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable
                        {
                            squeezeCount--
                            if (squeezeCount == 0) {
                                step = 3
                            }
                        })
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Keep tapping the lemon to squeeze it")
            }
            3 -> {
                Image(painter = painterResource(id = R.drawable.lemon_drink),
                    contentDescription = "glass of lemonade",
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable { step = 4 })
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Tap the lemonade to drink it")
            }
            4->{
                Image(painter = painterResource(id = R.drawable.lemon_restart),
                    contentDescription = "empty glass",
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable { step = 1 })
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Tap the empty glass to start again")


            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}