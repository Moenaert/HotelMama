package com.distributed.applications.soapservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.jvm.JvmStatic
import org.springframework.boot.SpringApplication
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlType
import javax.xml.bind.annotation.XmlSchemaType
import javax.xml.bind.annotation.XmlRegistry
import javax.xml.bind.annotation.XmlRootElement

@SpringBootApplication
open class SoapServiceApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SoapServiceApplication::class.java, *args)
        }
    }
}