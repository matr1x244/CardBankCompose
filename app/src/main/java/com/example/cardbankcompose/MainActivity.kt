package com.example.cardbankcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import com.example.cardbank.domain.data.models.base.BankBIN
import com.example.cardbankcompose.domain.viewmodel.MainViewModels
import com.example.cardbankcompose.ui.theme.CardBankComposeTheme
import org.koin.androidx.compose.koinViewModel
import java.nio.file.WatchEvent.Modifier


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

    viewModel.card.observeForever {
       it.country?.name.toString()
        println("@@@@ ${it.bank?.name}, ${it.bank?.city}")
    }

    Text(text = "11111", modifier = androidx.compose.ui.Modifier
        .padding(vertical = 50.dp))

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