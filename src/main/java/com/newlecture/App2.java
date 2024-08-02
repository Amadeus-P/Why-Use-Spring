package com.newlecture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.newlecture.web.entity.Exam;

public class App2 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Set<Exam> set = new HashSet<>();
		Map<String, Object> map = new HashMap();
		
		map.put("id", "sinny");
		map.put("pw", 1234);
		map.put("profile-img", "C:/src/img/myprofile.png");
		
		
		
//		System.out.println(map.get("id"));
//		System.out.println(map.get("pw"));
//		System.out.println(map.get("profile-img"));
		
//		for(Object key : map.keySet()) {
//			System.out.println(key);
//		}
//		for(Object value : map.values()) {
//			System.out.println(value);
//		}
		for(Object value : map.entrySet()) { // 중첩 제네릭 <Entry<,>>
			System.out.println(value);
		}
		for(Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.printf("%s %s \n", entry.getKey(), entry.getValue());
		}
		
		
		
		
		
		int sizeList = list.size();
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(3);
		
//		int num = (Integer)list.get(1);
		int num = list.get(1);
		
		
		Exam exam = new Exam();
		Exam exam1 = new Exam();
		
//		set.add("3");
		set.add(exam);
//		set.add(exam);
		set.add(exam1);
		set.add(new Exam("z",1,2,3));
//		set.add(4);
//		set.add(3);
		int sizeSet = set.size();
//		System.out.println(sizeList);
//		System.out.println(list);
//		System.out.println(sizeSet);
//		System.out.println(set);
		Iterator  it = set.iterator();
//		System.out.println(it.next());
//		System.out.println(set.iterator().next());
//		
//		while(it.hasNext())
//			System.out.println(it.next());
		
		for(Exam e : set) {
			System.out.println(e);
		}
		
		
		for(int c : new int[6]) { // ?
			System.out.println(c);
		}
	}

}
