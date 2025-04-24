package com.nicholas.sokomart.ui.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nicholas.sokomart.R
import com.nicholas.sokomart.navigation.ROUT_DASHBOARD
import com.nicholas.sokomart.navigation.ROUT_LOGIN
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController){

    val coroutine = rememberCoroutineScope()
    coroutine.launch {
        delay(1000)
        navController.navigate(ROUT_LOGIN)
    }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Cyan)
    ) {

        Image(
            painter = painterResource(R.drawable.boxes),
            contentDescription = "",
            modifier = Modifier.size(300.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Sokomart",
            fontSize = 40.sp,
            color = Color.White,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = "Make it once, sell it forever",
            fontSize = 40.sp,
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    SplashScreen(navController= rememberNavController())
}
