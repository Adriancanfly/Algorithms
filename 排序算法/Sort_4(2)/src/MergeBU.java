import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MergeBU {

	static Comparable[] aux;
	public static void sort(Comparable[] a)
	{				
	    aux=new Comparable[a.length];
		for(int sz=1;sz<a.length;sz+=sz)
		{
			for(int lo=0;lo<a.length;lo+=2*sz)
				merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,a.length-1));
		}
	}
	
	
	public static void merge(Comparable[] a, int lo,int mid,int hi)
	{
		int i=lo,j=mid+1;
		StdOut.printf("lo: %d, mid: %d, hi: %d\n", lo,mid,hi);
		for(int k=lo;k<=hi;k++)
			aux[k]=a[k];
		for(int k=lo;k<=hi;k++)
		{
			StdOut.printf("k: %d, i: %d, j: %d\n",k,i,j);
			if(less(a[mid],a[mid+1])) break;
			else if(i>mid) a[k]=aux[j++];
			else if(j>hi) a[k]=aux[i++];
			else if(less(aux[j],aux[i])) a[k]=aux[j++];
			else a[k]=aux[i++];}
	}
	
	public static void exch(Comparable[] a,int i,int j)
	{
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	private static boolean less(Comparable v,Comparable w)
	{
		return v.compareTo(w)<0;
	}
	private static void show(Comparable[] a)
	{
		for(int i=0;i<a.length;i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a)
	{
		for(int i=1;i<a.length;i++)
			if(less(a[i],a[i-1])) return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] a=StdIn.readAllStrings();
		sort(a);
		//assert isSorted(a);
		show(a);
		}

}
