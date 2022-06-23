package com.gilles.hotelmama

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LoginService {

    @Autowired
    private val repository: UserRepository?=null
    fun validateUser(user: String, password: String): Boolean {

        var bool: Boolean=false
        for (x in repository!!.findAll()) {
            bool = (user == x.name || user == x.name) && password == x.password
            return bool
        }

        return bool
    }
}