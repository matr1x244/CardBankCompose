package com.example.cardbankcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cardbankcompose.domain.viewmodel.MainViewModels
import com.example.cardbankcompose.ui.theme.CardBankComposeTheme
import org.koin.androidx.compose.koinViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardBankComposeTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting(viewModel: MainViewModels = koinViewModel()) {

    val text = "45717360"
    viewModel.onShowCard(text)
    val newBankServer = viewModel.card.observeAsState().value

    Row() {
        Text(text = newBankServer?.bank?.name.toString(),
            modifier = androidx.compose.ui.Modifier
                .padding(vertical = 50.dp)
        )
        Text(text = newBankServer?.bank?.city.toString())
    }

//    binding.inputLayoutTextWindow.setEndIconOnClickListener {
//        val numberBin = binding.binEditText.text.toString()
//        if (numberBin.isEmpty()) {
//        } else {
//            viewModel.onShowCard(numberBin)
//        }
//    }

    Row() {
        Text(text = "$text")
    }


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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CardBankComposeTheme {
        Greeting()
    }
}