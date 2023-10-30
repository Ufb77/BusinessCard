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
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                    Card()
                }
            }
        }
    }
}


@Composable
fun Card(modifier: Modifier = Modifier) {


    val background = painterResource(R.drawable.pexels_laura_tancredi_7078033)
    val qr = painterResource(R.drawable.qrlinkedin)
    val infiniteTransition = rememberInfiniteTransition(label = "infinite")
    val color by infiniteTransition.animateColor(
        initialValue = Color.Green,
        targetValue = Color.Red,
        animationSpec = infiniteRepeatable(
            animation = tween(9000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "color"
    )

    Box (
        modifier.fillMaxSize().drawBehind { drawRect(color) }.padding(5.dp)

    ) {
        Image(
            painter = painterResource(R.drawable.pexels_laura_tancredi_7078033),
            contentDescription = null,
            contentScale = ContentScale.Crop,


            )
        CabeceraEstructuraPpal(nombre = stringResource(R.string.Nombre))

        Image(
            painter = qr ,
            contentDescription = null,
            modifier = modifier.offset(x = 90.dp, y = 500.dp).size(200.dp)
                .border(
                    BorderStroke(3.dp, Color.Green),
                    RoundedCornerShape(20.dp)
                )
                .padding(3.dp)
                .clip(RoundedCornerShape(15.dp))

        )
    }



}

@Composable
fun CabeceraEstructuraPpal(nombre: String, modifier: Modifier = Modifier){
    val fotoCabecera = painterResource(R.drawable.me)
    Column(

        modifier = modifier
            .padding(top = 60.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally


    ){

        Image(
            painter = fotoCabecera,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(100.dp)
                .border(
                    BorderStroke(3.dp, Color.Green),
                    RoundedCornerShape(20.dp)
                )
                .padding(3.dp)
                .clip(RoundedCornerShape(20.dp))
        )

//                   .clip(shape = RoundedCornerShape(20.dp))


        Text(
            text = nombre,
            modifier = Modifier.padding(top = 10.dp),
            style = TextStyle(
                fontSize = 20.sp,
                shadow = Shadow(
                    color = Color.Green,
                    offset = Offset(4.0f, 7.0f),
                    blurRadius = 3f
                )
            )
        )


        FilaEmailEmpresa(email = stringResource(R.string.email),
            empresa = stringResource(R.string.empresa))

        FilaEstudiosWeb(estudios = stringResource(R.string.Studies),
            myWeb = stringResource(R.string.myWeb))


    }


}

@Composable
fun FilaEmailEmpresa(email: String, empresa: String, modifier: Modifier = Modifier){

    val company = painterResource(R.drawable.work_suitcase)
    val mail = painterResource(R.drawable.mail_fill0_wght400_grad0_opsz24)

    Row (
        modifier = Modifier.padding(top = 100.dp)


    ){

        Image(
            painter = mail,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)

        )

        Text(
            text = email,
            modifier = Modifier.padding(start = 5.dp ,end = 10.dp, top = 9.dp),
            fontSize = 14.sp
        )

        Image(
            painter = company,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)

        )

        Text(
            text = empresa,
            modifier = Modifier
                .padding(start = 5.dp, top = 9.dp),
            fontSize = 14.sp
        )

    }

}

@Composable
fun FilaEstudiosWeb(estudios: String, myWeb: String, modifier: Modifier = Modifier){

    val studies = painterResource(R.drawable.school_fill0_wght400_grad0_opsz24)
    val web = painterResource(R.drawable.web_fill0_wght400_grad0_opsz24)

    Row (
        modifier = Modifier.padding(top = 100.dp)
    ){

        Image(
            painter = studies,
            contentDescription = null,
            modifier = Modifier
                .size(45.dp)

        )

        Text(
            text = estudios,
            modifier = Modifier.padding( start = 10.dp, end = 10.dp, top = 9.dp),
            fontSize = 14.sp
        )

        Image(
            painter = web,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)

        )

        Text(
            text = myWeb,
            modifier = Modifier
                .padding(start = 5.dp, top = 9.dp),
            fontSize = 14.sp
        )



    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {

        Card()
    }
}