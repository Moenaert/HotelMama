package com.distributed.applications.soapservice

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class SoapServiceApplication {

    @Bean
    open fun run(repository: UserRepository): CommandLineRunner? {
        return CommandLineRunner { args: Array<String?>? ->
            insertFourEmployees(repository)
            System.out.println(repository.findAll())
            System.out.println(repository.findUsersByLastNameContaining(" "))
        }
    }

    fun insertFourEmployees(repository: UserRepository) {
        repository.save(User("Dalia", "Abo Sheasha"))
        repository.save(User("Trisha", "Gee"))
        repository.save(User("Helen", "Scott"))
        repository.save(User("Mala", "Gupta"))
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SoapServiceApplication::class.java, *args)
        }
    }
}