package cn.mzsoft

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service

@Service("groovyBean")
public class GroovyBean {
	String hello(){
		String s = "hello GroovyBean";
		println(s)
		return s
	}
}
