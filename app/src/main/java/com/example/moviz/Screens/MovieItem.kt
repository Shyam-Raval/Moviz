package com.example.moviz.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.moviz.Retrofit.Movie

@Composable
fun MovieItem(movie: Movie, onItemClick: (Movie) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .padding(16.dp) // A single padding value for the card
            .fillMaxWidth()
            .clickable { onItemClick(movie) }
    ) {
        // 1. Use a Column to stack everything vertically.
        Column {
            // Picture is the first item.
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500/${movie.poster_path}",
                contentDescription = "Poster for ${movie.title}",
                // This ensures the full image is visible, scaled to fit the width.
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )

            // A separate Column for the text content to apply padding easily.
            Column(
                modifier = Modifier.padding(16.dp),
                // This adds a nice space between the title and description.
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Heading is the second item.
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleLarge
                )

                // Description is the third item.
                Text(
                    text = movie.overview,
                    style = MaterialTheme.typography.bodyMedium
                    // No maxLines or overflow, so the full text is shown.
                )
            }
        }
    }
}