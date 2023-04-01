package com.example.fireandice.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fireandice.R

/*
@Composable
fun HomeScreen(
    characterUiState: CharacterUiState,
    modifier: Modifier = Modifier
) {
    when (characterUiState) {
        is CharacterUiState.Loading -> LoadingScreen(modifier)
        is CharacterUiState.Success -> ThronesListScreen(characterUiState.thrones, modifier)
        is CharacterUiState.Error -> ErrorScreen(modifier)
    }
}

 */

@Composable
fun HomeScreen(
    characterUiState: String,
    modifier: Modifier =Modifier
) {
    ThronesListScreen(characterUiState, modifier)
}


/*
@Composable
fun ThronesCard(character : com.example.fireandice.model.Character, modifier: Modifier = Modifier) {
    Card (
        modifier = Modifier
            .size(180.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ){
        Column (
            modifier = Modifier
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        //painter = painterResource(R.drawable.test),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier,
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data(character.imageUrl)
                            .crossfade(true)
                            .build(),
                        error = painterResource(id = R.drawable.ic_broken_image),

                    )
                }
            }

            Text(
                text = character.title,
                fontWeight = FontWeight(700),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(start = 4.dp)
            )

            Text(
                text = character.firstName,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(top = 4.dp, start = 4.dp)
            )
        }
    }
}

 */
@Composable
fun ThronesListScreen(characterUiState: String, modifier: Modifier = Modifier) {
/*
    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(
            items = character,
        ) {
            character -> ThronesCard(modifier = modifier,character = com.example.fireandice.model.Character )
        }
    }
 */
    Box(
       contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(characterUiState)
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
    ThronesCard(thrones = Thrones)
}
 */
