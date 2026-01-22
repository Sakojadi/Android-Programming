package com.example.firstproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstproject.ui.theme.FirstProjectTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var countLow by remember { mutableStateOf(0) }
    var countMedium by remember { mutableStateOf(0) }
    var countHigh by remember { mutableStateOf(0) }
    var last by remember { mutableStateOf("None") }
    var colorText by remember { mutableStateOf(Color.Black) }
    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Count: $countLow",
                modifier = modifier,
                color = Color.Red
            )
            Button(onClick = {
                countLow++
                last = "Low"
                colorText = Color.Red
            }) { Text("Low") }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Count: $countMedium",
                modifier = modifier,
                color = Color.Blue,
            )
            Button(onClick = {
                countMedium++
                last = "Medium"
                colorText = Color.Blue
            }) { Text("Medium") }
            Text(text = "Last Clicked Button $last", color = colorText)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Count: $countHigh",
                modifier = modifier,
                color = Color.Green
            )
            Button(onClick = {
                countHigh++
                last = "High"
                colorText = Color.Blue
            }) { Text("High") }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstProjectTheme {
        Greeting("Android")
    }
}