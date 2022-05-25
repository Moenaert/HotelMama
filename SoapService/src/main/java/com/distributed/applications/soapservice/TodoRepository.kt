package com.distributed.applications.soapservice

import generated.sources.jaxb2.Todo
import javax.annotation.PostConstruct
import kotlin.Throws
import javax.xml.datatype.DatatypeConfigurationException
import java.time.LocalDate
import javax.xml.datatype.DatatypeFactory
import java.util.HashMap
import org.springframework.stereotype.Component
import org.springframework.util.Assert

@Component
class TodoRepository {
    @PostConstruct
    @Throws(DatatypeConfigurationException::class)
    fun initData() {
        val task = Todo()
        task.id = 1
        task.description = "soap service ready"
        task.isIsDone = false
        task.user = "Gilles"
        val localDate = LocalDate.of(2019, 4, 25)
        val xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(localDate.toString())
        task.targetDate = xmlGregorianCalendar
        todos[task.id] = task
        val task2 = Todo()
        task2.id = 2
        task2.description = "rest service ready"
        task2.isIsDone = true
        task2.user = "Stefan"
        task2.targetDate = xmlGregorianCalendar
        todos[task2.id] = task2
    }

    fun findTodo(id: Int): Todo? {
        Assert.notNull(id, "The todo id must not be null")
        return todos[id]
    }

    companion object {
        private val todos: MutableMap<Int, Todo> = HashMap()
    }
}