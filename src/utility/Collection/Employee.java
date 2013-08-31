class Employee
{
 public Employee(String name)
 {
  this.name=name;
  this.salary=0;
 }
 public String toString()
 {
  return "[ name= "+name+", salary= " + salary + "]";
 }
 
 private String name;
 private double salary;
}