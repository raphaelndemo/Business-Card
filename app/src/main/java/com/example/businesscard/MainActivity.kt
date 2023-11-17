package com.example.businesscard

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
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),

                ) {


                    BusinessCard(name = getString(R.string.full_name), title = getString(R.string.title), modifier =  Modifier)
                    BusinessCardContact(cell = getString(R.string.cell), social = getString(R.string.social), mail = getString(R.string.mail), modifier = Modifier )



                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image = painterResource(R.drawable.android_logo)

        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .padding(30.dp)
                .background(color = colorResource(R.color.prussian_blue))
        )


        Text(
            text = stringResource(R.string.full_name),
            fontSize = (40.sp),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 5.dp)
        )
        Text(
            text = stringResource(R.string.title),
            modifier = Modifier
                .padding(bottom = 30.dp)
        )
        
    }
}

@Composable
fun BusinessCardContact(cell: String, social: String, mail: String, modifier: Modifier){
    Box (
        modifier = modifier
            .fillMaxSize()
            .padding(50.dp),
        contentAlignment = Alignment.BottomCenter

    ){
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = modifier
                    .padding(8.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_phone_24),
                    contentDescription = null,
                    tint = colorResource(R.color.caribbean_green),
                    modifier = modifier
                        .padding(8.dp)
                )
                Text(
                    text = stringResource(R.string.cell)
                )
            }
            Row(
                modifier = modifier
                    .padding(8.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_share_24),
                    contentDescription = null,
                    tint = colorResource(R.color.caribbean_green),
                    modifier = modifier
                        .padding(8.dp)
                )
                Text(
                    text = stringResource(R.string.social),

                    )
            }
            Row(
                modifier = modifier
                    .padding(8.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_email_24),
                    contentDescription = null,
                    tint = colorResource(R.color.caribbean_green),
                    modifier = modifier
                        .padding(8.dp)
                )
                Text(
                    text = stringResource(R.string.mail),

                    )
            }

        }
    }



}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {

        BusinessCard(name = stringResource(R.string.full_name), title = stringResource(R.string.title), modifier = Modifier)
        BusinessCardContact(cell = stringResource(R.string.cell), social = stringResource(R.string.social), mail = stringResource(R.string.mail), modifier = Modifier )
    }
}