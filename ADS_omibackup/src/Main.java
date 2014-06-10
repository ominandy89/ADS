

import java.io.*;
import java.util.ArrayList;

class adsproject {

  /*  int e, v, v1, v2, w = 0;
    int i, j;
    int[][] ar;
    int mincost=0;

    public void create() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of vertices");
        v = Integer.parseInt(in.readLine());
        System.out.println("Enter number of edges");
        e = Integer.parseInt(in.readLine());
        ar = new int[v][v];
        for (i = 0; i < v; i++) {
            for (j = 0; j < v; j++) {
                ar[i][j] =0;
            }
        }

        for (i = 0; i < e; i++) {
            System.out.println("enter edges and weight");
            v1 = Integer.parseInt(in.readLine());
            v2 = Integer.parseInt(in.readLine());
            w = Integer.parseInt(in.readLine());

            ar[v1][v2] = ar[v2][v1] = w;
        }
        for (i = 0; i < v; i++) {
            for (j = 0; j < v; j++) {
                System.out.print("   " + ar[i][j]);
            }
            System.out.println();
        }
    }

    public void prim() {

        ArrayList<Integer> visited = new ArrayList<Integer>();

        int temp1 = 0, temp2 = 0, min, pos = 0, t = 0;
        visited.add(0);

        for (int k = 0; k < v; k++) {
            min=9999;

            for (i = 0; i < visited.size(); i++) {
                for (j = 0; j < v; j++) {
                    if (visited.contains(j)) {
                        continue;
                    } else {
                        if (min > ar[visited.get(i)][j]) {
                            min = ar[visited.get(i)][j];
                            temp1 = visited.get(i);
                            temp2 = j;

                        }

                    }
                }


            //ar[temp1][temp2] = ar[temp2][temp1] = 1000;

            }
            if (min != 9999) {
                mincost += min;
            }
            

            visited.add(temp2);
             //min=9999;
        }
        System.out.println("min cost is "+mincost);
    }
    
    public void primusingfibo() {

        ArrayList<Integer> visited = new ArrayList<Integer>();
        mincost=0;
        int temp1 = 0, temp2 = 0, min, pos = 0, t = 0;
        visited.add(0);
        oper heap = new oper();
        fibo node;
        for (j = 0; j < v; j++)
        {
           if(ar[0][j]>0) 
               heap.insert(ar[0][j], 0, j);
        }
        boolean flag=false;
        for (int k = 0; k < v; k++) {
            
            while(true){
            node = heap.removeMin();
            if(!visited.contains(node.getV()))
            {
                min = node.getCost();
                
                for (j = 0; j < v; j++) {
                    if (visited.contains(j)&&ar[node.getV()][j]>0) {
                        heap.insert(ar[node.getV()][j],node.getV(), j);
                    }
                }
                break;
            }
            
            }
            mincost += min;
            visited.add(node.getCost());
             //min=9999;
        }
        System.out.println("min cost is "+mincost);
    }*/
}

/*public class Main {

    /**
     * @param args the command line arguments
     */
  /*  public static void main(String[] args) throws IOException {
        adsproject g = new adsproject();
        g.create();
        g.prim();

    }*/

