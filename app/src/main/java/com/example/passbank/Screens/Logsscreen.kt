package com.example.passbank.Screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Autorenew
import androidx.compose.material.icons.rounded.Category
import androidx.compose.material.icons.rounded.Delete
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.passbank.Data.PassBankViewModel
import com.example.passbank.Data.logs
import com.example.passbank.ui.theme.detaile1
import com.example.passbank.ui.theme.detaile2


@Composable
fun logitem(logs: logs,dllog:()->Unit){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(detaile2)
            .heightIn(70.dp)
            .padding(start = 2.dp, end = 2.dp, top = 8.dp, bottom = 8.dp)
            .border(1.dp, color = detaile1, shape = RoundedCornerShape(10.dp))

        ,


        ) {
        Row(
            modifier = Modifier
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically


        ) {
            Text(
                text = "Log",
                color = detaile1,
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = logs.created,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Bottom)
            )
            Spacer(modifier = Modifier.width(170.dp))

            Icon(imageVector = Icons.Rounded.Delete, contentDescription = null, tint = Color.Red,
                modifier = Modifier

                    .clickable {
                        dllog()



                    }
            )


        }
        Text(text =logs.message+logs.created,
            color = Color.White,
            fontSize = 15.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)

        )


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Logscreen(viewModel: PassBankViewModel,navController: NavController){
    val context = LocalContext.current.applicationContext
Column(
    modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
){



        TopAppBar(
            title = {


                    Text(
                        text = "Logs",
                        color = detaile1,
                        modifier = Modifier
                            .fillMaxHeight()
                            .wrapContentHeight(Alignment.CenterVertically)
                            .clickable {
                                navController.navigate("about")

                            }


                    )


            },
            colors = TopAppBarDefaults.topAppBarColors(detaile2),
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        )




    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ){




        val llogs by viewModel.alllogs.observeAsState(initial = emptyList())
        if(llogs.isEmpty()){
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){


                Text(text = "NO LOGS",
                    color = Color.White,
                    fontSize = 22.sp
                )
                Icon(imageVector = Icons.Rounded.Autorenew, contentDescription =null, tint = Color.White,
                    modifier = Modifier
                        .size(50.dp)
                    )
            }
            
        }
        else {

            LazyColumn(
                contentPadding = PaddingValues(

                ), verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                items(llogs) { log ->
                    logitem(logs = log) {
                        viewModel.deletelog(log)
                    }

                }


            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 5.dp, end = 5.dp)

            ,
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End
        ){





            FloatingActionButton(
                onClick = {
                    viewModel.clearlogs()
                    if(llogs.isNotEmpty())
                    Toast.makeText(context,"Cleared all logs",Toast.LENGTH_SHORT).show()
                          },
                containerColor = detaile2,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Rounded.Delete, contentDescription = null)

            }
        }
    }
}



}