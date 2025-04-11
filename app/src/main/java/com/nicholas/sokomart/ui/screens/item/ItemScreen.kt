package com.nicholas.sokomart.ui.screens.item

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nicholas.sokomart.R
import com.nicholas.sokomart.navigation.ROUT_INTENT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemScreen(navController: NavController){
    Column( modifier = androidx.compose.ui.Modifier.fillMaxSize(),
    ){
        //TOPAPPBAR
        TopAppBar(
            title = { Text(text="Item")},
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Magenta,
                titleContentColor = Color.White,
                navigationIconContentColor =  Color.White,
                actionIconContentColor = Color.White

            ),
            navigationIcon = {
                IconButton(onClick ={}) {

                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu Icon")


                }
            },
            actions = {
                IconButton(onClick = {}){
                    Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "Cart Icon")

                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Notifications, contentDescription = "Notifications Icon")
                }
                IconButton(onClick = {
                    navController.navigate(ROUT_INTENT)
                }) {
                    Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = "Arrowforward Icon")
                }
            }
        )
        //End of TopBar
       // modifier = Modifier.
        //Column( modifier = androidx.compose.ui.Modifier.fillMaxSize(),
 Column (){ var modifier = Modifier.verticalScroll(rememberScrollState()) }

        Image(
            painter = painterResource(R.drawable.welcome),
            contentDescription = "home",
            modifier = Modifier.fillMaxWidth().height(200.dp),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.height(20.dp))
        //Searchbar
        var search by remember { mutableStateOf("") }
        OutlinedTextField(
            value = search,
            onValueChange = {search =it},
            modifier = Modifier.fillMaxWidth().padding(),
            leadingIcon = { Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Icon")},
            placeholder = { Text(text="Search...")}

        )

        //End of Searchbar
        Spacer(modifier = Modifier.height(20.dp))
        //Row

        Row (modifier = Modifier.padding(start = 20.dp)){
            Image(
                painter = painterResource(R.drawable.img_3),
                contentDescription = "home",
                modifier = Modifier.width(200.dp).height(150.dp).clip(RoundedCornerShape(50)),
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
        //Row2
        Row (modifier = Modifier.padding(start = 20.dp)){
            Image(
                painter = painterResource(R.drawable.img_3),
                contentDescription = "home",
                modifier = Modifier.width(200.dp).height(150.dp).clip(RoundedCornerShape(50)),
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
        Row (modifier = Modifier.padding(start = 20.dp)){
            Image(
                painter = painterResource(R.drawable.img_3),
                contentDescription = "home",
                modifier = Modifier.width(200.dp).height(150.dp).clip(RoundedCornerShape(50)),
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
        Row (modifier = Modifier.padding(start = 20.dp)){
            Image(
                painter = painterResource(R.drawable.img_3),
                contentDescription = "home",
                modifier = Modifier.width(200.dp).height(150.dp).clip(RoundedCornerShape(50)),
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
 }


    }




@Preview(showBackground = true)
@Composable
fun ItemScreenPreview(){
    ItemScreen(navController= rememberNavController())
}

