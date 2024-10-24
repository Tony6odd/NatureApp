package com.roja.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.roja.myapplication.ui.theme.MyApplicationTheme

data class TouristSpot(val imageUrl: String, val title: String, val description: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        items(touristSpots) { spot ->
                            ImageCard(spot)
                        }
                    }
                }
            }
        }
    }

    private val touristSpots = listOf(
        TouristSpot(
            imageUrl = "https://img.freepik.com/foto-gratis/hermoso-paisaje-montanas_23-2150787850.jpg",
            title = "Montañas",
            description = "Un hermoso paisaje montañoso que ofrece vistas impresionantes."
        ),
        TouristSpot(
            imageUrl = "https://media.gq.com.mx/photos/620e915c43f71a078a35533f/master/pass/playa.jpg",
            title = "Playa Soleada",
            description = "Una playa tranquila con arena dorada y aguas cristalinas."
        ),
        TouristSpot(
            imageUrl = "https://assets.unenvironment.org/decadeonrestoration/2020-03/nature-3294681_1280%20%281%29.jpg",
            title = "Bosque",
            description = "Un bosque denso lleno de vida silvestre y senderos para explorar."
        ),
        TouristSpot(
            imageUrl = "https://d2nepu52esyu7g.cloudfront.net/images/d9b03362-9ba5-4cdc-8a43-dbb15eb7e96d_202301091223437211.webp",
            title = "Cascada ",
            description = "Una cascada impresionante rodeada de vegetación exuberante."
        ),
        TouristSpot(
            imageUrl = "https://humanidades.com/wp-content/uploads/2017/03/lago-1-e1565747174966.jpg",
            title = "Lago",
            description = "Un lago sereno ideal para relajarse y disfrutar de la naturaleza."
        )
    )
}

@Composable
fun ImageCard(spot: TouristSpot) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberImagePainter(spot.imageUrl),
                contentDescription = spot.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = spot.title,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = spot.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
