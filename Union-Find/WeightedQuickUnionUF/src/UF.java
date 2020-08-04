import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
	private int[] id;
	private int[] sz;
	private int count;
	public UF(int N)
	{
		id=new int[N];
		sz=new int[N];
		for(int i=0;i<N;i++)
			id[i]=i;
		for(int i=0;i<N;i++)
			sz[i]=1;
		count=N;
	}
	public int count()
	{
		return count;
	}
	public boolean connected(int p,int q)
	{
		return find(q)==find(p);
	}
	public int find(int p)
	{
		while(p!=id[p]) p=id[p];
		return p;
	}
	public void union(int p,int q)
	{
		int i=find(p);
		int j=find(q);
		if(i==j) return ;
		if(sz[i]>sz[j])
		{
			id[j]=i;
			sz[i]+=sz[j];
		}
		else
		{
			id[i]=j;
			sz[j]+=sz[i];
		}
		count--;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=StdIn.readInt();
		UF uf=new UF(N);
		while(!StdIn.isEmpty())
		{
			int p=StdIn.readInt();
			int q=StdIn.readInt();
			if(uf.connected(p, q)) continue;
			uf.union(p, q);
			StdOut.println(p+" "+q);
		}
		StdOut.println(uf.count()+"components");

	}

}
