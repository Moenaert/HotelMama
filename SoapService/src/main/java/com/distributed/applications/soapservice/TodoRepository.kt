package com.distributed.applications.soapservice

import generated.sources.jaxb2.Todo
import javax.annotation.PostConstruct
import kotlin.Throws
import javax.xml.datatype.DatatypeConfigurationException
import java.time.LocalDate
import javax.xml.datatype.DatatypeFactory
import org.springframework.stereotype.Component
import org.springframework.util.Assert
import java.util.*

@Component
class TodoRepository {
    @PostConstruct
    @Throws(DatatypeConfigurationException::class)
    fun initData() {

    }

    fun findTodo(id: Int): Todo? {
        Assert.notNull(id, "The todo id must not be null")
        return todos[id]
    }

    companion object {
        private val todos: MutableMap<Int, Todo> = HashMap()
    }
}