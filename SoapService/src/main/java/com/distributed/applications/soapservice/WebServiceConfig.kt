package com.distributed.applications.soapservice

import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.xml.xsd.XsdSchema
import org.springframework.xml.xsd.SimpleXsdSchema
import org.springframework.core.io.ClassPathResource
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.ws.config.annotation.EnableWs
import org.springframework.ws.config.annotation.WsConfigurerAdapter
import org.springframework.ws.transport.http.MessageDispatcherServlet
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition


@EnableWs
@Configuration
open class WebServiceConfig : WsConfigurerAdapter() {
    @Bean
    open fun messageDispatcherServlet(applicationContext: ApplicationContext?): ServletRegistrationBean<MessageDispatcherServlet> {
        val servlet = MessageDispatcherServlet()
        servlet.setApplicationContext(applicationContext)
        servlet.isTransformWsdlLocations = true
        return ServletRegistrationBean(servlet, "/ws/*")
    }

    @Bean(name = ["todos"])
    open fun defaultWsdl11Definition(countriesSchema: XsdSchema?): DefaultWsdl11Definition {
        val wsdl11Definition = DefaultWsdl11Definition()
        wsdl11Definition.setPortTypeName("TodosPort")
        wsdl11Definition.setLocationUri("/ws")
        wsdl11Definition.setTargetNamespace("http://distributedapplications.com/soapservice")
        wsdl11Definition.setSchema(countriesSchema)
        return wsdl11Definition
    }

    @Bean
    open fun countriesSchema(): XsdSchema {
        return SimpleXsdSchema(ClassPathResource("todo.xsd"))
    }
}