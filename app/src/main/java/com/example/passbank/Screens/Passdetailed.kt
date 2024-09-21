package com.example.passbank.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircleOutline
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.passbank.Data.Pass
import com.example.passbank.Data.PassBankViewModel
import com.example.passbank.ui.theme.detaile1
import com.example.passbank.ui.theme.detaile2
import com.example.passbank.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun passdetail(modifier: Modifier = Modifier,pass: Pass,viewmodel: PassBankViewModel,navController: NavController) {


    Column(
        modifier.fillMaxSize()
    ) {
        Topappbar(title = "Password Details")

        Column(
            modifier
                .fillMaxSize()
                .background(Color.Black),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally


        ) {

            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .border(1.dp, color = detaile1, shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center

            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .padding(6.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {


                        Text(
                            text = "Platform",
                            fontSize = 24.sp,
                            color = detaile1,
                            modifier = modifier


                        )
                        Icon(
                            painter = painterResource(id = R.drawable.platform),
                            contentDescription = null,
                            tint = detaile1,
                            modifier = modifier.padding(start = 8.dp)
                                    .size(25.dp)
                        )
                    }
                    Spacer(modifier = modifier.height(12.dp))
                    Text(
                        text = pass.platform,
                        fontSize = 22.sp,
                        color = Color.White
                    )

                }
            }
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .border(1.dp, color = detaile1, shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center

            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .padding(6.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {


                        Text(
                            text = "Email",
                            fontSize = 24.sp,
                            color = detaile1,
                            modifier = modifier


                        )
                        Icon(
                            painter = painterResource(id = R.drawable.email),
                            contentDescription = null,
                            tint = detaile1,
                            modifier = modifier
                                .size(25.dp)
                                .padding(start = 8.dp)

                        )
                    }
                    Spacer(modifier = modifier.height(12.dp))
                    Text(
                        text = pass.email,
                        fontSize = 22.sp,
                        color = Color.White
                    )

                }
            }
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .border(1.dp, color = detaile1, shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center

            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .padding(6.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {


                        Text(
                            text = "Password",
                            fontSize = 24.sp,
                            color = detaile1,
                            modifier = modifier


                        )
                        Icon(
                            painter = painterResource(id = R.drawable.passlabel),
                            contentDescription = null,
                            tint = detaile1,
                            modifier = modifier.padding(start = 8.dp)
                                .size(25.dp)
                        )
                    }
                    Spacer(modifier = modifier.height(12.dp))
                    SelectionContainer {


                        Text(
                            text = pass.password,
                            fontSize = 22.sp,
                            color = Color.White
                        )
                    }

                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {


                Button(
                    onClick = {
                        navController.navigate("editpass/${pass.id}")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = detaile2
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.edit),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = modifier
                                .size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))


                        Text(
                            text = "Edit",
                            fontSize = 15.sp
                        )
                    }

                }
                Spacer(modifier = Modifier.width(24.dp))
                Button(
                    onClick = {
                        viewmodel.deletepassword(pass)
                        viewmodel.addlog(viewmodel.crtdate(), message = "deleted:")

                        navController.navigate("passlist") {
                            popUpTo(0)
                        }

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = detaile2
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.delete),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = modifier
                                .size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))


                        Text(
                            text = "Delete",
                            fontSize = 15.sp
                        )
                    }

                }
            }

        }

    }
    Bottomnavbar(navController = navController)
}