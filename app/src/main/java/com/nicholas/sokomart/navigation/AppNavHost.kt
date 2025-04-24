package com.nicholas.sokomart.navigation

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nicholas.sokomart.data.UserDatabase
import com.nicholas.sokomart.repository.UserRepository
import com.nicholas.sokomart.ui.products.AddProductScreen
import com.nicholas.sokomart.ui.products.EditProductScreen
import com.nicholas.sokomart.ui.products.ProductListScreen
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
import com.nicholas.sokomart.ui.screens.auth.LoginScreen
import com.nicholas.sokomart.ui.screens.auth.RegisterScreen
import com.nicholas.sokomart.ui.screens.form.FormScreen
import com.nicholas.sokomart.viewmodel.AuthViewModel
import com.nicholas.sokomart.viewmodel.ProductViewModel


@RequiresApi(Build.VERSION_CODES.Q)

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_ADD_PRODUCT,
    productViewModel: ProductViewModel = viewModel(),
) {


    val context = LocalContext.current





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
        //AUTHENTICATION

        // Initialize Room Database and Repository for Authentication
        val appDatabase = UserDatabase.getDatabase(context)
        val authRepository = UserRepository(appDatabase.userDao())
        val authViewModel: AuthViewModel = AuthViewModel(authRepository)
        composable(ROUT_REGISTER) {
            RegisterScreen(authViewModel, navController) {
                navController.navigate(ROUT_LOGIN) {
                    popUpTo(ROUT_REGISTER) { inclusive = true }
                }
            }
        }

        composable(ROUT_LOGIN) {
            LoginScreen(authViewModel, navController) {
                navController.navigate(ROUT_HOME) {
                    popUpTo(ROUT_LOGIN) { inclusive = true }
                }
            }
        }
        // PRODUCTS
        composable(ROUT_ADD_PRODUCT) {
            AddProductScreen(navController, productViewModel)
        }

        composable(ROUT_PRODUCT_LIST) {
            ProductListScreen(navController, productViewModel)
        }

        composable(
            route = ROUT_EDIT_PRODUCT,
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId")
            if (productId != null) {
                EditProductScreen(productId, navController, productViewModel)
            }
        }


        }
}