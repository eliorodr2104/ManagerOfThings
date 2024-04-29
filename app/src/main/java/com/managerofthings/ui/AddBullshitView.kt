package com.managerofthings.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.managerofthings.dataClasses.ItemTag
import com.managerofthings.enums.ViewsName

@Preview
@Composable
fun AddBullshitView(
    paddingValues: PaddingValues = PaddingValues(16.dp),
    listState: LazyListState = LazyListState(),
    changeIndex: (ViewsName) -> Unit = {  }
) {
    var humorIndex by remember {
        mutableIntStateOf(0)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                paddingValues
            ),
        state = listState
    ) {
        item {
            HeaderAddBullshit()

            Divider(
                modifier = Modifier
                    .padding(
                        top = 5.dp
                    ),
                color = Color(0xFF282828)
            )
        }

        item {
            ScoreRowAddBullshit(
                title = "Humor",
                changeValue = { humorIndex = it },
                value = humorIndex
            )

            Divider(
                modifier = Modifier
                    .padding(
                        top = 5.dp
                    ),
                color = Color(0xFF282828)
            )
        }

        item {
            TagRowAddBullshit()

            Divider(
                modifier = Modifier
                    .padding(
                        top = 5.dp
                    ),
                color = Color(0xFF282828)
            )
        }

        item {
            ScoreRowAddBullshit(
                title = "Score",
                changeValue = { humorIndex = it },
                value = humorIndex
            )

            Divider(
                modifier = Modifier
                    .padding(
                        top = 5.dp
                    ),
                color = Color(0xFF282828)
            )
        }
        
        item {
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Button(
                    onClick = { changeIndex(ViewsName.HOME) },
                    modifier = Modifier
                        .padding(
                            all = 20.dp
                        )
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
private fun ScoreRowAddBullshit(
    title: String,
    changeValue: (Int) -> Unit,
    value: Int
) {
    Column(
        modifier = Modifier
            .padding(
                all = 20.dp
            ),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            for (i in 1 .. 5) {
                IconButton(
                    onClick = { changeValue(i) },
                    modifier = Modifier
                        .size(
                            size = 50.dp
                        )
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = null,
                            tint = if (value == i) Color.White else Color(0xFF4a4a4a),
                            modifier = Modifier
                                .size(
                                    size = 50.dp
                                )
                        )

                        Text(
                            text = i.toString(),
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleLarge,
                            color = if (value == i) Color.Black else Color.White
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TagRowAddBullshit() {
    val tagItemsTest = listOf(
        ItemTag(
            nameItem = "Test"
        ),

        ItemTag(
            nameItem = "Test"
        ),

        ItemTag(
            nameItem = "Test"
        ),

        ItemTag(
            nameItem = "Test"
        )
    )

    Column(
        modifier = Modifier
            .padding(
                all = 20.dp
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Tag",
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            IconButton(
                onClick = {  }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(
                tagItemsTest,
                key = {
                    it.id
                }
            ) { tag ->
                ItemTagView(
                    nameTag = tag.nameItem
                )
            }
        }
    }
}

@Composable
private fun ItemTagView(
    nameTag: String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(
                shape = RoundedCornerShape(
                    size = 8.dp
                )
            )
            .background(
                color = Color(0xFF282828)
            )
            .padding(
                all = 7.dp
            )
    ) {
        Text(
            text = nameTag,
            style = MaterialTheme.typography.titleMedium,
            color = Color.White
        )
    }
}


@Composable
private fun HeaderAddBullshit() {
    var textName by remember {
        mutableStateOf("")
    }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Box(
            modifier = Modifier
                .width(160.dp)
                .height(220.dp)
                .clip(
                    shape = RoundedCornerShape(
                        10.dp
                    )
                )
                .background(
                    color = Color.Gray
                )
                .clickable {  },
            contentAlignment = Alignment.Center


        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(
                        size = 70.dp
                    )
                    .clip(
                        shape = CircleShape
                    )
                    .background(
                        color = Color(0xFFBDBDBD)
                    )
            ) {
                Icon(
                    imageVector = Icons.Filled.PhotoCamera,
                    contentDescription = null,
                    modifier = Modifier
                        .size(
                            size = 35.dp
                        )
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            TextFieldCustomTheme(
                value = textName,
                onValueChange = { textName = it },
                label = {
                    Text(
                        text = "Name Bullshit",
                        color = Color(0xFFBDBDBD)
                    )
                },
                maxLines = 1,
                modifier = Modifier
            )

            TextFieldCustomTheme(
                value = textName,
                onValueChange = { textName = it },
                label = {
                    Text(
                        text = "Bullshit description",
                        color = Color(0xFFBDBDBD)
                    )
                },
                maxLines = 4,
                modifier = Modifier
            )
        }
    }
}

@Composable
private fun TextFieldCustomTheme(
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable () -> Unit,
    maxLines: Int,
    modifier: Modifier
) {
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        colors = TextFieldDefaults.colors(
            disabledContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            errorContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            cursorColor = Color.Transparent,
            errorCursorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTextColor = Color.White,
            focusedSupportingTextColor = Color.White
        ),
        label = { label() },
        maxLines = maxLines,
        modifier = modifier
            .border(
                width = 2.dp,
                shape = RoundedCornerShape(5.dp),
                color = Color(0xFF282828)
            )
    )
}