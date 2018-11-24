package fuxi;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Tstring {
	@SuppressWarnings("unchecked")
	public static <T> T cast(String svalue ,Class <T> cls){
		String b = cls.getSimpleName();
		switch(b) {
		case "Long": return (T) Long.valueOf(svalue);
		case "Integer" : return (T) Integer.valueOf(svalue);
		case "String":return (T) String.valueOf(svalue);
		case "Double":return (T) Double.valueOf(svalue);
		case "Float":return (T) Float.valueOf(svalue);
		case "Character":
			char[]chars = svalue.toCharArray();
			Character c = chars[0];
			return(T)c;
		case "Byte":return (T) Byte.valueOf(svalue);
		case "Short ":return (T) Short.valueOf(svalue);
		case "Date":
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			try {
				Date date = (Date) sdf.parse(svalue);
				return (T) date;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return null;
	}
	public static void main(String[] args) {
		//linkedHashMap(����)
		Map <String,String> map = new <String,String> LinkedHashMap();
		map.put("����","��");
		map.put("��ʦʦ","Ů");
		map.put("��־", "��");
		map.put("����", "��");
		map.put("�����", "Ů");
		int m=0 ,c=0;
		for(Map.Entry<String, String> e : map.entrySet()) {
			
			if(e.getValue()=="Ů") {
				m++;
				System.out.print(e.getKey()+",");
			}else {
				c++;
			}
		}
		System.out.println("Ů����"+m+"��");
		System.out.println("������"+c+"��");
		System.out.println("====================================================");
		for(Map.Entry<String, String> e : map.entrySet()) {
				System.out.println(e.getKey()+":"+e.getValue());
			}
		
		System.out.println("====================================================");
		
		for(Iterator iterator = map.entrySet().iterator();iterator.hasNext();) {
			
				System.out.println(iterator.next());
		}
		
		//����
		String a="123";
		long d = cast(a,Long.class);
		System.out.println(d);
		String a1="2018-8-18";
		Date d1 = cast(a1,Date.class);
		System.out.println(d1);
	}
}
