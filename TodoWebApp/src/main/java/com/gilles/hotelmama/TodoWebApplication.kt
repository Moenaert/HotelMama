package com.gilles.hotelmama

import com.gilles.hotelmama.TodoWebApplication
import com.gilles.hotelmama.jms.JmsMessage
import entity.UsersEntity
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
import javax.jms.ConnectionFactory
import javax.persistence.Persistence
import javax.persistence.TypedQuery





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

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val entityManagerFactory = Persistence.createEntityManagerFactory("default")
            val entityManager = entityManagerFactory.createEntityManager()
            val transaction = entityManager.transaction
            try {
                transaction.begin()
                val dalia = UsersEntity();
                dalia.id = 6;
                dalia.name = "Potato";
                dalia.supervisorId = 1;
                entityManager.persist(dalia);

//            dalia.setId(6);
//            dalia.setFirstName("Dalia");
//            dalia.setLastName("Abo Sheasha");
//            entityManager.persist(dalia);
//                val empByDeptQuery: TypedQuery<Employee> =
//                    entityManager.createNamedQuery("Employee.byDept", Employee::class.java)
//                empByDeptQuery.setParameter(1, "Java Advocacy")
//                for (employee in empByDeptQuery.getResultList()) {
//                    System.out.println(employee)
//                }
//                val countEmpByDept: Query =
//                    entityManager.createNativeQuery("SELECT COUNT(*) FROM Employee INNER JOIN Department D on Employee.department_id = D.id WHERE D.name=:deptName")
//                countEmpByDept.setParameter("deptName", "Java Advocacy")
//                System.out.println("There are " + countEmpByDept.getSingleResult() + " Java Advocates.")
                transaction.commit()
            } finally {
                if (transaction.isActive) {
                    transaction.rollback()
                }
                entityManager.close()
                entityManagerFactory.close()
            }

            val context = SpringApplication.run(TodoWebApplication::class.java, *args)
            val jmsTemplate = context.getBean(JmsTemplate::class.java)
            println("Sending jms message.")
            jmsTemplate.convertAndSend("TodoWebApplication", JmsMessage("This is a message send though JMS"))
        }
    }
}