package com.gilles.hotelmama.jms

class JmsMessage {
    var message: String? = null

    constructor() {}
    constructor(message: String?) {
        this.message = message
    }

    override fun toString(): String {
        return "JmsMessage{message='$message'}"
    }
}