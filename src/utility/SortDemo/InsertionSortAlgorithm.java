class InsertionSortAlgorithm extends SortAlgorithm {
    void sort(int a[]) throws Exception {
	for (int j = 1;j<a.length;j++ ) {
	     int key=a[j];
		 int i=j-1;
		
		 while(i>=0 && a[i]>key)
		 {
		if (stopRequested) {
		    return;
		}
		a[i+1]=a[i];
		i=i-1;
		 pause(j,i);
	    }
		
	    a[i+1]=key;
		// pause(i,j);
	}
    }
}