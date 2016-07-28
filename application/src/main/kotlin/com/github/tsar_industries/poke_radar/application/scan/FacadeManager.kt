package com.github.tsar_industries.poke_radar.application.scan

import com.github.tsar_industries.poke_radar.pokemon_go.PokemonGoFacade
import io.dropwizard.lifecycle.Managed
import javax.inject.Inject

internal class FacadeManager @Inject constructor(val facade: PokemonGoFacade) : Managed {
    override fun start() = facade.start()
    override fun stop() = facade.stop()
}
