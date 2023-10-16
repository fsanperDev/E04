package com.fsanper.e04

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Preview(
    name = "P1",
    showSystemUi = true,
    showBackground = true,
    fontScale = 1.1f,
    apiLevel = 33,
    device = Devices.NEXUS_6
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login() {
    var hidden by remember { mutableStateOf(true) }
    var myColor = Color(0xFF0197FE)
    var username by rememberSaveable() {
        mutableStateOf("")
    }
    var password by rememberSaveable() {
        mutableStateOf("")
    }
    var disable by rememberSaveable {
        mutableStateOf(false)
    }
    val isEmailValid = username.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(username).matches()
    val isPasswordValid = password.length >= 6
    val isButtonEnabled = isEmailValid && isPasswordValid

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,


        ) {

        Image(
            painter = painterResource(id = R.drawable.insta),
            contentDescription = "Instagram",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 25.dp)
        )

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 25.dp),
            placeholder = { Text(text = "Email address", color = Color.Gray) }

        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 5.dp),
            placeholder = { Text(text = "Password", color = Color.Gray) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation =
            if (hidden) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = {
                IconButton(onClick = { hidden = !hidden }) {
                    val vector = painterResource(//5
                        if (hidden) R.drawable.ic_visibility_off
                        else R.drawable.ic_visibility
                    )
                    val description = if (hidden) "Ocultar contraseña" else "Revelar contraseña" //6
                    Icon(painter = vector, contentDescription = description,
                        tint = Color.Gray,
                        modifier = Modifier.width(25.dp).height(25.dp).padding(end=5.dp))
                }
            }
        )

        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.End).padding(3.dp)
        ) {
            Text(
                text = "Forgotten password?", fontSize = 10.sp, color = myColor
            )
        }

        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(
                containerColor = myColor,
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 25.dp),
            shape = RoundedCornerShape(10.dp),
            enabled = isButtonEnabled
        ) {
            Text(text = "Log In")
        }

        Divider(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            color = Color.Gray,
            thickness = 1.dp,
        )

        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "facebook", modifier = Modifier
                    .height(20.dp)
                    .width(20.dp)
                    .padding(end = 5.dp)
            )
            Text(
                text = "Log in with Facebook", fontSize = 10.sp, color = myColor
            )
        }

        Divider(
            modifier = Modifier.padding(top = 135.dp),
            color = Color.Gray,
            thickness = 1.dp,
        )
        Text(text = "Don't have an account?", modifier = Modifier.padding(15.dp))
    }
}

fun enableLogin(email: String, password: String, function: () -> Unit): Boolean {
    if(Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6){
        return true
    }
    return false
}


