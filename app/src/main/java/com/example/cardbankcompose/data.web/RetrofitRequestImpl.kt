package com.example.cardbankcompose.data.web

import com.example.cardbank.domain.data.models.base.BankBIN

import com.example.cardbankcompose.domain.RepositoryBank

class RetrofitRequestImpl(private val api: BinApi) : RepositoryBank {

    override suspend fun observerBin(bin: String): BankBIN {
        return api.bankBin(bin)
    }

}