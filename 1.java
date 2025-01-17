import java.util.*;
class DataBaseCallers
{
    public static HashMap<Long,String> contacts=new HashMap<Long,String>();
    static void createEntry()
    {
        contacts.put(new Long("9900726035"),"Ronaldo");
        contacts.put(new Long("9741278570"),"Messi");
        contacts.put(new Long("7255554444"),"Deepika");
        contacts.put(new Long("9700001111"),"Kaka");
    }
    static void display()
    {
        System.out.println("*DataBaseCallers*");
        System.out.println(contacts);
        
    }
}

class MissedCallDetails
{
    Calendar cal;
    Long telno;
    String name;
    MissedCallDetails(Calendar x,Long y,String z)
    {
        cal=x;
        telno=y;
        name=z;
    }
    void display()
    {
        System.out.println("Current time ="+cal.getTime());
        System.out.println("Telephone Number="+telno);
        System.out.println("Name is="+name);
    }
}

public class Main
{
    static LinkedList<MissedCallDetails> amiss=new LinkedList<MissedCallDetails>();
	public static void main(String[] args) 
	{
	    //MissedCallDetails ob=new MissedCallDetails(Calendar.getInstance(),new Long("9741278570"),"Ronaldo");
	    //ob.display();
	    DataBaseCallers.createEntry();
	    DataBaseCallers.display();
	     
	    while(true)
	    {   
	        Scanner read=new Scanner(System.in);
	        System.out.println("Enter ur a Choice");
	        System.out.println("1: add miss call \n2: Delete based on number \n3: display \n4: exit");
	        int ch=read.nextInt();
	        switch(ch)
	        {
	            case 1:
	                    System.out.println("Enter the missed call telephone number details");
	                    Calendar cal=Calendar.getInstance();
	                    System.out.println("Enter telephone number=");
	                    Long telnox=read.nextLong();
	                    String name;
	                    if(DataBaseCallers.contacts.containsKey(telnox))
	                    {
	                        name=DataBaseCallers.contacts.get(telnox);
	                    }
	                    else
	                    {
	                        name="Private caller";
	                    }
	                    //System.out.println("Enter caller name=");
	                    //String name=read.next();
	                    MissedCallDetails ob=new MissedCallDetails(cal,telnox,name);
	                    if(amiss.size()==4)
	                    {
	                        amiss.removeLast();
	                    }
	                    amiss.addFirst(ob);
	                    System.out.println("*MissedCallDetails*");
	                    Iterator<MissedCallDetails> it = amiss.iterator();
                        while(it.hasNext()) 
                        {
                                MissedCallDetails i = it.next();
                                System.out.println("-------------");
                                i.display();
                        }
                        break;
                case 2: 
                        System.out.println("Enter number Delete in MissedCallDetails");
                        Long phonenum=read.nextLong();
                        Iterator <MissedCallDetails> it2= amiss.iterator();
                        boolean flag=false;
                        while(it2.hasNext())
                        {
                              MissedCallDetails ob2=it2.next();
                              if(ob2.telno==phonenum)
                              {
                                  flag=true;
                                  amiss.remove(ob2);
                                  break;
                              }
                        }
                        if(flag==true)
                        {
                            System.out.println("phone number deleted");
                        }
                        else
                        {
                            System.out.println("phone number not exists list");
                        }
                        break;
                    
                    
                case 3:
                        System.out.println("...MissedCallDetails...");
                        Iterator<MissedCallDetails> it1 = amiss.iterator();
                        while(it1.hasNext()) 
                        {
                                MissedCallDetails i = it1.next();
                                System.out.println("------");
                                i.display();
                        }
                        break;
                
                default:
                            return;
      
    
	        }
	    }
		
	} 
}
