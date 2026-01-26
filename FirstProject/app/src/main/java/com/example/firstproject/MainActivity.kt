package com.example.firstproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstproject.ui.theme.FirstProjectTheme

class MainActivity : ComponentActivity() {
    private val logs = mutableStateListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        Log.d("MainActivity", "onCreate")
        logs.add("onCreate")

        setContent {
            FirstProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    MainScreen(
                        logs = logs,
                        modifier = Modifier
                            .padding(padding)
                            .fillMaxSize()
                            .background(Color(0xFFFEB3DB))
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
        logs.add("onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
        logs.add("onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")
        logs.add("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
        logs.add("onDestroy")
    }
}
@Composable
fun MainScreen(
    logs: List<String>,
    modifier: Modifier = Modifier
) {
    var counter by remember { mutableIntStateOf(0) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), // ✅ IMPORTANT
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(200.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.barbie),
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )

            Text(
                text = "Barbara Millicent Roberts",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF5276C),
                textAlign = TextAlign.Center
            )

            Text(
                text = "I'm a Barbie Girl",
                fontSize = 16.sp,
                color = Color(0xFFF5276C),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = counter.toString(),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF5276C)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    counter++
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                )
            ) {
                Text(
                    "Click me 💖",
                    color = Color(0xFFF5276C)
                )
            }
        }

        Spacer(modifier = Modifier.height(150.dp))

        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            logs.forEach {
                Text(
                    text = it,
                    fontSize = 14.sp,
                    color = Color(0xFFF5276C)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Column(
            modifier = Modifier.padding(bottom = 50.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ContactRow(Icons.Filled.Phone, "+996 777 777 777")
            ContactRow(Icons.Filled.Share, "@nasipagulnuri")
            ContactRow(Icons.Filled.Email, "website@pupsiki.com")
        }
    }
}
@Composable
fun ContactRow(icon: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFFF5276C)
        )
        Text(
            text = text,
            color = Color(0xFFF5276C)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    FirstProjectTheme {
        MainScreen(
            logs = listOf("onCreate", "onStart", "onResume"),
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFEB3DB))
        )
    }
}