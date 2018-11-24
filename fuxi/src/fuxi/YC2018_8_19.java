package fuxi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class YC2018_8_19 {
	public static Date show(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONDAY, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}
	
	
	
	public static void main(String[] args) throws IOException {
		/*Iterator it = list.Iterator();
		while (it.hasNext()) {
			System.out.println(it.next);
		}*/
		File file = new File("C:/a.txt");
		File dir = new File("C:/xx.txt");
		File dir1 = new File("C:/yyy/ccc/q.txt");
		dir.mkdirs();//创建单级目录
		dir1.mkdirs();//创建多级目录
		//System.out.println(file.createNewFile());
		System.out.println(file.isFile());//查询有没有这个文件
		FileInputStream f = new FileInputStream("C:\\xx.txt");
		int i;
		do {
			i = f.read();
			System.out.println((char)i);
		}while(i !=0);
		f.close();
		
		
		
	}

}
