package com.example.compose_visitcard

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_visitcard.ui.theme.ComposeVisitCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeVisitCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    VisitCard(
                        stringResource(R.string.name),
                        stringResource(R.string.title),
                        stringResource(R.string.phone),
                        stringResource(R.string.share),
                        stringResource(R.string.mail)
                    )
                }
            }
        }
    }
}

@Composable
fun VisitCard(name: String, title: String, phonenum: String, partager: String, mail: String, modifier: Modifier = Modifier) {
    val logo = painterResource(id = R.drawable.android_logo)
    val phone = painterResource(id = R.drawable.phone)
    val share = painterResource(id = R.drawable.partage_fichier)
    val email = painterResource(id = R.drawable.email)
    Column(modifier = modifier
        .padding(20.dp)
        .fillMaxSize()
        .background(Color.LightGray)
    ) {
        Box(modifier = modifier
            .weight(1f)
            .fillMaxSize()
                                ) {
            Column (horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = modifier.fillMaxSize()
                ) {
                Row(Modifier.height(90.dp)
                    .background(Color.Blue)
                ) {
                    Image(painter = logo, contentDescription = null)
                }
                Row {
                    Text(
                        text = name,
                        fontSize = 30.sp,
                        color = Color.Magenta
                    )
                }
                Row {
                    Text(
                        text = title,
                        fontSize = 18.sp
                    )
                }
            }
        }

        Box(modifier = modifier
            .weight(0.5f)
            .fillMaxSize(),
            ) {

                Column(
                    modifier = modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Row(Modifier.height(40.dp)
                        .width(200.dp)
                        .padding(bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(painter = phone,
                                contentDescription = null,
                                modifier = modifier.padding(end = 10.dp))
                        Text(text = phonenum)
                    }

                    Row(Modifier.height(40.dp)
                        .width(200.dp)
                        .padding(bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(painter = share, contentDescription = null, modifier = modifier.padding(end = 10.dp))
                        Text(text = partager)
                    }

                    Row(Modifier.height(40.dp)
                        .width(200.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(painter = email,
                              contentDescription = null,
                              modifier = modifier.padding(end = 10.dp)
                                                .width(30.dp)
                        )
                        Text(text = mail)
                    }
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun VisitCardPreview() {
    ComposeVisitCardTheme {
        VisitCard(
            stringResource(R.string.name),
            stringResource(R.string.title),
            stringResource(R.string.phone),
            stringResource(R.string.share),
            stringResource(R.string.mail)
        )
    }
}