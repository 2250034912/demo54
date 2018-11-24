package fuxi;

import java.util.Scanner;

public class Yichang {

	public static void main(String[] args) {
		try {
			int m = Integer.parseInt("888888");//将含数字的字符串转换为整数
			int n = Integer.parseInt("aab888");
			int t = 7777;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			int [] a = new int[10];
				a[10]=1;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	 test();
		
		
	}
	public static void test() {
		Scanner s = new  Scanner(System.in);
		int i=0;
		System.out.println("请输入1~3");
		while(true) {
			switch(i) {
			case 1:
				
			}
		}
	}

}
