package com.example.cards_coil

import android.annotation.SuppressLint
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.benchmark.perfetto.Row
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "LIBROS") },
                            navigationIcon = {
                                IconButton(onClick = {}) {
                                    Icon(
                                        Icons.Filled.Menu,
                                        contentDescription = "Menu"
                                    )
                                }
                            },
                            actions = {
                                IconButton(onClick = {}) {
                                    Icon(
                                        Icons.Filled.Search,
                                        contentDescription = "Buscar"
                                    )
                                }
                            },
                            colors = TopAppBarDefaults.smallTopAppBarColors(
                                containerColor = Color.DarkGray,
                                navigationIconContentColor = Color.White,
                                actionIconContentColor = Color.White,
                                titleContentColor = Color.White
                            )
                        )
                    },


                    content = { paddingValues ->
                        Box(modifier= Modifier
                            .fillMaxSize()
                            .background(Color.Black)
                            .padding(paddingValues)) {
                            LazyColumn (
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                items(ImageCardDataList){imageCardData ->
                                    ImageCard(imageCardData)
                                    Spacer(modifier = Modifier.height(16.dp))

                                }

                            }


                        }
                    }
                )
            }
        }
    }

    data class ImageCardData(
        val imageUrl: String,
        val description: String
    )


    val ImageCardDataList = listOf(
        ImageCardData(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgA31nJI0IRhb7QyfzuNXNd3SRmM8CtOoN9w&s",
            "Angel Mecanico"),
        ImageCardData(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPUd_rfn7P-KcrH2U1X5-5aXlnbUxMjLkjbA&s",
            "Principe Mecanico"),
        ImageCardData(
            "https://static0planetadelibroscommx.cdnstatics.com/usuaris/libros/fotos/273/tam_1/portada_cazadores-de-sombras-los-origenes-3-princesa-mecanica_cassandra-clare_201806191945.jpg",
            "Princesa Mecanica"),
        ImageCardData(
            "https://lalibroteca.hn/cdn/shop/products/invisiblefront.jpg?v=1676048950",
            "Invisible"),
        ImageCardData(
            "https://image.slidesharecdn.com/aqu-dentro-siempre-llueve-chris-pueyo-z-lib-221019004531-7d39f539/85/Aqui-dentro-siempre-llueve-_Chris-Pueyo_-_z-lib-org_-pdf-1-320.jpg",
            "Aqui dentro siempre llueve")
    )


    @Composable
    fun ImageCard( imageCardData: ImageCardData ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            elevation = CardDefaults.cardElevation(3.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(5.dp, Color.Transparent)

        ) {


            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = imageCardData.imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(200.dp)
                        .height(200.dp),
                    contentScale = ContentScale.FillHeight,

                    )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = imageCardData.description,
                    textAlign = TextAlign.Center
                )
            }
        }

    }
}