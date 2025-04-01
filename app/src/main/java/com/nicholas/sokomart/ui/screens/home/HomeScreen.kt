package com.nicholas.sokomart.ui.screens.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nicholas.sokomart.R

@Composable
fun HomeScreen(navController: NavController){

    Column (modifier = Modifier.fillMaxSize()){

        Text(text = "SokoMart",
            fontSize = 15.sp,
            color = Color.Magenta,
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic

        )
        Text (
            text = "An Ecommerce App",
            fontSize = 15.sp

        )
        Image(
            painter = painterResource(R.drawable.home),
            contentDescription = "home"
        )

        Button(
            onClick = {},
            shape = AbsoluteRoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta)
        ) {
            Text(text="See More")
        }


    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(navController= rememberNavController())
}