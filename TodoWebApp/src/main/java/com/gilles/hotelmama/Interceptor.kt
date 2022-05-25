package com.gilles.hotelmama


import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.web.servlet.ModelAndView

import org.springframework.stereotype.Component
import java.lang.Exception

@Component
class Interceptor : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        println("Pre Handle method is Calling")
        return true
    }

    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any, modelAndView: ModelAndView) {
        println("Post Handle method is Calling")
    }

    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, exception: Exception) {
        println("Request and Response is completed")
    }
}