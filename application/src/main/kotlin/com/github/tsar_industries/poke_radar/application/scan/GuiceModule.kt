package com.github.tsar_industries.poke_radar.application.scan

import com.github.tsar_industries.poke_radar.pokemon_go.Location
import com.github.tsar_industries.poke_radar.pokemon_go.Password
import com.github.tsar_industries.poke_radar.pokemon_go.Username
import com.google.inject.AbstractModule

internal class GuiceModule : AbstractModule() {
    override fun configure() {
        bind(Username::class.java).toInstance(Username(""))
        bind(Password::class.java).toInstance(Password(""))
        bind(Location::class.java).toInstance(Location(59.337042, 18.064270, 0.0))
    }

}
