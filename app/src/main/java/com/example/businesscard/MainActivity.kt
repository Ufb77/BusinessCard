package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Cabecera("Android")
                }
            }
        }
    }
}


@Composable
fun Cabecera(name: String, modifier: Modifier = Modifier) {

    val background = painterResource(R.drawable.pexels_laura_tancredi_7078033)
    val myPicture = painterResource(R.drawable.me)
    val email = painterResource(R.drawable.mail_fill0_wght400_grad0_opsz24)
    val studies = painterResource(R.drawable.school_fill0_wght400_grad0_opsz24)
    val company = painterResource(R.drawable.storefront_fill0_wght400_grad0_opsz24)
    val web = painterResource(R.drawable.web_fill0_wght400_grad0_opsz24)
    val infiniteTransition = rememberInfiniteTransition(label = "infinite")
    val color by infiniteTransition.animateColor(
        initialValue = Color.Green,
        targetValue = Color.Blue,
        animationSpec = infiniteRepeatable(
            animation = tween(7000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "color"
    )

    Box (
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(R.drawable.pexels_laura_tancredi_7078033) ,
            contentDescription = null,
            contentScale = ContentScale.Crop,


        )

        Column(

            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally


        ){

            Image(
                painter = painterResource(R.drawable.me),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(shape = RoundedCornerShape(20.dp))
            )

            Text(
                text = "José Antonio Fernández-Montes García",
                modifier = Modifier.padding(top = 10.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(3.5f, 6.0f),
                        blurRadius = 3f
                    )
                )
            )

            Row (
                modifier = Modifier.padding(top = 100.dp)
            ){

                Image(
                    painter = email,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)

                )

                Text(
                    text = "jafmgdam@gmail.com",
                    modifier = Modifier.padding(start = 5.dp, end = 10.dp, top = 9.dp),
                    fontSize = 14.sp
                )

                Image(
                    painter = company,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)

                )

                Text(
                    text = "www.google.com",
                    modifier = Modifier
                        .padding(start = 5.dp, top = 9.dp),
                    fontSize = 14.sp
                )

            }

            Row (
                modifier = Modifier.padding(top = 100.dp)
            ){

                Image(
                    painter = studies,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)

                )

                Text(
                    text = "Técnico superior desarrollo apps",
                    modifier = Modifier.padding(start = 5.dp, end = 10.dp, top = 9.dp),
                    fontSize = 14.sp
                )

                Image(
                    painter = web,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)

                )

                Text(
                    text = "www.myweb.com",
                    modifier = Modifier
                        .padding(start = 5.dp, top = 9.dp),
                    fontSize = 14.sp
                )

            }
        }
    }






}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {

        Cabecera("Android")
    }
}