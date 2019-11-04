package cn.mzsoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述
 *
 * @author mazhuang
 * @date 2019/11/4 18:00
 */
@Component
public class ThreadBean {

	@Autowired
	JavaBean javaBean;

	public void threadStudy(){
		System.out.println("----------autowired注入--------");
		javaBean.hello();
		System.out.println("-----");


		Object o = new Object();
		final boolean[] flag = {true};

		int ii = 97;
		System.out.println(new String(new byte[]{(byte) ii}));

		new Thread(()->{
			for (int i = 1; i <= 999; i += 2) {
				synchronized (o) {
					while (true) {
						if (flag[0]) {
							System.out.println("current:" + i);
							flag[0] = !flag[0];
							o.notifyAll();
							break;

						} else {
							try {
								o.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}

			}
		}).start();
		new Thread(()->{
			for (int i = 2; i <= 1000; i += 2) {

				synchronized (o) {
					while (true) {
						if (!flag[0]) {
							System.out.println("current:" + i);
							flag[0] = !flag[0];
							o.notifyAll();
							break;
						} else {
							try {
								o.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

						}
					}
				}
			}
		}).start();

	}
}
