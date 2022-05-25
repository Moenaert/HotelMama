package com.distributed.applications.soapservice

import com.mysql.cj.protocol.Resultset
import generated.sources.jaxb2.Todo
import jdk.incubator.vector.VectorOperators
import org.springframework.stereotype.Component
import org.springframework.util.Assert
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException


import java.time.LocalDate
import javax.annotation.PostConstruct
import javax.xml.datatype.DatatypeConfigurationException
import javax.xml.datatype.DatatypeFactory


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

        println("INITIALIZING OF DATABASE BLOCK");
        println("TO DO: Move this block to an appropriate class");
        println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        val c:Connection;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost?serverTimezone=UTC","root","Potatoroll123")
            println("Connection to Gilles' & Stefan's DataBase successful")

            val s2 = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
            val r2 = s2.executeUpdate("INSERT INTO `sys`.`UserInfo` (`name`, `password`) VALUES ('stormTrooper', 'Force');");

            val s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
            val r = s.executeQuery("SELECT * FROM sys.UserInfo");
            while(r.next()){
                println(r.getString("name"));
            }

        }catch (e: SQLException){
            e.printStackTrace()
        }

        println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

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