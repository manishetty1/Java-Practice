import java.util.*;

class Employee
{
    int ID;
    int age;
    String name;
    String gender;

    public Employee(int ID, String name)
    {
        this.ID= ID;
        this.name = name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return ID == employee.ID &&
                name.equals(employee.name) ;

    }

}




public class MainApp
{
    static Map<Employee,String> employeeHashMap=null;

    public static void loadDB()
    {

        employeeHashMap.put(new Employee(1,"Manish"),"Intelligent");
        employeeHashMap.put(new Employee(2,"Kiran"),"poor");

    }

    public static void main(String[] args)
    {
        employeeHashMap=new HashMap<Employee, String>();
        loadDB();
        String value=employeeHashMap.get(new Employee(1, "Manish"));
        System.out.println(value);

    }




}
