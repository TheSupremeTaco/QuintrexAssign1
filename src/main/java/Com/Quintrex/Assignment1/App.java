package Com.Quintrex.Assignment1;
import java.util.*;
import java.io.IOException;
import java.lang.Math;
import java.nio.file.*;
import java.util.regex.*;

public class App 
{
    public static void main( String[] args )
    {
    	//Array used for illustrating each collection type
    	String[] addressArray = {"Java","JavaScript","C","C++","C#","Python"};
        printStatement("List Demo");
        listDemo(addressArray);
        System.out.print("\n");
        setDemo();
        System.out.println();
        mapDemo();
        System.out.println();
        IODemo();
        regExDemo();
        
    }
    
    static void printStatement(String inputString)
    {
    	System.out.println(inputString);
    }
    
    static void listDemo(String[] addressArray)
    {
    	ArrayList<String> addressList = new ArrayList<String>();
    	for (int i=0; i<addressArray.length; i++) addressList.add(addressArray[i]);
    	System.out.println(addressList);
    	
    	// Using methods from the ArrayList object
    	for (int i = 0; i < addressList.size();i++)
    	{
    		System.out.println("The " + i + " language in the ArrayList is:" + addressList.get(i));
    	}
    	// Unlike arrays, ArrayList objects can change sizes
    	addressList.add("Ruby");
    	System.out.println(addressList);
    }
    
    static void setDemo()
    {
    	HashSet<Integer> zipCode = new HashSet<Integer>();
    	for (int i =0; i<10;i++)
    	{
    		
    		int rand = (int)(Math.random()*100000);
    		zipCode.add(rand);
    		
    	}
    	System.out.println(zipCode);
    	// Demo case: no duplicates in set collections
    	Integer[] dupliZips = {11111,11111,11112};
    	for(int i = 0; i < dupliZips.length;i++)
    	{
    		zipCode.add(dupliZips[i]);
    	}
    	System.out.println(zipCode);
    }
    
    static void mapDemo()
    {
    	// Students Pass/Fail
    	Map<String, String> studentReport = new HashMap<String,String>();
    	String [] students = {"Tim","James","Jan","Tom","Larry"};
    	String tmpStr;
    	for(int i =0; i<students.length;i++)
    	{
    		if (Math.random() > 0.5) tmpStr = "pass";
    		else tmpStr = "fail";
    		studentReport.put(students[i], tmpStr);
    	}
    	for (Map.Entry<String, String> record: studentReport.entrySet())
    	{
    		System.out.print(record.getKey() + ":");
    		System.out.println(record.getValue());
    	}
    }
    
    static void IODemo()
    {
    	String TXT_FILE = "C:/Users/Tako/Desktop/txtFile.txt";
    	Path textFilePath = Paths.get(TXT_FILE);
    	try {
			Files.createFile(textFilePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String txtContent = "Testing file output";
    	try {
			Files.write(textFilePath, txtContent.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    static void regExDemo()
    {
    	ArrayList<String> dates = new ArrayList();
    	dates.add("1/1/11");
    	dates.add("01/017/11");
    	dates.add("01/01/2011");
    	dates.add("01//2011");
    	dates.add("1/11/2011");
    	dates.add("1/11/1");
    	dates.add("11/1/1661");
    	

    	String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
    	
    	Pattern pattern = Pattern.compile(regex);
    	 
    	for(String date : dates)
    	{
    	  Matcher matcher = pattern.matcher(date);
    	  System.out.println(date +" : "+ matcher.matches());
    	}
    }
    
}