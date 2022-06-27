package com.distributed.applications.soapservice

import generated.sources.jaxb2.GetTodoRequest
import generated.sources.jaxb2.GetTodoResponse
import generated.sources.jaxb2.Todo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload

@Endpoint
class TodoEndpoint @Autowired constructor(private val todoRepository: TodoRepository) {

    @Autowired
    private val todoRepository2: ToDoRepository2?=null

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetTodoRequest")
    @ResponsePayload
    fun getTodo(@RequestPayload request: GetTodoRequest): GetTodoResponse {
        val response = GetTodoResponse()
        parseData()
        response.todo =todoRepository.findTodo(request.id)
        println("Testing"+request.id)
        return response
    }

    fun parseData(){
        todoRepository.clearTodo()
        var idee = 0

        for(e:ToDoEntity in todoRepository2?.findAll()!!)     {
            var todo = Todo()
            todo.id= e.id.toInt()
            todo.description= e.description
            todo.user= e.name
            todo.targetDate= e.targetDate
            todoRepository.insertTodo(todo,idee)
            idee++
        }
    }

    companion object {
        private const val NAMESPACE_URI = "http://distributedapplications.com/soapservice"
    }
}