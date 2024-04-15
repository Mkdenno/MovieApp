package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movieapp.homeScreen.HomeScreen
import com.example.movieapp.signIn.SignInScreen
import com.example.movieapp.signIn.SignInViewModel
import com.example.movieapp.signUp.SignUpScreen
import com.example.movieapp.signUp.SignUpViewModel

@Composable
fun Navigation(
    navHostController: NavHostController

) {
    NavHost(navController =navHostController , startDestination =Screen.SignInScreen.route ) {
        composable(route=Screen.SignInScreen.route){
            val viewModel= viewModel<SignInViewModel>()
            SignInScreen(
                signInViewModel =viewModel,
                navigateToSignUp = {
                    navHostController.navigate(Screen.SignUpScreen.route)

                },
                navigateToHomeScreen = {
                    navHostController.navigate(Screen.HomeScreen.route){
                        popUpTo(Screen.SignInScreen.route){
                            inclusive=true
                        }

                    }

                }

                )
        }

        composable(route=Screen.SignUpScreen.route){
            val viewModel= viewModel<SignUpViewModel>()

            SignUpScreen(

                signUpViewModel = viewModel,
                navigateBack = {

                },
                navigateToSignIn = {
                    navHostController.navigate(Screen.SignInScreen.route)
                }
            )

        }

        composable(route=Screen.HomeScreen.route){
            HomeScreen(

            )

        }

    }

}
sealed class Screen(val route: String){
    object SignInScreen : Screen("signing_screen")
    object SignUpScreen : Screen("signup_screen")
    object HomeScreen : Screen("home_screen")


}