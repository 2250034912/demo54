package fuxi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileIo {
	
	public static void dispaly(String fileName,String charset) throws IOException {
		FileInputStream fis = null ;//��Դ��
		InputStreamReader isr = null;//������
		try {
			fis=new FileInputStream(fileName);
			isr = new InputStreamReader(fis,charset);
			char[] stringBuffer = new char[1024];
			int length;
			while((length = isr.read(stringBuffer)) > 0) {
				String s = new String (stringBuffer,0,length);
				System.out.println("=========================");
				System.out.println(s);
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			fis.close();
			isr.close();
		}
		
	}
	
	
	public void display1(String fileName,String charset) {
		//������(��Դ����������)
		FileInputStream fis = null;
		InputStreamReader isr = null;
		
		//������
		try {
			fis=new FileInputStream(fileName);
			isr = new InputStreamReader(fis,charset);
			char [] stringBuffer = new char[1024];
			int length;
			while((length = isr.read(stringBuffer))>0) {
				String s = new String (stringBuffer,0,length);
				System.out.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static boolean copy(String fileName,String newFileName) throws IOException {
		//�ж�Դ�ļ��Ƿ����
		File sf = new File(fileName);
		if(sf.exists()==false) {
			System.out.println("�ļ�"+fileName+"�Ҳ�����");
			return false;
		}
		//���ж�Ŀ���ļ��Ƿ����
		File sf1 = new File(newFileName);
		if(sf1.exists()==true) {
			System.out.println("����ѡ��"+newFileName+"�ļ��Ѿ������Ƿ�ѡ�񸲸Ǹ��ļ�\r\n"
					+"��ѡ���ǣ�Y����N��");
			Scanner s = new Scanner(System.in);
			String str =s.next();
			s.close();
			//equalsIgnoreCase(str):���Դ�Сд�ıȽ�
			if("n".equalsIgnoreCase(str)) {
				System.out.println("�ļ�����ʧ�ܣ�");
				return false;
			}
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(fileName);//�ֽ���
			fos = new FileOutputStream(newFileName);
			byte[] sbuffer = new byte[1024];
			int length;
			
			while((length = fis.read(sbuffer))>0) {
				fos.write(sbuffer,0,length);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			fis.close();
			fos.close();
		}
		System.out.println("�ļ����Ƴɹ�");
		
		return true;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		//�ļ����������ֽ���/
		FileInputStream fis = new FileInputStream("F:/red.txt");
		int i;
		do {
			i = fis.read();
			System.out.print((char)i);
			
		}while(i != -1);
		
		fis.close();
		
		//�ַ��������ļ�(û������)
		FileReader fr = new FileReader("F:/red.txt");
		char[] stringBuffer = new char[1024];
		int count;
		//���count = -1;���ʾ�����ˣ�
		while((count = fr.read(stringBuffer))>0) {
			String s = new String (stringBuffer,0,count);
			System.out.println(s);
		}
		fr.close();
		
		dispaly("F:/red.txt","gbk");
		//gb2312���ļ������
		//utf-8�����
		//gbk�����ַ�������
		copy("F:/red.txt","F:/rad1.txt");
		
		
		
		
		
		
	}

}
