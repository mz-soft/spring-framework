package cn.mzsoft;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 功能描述
 *
 * @author mazhuang
 * @date 2019/11/3 17:21
 */
@Component
public class JavaBean {

	public String hello(){
		String s = "hello java bean";
		System.out.println(s);
		return s;
	}

}
