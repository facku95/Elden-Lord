package org.example.project.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.example.project.domain.classes.ListaArmas
import org.example.project.domain.classes.Arma

class EldenRingAPI {

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
            val response: ListaArmas = client.get("https://eldenring.fanapis.com/api/weapons?limit=45").body()
            response.data
        } catch (e: Exception) {
            println("DEBUG: Error al obtener armas -> ${e.message}")
            emptyList() // Devuelve lista vacía si falla
        }
    }
}
