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
		FileInputStream fis = null ;//资源流
		InputStreamReader isr = null;//处理流
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
		//定义流(资源流，处理流)
		FileInputStream fis = null;
		InputStreamReader isr = null;
		
		//构建流
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
		//判断源文件是否存在
		File sf = new File(fileName);
		if(sf.exists()==false) {
			System.out.println("文件"+fileName+"找不到！");
			return false;
		}
		//在判断目标文件是否存在
		File sf1 = new File(newFileName);
		if(sf1.exists()==true) {
			System.out.println("您所选的"+newFileName+"文件已经存在是否选择覆盖该文件\r\n"
					+"请选择是（Y）否（N）");
			Scanner s = new Scanner(System.in);
			String str =s.next();
			s.close();
			//equalsIgnoreCase(str):忽略大小写的比较
			if("n".equalsIgnoreCase(str)) {
				System.out.println("文件复制失败！");
				return false;
			}
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(fileName);//字节流
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
		System.out.println("文件复制成功");
		
		return true;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		//文件输入流，字节流/
		FileInputStream fis = new FileInputStream("F:/red.txt");
		int i;
		do {
			i = fis.read();
			System.out.print((char)i);
			
		}while(i != -1);
		
		fis.close();
		
		//字符流读入文件(没有乱码)
		FileReader fr = new FileReader("F:/red.txt");
		char[] stringBuffer = new char[1024];
		int count;
		//如果count = -1;则表示读完了；
		while((count = fr.read(stringBuffer))>0) {
			String s = new String (stringBuffer,0,count);
			System.out.println(s);
		}
		fr.close();
		
		dispaly("F:/red.txt","gbk");
		//gb2312中文简体编码
		//utf-8万国码
		//gbk中文字符集编码
		copy("F:/red.txt","F:/rad1.txt");
		
		
		
		
		
		
	}

}
