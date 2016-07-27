package com.github.tsar_industries.poke_radar.application.scan

import com.github.tsar_industries.poke_radar.pokemon_go.PokemonGoFacade
import ru.vyarus.dropwizard.guice.module.installer.feature.health.NamedHealthCheck
import javax.inject.Inject

internal class MyHealthCheck @Inject constructor(val facade: PokemonGoFacade) : NamedHealthCheck() {
    override fun getName() = "PokemonGoHealthCheck"
    override fun check(): Result {
        if (facade.isHealthy()) {
            return Result.healthy()
        }
        return Result.unhealthy("not connected to servers")
    }
}
