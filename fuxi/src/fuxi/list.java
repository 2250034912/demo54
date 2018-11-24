package fuxi;

import java.util.*;
//list集合；set集合；Set集合中的元素不可重复；Map集合
//总结：list->ArrayList长度可改变；Map集合如果key一样值不一样后者覆盖前者；
//Map集合Map.Entry()：内部接口；
public class list {
	public static void main(String[] args) {
		
		
		
		List list = new ArrayList();
		List list1 = new LinkedList();
		List list2 = new Vector();
		list.add("你好");/*装箱操作*/
		list.add(true);
		list.add(100);
		
		System.out.println(list.get(1));
		list.add(1, "世界");
		System.out.println(list.get(1));
		/*
		 * 三种遍历方式
		 * */
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+",");
		}
		System.out.println("\n===================================");
		for(Object o : list) {
			System.out.print(o+",");
		}
		System.out.println("\n====================================");
		//返回迭代器对象
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + ",");
		}
		System.out.println("\n====================================Set集合");
		testset();
		System.out.println("\n====================================Map集合");
		testMap();
	}
	public static void testset() {
		Set set = new HashSet();
		set.add("你好");
		set.add(true);
		set.add(100);
		
		
		set.add("你好");
		set.add(true);
		/*
		 * 两种方式遍历Set
		 * */
		for(Object o : set) {
			System.out.print(o+",");
		}
	}
	public static void testMap() {
		//键值对（双列集合）键唯一值可重复  HashMap的键可以为空
		Map <String,Object>map = new HashMap<String,Object>();
		//< >里存放的:泛型 -> 用于指定存放元素的内型。
		map.put("123", "董超");
		map.put("321", "学霸");
		map.put("101", "学霸");
		map.put("102", "小明");
		map.put("321", "小猫");
		map.put(null, "小猪");
		System.out.println(map.get("321"));
		System.out.println(map.get("102"));
		System.out.println(map.get(null));
		/*
		 * 遍历方法
		 * 增强for循环迭代map，Map.Entry是Map接口的内部接口
		 * */
		for(Map.Entry<String, Object> e : map.entrySet()) {
			System.out.print(e.getKey()+"="+e.getValue()+";");
		}
	}

}
