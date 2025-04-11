package com.nicholas.sokomart.ui.screens.Service

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nicholas.sokomart.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiceScreen(navController: NavController){

    //Scaffold
    Column (modifier = Modifier.fillMaxSize()
        .paint(painter = painterResource(R.drawable.img_5))
    )
    {

    var selectedIndex by remember { mutableStateOf(0) }


        Scaffold(
            //TopBar
            topBar = {
                TopAppBar(
                    title = { Text("Item Screen") },
                    navigationIcon = {
                        IconButton(onClick = { /* Handle back/nav */ }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Green,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    )
                )
            },

            //BottomBar
            bottomBar = {
                NavigationBar(
                    containerColor = Color.Green
                ) {
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                        label = { Text("Home") },
                        selected = selectedIndex == 0,
                        onClick = {
                            selectedIndex = 0
                            //navController.navigate(ROUT_HOME)
                        }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
                        label = { Text("Favorites") },
                        selected = selectedIndex == 1,
                        onClick = {
                            selectedIndex = 1
                            // navController.navigate(ROUT_HOME)
                        }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                        label = { Text("Profile") },
                        selected = selectedIndex == 2,
                        onClick = {
                            selectedIndex = 2
                            //  navController.navigate(ROUT_HOME)
                        }
                    )

                }
            },

            //FloatingActionButton
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /* Add action */ },
                    containerColor = Color.LightGray
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                ) {

                    //Main page contents
                    Row(modifier = Modifier.padding(start = 20.dp)) {
                        Image(
                            painter = painterResource(R.drawable.img_3),
                            contentDescription = "home",
                            modifier = Modifier.width(200.dp).height(150.dp)
                                .clip(RoundedCornerShape(50)),
                            contentScale = ContentScale.FillWidth

                        )
                        Column {
                            Text(
                                text = "Men's T-shirt",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 20.sp

                            )
                            Text(
                                text = "Casual Wear",
                                fontSize = 15.sp

                            )
                            Text(
                                text = "Ksh.1900",
                                fontSize = 15.sp,
                                textDecoration = TextDecoration.LineThrough

                            )
                            Text(
                                text = "Ksh.1500",
                                fontSize = 15.sp
                            )
                            Row {
                                Icon(imageVector = Icons.Filled.Star, contentDescription = "")
                                Icon(imageVector = Icons.Filled.Star, contentDescription = "")
                                Icon(imageVector = Icons.Filled.Star, contentDescription = "")
                                Icon(imageVector = Icons.Filled.Star, contentDescription = "")
                                Icon(imageVector = Icons.Filled.Star, contentDescription = "")
                                Icon(imageVector = Icons.Filled.Star, contentDescription = "")

                            }


                        }

                    }


                    //End of Row


                }

            }
        )
    }

    //End of scaffold




}

@Preview(showBackground = true)
@Composable
fun ServiceScreenPreview(){
    ServiceScreen(navController= rememberNavController())
}
