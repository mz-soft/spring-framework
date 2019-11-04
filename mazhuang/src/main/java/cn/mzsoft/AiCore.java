package cn.mzsoft;

import java.util.Scanner;

/**
 * 功能描述
 *
 * @author mazhuang
 * @date 2019/11/4 20:54
 */
public class AiCore {
	public static void main(String[] args) {
		System.out.println("Ai Core internal test  build:v00.0.250478.debug.");
		while (true){
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			String out = str.replace("?","。");
			out = out.replace("？","。");
			 out = out.replace("吗","");
			 out = out.replace("你","我");
			System.out.println("ai:"+out);
		}
	}
}
