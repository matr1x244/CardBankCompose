package com.example.cardbankcompose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cardbankcompose.domain.viewmodel.MainViewModels
import org.koin.androidx.compose.koinViewModel

@Composable
fun Greeting(
    textField: State<String>,
    onValueChangeText: (String) -> Unit,
    viewModel: MainViewModels = koinViewModel()
) {

    val textValue = textField.value
    val newBankServer =
        viewModel.card.observeAsState().value // подписка LiveData ViewModel (.observeAsState())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 10.dp)
    ) {
        OutlinedTextField(
            value = textValue,
            onValueChange = onValueChangeText,
            textStyle = TextStyle(fontSize = 20.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = stringResource(R.string.search_desc_icon),
                    modifier = Modifier.size(50.dp),
                    tint = Color.Green,
                )
                IconButton(onClick = { if (textValue.isNotEmpty()) viewModel.onShowCard(textValue)}) {
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color.Blue,
            ),
            label = {
                Text(text = stringResource(R.string.search_bin))
            },
            placeholder = {
                Text(text = stringResource(R.string.primer_431723))
            },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.fillMaxWidth()

        )
        Text(
            text = "${textValue.length}",
            textAlign = TextAlign.Justify,
            color = Color.Blue,
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 5.dp)
        )

        if (viewModel.card.observeAsState().value != null) {
            Column() {
                Text(
                    text = newBankServer?.bank?.name.toString(),
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                )
                Text(
                    text = newBankServer?.scheme.toString(),
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                )
                Text(
                    text = newBankServer?.type.toString(),
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                )
                Text(
                    text = newBankServer?.brand.toString(),
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                )
                Text(
                    text = newBankServer?.country?.name.toString(),
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                )
                Text(
                    text = newBankServer?.bank?.url.toString(),
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                )

            }
        }
    }


//    binding.inputLayoutTextWindow.setEndIconOnClickListener {
//        val numberBin = binding.binEditText.text.toString()
//        if (numberBin.isEmpty()) {
//        } else {
//            viewModel.onShowCard(numberBin)
//        }
//    }

}
