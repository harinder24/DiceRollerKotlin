package com.example.dicerollerkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dicerollerkotlin.ui.theme.DiceRollerKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerKotlinTheme {
                DiceRollerApp()
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp(){
    Column() {
        DiceRollerWithImageAndButton(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
    }

}

@Composable
fun DiceRollerWithImageAndButton(modifier: Modifier) {
    var result by remember {
        mutableStateOf(1)
    }
    val image = when(result){
        1 -> painterResource(id = R.drawable.dice_1)
        2 -> painterResource(id = R.drawable.dice_2)
        3 -> painterResource(id = R.drawable.dice_3)
        4 -> painterResource(id = R.drawable.dice_4)
        5 -> painterResource(id = R.drawable.dice_5)
        else -> painterResource(id = R.drawable.dice_6)
    }
    Image(painter = image, contentDescription = null)

    Button(onClick = {result = (1..6).random()}) {
            Text(text = stringResource(R.string.roll))
    }
}
