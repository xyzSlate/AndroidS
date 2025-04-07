package com.nicholas.sokomart.ui.screens.intent


import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nicholas.sokomart.navigation.ROUT_ITEM


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntentScreen(navController: NavController){

    Column (modifier = Modifier.fillMaxSize()){

        val mContext = LocalContext.current

        //TOPAPPBAR
        TopAppBar(
            title = { Text(text="Item") },
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
                    Icon(imageVector = Icons.Filled.Share, contentDescription = "Share Icon")

                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = "Settings Icon")
                }
            }
        )
        //End of TopBar
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                val simToolKitLaunchIntent =
                    mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                simToolKitLaunchIntent?.let { mContext.startActivity(it) }

            },
            shape = AbsoluteRoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier.fillMaxWidth().padding(50.dp)

        )
        {
            Text(text="MPESA")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            val smsIntent=Intent(Intent.ACTION_SENDTO)
            smsIntent.data="smsto:0792451363".toUri()
            smsIntent.putExtra("sms_body","Hello,how was your day?")
            mContext.startActivity(smsIntent)
        },
            shape = AbsoluteRoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier.fillMaxWidth().padding(50.dp)

        )
        {
            Text(text="SMS")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                val callIntent= Intent(Intent.ACTION_DIAL)
                callIntent.data="tel:0792451363".toUri()
                mContext.startActivity(callIntent)
            },
            shape = AbsoluteRoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier.fillMaxWidth().padding(50.dp)

        )
        {
            Text(text="CALL")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                val shareIntent=Intent(Intent.ACTION_SEND)
                shareIntent.type="text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this cool content")
                mContext.startActivity(Intent.createChooser(shareIntent, "Share"))
            },
            shape = AbsoluteRoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier.fillMaxWidth().padding(50.dp)

        )
        {
            Text(text="SHARE")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("syznicholas@gmail.com"))
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                mContext.startActivity(shareIntent)
            },
            shape = AbsoluteRoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier.fillMaxWidth().padding(50.dp)

        )
        {
            Text(text="E-MAIL")
        }
    }


}

@Preview(showBackground = true)
@Composable
fun IntentScreenPreview(){
    IntentScreen(navController= rememberNavController())
}
