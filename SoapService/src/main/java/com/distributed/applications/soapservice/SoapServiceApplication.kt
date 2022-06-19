package com.distributed.applications.soapservice

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class SoapServiceApplication {

//    @Bean
//    open fun run(repository: EmployeeRepository): CommandLineRunner? {
//        return CommandLineRunner { args: Array<String?>? ->
//            insertFourEmployees(repository)
//            System.out.println(repository.findAll())
//            System.out.println(repository.findEmployeesByLastNameContaining(" "))
//        }
//    }
//
//    fun insertFourEmployees(repository: EmployeeRepository) {
//        repository.save(Employee("Dalia", "Abo Sheasha"))
//        repository.save(Employee("Trisha", "Gee"))
//        repository.save(Employee("Helen", "Scott"))
//        repository.save(Employee("Mala", "Gupta"))
//    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SoapServiceApplication::class.java, *args)
        }
    }
}