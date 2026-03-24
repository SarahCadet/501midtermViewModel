package com.example.midtermviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.midtermviewmodel.ui.theme.MidtermViewModelTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MidtermViewModelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

class CounterViewModel () : ViewModel(){
    var count by mutableStateOf(0)
    val incrememt: () -> Unit = {count++}
}
@Composable
fun CounterScreen(modifier: Modifier = Modifier) {
    val counterViewModel: CounterViewModel = viewModel()
    Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Count: ${counterViewModel.count}")
        Button(onClick = { counterViewModel.incrememt() }) {
            Text("Increment")
            print("${counterViewModel.count}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MidtermViewModelTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            CounterScreen(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}