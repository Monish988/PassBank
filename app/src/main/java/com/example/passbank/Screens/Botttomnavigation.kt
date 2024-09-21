package com.example.passbank.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircleOutline
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.passbank.R
import com.example.passbank.ui.theme.detaile2
@Composable
fun Bottomnavbar(navController:NavController) {
    Row(
        modifier = Modifier
            .fillMaxSize()

    ) {



        BottomAppBar(
            modifier = Modifier
                .align(Alignment.Bottom)
                .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                .height(54.dp),
            tonalElevation = 32.dp,
            //contentColor = Color.Black,
            containerColor = detaile2

        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 6.dp, end = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround


            ) {
                Box(
                    contentAlignment = Alignment.Center,

                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.Black)
                        .size(50.dp)


                ) {


                    Icon(
                        painter = painterResource(id = R.drawable.random),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .wrapContentSize(Alignment.Center)
                            .size(31.dp)
                            .clickable {
                                navController.navigate("generatepass")
                            },


                        )
                }
                Box(
                    contentAlignment = Alignment.Center,

                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.Black)
                        .size(50.dp)


                ) {


                    Icon(
                        imageVector = Icons.Rounded.AddCircleOutline,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .wrapContentSize(Alignment.Center)
                            .size(31.dp)
                            .clickable { navController.navigate("addpass") },


                        )
                }
                Box(
                    contentAlignment = Alignment.Center,

                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.Black)
                        .size(50.dp)


                ) {


                    Icon(
                        painter = painterResource(id = R.drawable.logs2),
                        contentDescription = null,
                        tint = Color.White,

                        modifier = Modifier
                            .wrapContentSize(Alignment.Center)
                            .size(31.dp)

                            .clickable {
                                navController.navigate("logs")
                            },


                        )
                }

            }

        }
    }
}
