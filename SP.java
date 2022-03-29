import java.util.*;

public class SP {
    private static final Scanner scanner = new Scanner(System.in);
    private static Integer readInt() {
        return scanner.nextInt();
    }
    private static void gPath(int[][] d, int r, int c, List<Integer> rway)
    {
        if (d[r][c] == r) {
            return;
        }
        gPath(d, r, d[r][c], rway);
        rway.add(d[r][c]);
    }
    private static List sol(int[][] path)
    {
        int v = 0;
        int u =1;
        List<Integer> route = new ArrayList<>();
        if (u != v && path[v][u] != -1)
        {
            route.add(0);
            gPath(path, 0, 1, route);
            route.add(1);
        }
        return route;
    }
    public static List org(int[][] darry)
    {
        if (darry ==null || darry.length == 0) {
        }
        int size = darry.length;

        int[][] weight = new int[size][size];
        int[][] cp = new int[size][size];

        for (int r = 0; r < size; r++)
        {
            for (int c = 0; c < size; c++)
            {
                weight[r][c] = darry[r][c];
                if (r == c) {
                    cp[r][c] = 0;
                }
                else if (weight[r][c] != Integer.MAX_VALUE) {
                    cp[r][c] = r;
                }
                else {
                    cp[r][c] = -1;
                }
            }
        }

        for (int k = 0; k < size; k++)
        {
            for (int v = 0; v < size; v++)
            {
                for (int u = 0; u < size; u++)
                {
                    if (weight[v][k] != Integer.MAX_VALUE && weight[k][u] != Integer.MAX_VALUE && (weight[v][k] + weight[k][u] < weight[v][u])) {
                        weight[v][u] = weight[v][k] + weight[k][u];
                        cp[v][u] = cp[k][u];
                    }
                }
                if (weight[v][v] < 0)
                {
                    System.out.println("error");
                }
            }
        }
      return sol(cp);
    }
    public static void main(String[] args)
    {
        int I = Integer.MAX_VALUE;
int a = readInt();
        int[][] adjMatrix = new int[100][100];
        for(int b=0;b<100; b++){
            for(int p=0;p<100;p++){
                adjMatrix[b][p]=I;
            }
        }
        HashMap<Integer,Integer> h=new HashMap<>();
        h.put(47,0);
        h.put(79,1);
        int x=2;
        for(int i =0; i<a;i++){
          int b=readInt();
          int c=readInt();
          int d=readInt();

            if(!h.containsKey(b)) {
                h.put(b, x);
                x++;
            }
            if(h.containsKey(c)){
                adjMatrix[h.get(b)][h.get(c)]=d;
            }
            else{
                h.put(c,x);
                adjMatrix[h.get(b)][h.get(c)]=d;
                x++;
            }

        }
         List<Integer> lol;
       lol= org(adjMatrix);
        int count =0;
        for(int i=0;i<lol.size()-1;i++){
            int gg=lol.get(i);
            int gg1=lol.get(i+1);
            int j =adjMatrix[gg][gg1];
           count = count +j;
        }
        System.out.println(count);

    }
}
