package com.nicholas.sokomart.ui.screens.more


import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nicholas.sokomart.R
import com.nicholas.sokomart.navigation.ROUT_INTENT


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreScreen(navController: NavController){

    Column (modifier = Modifier.fillMaxSize()){
        //TOPAPPBAR
        TopAppBar(
            title = { Text(text="More Products") },
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
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "Cart Icon")
                }
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        //Searchbar
        var search by remember { mutableStateOf("") }
        OutlinedTextField(
            value = search,
            onValueChange = {search =it},
            modifier = Modifier.fillMaxWidth().padding(),
            leadingIcon = { Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Icon")},
            placeholder = { Text(text="Search More products...")}

        )

        //End of Searchbar

        Spacer(modifier = Modifier.height(10.dp))

        //Box

        Box(
            modifier = Modifier.fillMaxWidth().height(250.dp)
        ){
            Image(
                painter = painterResource(R.drawable.carmart),
                contentDescription = "home",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillWidth,
            )
            Icon(imageVector = Icons.Default.Favorite,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.align(alignment = Alignment.TopEnd,


                )
                )

            Text(
                text = "Find the best Products",
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold
            )
        }
        //End of Box
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "POPULAR CARS",
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),


        )
        Spacer(modifier = Modifier.height(10.dp))
        //Row
        Row(modifier = Modifier.padding(start = 20.dp)) {


            val mContext = LocalContext.current
            //Column
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(

                    painter = painterResource(R.drawable.car3),
                    contentDescription = "home",
                    modifier = Modifier.size(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.FillBounds

                )
                Text(
                    text = "Mercedes",
                    fontSize = 15.sp,

                    )
                Text(
                    text = "Ksh.2000000",
                    fontSize = 15.sp,

                    )

                Button(
                    onClick = {
                        val simToolKitLaunchIntent =
                            mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                    },

                )
                { Text(text = "Buy") }

            }

            //End of column
            Spacer(modifier = Modifier.height(10.dp))
            //Column
            Column(horizontalAlignment = Alignment.CenterHorizontally){
                Image(

                    painter = painterResource(R.drawable.car3),
                    contentDescription = "home",
                    modifier = Modifier.size(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.FillBounds

                )
                Text(
                    text = "Mercedes",
                    fontSize = 15.sp,

                    )
                Text(
                    text = "Ksh.2000000",
                    fontSize = 15.sp,

                    )

                Button(
                    onClick = {
                        val smsIntent = Intent(Intent.ACTION_SENDTO)
                        smsIntent.data = "smsto:0792451363".toUri()
                        smsIntent.putExtra("sms_body", "Hello,how was your day?")
                        mContext.startActivity(smsIntent)

                    },
                )
                { Text(text="Buy") }

            }
            //End of column
            Spacer(modifier = Modifier.height(10.dp))

        }
        //End of Row







    }


}

@Preview(showBackground = true)
@Composable
fun MoreScreenPreview(){
    MoreScreen(navController= rememberNavController())
}
