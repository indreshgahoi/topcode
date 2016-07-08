
package utility.SortDemo;

class HeapSortAlgorithm extends SortAlgorithm
{
 int heapSize;
 int largest;
public void heapSort(int a[]) throws Exception
{
 buildMaxHeap(a);
 for(int i=a.length-1;i>0;--i)
 {int temp=a[0];
   a[0]=a[i];
   a[i]=temp;
   heapSize=heapSize-1;
     // pause(i,2); 
if (stopRequested) {
		    return;
		}	 
   maxHeapIfy(a,0);
     }
}

public void buildMaxHeap(int a[])throws Exception
{
 heapSize=a.length-1;
for(int p=heapSize/2;p>=0;--p)
{
   maxHeapIfy(a,p);
}  }
public void maxHeapIfy(int a[],int d) throws Exception
{

  int l=left(d);
  int r=right(d);
  if(l<=heapSize &&(a[l]>a[d])){
     largest=l;}
	else {largest=d;}
	 if(r<=heapSize && a[r] > a[largest])
	 largest=r;
	 if(largest!=d)
	 {
	   int temp=a[largest];
	    a[largest]=a[d];
		a[d]=temp;
		pause(heapSize,largest);
		  maxHeapIfy(a,largest);
	 }
	}


public int left(int m) throws Exception
{
 return 2*m+1;
}
public int right(int n) throws Exception
{
 return 2*n+2;
}

 public void sort(int a[])  throws Exception
   {heapSort(a);
  }
}


 



