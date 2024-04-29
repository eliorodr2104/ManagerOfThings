package com.managerofthings.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
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
import com.managerofthings.dataClasses.ItemBottomBar
import com.managerofthings.enums.ViewsName
import com.managerofthings.enums.ViewsName.*

@OptIn(ExperimentalMaterial3Api::class)
@Preview(backgroundColor = 0xFF000000)
@Composable
fun MenuView() {
    var viewActually by remember {
        mutableStateOf(HOME)
    }

    var nameUser by remember {
        mutableStateOf("Eliomar")
    }
    
    val listState = rememberLazyListState()
    val expandedFab by remember {
        derivedStateOf {
            listState.firstVisibleItemScrollOffset == 0
        }
    }

    val listButtom = listOf(
        ItemBottomBar(
            selected = { viewActually == LIST },
            onclick = { viewActually = LIST },
            icon = { Icon(
                imageVector = if (viewActually == LIST) Icons.AutoMirrored.Filled.List else Icons.AutoMirrored.Outlined.List,
                contentDescription = null,
                tint = Color.White
            ) },
            label = { Text(text = "List") },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color(0xFF282828),
                selectedTextColor = Color.White
            )
        ),

        ItemBottomBar(
            selected = { viewActually == HOME },
            onclick = { viewActually = HOME },
            icon = { Icon(
                imageVector = if (viewActually == HOME) Icons.Filled.Home else Icons.Outlined.Home,
                contentDescription = null,
                tint = Color.White
            ) },
            label = { Text(text = "Home") },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color(0xFF282828),
                selectedTextColor = Color.White
            )
        ),

        ItemBottomBar(
            selected = { viewActually == FAVORITE },
            onclick = { viewActually = FAVORITE },
            icon = { Icon(
                imageVector = if (viewActually == FAVORITE) Icons.Filled.Favorite else Icons.Outlined.Favorite,
                contentDescription = null,
                tint = Color.White
            ) },
            label = { Text(text = "Favorite") },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color(0xFF282828),
                selectedTextColor = Color.White
            )
        )
    )

    if (viewActually == LOGIN) {
        LoginView(
            changeValue = { viewActually = HOME },
            getName = { nameUser = it }
        )

    }else {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            containerColor = Color.Black,
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Black
                    ),
                    title = {
                        when(viewActually) {
                            HOME -> {
                                TopAppBarHome(
                                    nameUser = nameUser
                                )
                            }

                            ADD_BULLSHIT -> {
                                TopAppBarAddItem(
                                    changeIndex = { viewActually = it }
                                )
                            }

                            FAVORITE -> TODO()
                            CAMERA -> TODO()
                            LIST -> TODO()
                            VIEW_BULLSHIT -> TODO()
                            ADD_TAGS -> TODO()
                            LOGIN -> TODO()
                        }
                    }
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = Color(0xFF282828)
                ) {
                    for (item in listButtom) {
                        NavigationBarItem(
                            selected = item.selected(),
                            onClick = { item.onclick() },
                            icon = { item.icon() },
                            label = { item.label() },
                            colors = item.colors,
                            alwaysShowLabel = item.selected()
                        )
                    }
                }
            },

            floatingActionButton = {
                ExtendedFloatingActionButton(
                    onClick = { viewActually = ADD_BULLSHIT },
                    icon = { Icon(Icons.Filled.Add, "Extended floating action button.") },
                    text = { Text(text = "Add item") },
                    containerColor = Color.White,
                    expanded = expandedFab
                )
            }

        ) { paddingValues ->

            when(viewActually) {
                HOME -> HomeView(
                    paddingValues = paddingValues,
                    listState = listState,
                    changeIndex = { viewActually = it }
                )

                ADD_BULLSHIT -> AddBullshitView(
                    paddingValues = paddingValues,
                    listState = listState,
                    changeIndex = { viewActually = it }
                )

                FAVORITE -> TODO()
                CAMERA -> TODO()
                LIST -> TODO()
                VIEW_BULLSHIT -> TODO()
                ADD_TAGS -> TODO()
                LOGIN -> TODO()
            }
        }
    }
}

@Composable
private fun TopAppBarHome(
    nameUser: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, end = 15.dp, bottom = 5.dp)
    ) {
        Text(
            text = "Welcome\n$nameUser",
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Box(
            modifier = Modifier
                .size(45.dp)
                .clip(
                    shape = CircleShape
                )
                .background(
                    color = Color.White
                )
        )
    }
}

@Composable
private fun TopAppBarAddItem(
    changeIndex: (ViewsName) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, end = 15.dp, bottom = 5.dp)
    ) {
        Text(
            text = "Add new bullshit",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .align(Alignment.Center)
        )

        IconButton(onClick = { changeIndex(HOME) }) {
            Icon(
                tint = Color.White,
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .size(27.dp)
                    .align(Alignment.CenterStart)
            )
        }
    }
}