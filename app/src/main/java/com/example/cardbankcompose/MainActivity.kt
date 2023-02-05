package com.example.cardbankcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.cardbankcompose.ui.theme.CardBankComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardBankComposeTheme {
                val textField = remember{ mutableStateOf("")}
                    Greeting(textField = textField, onValueChangeText = { newText ->
                        textField.value = newText
                    })
            }
        }
    }
}
