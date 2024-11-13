package java_online1;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Scanner;

class  OrderedDictionary<k,v> {
	    public static void main(String[] args) {
	    	LinkedHashMap<Integer, Integer> map
            = new LinkedHashMap<Integer, Integer>();
	    	int num, k, v;
	        System.out.println("enter the range of numbers: ");
	        Scanner input=new Scanner(System.in);
	        num=input.nextInt(); 
	        for (int i = 0; i < num; i++) {
	           
	            k = i + 1;// Taking inputs from user.
	            v = k * 10;    
	            map.put(k, v); // Add mappings using put method.
	            System.out.println("Key-Value pairs: "
                        + map.entrySet());
	        }
	  }
}