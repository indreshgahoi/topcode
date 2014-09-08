package utility.Collection;
import java.util.*;

public class MapTest
{
	public static void main(String [] str)
	{
		Map<String,Employee> staff=new HashMap<String,Employee>();
		staff.put("1",new Employee("indresh"));
		staff.put("2", new Employee("sanjay"));
		staff.put("3",new Employee("vivek"));
		System.out.println(staff);
		staff.remove("3");
		staff.put("3",new Employee("Ankur"));
		System.out.println(staff.get("2"));
		for(Map.Entry<String,Employee> entry : staff.entrySet())
		{
			String key=entry.getKey();
			Employee value=entry.getValue();
			System.out.println("key= "+key+" value= "+value);
		}

	}

}