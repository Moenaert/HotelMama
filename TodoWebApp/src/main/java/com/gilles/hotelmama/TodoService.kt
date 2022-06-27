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
import org.springframework.stereotype.Service
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import java.util.*

@Service
class TodoService {
    var todoCount = 0
    var todoCount2= 0
    fun filterTodos(user: String): List<Todo> {
        val filteredTodos: MutableList<Todo> = ArrayList()
        for (todo in todos) {
            if (todo.user == user) filteredTodos.add(todo)
        }
        return filteredTodos
    }

    fun TodoById(idee:Int): Todo? {
        for(todo in todos){
            if(todo.id==idee) return todo
        }
        return null
    }

    fun addTodo(name: String, description: String, targetDate: Date, isDone: Boolean): Int {
        todos.add(Todo(++todoCount, name, description, targetDate, isDone))
        todoCount2++
        println("todoCount" + todoCount)
        return todoCount
    }

    fun deleteTodo(id: Int) {
        todos.removeIf { todo: Todo ->
            if (todo.id == id) {
                //--todoCount
                todoCount2--
                return@removeIf true
            }
            false
        }
    }

    companion object {
        private val todos: MutableList<Todo> = ArrayList()
    }
}