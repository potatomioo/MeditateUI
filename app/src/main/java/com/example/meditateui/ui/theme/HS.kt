package com.example.meditateui.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditateui.R
import com.example.meditateui.features

@Composable
fun HomeScreen() {

    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()
    ) {

        val nameInput by remember {
            mutableStateOf("Potatomioo")
        }

        Column {
            Greet(nameInput)
            chipset(chips = listOf("Sweet Sleep","Stress Out","Anxiety","Depression"))
            playingSec(Name = "Flying Soul", label = "Meditation: 3-10 min")
        }
    }

}


@Composable
fun Greet(
    name:String
) {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween, //at corners
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ){
        Column {
            Text(
                text = "Welcome, $name",
//                style = TextStyle(
//                    fontFamily = gothicA1,
//                    fontSize = 30.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.White
//                )
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Have a good day!",
                style = MaterialTheme.typography.bodySmall
            )
        }

        //Icon(imageVector = Icons.Filled.Search, contentDescription = "default")

        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(20.dp)
        )
    }
}


@Composable
fun chipset(
    chips:List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow{
        items(chips.size){
            Box(
                modifier = Modifier
                    .padding(
                        start = 15.dp,
                        top = 15.dp,
                        bottom = 15.dp
                    ) //Not taking in end because the next box will contain the padding at start too. I want to show a gap between two
                    .clip(RoundedCornerShape(10.dp))
                    .clickable { selectedChipIndex = it }
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                        //color made in Color.kt Whenever we call these variables directly. It comes as a color function
                    )
                    .padding(12.dp)
            ) {

                Text(text = chips[it],
                    style = MaterialTheme.typography.bodySmall
                )

            }
        }

    }
}


@Composable
fun playingSec(
    Name:String,
    label:String
) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(LightRed)
                .clickable {
                    DarkRed
                }
                .padding(15.dp)

        ) {
            Column {

                Text(
                    text = Name,
//                    style = MaterialTheme.typography.bodyMedium
                    style = TextStyle(
                        fontFamily = gothicA1,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 18.sp
                    )
                )

                Text(
                    text = label,
                    style = TextStyle(
                        fontFamily = gothicA1,
                        fontWeight = FontWeight.Normal,
                        color = TextWhite,
                        fontSize = 14.sp
                    )
                )

            }
            Box (
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(35.dp)
                    .clip(CircleShape)
                    .background(color = ButtonBlue)
            ){

                Icon(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = "Play",
                    tint = Color.White,
                    modifier = Modifier
                        .size(15.dp)
                )
            }

        }
}

//We will make a dataclass of kotlin for this feature which will contain all the parameters for one feature sec
@Composable
fun features(
    feature : List<features> //passing features class inside list
) {

    Column (
        modifier = Modifier
            .fillMaxWidth()
    ){
        Text(
            text = "Features",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(10.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 15.dp,end = 15.dp,bottom = 100.dp), //at bottom, Taking a 100 dp padding for the navigation bar
            modifier = Modifier
                .fillMaxHeight()
        ) {
            items(feature.size){
                
            }
        }
    }

}