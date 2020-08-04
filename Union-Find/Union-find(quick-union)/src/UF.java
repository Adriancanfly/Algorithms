import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
public class UF {
	 private int[] id;
     private int count;

     public UF(int N)
     {
         count = N;
         id = new int[N];
         for (int i = 0; i < N; i++)
             id[i] = i;
     }

     public int Count()
     {
         return count;
     }

     public boolean Connected(int p, int q)
     {
         return Find(p) == Find(q);
     }

     public int Find(int p)
     {
         while(p!=id[p]) p=id[p];
         return p;
     }

     public void union(int p, int q)     //������������������ǲ���ͨ�Ļ����������������ڵ���ͨ��������Ϊһ��
     {
         int pRoot = Find(p);
         int qRoot = Find(q);

         if (qRoot == pRoot) return;

         id[pRoot]=qRoot;

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
			if(uf.Connected(p, q)) continue;
			uf.union(p, q);
			StdOut.println(p+" "+q);
		}
		StdOut.println(uf.Count()+"components");

	}

}
