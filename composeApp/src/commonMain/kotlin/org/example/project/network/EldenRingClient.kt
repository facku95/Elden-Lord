package org.example.project.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.example.project.domain.classes.Arma
import org.example.project.domain.classes.Ceniza
import org.example.project.domain.classes.Item
import org.example.project.domain.classes.Jefe
import org.example.project.domain.classes.ListaCenizas
import org.example.project.domain.classes.ListaItems
import org.example.project.domain.classes.ListaJefes
import org.example.project.domain.classes.ListaMagias
import org.example.project.domain.classes.ListaNPC
import org.example.project.domain.classes.Magia
import org.example.project.domain.classes.NPC

object EldenRingClient {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun getWeapons(): List<Arma> {
        return client.get("https://eldenring.fanapis.com/api/weapons").body()
    }

    suspend fun getBosses(): List<Jefe> {
        return try {
            val response: ListaJefes = client.get("https://eldenring.fanapis.com/api/bosses").body()
            response.data
        } catch (e: Exception) {
            println("DEBUG: Error al obtener jefes -> ${e.message}")
            emptyList()
        }
    }
    suspend fun getItems(): List<Item> {
        return try {
            val response: ListaItems = client.get("https://eldenring.fanapis.com/api/items").body()
            response.data
        } catch (e: Exception) {
            println("DEBUG: Error al obtener items -> ${e.message}")
            emptyList()
        }
    }

    suspend fun getNPCs(): List<NPC> {
        return try {
            val response: ListaNPC = client.get("https://eldenring.fanapis.com/api/npcs").body()
            response.data
        } catch (e: Exception) {
            println("DEBUG: Error al obtener NPCs -> ${e.message}")
            emptyList()
        }
    }

    suspend fun getCenizas(): List<Ceniza> {
        return try {
            val response: ListaCenizas = client.get("https://eldenring.fanapis.com/api/ashes").body()
            response.data
        } catch (e: Exception) {
            println("DEBUG: Error al obtener cenizas -> ${e.message}")
            emptyList()
        }
    }
    suspend fun getMagias(): List<Magia> {
        return try {
            val response: ListaMagias = client.get("https://eldenring.fanapis.com/api/spells").body()
            response.data
        } catch (e: Exception) {
            println("DEBUG: Error al obtener magias -> ${e.message}")
            emptyList()
        }
    }
    suspend fun getSpells(): List<Magia> {
        return try {
            val response: ListaMagias = client.get("https://eldenring.fanapis.com/api/spells").body()
            response.data
        } catch (e: Exception) {
            println("DEBUG: Error al obtener hechizos -> ${e.message}")
            emptyList()
        }
    }

    suspend fun getIncantations(): List<Magia> {
        return try {
            val response: ListaMagias = client.get("https://eldenring.fanapis.com/api/incantations").body()
            response.data
        } catch (e: Exception) {
            println("DEBUG: Error al obtener conjuros -> ${e.message}")
            emptyList()
        }
    }


}


