package com.example.cardbankcompose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cardbankcompose.domain.viewmodel.MainViewModels
import org.koin.androidx.compose.koinViewModel

@Composable
fun Greeting(textField: State<String>, onValueChangeText: (String) -> Unit, viewModel: MainViewModels = koinViewModel()) {

    val textValue = textField.value
    val newBankServer = viewModel.card.observeAsState().value // подписка LiveData ViewModel (.observeAsState())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 10.dp)
    ) {
        OutlinedTextField(
            value = textValue,
            onValueChange = onValueChangeText,
            textStyle = TextStyle(fontSize = 20.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            maxLines = 7,
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Поиск",
                    modifier = Modifier.size(50.dp),
                    tint = Color.Green,
                )
                IconButton(onClick = { viewModel.onShowCard(textValue) }) {
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color.Blue,
            ),
            label = {
                Text(text = "Поиск BIN")
            },
            placeholder = {
                Text(text = "на пример: 431723")
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
        Column() {
            Text(text = newBankServer?.bank?.name.toString(),
                modifier = Modifier
                    .padding(vertical = 5.dp))

            Text(text = newBankServer?.bank?.city.toString(),
                modifier = Modifier
                    .padding(vertical = 5.dp))
        }
    }

//    binding.inputLayoutTextWindow.setEndIconOnClickListener {
//        val numberBin = binding.binEditText.text.toString()
//        if (numberBin.isEmpty()) {
//        } else {
//            viewModel.onShowCard(numberBin)
//        }
//    }

//    viewModel.card.observe(viewLifecycleOwner) {
//        binding.bankTv.text = it.bank?.name
//        binding.schemeTv.text = it.scheme
//        binding.typeTv.text = it.type
//        binding.brandTv.text = it.brand
//        binding.countryTv.text = it.country?.name
//        binding.urlTv.text = it.bank?.url
//        binding.phoneTv.text = it.bank?.phone
//        binding.latitudeTv.text = it.country?.latitude.toString()
//        binding.longitudeTv.text = it.country?.longitude.toString()
//    }

}
