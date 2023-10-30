package com.example.tictactoc.screen


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape


import androidx.compose.material3.Button


import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tictactoc.R
import com.example.tictactoc.compents.BoardBase
import com.example.tictactoc.compents.BoardCellValue
import com.example.tictactoc.compents.Circle
import com.example.tictactoc.compents.Cross
import com.example.tictactoc.compents.GameState
import com.example.tictactoc.compents.VictoryType
import com.example.tictactoc.compents.WinDiagonalLine1
import com.example.tictactoc.compents.WinDiagonalLine2
import com.example.tictactoc.compents.WinHorizontalLine1
import com.example.tictactoc.compents.WinHorizontalLine2
import com.example.tictactoc.compents.WinHorizontalLine3
import com.example.tictactoc.compents.WinVerticalLine1
import com.example.tictactoc.compents.WinVerticalLine2
import com.example.tictactoc.compents.WinVerticalLine3
import com.example.tictactoc.model.GameViewModel
import com.example.tictactoc.model.UserAction

import com.example.tictactoc.ui.theme.Gray
import com.example.tictactoc.ui.theme.Green


@Composable
fun StartScreen(
    viewModel: GameViewModel,
    navHostController: NavHostController,
) {

    val state = viewModel.state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Player 'O' : ${state.playerCircleCount}", fontSize = 16.sp,
                color = Color(0xFF09BFD8)

                )
            Text(text = "Draw : ${state.drawCount}", fontSize = 16.sp,
color = Color.Blue
                )
            Text(text = "Player 'X' : ${state.playerCrossCount}", fontSize = 16.sp,
                color = Color(0xFFFFEB3B)

                )


        }
        val myFont=FontFamily(Font(R.font.bad_script))
        Text(
            text = stringResource(R.string.tic_tac_toe),
               fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = myFont,
            fontStyle = FontStyle.Italic,
            color=Color.Green


        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(20.dp)
                )
                .clip(RoundedCornerShape(20.dp))
                .background(Gray),
            contentAlignment = Alignment.Center
        ) {
            BoardBase()
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .aspectRatio(1f),
                columns = GridCells.Fixed(3)
            ) {
                viewModel.boardItems.forEach { (cellNo, boardCellValue) ->
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                                .clickable(
                                    interactionSource = MutableInteractionSource(),
                                    indication = null
                                ) {
                                    viewModel.onAction(
                                        UserAction.BoardTapped(cellNo)
                                    )
                                },
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            AnimatedVisibility(
                                visible = viewModel.boardItems[cellNo] != BoardCellValue.NONE,
                                enter = scaleIn(tween(1000))
                            ) {
                                if (boardCellValue == BoardCellValue.CIRLCE) {
                                    Circle()
                                } else if (boardCellValue == BoardCellValue.CROSS) {
                                    Cross()
                                }
                            }
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AnimatedVisibility(
                    visible = state.hasWon,
                    enter = fadeIn(tween(2000))
                ) {
                    DrawVictoryLine(state = state)
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = state.hintText,
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color =
                if (state.hasWon) Color.Green else Color.Black
            )





            Button(
                {
                    viewModel.onAction(
                        UserAction.PlayAgainButtonClicked
                    )
                },
                shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 10.dp),
               elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 20.dp,
                    disabledElevation = 0.dp,


                ),



                colors = ButtonDefaults.buttonColors(
                containerColor = Green,
                    contentColor = Color.White
                )

















            ) {
                Text(
                    text = if (
                        state.hasWon || state.drawCount > 0
                    ) "Play Again" else "Reset",
                    color = Color.White,

                    fontSize = 16.sp
                )
            }

        }
    }
}

@Preview
@Composable
fun GameScreenr () {
    StartScreen(
        viewModel = GameViewModel(),
        navHostController = NavHostController(LocalContext.current)
    )




}

@Composable
fun DrawVictoryLine(
    state: GameState,
) {
    when (state.victoryType) {
        VictoryType.HORIZONTAL1 -> WinHorizontalLine1()
        VictoryType.HORIZONTAL2 -> WinHorizontalLine2()
        VictoryType.HORIZONTAL3 -> WinHorizontalLine3()
        VictoryType.VERTICAL1 -> WinVerticalLine1()
        VictoryType.VERTICAL2 -> WinVerticalLine2()
        VictoryType.VERTICAL3 -> WinVerticalLine3()
        VictoryType.DIAGONAL1 -> WinDiagonalLine1()
        VictoryType.DIAGONAL2 -> WinDiagonalLine2()
        VictoryType.NONE -> {}
    }
}


