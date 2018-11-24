package fuxi;//字符串->字符数组；字符串里的字母->大写，小写；字符串->字符数组
				//统计字符串某个元素个数；字符串字段的截取；

public class Stringuse {
	public static void main(String[] args) {
		String s = "语文,数学,英语,化学";
		String []a = s.split(",");
		for(String r : a) {
			System.out.println(r);
		}//增强for循环格式for(输出数据类型 : 数组名)
		//转化为大写
		String s1 = "很(chao)容(ji)易(nan)";
		String a1 = s1.toUpperCase();
		System.out.println(a1);
		//==============转化为小写
		String s2 = "NIHAO+JAVA";
		String [] a7 =s2.split("+");
		System.out.println("=======================================");
		for(int i=0;i<a7.length;i++) {
			System.out.println(a7[i]);
		}
		System.out.println("==============================================");
		String a2 = s2.toLowerCase();
		System.out.println(a2);
		//==============转化char数组
		String s3 = "哈哈哈哈嘻嘻嘻哈嘻哈嘻哈洗衣蜥蜴";
		char a3[] = s3.toCharArray();
		for(char b : a3) {
			System.out.print(b+" ");
		}
		//=============元素个数
		String s4 = "哈哈哈哈嘻嘻嘻哈嘻哈嘻哈洗衣蜥蜴";
		char a4[] = s4.toCharArray();
		int count=0;
		for(char b1 : a4) {
			if(b1 == '哈') {
				count++;
			}
		}
		System.out.println();
		System.out.println("一共有"+count+"哈");
		String s5 = "c:/window/system/test.txt";
		int pos = s5.lastIndexOf("/");
		System.out.println(s5.substring(pos+1));
		String s6 = "";
		//=============stringBuffer
		/*long start = System.currentTimeMillis();
		for(int i = 0;i < 100000; i++) {
			s+="汪";
		}
		System.out.println(System.currentTimeMillis()-start);*/
		StringBuffer sb = new StringBuffer();
		long start1 = System.currentTimeMillis();
		for(int i = 0;i < 100000; i++) {
			sb.append("汪");
		}
		System.out.println(System.currentTimeMillis()-start1);
	}
}
