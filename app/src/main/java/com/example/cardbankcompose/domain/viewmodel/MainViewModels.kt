package com.example.cardbankcompose.domain.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardbank.domain.data.models.base.BankBIN
import com.example.cardbankcompose.domain.RepositoryBank
import kotlinx.coroutines.*

class MainViewModels(private val repository: RepositoryBank) : ViewModel() {

    private val _card = MutableLiveData<BankBIN>()
    val card: LiveData<BankBIN> = _card

    fun onShowCard(textNumber: String) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.v("@@@", "No success $throwable")
        }
        var newStart: Job? = null
        newStart?.cancel()
        newStart = viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val result = repository.observerBin(textNumber)
            withContext(Dispatchers.Main) {
                _card.postValue(result)
            }
        }
    }

}
