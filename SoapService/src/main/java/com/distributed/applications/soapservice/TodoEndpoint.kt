package com.distributed.applications.soapservice

import generated.sources.jaxb2.GetTodoRequest
import generated.sources.jaxb2.GetTodoResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload

@Endpoint
class TodoEndpoint @Autowired constructor(private val todoRepository: TodoRepository) {
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetTodoRequest")
    @ResponsePayload
    fun getTodo(@RequestPayload request: GetTodoRequest): GetTodoResponse {
        val response = GetTodoResponse()
        response.todo = todoRepository.findTodo(request.id)
        return response
    }

    companion object {
        private const val NAMESPACE_URI = "http://distributedapplications.com/soapservice"
    }
}