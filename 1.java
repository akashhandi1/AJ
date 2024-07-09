import java.util.*;
public class Caller {
	String name;
	Float telNo;
	Calendar d;
	Caller(String temp, Float t,Calendar p)
	{
		if(temp.equals(""))
			name="Private Number";
		else
			name=temp;
		telNo=t;
		d=p;
		
	}
	public void display()
	{
		System.out.println("Name:"+name+"TelNo:"+telNo+"Date:"+d.getTime());
	}
}

import java.util.*;
public class DateCompare implements Comparator<Caller>{
	public int compare(Caller x,Caller y)
	{
		return (int)x.d.compareTo(y.d);
	}

}

import java.util.*;
public class Main {
	public static void main(String[] args)
	{
		Calendar d=Calendar.getInstance();
		d.set(Calendar.HOUR, 10);
	    d.set(Calendar.MINUTE, 29);
	    d.set(Calendar.SECOND, 22);
	    Calendar e=Calendar.getInstance();
		e.set(Calendar.HOUR, 4);
	    e.set(Calendar.MINUTE, 28);
	    e.set(Calendar.SECOND, 20);
	    Calendar f=Calendar.getInstance();
		f.set(Calendar.HOUR, 11);
	    f.set(Calendar.MINUTE, 26);
	    f.set(Calendar.SECOND, 20);
	    
		Caller c1=new Caller("Ananya",9005674f,d);
		Caller c2=new Caller("Bavya",98765434f,e);
		Caller c3=new Caller("",9006739f,f);
		
		c1.display();
		c2.display();
		c3.display();
		ArrayList<Caller> list=new ArrayList<Caller>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		System.out.println("Sorting in new list of callers");
		ArrayList<Caller> sort_list=new ArrayList<Caller>(list);
		Collections.sort(sort_list,new DateCompare());
		for(Caller samp:sort_list)
			samp.display();
	}

}
