package com.example.passbank.Screens

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.passbank.ui.theme.detaile1
import com.example.passbank.ui.theme.detaile2


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun About(){
    val context = LocalContext.current.applicationContext
    var showstate by rememberSaveable{
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)

    ){
        TopAppBar(title = {
            Text(
                text = "About",
                color = detaile1,
                fontSize = 24.sp

            )
        },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = detaile2)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 12.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(text = "Created by:",
                color = detaile1,
                fontSize = 22.sp,


                )
            Text(text = "Monish Khan ",
                color = Color.White,
                fontSize = 22.sp,
                modifier = Modifier
                    .clickable {
                        Toast.makeText(context,"Thanks For Downloading", Toast.LENGTH_SHORT).show()
                    }

            )
            Spacer(modifier = Modifier.height(30.dp))

            Text(text = "Contact Me",
                color = detaile1,
                fontSize = 22.sp

            )
            IconButton(onClick = {
                showstate = !showstate

            }
            ) {
                Icon(imageVector = Icons.Filled.SupportAgent, contentDescription =null, tint = Color.White )


            }
            Spacer(modifier = Modifier.height(40.dp))
            AnimatedVisibility(visible = showstate) {

                Card(
                    modifier = Modifier
                        .size(250.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = detaile2)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 10.dp, bottom = 10.dp)
                        ,
                        horizontalAlignment = Alignment.CenterHorizontally,


                        ){
                        doubletext(tex1 ="Email", text2 = "monishkhan47786@gmail.com")
                        Spacer(modifier = Modifier.height(50.dp))
                        doubletext(tex1 ="GitHub", text2 = "Monish089")
                        Spacer(modifier = Modifier.height(50.dp))
                        doubletext(tex1 ="Instagram", text2 = "Monish")


                    }



                }

            }


        }

    }

}
@Composable
fun doubletext(tex1:String,text2:String) {
    Text(text = tex1, color = detaile1)
    SelectionContainer {
        Text(text = text2, color = Color.White)
    }
}

