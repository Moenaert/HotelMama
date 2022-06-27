package com.gilles.hotelmama

import com.gilles.hotelmama.jms.Receiver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.SessionAttributes
import java.util.*
import java.util.stream.Collectors


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

    @Autowired
    private val repository2: UserRepository?=null


    @GetMapping(AppConfig.todoPageURL)
    fun showTodoPage(model: Model): String? {

        println("Print")
        println(repository?.findAllToDoes(Sort.by("name")))
        val user = model.getAttribute(AppConfig.nameModelAttributeName) as String
        model.addAttribute(AppConfig.todosModelAttributeName, todoService!!.filterTodos(user))
        model.addAttribute(AppConfig.todoCountModelAttributeName, todoService.todoCount2)
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
        val todotje:ToDoEntity = ToDoEntity(intje.toLong(),model.getAttribute(AppConfig.nameModelAttributeName) as String, description,Date(),false)

        repository2?.findUserByName(model.getAttribute(AppConfig.nameModelAttributeName) as String)?.toDos?.add(todotje )


        todotje.users?.add(repository2?.findUserByName(model.getAttribute(AppConfig.nameModelAttributeName) as String))

        val keytje=UserToDosDos()
        keytje.combinationTable=123456789
        keytje.todo = todotje
        keytje.user = repository2?.findUserByName(model.getAttribute(AppConfig.nameModelAttributeName) as String)
        todotje.keys.add(keytje)

        repository?.save(todotje)

        return "redirect:" + AppConfig.todoPageViewTemplate
    }


    @GetMapping(AppConfig.deleteTodoURL)
    fun deleteTodo(model: Model?, @RequestParam id: Int): String {

        repository?.findToDoEntityById(id.toLong())?.users?.remove(repository2?.findUserByName(model?.getAttribute(AppConfig.nameModelAttributeName) as String))
        repository2?.findUserByName(model?.getAttribute(AppConfig.nameModelAttributeName) as String)?.toDos?.remove(repository?.findToDoEntityById(id.toLong()))

        repository?.deleteById(id.toLong())
        todoService!!.deleteTodo(id)
        return "redirect:" + AppConfig.todoPageViewTemplate
    }
}