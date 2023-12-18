package assingment;

import java.util.Arrays;
import java.util.StringJoiner;

public class student implements Comparable<student>{
	private String name;
	private final int id;
	private static int count;
	private static student all[];
	public student(String name, int id ) {
		if (name == null||name.isBlank()|| id < 0) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.id = id;
		if(all == null ) {
			all = new student[2];
		}
		if(all.length == count){
			all = Arrays.copyOf(all, all.length*2);
		}
		
	
		
		all[count++] = this;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public static student remove(int id){
		for (int i = 0; i < count; i++) {
			if (all[i].id == id) {
				var spa = all[i];
				all[i]=all[--count];
				all[count]=null;
				Arrays.sort(all,0,count);
			}
		}
		return null;
		
	}
	public static String listall(){
		var sj = new StringJoiner(";");
		for (int i = 0; i < count; i++) {
			sj.add(all[i].toString());
		}
		return sj.toString();
		
	}
	
	@Override
	public String toString() {
		return "["+ name + " "+ id + "]";
	}
	@Override
	public int compareTo(student o) {
		
		return this.id - o.id;
	}
	

}
