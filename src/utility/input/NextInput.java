package utility.input;



public interface NextInput<T>{
	InputReader in=InputReader.getInputReader();
	T nextT();
}