package org.example.project.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.example.project.domain.classes.ListaArmas
import org.example.project.domain.classes.Arma
import org.example.project.domain.classes.ArmaDetailResponse

class EldenRingAPI {

    private val BASE_URL : String = "https://eldenring.fanapis.com/api/weapons"
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            })
        }
    }

    suspend fun getWeapons(): List<Arma> {
        return try {
            val response: ListaArmas = client.get("$BASE_URL?limit=40").body()
            response.data
        } catch (e: Exception) {
            println("DEBUG: Error al obtener armas -> ${e.message}")
            emptyList() // Devuelve lista vacía si falla
        }
    }

    suspend fun getWeaponById(id: String): Arma{
        return try {
            val url = "$BASE_URL/$id"
            val response: ArmaDetailResponse = client.get(url).body()
            response.data

        } catch (e: Exception){
            throw e
        }

    }

}
