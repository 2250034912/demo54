package fuxi;

import java.util.*;
//list���ϣ�set���ϣ�Set�����е�Ԫ�ز����ظ���Map����
//�ܽ᣺list->ArrayList���ȿɸı䣻Map�������keyһ��ֵ��һ�����߸���ǰ�ߣ�
//Map����Map.Entry()���ڲ��ӿڣ�
public class list {
	public static void main(String[] args) {
		
		
		
		List list = new ArrayList();
		List list1 = new LinkedList();
		List list2 = new Vector();
		list.add("���");/*װ�����*/
		list.add(true);
		list.add(100);
		
		System.out.println(list.get(1));
		list.add(1, "����");
		System.out.println(list.get(1));
		/*
		 * ���ֱ�����ʽ
		 * */
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+",");
		}
		System.out.println("\n===================================");
		for(Object o : list) {
			System.out.print(o+",");
		}
		System.out.println("\n====================================");
		//���ص���������
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + ",");
		}
		System.out.println("\n====================================Set����");
		testset();
		System.out.println("\n====================================Map����");
		testMap();
	}
	public static void testset() {
		Set set = new HashSet();
		set.add("���");
		set.add(true);
		set.add(100);
		
		
		set.add("���");
		set.add(true);
		/*
		 * ���ַ�ʽ����Set
		 * */
		for(Object o : set) {
			System.out.print(o+",");
		}
	}
	public static void testMap() {
		//��ֵ�ԣ�˫�м��ϣ���Ψһֵ���ظ�  HashMap�ļ�����Ϊ��
		Map <String,Object>map = new HashMap<String,Object>();
		//< >���ŵ�:���� -> ����ָ�����Ԫ�ص����͡�
		map.put("123", "����");
		map.put("321", "ѧ��");
		map.put("101", "ѧ��");
		map.put("102", "С��");
		map.put("321", "Сè");
		map.put(null, "С��");
		System.out.println(map.get("321"));
		System.out.println(map.get("102"));
		System.out.println(map.get(null));
		/*
		 * ��������
		 * ��ǿforѭ������map��Map.Entry��Map�ӿڵ��ڲ��ӿ�
		 * */
		for(Map.Entry<String, Object> e : map.entrySet()) {
			System.out.print(e.getKey()+"="+e.getValue()+";");
		}
	}

}
