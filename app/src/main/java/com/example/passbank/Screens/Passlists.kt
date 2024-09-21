package com.example.passbank.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircleOutline
import androidx.compose.material.icons.rounded.Autorenew
import androidx.compose.material.icons.rounded.Category
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.passbank.Data.Pass
import com.example.passbank.Data.PassBankViewModel
import com.example.passbank.R
import com.example.passbank.ui.theme.detaile1
import com.example.passbank.ui.theme.detaile2

@Composable
fun Passitem(modifier: Modifier = Modifier,pass: Pass,onclick:()->Unit){

    Row(
        modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 2.dp, end = 2.dp, top = 7.dp, bottom = 7.dp)
            .border(1.dp, color = detaile1, shape = RoundedCornerShape(11.dp))
            .background(detaile2)
            .clickable {
                onclick()
            }
        ,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(painter = painterResource(id = R.drawable.listitem), contentDescription = null,
            modifier
                .weight(1f)
                .wrapContentSize(Alignment.Center)


            ,
            tint = Color.White,



            )
        Text(text = pass.platform,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = modifier
                .weight(7f)

                .padding(start = 23.dp)

            )


    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Passlist(viewModel: PassBankViewModel,navController: NavController){
    val data by viewModel.alldata.observeAsState(initial = emptyList())
    Column(
        modifier = Modifier
            .fillMaxSize()

            .background(Color.Black)
    ) {


        Topappbar(title = "Password List").also {

        }

        if (data.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = "No Passwords :(",
                    color = Color.White,
                    fontSize = 22.sp
                    )
                Icon(imageVector = Icons.Rounded.Autorenew, contentDescription = null, tint = Color.White,
                    modifier = Modifier
                        .size(50.dp)
                    )
                
            }

        } else {
            LazyColumn(
                contentPadding = PaddingValues(
                    start = 8.dp,
                    end = 8.dp,
                    top = 11.dp,
                    bottom = 11.dp
                ),

                ) {

                items(data) { pass ->
                    Passitem(pass = pass) {
                        navController.navigate("passdetail/${pass.id}")

                    }


                }


            }
        }
    }
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.End

    ){





        FloatingActionButton(
            containerColor = detaile2, onClick = {
                navController.navigate("addpass")

            },
            contentColor = Color.White,
            modifier = Modifier
                .padding(bottom = 64.dp, end = 14.dp)

        ) {
            Text(text = "Add")

        }
    }
  Bottomnavbar(navController = navController)

}
@Preview
@Composable
fun b(){
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.End

    ){


        FloatingActionButton(
            containerColor = Color.Black, onClick = {

            },
            contentColor = Color.White,
            modifier = Modifier
                .padding(bottom = 14.dp, end = 14.dp)

        ) {
            Text(text = "Edit")

        }
    }
    
}