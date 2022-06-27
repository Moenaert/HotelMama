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
import org.springframework.jms.core.JmsTemplate
import org.springframework.ui.Model
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import java.util.*

@RestController
@SessionAttributes("name")
class TodoRestController {
    @Autowired
    var todoService: TodoService? = null
    @GetMapping(AppConfig.randomTodoRestURL)
    fun randomTodoRest(model: Model): Todo? {
        println(model.getAttribute(AppConfig.todoCountModelAttributeName))
        if (todoService!!.todoCount == 0) return Todo(0, "X", "No Tasks to do!", Date(), true)
        val todoList = todoService!!.filterTodos(model.getAttribute(AppConfig.nameModelAttributeName) as String)
        return getRandomFromList(todoList)
    }

    @Autowired
    var soapClient: SoapWebServiceClient? = null
    @GetMapping(AppConfig.randomTodoSoapURL)
    fun randomTodoSoap(model: Model?): String? {
        if (todoService!!.todoCount == 0) return "No Tasks to do!"
        if (todoService!!.todoCount == 1) return "You have only 1 task left!"
        val rand = Random()
        return soapClient!!.postSOAPXML(rand.nextInt(1, todoService!!.todoCount2))
    }

    fun getRandomFromList(list: List<Todo?>?): Todo? {
        val rand = Random()
        return list!![rand.nextInt(list.size)]
    }
}