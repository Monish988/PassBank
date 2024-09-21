package com.example.passbank

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.Animation
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.passbank.Data.Pass
import com.example.passbank.Data.PassBankViewModel
import com.example.passbank.Data.Passdatabase
import com.example.passbank.Data.Passrepository
import com.example.passbank.Data.passviewmodelfactory
import com.example.passbank.Screens.About
import com.example.passbank.Screens.AddPassword
import com.example.passbank.Screens.Editpass
import com.example.passbank.Screens.Logscreen
import com.example.passbank.Screens.Passlist
import com.example.passbank.Screens.gener
import com.example.passbank.Screens.passdetail
import com.example.passbank.ui.theme.PassBankTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(
            applicationContext,
            Passdatabase::class.java,
            name = "PassBank_Database"
        ).build()
        val repository:Passrepository =Passrepository(db.Passdao(),db.LogsDAO())
        val viewModel:PassBankViewModel by viewModels {
            passviewmodelfactory(repository)

        }
        //Toast.makeText(LocalContext.current.applicationContext,"Created By Monish",Toast.LENGTH_SHORT).show()


        setContent {



            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "passlist",
                enterTransition = {
                    fadeIn()+slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Up)
                },



               // popExitTransition = {slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left)}
                //exitTransition =  { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left)},
                //exitTransition = { fadeOut(animationSpec = tween(100))+slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Down)},
               // exitTransition = { slideOutHorizontally(targetOffsetX =  {1000}) + fadeOut(spring(dampingRatio = Spring.DampingRatioNoBouncy, stiffness = Spring.StiffnessLow)) }


                ){
                composable("passlist"){
                    Passlist(viewModel = viewModel, navController = navController)

                }
                composable("generatepass"){
                    gener(navController)
                }
                composable("addpass"){
                    AddPassword(viewModel = viewModel, navController = navController)
                }
                composable("passdetail/{id}"){BackStackEntry ->
                    val passid = BackStackEntry.arguments?.getString("id")?.toInt()
                    val passit = viewModel.alldata.observeAsState(initial = emptyList()).value.find { it.id == passid }
                    passit?.let {
                        passdetail(pass = it, viewmodel = viewModel, navController = navController)
                    }

                }
                composable("editpass/{id}") { BackStackEntry ->
                    val passid = BackStackEntry.arguments?.getString("id")?.toInt()
                    val passit =
                        viewModel.alldata.observeAsState(initial = emptyList()).value.find { it.id == passid }
                    passit?.let {
                        Editpass(pass = it, viewModel = viewModel, navController = navController)
                    }
                }
                composable("logs"){

                    Logscreen(viewModel = viewModel,navController)
                }
                composable("about"){
                    About()
                }
            }

        }
    }
}

