package com.fsanper.e04

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



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
    var username by rememberSaveable(){
        mutableStateOf("")
    }
    var password by rememberSaveable() {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Image(
            painter = painterResource(id = R.drawable.insta),
            contentDescription = "Instagram",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        TextField(value = username, onValueChange = { username = it })
        MySpacer(size = 10)
        TextField(value = password, onValueChange = { password = it })
        MySpacer(size = 16)

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Iniciar Sesion")
        }


    }
}