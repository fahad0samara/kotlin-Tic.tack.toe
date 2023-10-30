package com.example.tictactoc.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.tictactoc.R
import com.example.tictactoc.R.drawable


@Composable
fun SplashScreen() {
    Column (modifier = Modifier.fillMaxSize()
        .background(if (isSystemInDarkTheme())
            Color.DarkGray else Color.White)
        ,horizontalAlignment = Alignment.CenterHorizontally,

        ){
        LoderAnimation(
            modifier=Modifier.size(400.dp),
            anim= drawable.ic_launcher_background

        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Tic Tac Toc",fontSize = 30.sp)

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




