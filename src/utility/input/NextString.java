package utility.input;



public class NextString implements NextInput<String>{
	public String nextT(){
		return in.next(); 
	}
}