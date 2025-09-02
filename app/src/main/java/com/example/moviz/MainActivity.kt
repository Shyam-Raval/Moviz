package com.example.moviz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.moviz.Room.MoviesDB
import com.example.moviz.Screens.MovieScreen
import com.example.moviz.repository.Repository
import com.example.moviz.ui.theme.MovizTheme
import com.example.moviz.viewmodel.MovieViewModel
import com.example.moviz.viewmodel.MovieViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //ROOM
        val database = MoviesDB.getInstance(applicationContext)

        val repository = Repository(applicationContext)
        val viewModelFactory = MovieViewModelFactory(repository)
        val movieViewModel = ViewModelProvider(
            this, viewModelFactory
        )[MovieViewModel::class.java]

        setContent {
            MovizTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),

                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        Column {
                            HeaderComposable()
                            MovieScreen(viewModel = movieViewModel)
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun HeaderComposable() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)

    ) {
        Text("Moviz App" , fontSize = 32.sp , fontWeight = FontWeight.Bold)
        Text("Get Popular Movies" , fontSize = 16.sp , fontWeight = FontWeight.Bold)
    }
    
}