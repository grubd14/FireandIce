package com.example.fireandice.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.fireandice.R
import com.example.fireandice.model.Character


@Composable
fun HomeScreen(
    characterUiState: CharacterUiState,
    modifier: Modifier = Modifier
) {
    when (characterUiState) {
        is CharacterUiState.Loading -> LoadingScreen(modifier)
        is CharacterUiState.Success -> ThronesGridScreen(characterUiState.thrones, modifier = modifier)
        else -> ErrorScreen()
    }
}


@Composable
fun ThronesCard(thrones: Character, modifier: Modifier = Modifier) {
    Card (
        modifier = Modifier
            .size(450.dp)
            .padding(22.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ){
        Column (
            modifier = Modifier,
            verticalArrangement = Arrangement.Center
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        //painter = painterResource(R.drawable.test),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier,
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data(thrones.imageUrl)
                            .crossfade(true)
                            .build(),
                        error = painterResource(id = R.drawable.ic_broken_image),

                        )
                }
            }
            Column (
                modifier = modifier
                    .fillMaxHeight()
                    .wrapContentHeight()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
                //horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = thrones.title,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(700),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(start = 10.dp)

                )
                Text(
                    text = "ID: ${thrones.id}",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = modifier
                        .padding(top = 4.dp)
                )

                Text(
                    text = "First Name: ${thrones.firstName}",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                )
                Text(
                    text = "Last Name: ${thrones.lastName}",
                    style = MaterialTheme.typography.bodyLarge,
                )
                Text(
                    text = "Full Name: ${thrones.fullName}",
                    style = MaterialTheme.typography.bodyLarge,
                )
                Text(
                    text = "Family: ${thrones.family}",
                    style = MaterialTheme.typography.bodyLarge,
                )
                Text(
                    text = "Image URL: ${thrones.image}",
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }
    }
}

@Composable
fun ThronesGridScreen(thrones: List<Character>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(items = thrones, key = { thrones -> thrones.id }) {
            thrones -> ThronesCard(thrones)
        }
    }
}


@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Loading Failed"
        )
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .size(200.dp),
            painter = painterResource(id = R.drawable.loading_img),
            contentDescription = null,
        )
    }

}

/*
@Preview(showBackground = false)
@Composable
fun ThronesApp() {
    ThronesCard(thrones = Character)
}

 */



