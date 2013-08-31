package utility.topcoder.srm566;

public class PenguinTiles {
	
	public int minMoves(String[] tiles)
	{
		int row=tiles.length;
		int col=tiles[0].length();
		int x=0,y=0;
		int steps=0;
	
		for (int i = 0; i<row ; i++) {
			for (int j = 0; j<col; j++) {
				if(tiles[i].charAt(j)=='.'){
					x=i;
					y=j;
					break;
				}
			}
		}
		if(x==(row-1) && (y==col-1))
			steps=0;
		else if((x==(row-1)) || (y==(col-1)))
			  steps=1;
		else steps=2;
		return steps;
	}
	

}
