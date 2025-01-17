import java.util.*;
class BOOK
{
    String title,author,publisher;
    double price;
    BOOK(String x, String y, String z,double p)
    {
        title=x;
        author=y;
        publisher=z;
        price=p;
    }
    public String toString()
    {
        return title+"    "+author+"   "+publisher+"   "+price;
    }
}

class BookCompare implements Comparator<BOOK>
{
    public int compare(BOOK b1, BOOK b2)
    {
        if(b1.price>b2.price)
        {
            return 1;
        }
        else if(b1.price==b2.price)
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }
} 
public class Main
{
	public static void main(String[] args) 
	{
	    BOOK ob1= new BOOK("T1","A1","P1",780);
	    BOOK ob2= new BOOK("T2","A2","P2",500);
	    BOOK ob3= new BOOK("oops with java","A3","P3",800);
	    BOOK ob4= new BOOK("T4","A1","P4",300);
	    BOOK ob5= new BOOK("oops with c++","A4","P5",200);
	    ArrayList <BOOK> Ar=new ArrayList<BOOK>();
	    Ar.add(ob1);
	    Ar.add(ob2);
	    Ar.add(ob3);
	    Ar.add(ob4);
	    Ar.add(ob5);
	    
	    System.out.println(".Book List .");
	    for(BOOK ob:Ar)
	    {
	        System.out.println(ob);
	    }
	    Collections.sort(Ar,new BookCompare());
	    System.out.println(".Book List after sorted price list.");
	    for(BOOK ob:Ar)
	    {
	        System.out.println(ob);
	    }
	    
	    
	    System.out.println("-Create a hashmap with unique book id-");
	    HashMap<Integer,BOOK> hm=new HashMap<Integer,BOOK>();
	    Integer i=101;
	    for(BOOK ob:Ar)
	    {
	        hm.put(i,ob);
	        i++;
	    }
	    for (Integer keyid : hm.keySet()) 
	    {
            System.out.print("keyId: " + keyid ) ;
            System.out.println( "  " + hm.get(keyid));
        }
        System.out.println("-Search given author and display-");
        Scanner read= new Scanner(System.in);
        System.out.println("Enter author name: ");
        String name=read.nextLine();
		for(BOOK ob:Ar)
		{
		    if(name.equals(ob.author))
		    {
		        System.out.println(ob);
		    }
		}
		System.out.println("-create new list <price more then user specified price>-");
		LinkedList<BOOK> temp = new LinkedList<BOOK>();
		//Scanner read= new Scanner(System.in);
        System.out.println("Enter book price: ");
        double rate=read.nextDouble();
		for(BOOK ob:Ar)
	    {
	        if(ob.price>rate)
	        {
	            temp.add(ob);
	            System.out.println(ob);
	            
	        }
	    }
	    System.out.println("--------------search publisher and update-------");
		System.out.println("Enter book publisher name: ");
		Scanner rd=new Scanner(System.in);
        String pname=rd.nextLine();
		for(BOOK ob:Ar)
	    {   
	        
	        if(pname.equals(ob.publisher))
		    {
		        System.out.println(ob);
		    }
	    } 
	    System.out.println("-all the books that match either the whole or a part of the book title-");
	    
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter intested area");
	    String y=sc.nextLine();
	    int flag=0;
	    for(BOOK ob:Ar)
	    {   
	        if(ob.title.contains(y))
            {   flag=1;
                
                System.out.println(ob);
             }
	        
	    }
	    if(flag==0)
	    {
	       System.out.println("title not matches "); 
	    }
	    System.out.println("-search title  and update publisher name-");
		System.out.println("Enter book title name: ");
		Scanner rd1=new Scanner(System.in);
        String tname=rd1.nextLine();
		for(BOOK ob:Ar)
	    {   
	        
	        if(tname.equals(ob.title))
		    {
		        System.out.println(ob);
		        System.out.println("enter new publisher name");
		        String pname1=rd1.nextLine();
		        ob.publisher=pname1;
		        System.out.println(ob);
		    }
	    } 
	    
		
	}
}
