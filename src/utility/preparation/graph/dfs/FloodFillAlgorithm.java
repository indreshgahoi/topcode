package utility.preparation.graph.dfs;


/* Questiom Implement MS Paint
 * 
 * http://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/
 * 
 * 
 */


public class FloodFillAlgorithm {
	static final int WIDTH = 256;
	static final int HEIGHT = 256 ;
	int screen[][] = new int[HEIGHT][WIDTH];
	int dx[] = {0,1,0,-1};
	int dy[] = {1,0,-1,1};
	public  void fill(int x , int y ,int oldColor, int newColor){
	  
		if(x < 0 || y < 0 || x >= HEIGHT || y >= WIDTH ) return ;
		if(screen[x][y] == newColor || screen[x][y] != oldColor) return ;
	    screen[x][y] = newColor ;
	    
	    for(int i = 0 ; i < dx.length ; ++i){
	    	int xx = x + dx[i] ;
	    	int yy = y + dy[i] ;
	    	fill(xx,yy,oldColor,newColor);
	    }
	
	}
	

}
