package utility.preparation.graph.Bfs;
/*
 * 1000 from Division 1 in SRM 156
 */

/*Given a board consisting of empty space, walls, and the starting positions of two players A and 
 *B, determine the minimum number of turns it will take for players A and B to switch positions 
 *on the board.During a turn, one or both players may take a step. A step is defined
 *as a unit movement up, down, left, right, or in any of the four diagonals.
 *Players may not step into walls or off the board. Players may never share 
 *the same square at the end of a turn. Players may not cross paths during a 
 *turn. Crossing paths occurs when players A and B switch positions in a single
 * turn. For example, assume player A is in the upper left corner of the board
 * , and player B is in the square immediately to his right. Player A may not
 *  move right while player B moves left, since they would be passing each 
 *  other. Player A can, however, move right if player B moves in any other
 *   direction.You will be given a String[] board, representing the game board. 
 *   board will contain exactly one 'A' and exactly one 'B'; each other character will be either '.' (empty space), or 'X' (a wall). Your method should return the minimum number of turns necessary for players A and B to switch positions, or -1 if this is impossible.
*/
import java.util.*;
class state{
	int p1x,p1y,p2x,p2y;
	int steps;
	public state(int p1x, int p1y, int p2x, int p2y,int steps) {
		super();
		this.p1x = p1x;
		this.p1y = p1y;
		this.p2x = p2x;
		this.p2y = p2y;
		this.steps =steps;
	}
	
	public boolean change(state ft){
		
		return (((this.p1x==ft.p2x)&&(this.p1y==ft.p2y))&&((this.p2x==ft.p1x)&&(this.p2y==ft.p1y)));
	}
}
public class PathFinding {
	
	boolean[][][][] visited;
	String [] board; 
	state start;
	
	
	public boolean valid(state st){
		return ((st.p1x<0 ||  st.p1y<0 || st.p2x<0 || st.p2y<0 ||
				st.p1x>=board[0].length() ||  st.p1y>=board[0].length() || st.p2x>=board[0].length() || st.p2y>=board[0].length()
				|| board[st.p1x].charAt(st.p1y)=='X' ||board[st.p2x].charAt(st.p2y)=='X') ||((st.p1x==st.p2x)&&(st.p1y==st.p2y)));
	}
	void init(String[] board){
		
		for(int i=0;i<board.length;i++)
			this.board[i]=board[i];
		boolean fa=false,fb=false;
		int p1x=0,p1y=0,p2x=0,p2y=0;
		for(int i=0;i<board.length;i++)
		{
			if(fa && fb)
				break;
			int loc=board[i].indexOf('A');
			if(!fa && loc!=-1)
			{	p1x=i;
			    p1y=loc;
			    fa=true;
			}
			loc=board[i].indexOf('B');
			if(!fb && loc!=-1)
			{	p2x=i;
			    p2y=loc;
			    fb=true;
			}
		}
		start=new state(p1x, p1y, p2x, p2y, 0);
	}
	public int minTurns(String[] board)
	{
		init(board);
		List<state> que=new LinkedList<state>();
		que.add(start);
		while(que.size()!=0){
			state ft=que.remove(0);
			
			if(valid(ft))
				continue;
			if(visited[ft.p1x][ft.p1y][ft.p2x][ft.p2y])
				continue;
			visited[ft.p1x][ft.p1y][ft.p2x][ft.p2y]=true;
			if(start.change(ft))
				return ft.steps;
			for(int p1dx=-1;p1dx<=1;p1dx++){
				for(int p1dy=-1;p1dy<=1;p1dy++){
					for(int p2dx=-1;p2dx<=1;p2dx++){
						for(int p2dy=-1;p2dy<=1;p2dy++){
							
						   //check cross condition
						  if((ft.p1x==(ft.p2x+p2dx))&&(ft.p1y==(ft.p2y+p2dy))&&((ft.p2x==(ft.p1x+p1dx))&&(ft.p2y==(ft.p1y+p1dy))))
							  continue;
						  que.add(new state(ft.p1x+p1dx,ft.p1y+p1dy,ft.p2x+p2dx,ft.p2y+p2dy,ft.steps+1));
						}
				      }
			        }
		         }
		}
		return -1;
	}

}
