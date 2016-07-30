package com.github.tsar_industries.poke_radar.pokemon_go

import com.pokegoapi.api.PokemonGo
import com.pokegoapi.auth.PtcCredentialProvider
import okhttp3.OkHttpClient
import javax.inject.Inject


open class PokemonGoService {
    val pokemonApi: PokemonGo

    @Inject
    constructor(username: Username, password: Password, location: Location) {
        val client = OkHttpClient()
        val provider = PtcCredentialProvider(client, username.value, password.value)
        pokemonApi = PokemonGo(provider, client)
        pokemonApi.setLocation(location.latitude, location.longitude, location.altitude)
    }

    fun getUsername(username: String, password: String): String {

        val myPair = Pair(1, 2) //todo remove this once we use kotlin stdlib properly somewhere



        return pokemonApi.playerProfile.username
    }

    fun getCatchablePokemons(): List<String> {
        return pokemonApi.map.catchablePokemon
                .map { it.pokemonId.name }
    }

    fun isHealthy(): Boolean {
        try {
            return pokemonApi.playerProfile.username.isNotBlank()
        } catch(e: Exception) {
            e.printStackTrace()
            return false
        }
    }
}
