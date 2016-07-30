package com.github.tsar_industries.poke_radar.pokemon_go

import org.slf4j.LoggerFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonGoFacade {
    private val logger = LoggerFactory.getLogger(this.javaClass)
    private val FIVE_MINUTES: Long = 1000 * 60 * 5
    private val username: Username
    private val password: Password
    private val location: Location
    private val thread: Thread

    private var api: PokemonGoService? = null
    private var running: Boolean = false
    var catchablePokemons: List<String>? = null

    @Inject
    internal constructor(username: Username, password: Password, location: Location) {

        this.username = username
        this.password = password
        this.location = location
        thread = Thread({
            while (running) {
                try {
                    login()
                    updatePokemonMap()
                } catch(e: Exception) {
                    e.printStackTrace()
                }
                try {
                    Thread.sleep(FIVE_MINUTES)
                } catch(e: InterruptedException) {
                    println("Interrupted")
                }
            }
        })
    }

    fun start() {
        running = true
        thread.start()
    }

    fun stop() {
        running = false
    }

    private fun login() {
        api = PokemonGoService(username, password, location)
    }

    private fun updatePokemonMap() {
        catchablePokemons = api?.getCatchablePokemons()
        logger.info("Nearby pokemon: {}", catchablePokemons)
    }

    fun isHealthy():Boolean {
        api?.let {
            return it.isHealthy()
        }
        return false
    }
}
