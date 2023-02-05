package com.example.cardbankcompose.domain

import com.example.cardbank.domain.data.models.base.BankBIN

interface RepositoryBank {

    suspend fun observerBin(bin: String): BankBIN

}