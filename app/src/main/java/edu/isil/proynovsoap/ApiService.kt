package edu.isil.proynovsoap

import edu.isil.provnovsoap.PlayerName
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("info.wso/AllCardsInfo/JSON/debug")
    suspend fun getAllCardsInfo(): List<CardInfo>

    @GET("info.wso/AllPlayerNames/JSON/debug")
    suspend fun getAllPlayerNames(@Query("bSelected") bSelected: Boolean = true): List<PlayerName>

}