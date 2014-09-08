package utility.input;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/*
 *  Byte Streams :-Programs use byte streams to perform input and output of 8-bit bytes. All byte stream classes 
 *  		are descended from InputStream and OutputStream.

There are many byte stream classes. To demonstrate how byte streams work, we'll focus on the file I/O byte streams
, FileInputStream and FileOutputStream. 
Other kinds of byte streams are used in much the same way; they differ mainly in the way they are constructed
 *  	
 * 
 * 
 * 
 */

public class StreamExample {

	
	
	
	
	public static void main(String[] args) throws IOException {
		
		ByteStreamExample byteStream = new ByteStreamExample() ;
		CharacterStreamExample charStream = new CharacterStreamExample() ;
		CopyLines lines = new CopyLines();
			//byteStream.copyOfBytes();
			//charStream.copyOfCharacter() ;
			lines.copyLine();
		
		
	}
}


/*
 * All byte stream classes are descended from InputStream and OutputStream.
 * 
 */
class ByteStreamExample
{
	FileInputStream inputStream = null ;
	FileOutputStream outputStream = null ;
	public  void copyOfBytes() throws IOException
	{
		try
		{
		inputStream = new FileInputStream("source.txt");
		outputStream = new FileOutputStream("dest.txt");
		int c ;
		while((c=inputStream.read())!= -1)
		{
			outputStream.write(c);
		}
		}
		finally
		{
			if(inputStream != null)
				inputStream.close();
			if(outputStream != null)
				outputStream.close();
		}
	}
}


/*
 * 
 * All character stream classes are descended from Reader and Writer. 
 * 
 */
/*
 *  The most important difference is that CopyCharacters uses FileReader and FileWriter for input and output 
 *  in place of FileInputStream and FileOutputStream. Notice that both CopyBytes and CopyCharacters use an int 
 *  variable to read to and write from. However, in CopyCharacters, the int variable holds a character value 
 *  in its last 16 bits; in CopyBytes, the int variable holds a byte value in its last 8 bits.
 * 
 * 
 */
class CharacterStreamExample
{
	FileReader inputStream = null ;
	FileWriter outputStream = null ;
	
	
	public void copyOfCharacter() throws IOException
	{
		try
		{
			inputStream = new FileReader("source.txt");
			outputStream = new FileWriter("destChar.txt");
			int c ;
			while((c = inputStream.read()) != -1)
			{
				outputStream.write(c);
			}
		}
		finally
		{
			if(inputStream != null)
				inputStream.close();
			if(outputStream != null)
				outputStream.close();
		}
	}
}




class CopyLines
{
	BufferedReader in = null ;
	PrintWriter out = null ;
	public void copyLine() throws IOException
	{
		try
		{
		in = new BufferedReader(new FileReader("source.txt"));
		out = new PrintWriter(new FileWriter("destByLine.txt"));
		String line ;
		while( (line = in.readLine()) != null )
		{
			out.println(line);
		}
		}
		finally
		{
			if(in != null)
				in.close() ;
			if(out != null)
				out.close();
		}
	}
}