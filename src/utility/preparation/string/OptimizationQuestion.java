package utility.preparation.string;

import java.util.Vector;

/*
 *   	Q3. How could this method be optimized?
 *      
 *      Answer : We Can Use StringBuilder to optimize the appending cast .
 *      
 *      Vector is thread safe (So Lock and unlock cost is involved) .
 *      So we can avoid this using Arraylist but it depends on requirement
 *      and other module . 
 *      Method signature is part of class design .
 *      So my answer is on the assumption that only needs to modify the statements inside the
 *      method . 
 *              We Can Use StringBuilder to optimize the appending cast . 
 *              (But Java compiler  is smart enough to optimize this kind of optimization)
 *        
 *      
 *      
 * 
 * 
 */

class OptimizationQuestion {

	public String generateHTMLTable(Vector list) {

		//String ret = new String("<html><body><table>");
  //Optimization part 
		StringBuilder ret = new StringBuilder(1024); 
		for (int c = 0; c < list.size(); ++c) {
            // Replace with Append method
			ret.append("<tr><td>" + list.elementAt(c) + "</td></tr>");

		}

		ret.append("</table></body></html>");

		return ret.toString();

	}



}
