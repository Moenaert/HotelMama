package com.gilles.hotelmama.soap.client

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
import org.apache.http.client.HttpClient
import org.springframework.jms.core.JmsTemplate
import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import java.lang.Exception
import java.util.regex.Pattern

@Component
class SoapWebServiceClient {
    fun postSOAPXML(todo_id: Int): String? {
        var responseString: String? = null
        try {
            val soapBody = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gs="http://distributedapplications.com/soapservice">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:GetTodoRequest>
         <gs:id>$todo_id</gs:id>
      </gs:GetTodoRequest>
   </soapenv:Body>
</soapenv:Envelope>"""
            val httpclient: HttpClient = DefaultHttpClient()
            val strEntity = StringEntity(soapBody, "text/xml", "UTF-8")
            val post = HttpPost("http://localhost:8080/ws")
            post.setHeader("SOAPAction", "GetData")
            post.entity = strEntity
            val response = httpclient.execute(post)
            val respEntity = response.entity
            if (respEntity != null) {
                responseString = EntityUtils.toString(respEntity)
                println(responseString)
                val m = Pattern.compile("<balance>([^<]*)").matcher(responseString) //groups all characters except < (tag closing character)
                while (m.find()) {
                    println(m.group(1))
                }
            } else {
                System.err.println("No Response")
            }
        } catch (e: Exception) {
            System.err.println("WebService SOAP exception = $e")
        }
        return responseString
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val soapWebServiceClientObject = SoapWebServiceClient()
            soapWebServiceClientObject.postSOAPXML(1)
        }
    }
}