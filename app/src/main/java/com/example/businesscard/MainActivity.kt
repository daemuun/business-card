package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardApp(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(color = Color(0xFFF5FFFA))
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        CardTitle(
            profileImage = painterResource(R.drawable.chill_guy),
            imageDescription = "Очень умный человек",
            userName = "Дудоладов Дмитрий Иванович",
            userAge = 18,
            modifier = Modifier
                .padding(16.dp)
        )
        CardDescription(
            title = "Начинающий андройд разработчик",
            description = "Привет, я начал изучать курс от гугл по Андройд разработке, в котором рассказыввается про новейший инструмент - Jetpack Compose, в первой части курса я познакомился с основами языка программирования kotlin, а также научился создавать простые UI, которые исползуют простые элементы компановки, такие как Box, Column и Row, а также познакомился с параметром Modifier и параметрами выравнивания текста. Это моё первое приложение, так что не судите строго. Я надеюсь, что путь, который предстоит мне будет таким же увлекательным и веселым !!!",
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
                .fillMaxWidth()
        )
        CardContacts(
            phoneNumber = "+7 (921) 884-03-18",
            userId = "@1234",
            email = "helloworld@gmail.com",
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun CardTitle(
    profileImage: Painter,
    imageDescription: String?,
    userName: String,
    userAge: Int,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Image(
            painter = profileImage,
            contentDescription = imageDescription,
            modifier = Modifier.weight(1f),
            contentScale = ContentScale.Fit

        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = userName,
                fontSize = 24.sp,
                lineHeight = 30.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = "$userAge лет",
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}

@Composable
fun CardDescription(
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
        )
    }
}

@Composable
fun CardContacts(
    phoneNumber: String,
    userId: String,
    email: String,
    modifier: Modifier = Modifier
) {
    val phoneIcon = Icons.Rounded.Call
    val shareIdIcon = Icons.Rounded.Share
    val emailIcon = Icons.Rounded.Email

    Column(modifier = modifier) {
        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            Icon(
                imageVector = phoneIcon,
                contentDescription = null,
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(
                text = phoneNumber
            )
        }

        Row {
            Icon(
                imageVector = shareIdIcon,
                contentDescription = null,
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(
                text = userId
            )
        }

        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            Icon(
                imageVector = emailIcon,
                contentDescription = null,
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(
                text = email
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardApp(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFF5FFFA))
        )
    }
}