package com.example.tictactoc.screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.tictactoc.R
import com.example.tictactoc.R.drawable
import kotlinx.coroutines.delay
import androidx.navigation.NavHostController

@Composable
fun SplashScreen(navController: NavHostController) {
    val alpha = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        alpha.animateTo(
            1f,
            animationSpec = tween(1000)
        )
        delay(1000)

        navController.navigate("start_screen") {
            popUpTo("Splash") { inclusive = true }
        }

    }

    Column (modifier = Modifier.fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        ,horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

        ){
        Image(
            modifier = Modifier
                .size(400.dp)
                .background(Color.Transparent),
            painter = painterResource(id = drawable.to),
            contentDescription = null
        )




    }


}

@Composable
fun LoderAnimation(modifier: Modifier, anim: Int) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(anim)
    )
    LottieAnimation(
        modifier = modifier,
        composition = composition,
        iterations = LottieConstants.IterateForever
    )



}




