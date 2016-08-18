package Day6Comparable;

import java.util.*;
class itmap
{
public static void main(String a[])
{
Map m=new TreeMap();
m.put(1,"java");
m.put(2,"jsp");
m.put(3,"jini");
//Here only values can be displayed but not the keys so no the best usage
Collection c=m.values();
Iterator obj=c.iterator();
while(obj.hasNext())
{
System.out.println(obj.next());
}
//The below displays it  with keys and values
Set s=m.entrySet();
Iterator it=s.iterator();
while(it.hasNext())
{
Map.Entry me=(Map.Entry)it.next();
System.out.println(me.getKey()+"     "+me.getValue());
}


}
}