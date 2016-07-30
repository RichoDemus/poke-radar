package com.github.tsar_industries.poke_radar.application

import com.github.richodemus.guice_classpath_scanning.ClassPathScanningModule
import com.github.tsar_industries.poke_radar.application.scan.GuiceModule
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import ru.vyarus.dropwizard.guice.GuiceBundle

class MyApplication : Application<MyConfiguration>() {
    companion object {
        @JvmStatic fun main(args: Array<String>) = MyApplication().run(*args)
    }

    override fun initialize(bootstrap: Bootstrap<MyConfiguration>) =
            bootstrap.addBundle(GuiceBundle.builder<MyConfiguration>()
                    .enableAutoConfig("com.github.tsar_industries.poke_radar.application.scan")
                    .modules(ClassPathScanningModule("com.github.tsar_industries.poke_radar.application.service"), GuiceModule())
                    .build())

    override fun run(configuration: MyConfiguration, environment: Environment) {
    }
}
