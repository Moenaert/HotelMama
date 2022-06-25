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
        response.todo = Todo()
        val todofrombase: ToDoEntity? =todoRepository2?.findAll()?.last()
        response.todo.id= todofrombase?.id?.toInt()!!
        response.todo.description= todofrombase.description!!
        response.todo.user= todofrombase?.name!!
        response.todo.targetDate= todofrombase?.targetDate!!
//        todoRepository2?.findById(request.id.toLong())
        return response
    }

    companion object {
        private const val NAMESPACE_URI = "http://distributedapplications.com/soapservice"
    }
}