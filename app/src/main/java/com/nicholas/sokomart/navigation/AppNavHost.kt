package com.nicholas.sokomart.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nicholas.sokomart.ui.screens.Service.ServiceScreen
import com.nicholas.sokomart.ui.screens.about.AboutScreen
import com.nicholas.sokomart.ui.screens.contact.ContactScreen
import com.nicholas.sokomart.ui.screens.home.HomeScreen
import com.nicholas.sokomart.ui.screens.dashboard.DashboardScreen
import com.nicholas.sokomart.ui.screens.intent.IntentScreen
import com.nicholas.sokomart.ui.screens.item.ItemScreen
import com.nicholas.sokomart.ui.screens.more.MoreScreen
import com.nicholas.sokomart.ui.screens.splash.SplashScreen
import com.nicholas.sokomart.ui.screens.start.StartScreen
import com.nicholas.sokomart.ui.screens.Assignment.ProjectScreen
import com.nicholas.sokomart.ui.screens.form.FormScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUT_ITEM) {
            ItemScreen(navController)
        }
        composable(ROUT_START) {
            StartScreen(navController)
        }
        composable(ROUT_INTENT) {
            IntentScreen(navController)
        }
        composable(ROUT_MORE) {
            MoreScreen(navController)
        }
        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController)
        }
        composable(ROUT_CONTACT) {
            ContactScreen(navController)
        }
        composable(ROUT_SERVICE) {
            ServiceScreen(navController)
        }
        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUT_PROJECT) {
            ProjectScreen()
        }
        composable(ROUT_FORM) {
            FormScreen(navController)
        }


    }
}