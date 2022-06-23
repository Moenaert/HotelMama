package com.gilles.hotelmama

import org.springframework.web.bind.annotation.SessionAttributes
import com.gilles.hotelmama.AppConfig
import org.springframework.jms.annotation.JmsListener
import com.gilles.hotelmama.jms.JmsMessage
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.entity.StringEntity
import org.apache.http.client.methods.HttpPost
import org.apache.http.util.EntityUtils
import kotlin.jvm.JvmStatic
import com.gilles.hotelmama.soap.client.SoapWebServiceClient
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.web.servlet.ModelAndView
import com.gilles.hotelmama.TodoService
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.beans.factory.annotation.Autowired
import com.gilles.hotelmama.SessionTimer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import com.gilles.hotelmama.LoginService
import org.springframework.web.bind.annotation.RestController
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.jms.annotation.EnableJms
import javax.jms.ConnectionFactory
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer
import org.springframework.jms.config.JmsListenerContainerFactory
import org.springframework.jms.config.DefaultJmsListenerContainerFactory
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.boot.SpringApplication
import com.gilles.hotelmama.TodoWebApplication
import com.gilles.hotelmama.jms.Receiver
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.jms.core.JmsTemplate
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import java.util.*

@Controller
@SessionAttributes(AppConfig.nameModelAttributeName)
class TodoController {
    @Autowired
    private val todoService: TodoService? = null

    @Autowired
    private val timer: SessionTimer? = null

    @Autowired
    private val receiver: Receiver? = null

    @Autowired
    private val repository: ToDoRepository?=null

    @GetMapping(AppConfig.todoPageURL)
    fun showTodoPage(model: Model): String? {
        val user = model.getAttribute(AppConfig.nameModelAttributeName) as String
        model.addAttribute(AppConfig.todosModelAttributeName, todoService!!.filterTodos(user))
        model.addAttribute(AppConfig.todoCountModelAttributeName, todoService.todoCount)
        model.addAttribute(AppConfig.timerModelAttributeName, timer!!.sessionTime)
        model.addAttribute(AppConfig.messageModelAttributeName, receiver!!.message)
        return AppConfig.todoPageViewTemplate
    }

    @GetMapping(AppConfig.addTodoPageURL)
    fun showAddTodoPage(): String? {
        return AppConfig.addTodoViewTemplate
    }

    @PostMapping(AppConfig.addTodoPageURL)
    fun addTodo(model: Model, @RequestParam description: String): String {

        val intje: Int = todoService!!.addTodo(model.getAttribute(AppConfig.nameModelAttributeName) as String, description, Date(), false)
        repository?.save(ToDoEntity(intje.toLong(),"TestingName", description,Date(),false))

        return "redirect:" + AppConfig.todoPageViewTemplate
    }


    @GetMapping(AppConfig.deleteTodoURL)
    fun deleteTodo(model: Model?, @RequestParam id: Int): String {

        // TODO: 22/06/2022 Add Temporal annotation in ToDoEntity
        // TODO: 22/06/2022 Add other annotations

        println(todoService!!.TodoById(id)?.id)
        println("Ayyy"+ id)
        repository?.deleteById(id.toLong())
        todoService!!.deleteTodo(id)
        return "redirect:" + AppConfig.todoPageViewTemplate
    }
}