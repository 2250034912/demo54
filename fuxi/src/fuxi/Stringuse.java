package fuxi;//�ַ���->�ַ����飻�ַ��������ĸ->��д��Сд���ַ���->�ַ�����
				//ͳ���ַ���ĳ��Ԫ�ظ������ַ����ֶεĽ�ȡ��

public class Stringuse {
	public static void main(String[] args) {
		String s = "����,��ѧ,Ӣ��,��ѧ";
		String []a = s.split(",");
		for(String r : a) {
			System.out.println(r);
		}//��ǿforѭ����ʽfor(����������� : ������)
		//ת��Ϊ��д
		String s1 = "��(chao)��(ji)��(nan)";
		String a1 = s1.toUpperCase();
		System.out.println(a1);
		//==============ת��ΪСд
		String s2 = "NIHAO+JAVA";
		String [] a7 =s2.split("+");
		System.out.println("=======================================");
		for(int i=0;i<a7.length;i++) {
			System.out.println(a7[i]);
		}
		System.out.println("==============================================");
		String a2 = s2.toLowerCase();
		System.out.println(a2);
		//==============ת��char����
		String s3 = "������������������������ϴ������";
		char a3[] = s3.toCharArray();
		for(char b : a3) {
			System.out.print(b+" ");
		}
		//=============Ԫ�ظ���
		String s4 = "������������������������ϴ������";
		char a4[] = s4.toCharArray();
		int count=0;
		for(char b1 : a4) {
			if(b1 == '��') {
				count++;
			}
		}
		System.out.println();
		System.out.println("һ����"+count+"��");
		String s5 = "c:/window/system/test.txt";
		int pos = s5.lastIndexOf("/");
		System.out.println(s5.substring(pos+1));
		String s6 = "";
		//=============stringBuffer
		/*long start = System.currentTimeMillis();
		for(int i = 0;i < 100000; i++) {
			s+="��";
		}
		System.out.println(System.currentTimeMillis()-start);*/
		StringBuffer sb = new StringBuffer();
		long start1 = System.currentTimeMillis();
		for(int i = 0;i < 100000; i++) {
			sb.append("��");
		}
		System.out.println(System.currentTimeMillis()-start1);
	}
}
