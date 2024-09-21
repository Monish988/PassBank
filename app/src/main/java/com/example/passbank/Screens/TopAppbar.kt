package com.example.passbank.Screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DisabledByDefault
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.passbank.ui.theme.detaile1
import com.example.passbank.ui.theme.detaile2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Topappbar(title:String){
    TopAppBar(title = {

        Text(
            text = title,
            color = detaile1,
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentHeight(Alignment.CenterVertically)


        )

    },
        colors = TopAppBarDefaults.topAppBarColors(detaile2),
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
    )
}

@Composable
fun SideScreen(icon: ImageVector = Icons.Rounded.DisabledByDefault, color: Color = Color.Black, text:String = "Default", click:()->Unit = {}){

    var isexpanded by rememberSaveable{
        mutableStateOf(!false)
    }
    val expwidth by animateDpAsState(targetValue = if(isexpanded) 120.dp else 50.dp)
    val alg = if(isexpanded) Arrangement.End else Arrangement.Center

        Column(
            modifier = Modifier
//                .fillMaxHeight()



                .width(expwidth)
                .clip(RoundedCornerShape(bottomEnd = 14.dp))
                .background(color)

        ){



            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = alg,
                modifier = Modifier.fillMaxWidth()
            ){
                AnimatedVisibility(visible = isexpanded, enter = fadeIn()) {
                    Text(
                        text = text,
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                            .padding(end = 8.dp)
                            .clickable {

                            }

                    )

                }


                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier

                        .size(30.dp)
                        .padding(end = 2.dp, bottom = 2.dp)
                        .clickable { isexpanded = !isexpanded }

                )
            }



        }
    }



