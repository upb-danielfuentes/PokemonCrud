package colombiadex.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

object PokemonApi {
    private const val API_URL = "https://pokeapi.co/api/v2/pokemon/"

    suspend fun getRandomPokemon(): String {
        return withContext(Dispatchers.IO) {
            val url = URL("https://pokeapi.co/api/v2/pokemon/${(1..150).random()}")
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            val inputStream = connection.inputStream
            val jsonString = inputStream.bufferedReader().use { it.readText() }
            val jsonObject = JSONObject(jsonString)
            val pokemonName = jsonObject.getString("name")
            pokemonName
        }
    }

}

