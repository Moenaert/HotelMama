package com.gilles.hotelmama


import org.springframework.web.bind.annotation.SessionAttributes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.stereotype.Controller
import org.springframework.ui.Model


@Controller
@SessionAttributes("name")
class LoginController {
    @Autowired
    private val loginService: LoginService? = null
    @GetMapping(AppConfig.loginPageURL)
    fun showLoginPage(): String? {
        return AppConfig.loginPageViewTemplate
    }

    @PostMapping(AppConfig.todoPageURL)
    fun handleUserLogin(model: Model, @RequestParam name: String, @RequestParam password: String): String? {
        if (!loginService!!.validateUser(name, password)) {
            model.addAttribute(AppConfig.loginErrorModelAttributeName, AppConfig.loginErrorMessage)
            return AppConfig.loginPageViewTemplate
        }
        model.addAttribute(AppConfig.nameModelAttributeName, name)
        return "redirect:todos"
    }
}