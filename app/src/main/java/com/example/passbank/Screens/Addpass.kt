package com.example.passbank.Screens

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.passbank.Data.LogM
import com.example.passbank.Data.PassBankViewModel
import com.example.passbank.R
import com.example.passbank.ui.theme.detaile1
import com.example.passbank.ui.theme.detaile2





fun checkstrength(password:String):String{

    return  when{
        password.length>=10 && password.any(){it.isUpperCase()}&&password.any(){it.isDigit()}
                &&password.any(){!it.isLetterOrDigit()} -> "Strong"
        password.length>=8&&password.any(){it.isUpperCase()} ->"Mid"
        else ->"Weak"
    }
}
fun getstrentghcolor(strength :String):Color{
    return when(strength){
        "Strong"->Color.Green
        "Mid"-> Color.Yellow
        else -> Color.Red

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPassword(modifier:Modifier = Modifier,viewModel: PassBankViewModel,navController: NavController) {
    val context = LocalContext.current.applicationContext





    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var strength = checkstrength(password)
    var platform by rememberSaveable {
        mutableStateOf("")
    }


    var iconstate by rememberSaveable {
        mutableStateOf(
            false
        )
    }
    val icon =
        if (iconstate) painterResource(id = R.drawable.showpass) else painterResource(id = R.drawable.hdepass)










    Column(
        modifier.fillMaxSize()
    ){
        TopAppBar(title = {

        Text(
            text = "Add Password",
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


        Column(
            modifier
                .fillMaxSize()
                .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = platform,
            onValueChange = {
                platform = it
            },

            placeholder = {
                Text(
                    text = "Platform",
                    color = Color.White
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.platform), contentDescription = null,
                    tint = Color.White,
                    modifier = modifier
                        .size(25.dp)

                )

            }, shape = RoundedCornerShape(12.dp),
            modifier = modifier
              //  .border(0.5.dp, detaile1, shape = RoundedCornerShape(12.dp))
            ,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Green,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                unfocusedBorderColor = detaile1
            )


        )
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },

            placeholder = {
                Text(
                    text = "email",
                    color = Color.White
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.email), contentDescription = null,
                    modifier
                        .size(25.dp),
                    tint = Color.White

                )
            }, shape = RoundedCornerShape(12.dp),
            modifier = modifier
                ,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Green,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                unfocusedBorderColor = detaile1
            )

        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },

            placeholder = {
                Text(
                    text = "Password",
                    color = Color.White
                )
            },
            maxLines = 1,
            trailingIcon = {
                Icon(
                    painter = icon, contentDescription = null,
                    modifier
                        .size(25.dp)
                        .clickable { iconstate = !iconstate },
                    tint = Color.White
                )
            },
            visualTransformation = if (iconstate) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            }, shape = RoundedCornerShape(12.dp),
            modifier = modifier,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Green,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                unfocusedBorderColor = detaile1
            )
        )
            Spacer(modifier = Modifier.height(6.dp))
            AnimatedVisibility(visible = password.isNotEmpty()) {



                Text(text = "Password Strength: $strength",
                    color = getstrentghcolor(strength),
                    modifier = Modifier
                        .clickable {
                            when (strength) {
                                "Weak" -> Toast.makeText(
                                    context,
                                    "add more UppecCase characters or numbers",
                                    Toast.LENGTH_SHORT
                                ).show()

                                "Mid" -> Toast.makeText(
                                    context,
                                    "add Special Characters",
                                    Toast.LENGTH_SHORT
                                ).show()

                            }
                        }


                )
            }

        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (password.isEmpty() || email.isEmpty() || password.isEmpty()) {
                        Toast.makeText(context, "Add All Fields", Toast.LENGTH_SHORT).show()
                    } else {

                        viewModel.addpassword(
                            password = password,
                            email = email,
                            platform = platform
                        )

                        viewModel.addlog(created = viewModel.crtdate(), message = "created:")

                        navController.navigate("passlist") {
                            popUpTo(0)
                        }
                    }
                },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                modifier = modifier.border(1.dp, detaile1, shape = RoundedCornerShape(12.dp))
            ) {
                Text(text = "Add Password")

            }

        }


    }
}
}