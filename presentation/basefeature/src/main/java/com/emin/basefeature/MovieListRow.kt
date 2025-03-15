package com.emin.basefeature

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.emin.model.Movie

@Composable
fun MovieListRow(
    movie: Movie,
    onItemClick: (Movie) -> Unit
) {
    val titleMovie = movie.Title

    val textColor = if (titleMovie == "Batman Begins") Color.Red else Color.Black

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(movie) }
            .padding(10.dp)
            .border(1.dp, Color.DarkGray, shape = RoundedCornerShape(corner = CornerSize(18.dp))),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Box(
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(corner = CornerSize(18.dp)))
                .background(Color.Transparent)
                .padding(5.dp)
        ) {
            AsyncImage(
                model = movie.Poster,
                contentDescription = movie.Title,
                modifier = Modifier
                    .padding(16.dp)
                    .size(200.dp, 200.dp)
                    .clip(RectangleShape)
            )
        }

        Column(
            modifier = Modifier.align(CenterVertically)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                movie.Title,
                style = MaterialTheme.typography.headlineLarge,
                overflow = TextOverflow.Ellipsis,
                color = textColor,
                textAlign = TextAlign.Center
            )

            Text(
                movie.Year,
                style = MaterialTheme.typography.headlineLarge,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        }
    }
}

@Composable
@Preview
fun MovieListRowView() {
    MovieListRow(movie = Movie("Movie 1", "komedy", "123123", "5.5"), onItemClick = { })
}
