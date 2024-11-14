package com.example.labreposicionmovil

import android.widget.NumberPicker.OnValueChangeListener
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Label
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun Screen (){
    var username by remember { mutableStateOf("") }
    var qrCode by remember { mutableStateOf("") }

    Column (modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Ingrese su nombre de usuario de LinkedIn") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val linkedIn = "https://www.linkedin.com/in/$username/"
            qrCode = "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=$linkedIn"
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Generar codigo")
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (qrCode.isNotEmpty()){
            Image(
                painter = rememberAsyncImagePainter(model = qrCode),
                contentDescription = "Código QR",
                modifier = Modifier.size(150.dp),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}