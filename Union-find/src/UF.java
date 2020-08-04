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
         return id[p];
     }

     public void union(int p, int q)     //������������������ǲ���ͨ�Ļ����������������ڵ���ͨ��������Ϊһ��
     {
         int pID = Find(p);
         int qID = Find(q);

         if (qID == pID) return;

         for (int i = 0; i < id.length; i++)   //Ҳ���ǽ�������ͨ�����е�һ���ı�ʶ���ı�Ϊ��һ���ģ����Ҫ���Ҹ���ͬ����
             if (id[i] == pID)                 //�е����д���,һ�ֱ����ⷨ
                 id[i] = qID;

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
