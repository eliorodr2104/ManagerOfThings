package com.managerofthings.ui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.managerofthings.dataClasses.BullshitHomeItem
import com.managerofthings.dataClasses.ItemShortcut
import com.managerofthings.enums.ViewsName
import java.io.File

@Preview
@Composable
fun HomeView(
    paddingValues: PaddingValues = PaddingValues(16.dp),
    listState: LazyListState = LazyListState(),
    changeIndex: (ViewsName) -> Unit = {  }
) {
    val shortcutButtonItems = listOf(
        arrayOf(
            ItemShortcut(
                name = "Today's bullshit",
                image = Icons.Filled.LocationOn,
                onClick = {  }
            ),

            ItemShortcut(
                name = "Favorite bullshit",
                image = Icons.Filled.Star,
                onClick = {  }
            ),
        ),

        arrayOf(
            ItemShortcut(
                name = "Bullshit categories",
                image = Icons.Filled.Info,
                onClick = {  }
            ),

            ItemShortcut(
                name = "Bullshit done in the past",
                image = Icons.Filled.DateRange,
                onClick = {  }
            )
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        state = listState
    ) {
        item {
            Divider(
                modifier = Modifier
                    .padding(
                        top = 15.dp
                    ),
                color = Color(0xFF282828)
            )

            BarRecommended()

            ButtonAddEvent(
                changeIndex = changeIndex
            )

            BullshitOfTheDay()

            Text(
                text = "Tools",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(
                        all = 15.dp
                    )
            )
        }

        items(shortcutButtonItems) { item ->
            ShortCutButton(
                shortCutItems = item
            )
        }
    }
}

@Composable
private fun BarRecommended() {
    val bullshitItemTest = listOf(
        BullshitHomeItem(
            image = ""
        ),

        BullshitHomeItem(
            image = ""
        ),

        BullshitHomeItem(
            image = ""
        ),

        BullshitHomeItem(
            image = ""
        )
    )


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Text(
            text = "Your things",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.labelLarge
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(
                    bullshitItemTest,
                    key = {
                        it.id
                    }
                ) { item ->
                    BullshitHomeItemView(
                        item = item
                    )
                }
            }

            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = Color(0xFF282828)
            ) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
private fun BullshitHomeItemView(
    item: BullshitHomeItem
) {
    val imgFile = File(item.image)

    var imgBitmap: Bitmap? = null
    if (imgFile.exists()) {
        // on below line we are creating an image bitmap variable
        // and adding a bitmap to it from image file.
        imgBitmap = BitmapFactory.decodeFile(imgFile.absolutePath)
    }

    Box(
        modifier = Modifier
            .size(60.dp)
            .clip(
                shape = RoundedCornerShape(
                    size = 5.dp
                )
            )


    ) {
        Image(
            painter = rememberAsyncImagePainter(imgBitmap),
            contentDescription = null,
        )
    }
}

@Composable
private fun ButtonAddEvent(
    changeIndex: (ViewsName) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .border(
                width = 2.dp,
                color = Color(0xFF282828),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(15.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 15.dp,
                    bottom = 15.dp
                ),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                tint = Color.White
            )

           Column(
               horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.spacedBy(15.dp),
               modifier = Modifier
                   .fillMaxWidth()
           ) {
               Column(
                   modifier = Modifier
                       .fillMaxWidth()
               ) {
                   Text(
                       text = "Discover new bullshit",
                       style = MaterialTheme.typography.titleLarge,
                       fontWeight = FontWeight.Bold,
                       color = Color.White
                   )

                   Text(
                       text = "Keep track of your bullshit!",
                       style = MaterialTheme.typography.bodyLarge,
                       color = Color.White
                   )
               }

               Button(
                   onClick = { changeIndex(ViewsName.ADD_BULLSHIT) },
                   modifier = Modifier
                       .padding(end = 35.dp)
                       .fillMaxWidth(),
                   shape = RoundedCornerShape(10.dp),
                   colors = ButtonDefaults.buttonColors(
                       containerColor = Color(0xFF282828)
                   )
               ) {
                   Text(
                       text = "Create",
                       color = Color.White
                   )
               }
           }
        }
    }
}

@Composable
private fun BullshitOfTheDay() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Text(
            text = "Bullshit of the day",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = Color(0xFF282828),
                    shape = RoundedCornerShape(10.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .padding(
                        start = 15.dp
                    )
                    .fillMaxHeight()
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(
                            shape = RoundedCornerShape(
                                size = 5.dp
                            )
                        )
                        .background(
                            color = Color.White
                        )

                )

                Column(
                    modifier = Modifier
                        .padding(
                            start = 10.dp
                        )
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(
                        text = "Tag",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Text(
                        text = "Category",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Button(
                onClick = {

                },
                modifier = Modifier
                    .padding(
                        all = 20.dp
                    ),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF282828)
                )
            ) {
                Text(
                    text = "View",
                    color = Color.White
                )
            }
        }
    }
}

@Composable
private fun ShortCutButton(
    shortCutItems: Array<ItemShortcut>
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        for (item in shortCutItems) {
            Box(
                modifier = Modifier
                    .size(
                        size = 160.dp
                    )
                    .border(
                        width = 2.dp,
                        color = Color(0xFF282828),
                        shape = CircleShape
                    )
                    .clickable { item.onClick() },
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Icon(
                        imageVector = item.image,
                        contentDescription = null,
                        modifier = Modifier.size(
                            size = 45.dp
                        ),
                        tint = Color.White
                    )

                    Text(
                        text = item.name,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleSmall,
                        overflow = TextOverflow.Clip,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}