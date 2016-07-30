package com.github.tsar_industries.poke_radar.application.service

import com.github.tsar_industries.poke_radar.pokemon_go.Location
import com.github.tsar_industries.poke_radar.pokemon_go.Password
import com.github.tsar_industries.poke_radar.pokemon_go.PokemonGoService
import com.github.tsar_industries.poke_radar.pokemon_go.Username

internal class SimpleService : Service {
    override fun getMessage() = "The service class works"
    override fun getUsername(username: String, password: String) = PokemonGoService(Username(username), Password(password), Location(10.0,10.0,10.0)).getUsername(username, password)
}
