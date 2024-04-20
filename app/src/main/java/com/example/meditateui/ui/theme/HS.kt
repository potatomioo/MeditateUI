package com.example.meditateui.ui.theme

import android.media.MediaPlayer
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditateui.Feature
import com.example.meditateui.R
import com.example.meditateui.bottomNav
import java.math.RoundingMode

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
            featuresec(features =
                listOf(
                    Feature(
                        title = "Sleep Meditation",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night Pills",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calm Down",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    ),
                    Feature(
                        title = "Good Wishes",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Visionary",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    )
                )
            )
            bottomNavigation(
                items = listOf(
                    bottomNav(
                        title = "Home",
                        R.drawable.ic_home
                    ),
                    bottomNav(
                        title = "Music",
                        R.drawable.ic_music
                    ),
                    bottomNav(
                        title = "Moon",
                        R.drawable.ic_moon
                    ),
                    bottomNav(
                        title = "Bubble",
                        R.drawable.ic_bubble
                    ),
                    bottomNav(
                        title = "Profile",
                        R.drawable.ic_profile
                    )
                )
            )
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
            modifier = Modifier
                .size(20.dp)
                .clickable {
                    //Search
                }
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
fun featuresec(
    features : List<Feature> //passing features class inside list
) {

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 75.dp)
    ){
        Text(
            text = "Features",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(10.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp,end = 7.5.dp,bottom = 50.dp), //at bottom, Taking a 100 dp padding for the navigation bar
            modifier = Modifier
                .fillMaxHeight()
        ) {
            items(features.size){
                FeatureItem(Feature = features[it])
            }
        }
    }

}


//Making Feature item in some other composable

@Composable
fun FeatureItem(
    Feature:Feature
) {
    BoxWithConstraints (
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Feature.darkcolor)
    ){
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        //medium color path

//        val mediumColorPoint1 = Offset(0f,height * 0.3f) //at x its 0 and the 30%  of its maximum height
//        val mediumColorPoint2= Offset(width*0.1f,height * 0.35f)
//        val mediumColorPoint3 = Offset(width*0.4f,height * 0.5f)
//        val mediumColorPoint4 = Offset(width*0.75f,height * 0.7f)
//        val mediumColorPoint5 = Offset(width*01.4f,-height.toFloat())  //-height will go somewhere up to the screen for a better curve
//
//        val mediumColorPath = Path().apply{
//            moveTo(mediumColorPoint1.x,mediumColorPoint1.y)
//            standardQuadFromTo(mediumColorPoint1,mediumColorPoint2)
//            standardQuadFromTo(mediumColorPoint2,mediumColorPoint3)
//            standardQuadFromTo(mediumColorPoint3,mediumColorPoint4)
//            standardQuadFromTo(mediumColorPoint4,mediumColorPoint5)
//            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
//            lineTo(-100f,height.toFloat() + 100f)
//            close()
//        }

        //lightcolorPath
        val lightColorPoint1 = Offset(0f,height * 0.35f) //at x its 0 and the 30%  of its maximum height
        val lightColorPoint2= Offset(width*0.1f,height * 0.4f)
        val lightColorPoint3 = Offset(width*0.3f,height * 0.35f)
        val lightColorPoint4 = Offset(width*0.65f,height.toFloat())
        val lightColorPoint5 = Offset(width*1.4f,-height.toFloat())  //-height will go somewhere up to the screen for a better curve

        val lightColorPath = Path().apply{
            moveTo(lightColorPoint1.x,lightColorPoint1.y)
            standardQuadFromTo(lightColorPoint1,lightColorPoint2)
            standardQuadFromTo(lightColorPoint2,lightColorPoint3)
            standardQuadFromTo(lightColorPoint3,lightColorPoint4)
            standardQuadFromTo(lightColorPoint4,lightColorPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f,height.toFloat() + 100f)
            close()
        }

        Canvas(modifier = Modifier
            .fillMaxSize()
        ) {
//            drawPath(
//                path = mediumColorPath,
//                color = Feature.mediumcolor
//            )
            drawPath(
                path = lightColorPath,
                color = Feature.lightcolor
            )

        }

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
        ){
            Text(text = Feature.title,
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = Feature.iconid)
                ,contentDescription = Feature.title,
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .size(15.dp)
            )
            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .clickable {
                        //handle
                    }
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }

    }
}


//Dataclass for bottomNavigation Content

@Composable
fun bottomNavigation(
    items: List<bottomNav>,
    modifier: Modifier = Modifier,
    activeHighlightColor : Color = ButtonBlue,
    activeTextColor : Color = Color.White,
    inactiveTextColor : Color = AquaBlue,
    initialTextIndex :Int = 0
) {

    var selectedItemIndex by remember {
        mutableStateOf(initialTextIndex)
    }

    Row (
        horizontalArrangement = Arrangement.SpaceAround,    //equal space to all the items
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(10.dp)
    ){
        items.forEachIndexed {index, item ->
            bottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
            ) {
                selectedItemIndex = index
            }
        }
    }

}

//for each bottom item

@Composable
fun bottomMenuItem(
    item: bottomNav,
    isSelected: Boolean = false,
    activeHighlightColor : Color = ButtonBlue,
    activeTextColor : Color = Color.White,
    inactiveTextColor : Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ){
            Icon(
                painter = painterResource(id = item.iconid),
                contentDescription = item.title,
                tint = if(isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if(isSelected) activeTextColor else inactiveTextColor,
            style = TextStyle(
                fontSize = 15.sp
            )
            )
    }
}
