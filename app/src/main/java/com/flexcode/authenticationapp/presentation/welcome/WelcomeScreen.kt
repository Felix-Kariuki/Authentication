package com.flexcode.authenticationapp.presentation.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.flexcode.authenticationapp.R
import com.flexcode.authenticationapp.destinations.LoginScreenDestination
import com.flexcode.authenticationapp.destinations.RegisterScreenDestination
import com.flexcode.authenticationapp.ui.theme.ColorBg
import com.flexcode.authenticationapp.ui.theme.ColorButton
import com.flexcode.authenticationapp.ui.theme.PurpleBg
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun WelcomeScreen(
    navigator: DestinationsNavigator
) {

    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(40.dp))
                .height(378.dp)
                .fillMaxWidth(),
            backgroundColor = PurpleBg
        ) {
            Image(
                painter = painterResource(R.drawable.image),
                contentDescription = "Welcome Screen Image",
                modifier = Modifier
                    .height(520.dp)
            )

        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Welcome to the \n Login/Register Tutorial ",
            fontSize = 26.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(4.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Just playing around with jetpack compose",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontWeight = FontWeight.Light
        )

        Spacer(modifier = Modifier.height(64.dp))
        Row(
           modifier = Modifier.fillMaxWidth(),
           horizontalArrangement = Arrangement.Center
        ) {

            Button(
                onClick = {
                          navigator.navigate(RegisterScreenDestination)
                },
                // Uses ButtonDefaults.ContentPadding by default
                contentPadding = PaddingValues(
                    start = 40.dp,
                    top = 12.dp,
                    end = 40.dp,
                    bottom = 12.dp
                ),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.DarkGray)
            ) {

                Text(
                    "Register",
                    fontSize = 20.sp
                )
            }
            Button(
                onClick = {
                    navigator.navigate(LoginScreenDestination)
                },
                // Uses ButtonDefaults.ContentPadding by default
                contentPadding = PaddingValues(
                    start = 40.dp,
                    top = 12.dp,
                    end = 40.dp,
                    bottom = 12.dp
                ),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = PurpleBg,
                    contentColor = Color.White)
            ) {
                Text(
                    "Login",
                    fontSize = 20.sp
                )
            }
        }
    }

}