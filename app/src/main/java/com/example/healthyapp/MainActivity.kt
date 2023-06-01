package com.example.healthyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthyapp.data.DataResource
import com.example.healthyapp.model.HealthyOne
import com.example.healthyapp.ui.theme.HealthyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealthyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HealthyAppUI()
                }
            }
        }
    }
}


@Composable
fun HealthyAppCard(healthyOne: HealthyOne, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .shadow(elevation = 7.dp, shape = RectangleShape, ambientColor = Color.Blue),
        border = BorderStroke(1.dp, Color.Gray),
        colors = CardDefaults.cardColors(containerColor = Color.White),

        ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box() {
                Image(
                    painter = painterResource(healthyOne.sumberGambar),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(68.dp)
                        .width(68.dp)
                        .aspectRatio(1f)
                )
            }
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = stringResource(healthyOne.sumberTesk),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 8.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 8.dp)
                    )
                    Text(
                        text = healthyOne.sumberAngka.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}


@Composable
fun HealthyAppUI() {
    HealthyAppList(
        healthyAppList = DataResource().loadHealthyOne()
    )
}


@Composable
fun HealthyAppList(healthyAppList: List<HealthyOne>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .padding(10.dp)
    ) {
        items(healthyAppList) { healthyOne ->
            HealthyAppCard(
                healthyOne = healthyOne
            )
        }
    }
}

@Preview
@Composable
fun HealthyAppPreview() {
    HealthyAppUI()
}