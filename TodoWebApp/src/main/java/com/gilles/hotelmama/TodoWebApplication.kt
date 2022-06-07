package com.gilles.hotelmama

import com.gilles.hotelmama.jms.JmsMessage
import entity.ToDoEntity
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer
import org.springframework.context.annotation.Bean
import org.springframework.jms.annotation.EnableJms
import org.springframework.jms.config.DefaultJmsListenerContainerFactory
import org.springframework.jms.config.JmsListenerContainerFactory
import org.springframework.jms.core.JmsTemplate
import org.springframework.jms.support.converter.MappingJackson2MessageConverter
import org.springframework.jms.support.converter.MessageConverter
import org.springframework.jms.support.converter.MessageType
import repository.ToDoRepository
import javax.jms.ConnectionFactory
import javax.persistence.Persistence


@SpringBootApplication
@EnableJms
open class TodoWebApplication {
    @Bean
    open fun myFactory(connectionFactory: ConnectionFactory?, configurer: DefaultJmsListenerContainerFactoryConfigurer): JmsListenerContainerFactory<*> {
        val factory = DefaultJmsListenerContainerFactory()
        configurer.configure(factory, connectionFactory)
        return factory
    }

    @Bean
    open fun jacksonJmsMessageConverter(): MessageConverter {
        val converter = MappingJackson2MessageConverter()
        converter.setTargetType(MessageType.TEXT)
        converter.setTypeIdPropertyName("_type")
        return converter
    }

    @Bean
    open fun run(repository: ToDoRepository): CommandLineRunner? {
        return CommandLineRunner { args: Array<String?>? ->
            insertFourEmployees(repository)
            System.out.println(repository.findAll())
        }
    }

    private fun insertFourEmployees(repository: ToDoRepository) {
        repository.save(ToDoEntity())
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

//            val entityManagerFactory = Persistence.createEntityManagerFactory("default")
//            val entityManager = entityManagerFactory.createEntityManager()
//            val transaction = entityManager.transaction
//            try {
//                println("AYYYYYY");
//                transaction.begin()
//
//                val peter = ToDoEntity();
//
//                peter.description= "potato2";
//                peter.toDoId=1;
//
//                entityManager.merge(peter);
//                entityManager.persist(peter);
//
//               transaction.commit()
//            } finally {
//                if (transaction.isActive) {
//                    transaction.rollback()
//                }
//                entityManager.close()
//                entityManagerFactory.close()
//            }

            val context = SpringApplication.run(TodoWebApplication::class.java, *args)
            val jmsTemplate = context.getBean(JmsTemplate::class.java)
            println("Sending jms message.")
            jmsTemplate.convertAndSend("TodoWebApplication", JmsMessage("This is a message send though JMS"))
        }

    }
}