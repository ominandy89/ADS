/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Omi
 */
public class mst {  //class to implement all the MST functionalities

    /**
     *
     * @param args
     * @throws IOexception
     */
    int e, v, u1, v1, w = 0;
    int i, j;
    int[][] ar = {{0, 3, 0, 10}, {3, 0, 3, 2}, {0, 3, 0, 4}, {10, 2, 4, 0}};
    int mincost = 0;
    
    ArraylistNode[] AL;
    public static String f;
    ArrayList<edges> er = new ArrayList<edges>();
    //String path="C:\\Users\\Omi\\Documents\\NetBeansProjects\\ADS_omi\\";
   String path=System.getProperty("user.dir")+"/";

    public static void main(String args[]) throws IOexception, IOException {
        //System.out.println(System.getProperty("user.dir"));
        mst m1 = new mst();
        if (args.length > 0 && args[0].equals("r")) { // taking inputs using command line
            int number = Integer.parseInt(args[1]);
            int dens = Integer.parseInt(args[2]);
            m1.random(number, dens);
            m1.primusingfibo();
            m1.prim();
        }
        if (args.length > 0 && args[0].equals("s")) {

            f = args[1];
            m1.readFile(f);
            m1.prim();
        }
        if (args.length > 0 && args[0].equals("f")) {

            f = args[1];
            m1.readFile(f);
            m1.primusingfibo();
        }

    }

    public void random(int n, int d) {//random number generator
        int density = d;

        int maxedge = (int) (((double) (n * (n - 1)) / 2) * ((double) density / 100));

        AL = new ArraylistNode[n];
        v = n;
        Random rand = new Random();
        for (int j = 0; j < n - 1; j++) {
            int pick = rand.nextInt(1000) + 1;

            addToAL(j, (j + 1), pick);
            addToAL(j + 1, j, pick);
        }
        int rem = maxedge - (n - 1);
        int j = 0;
        while (j < rem) {
            int pick1 = rand.nextInt(n);
            int pick2 = rand.nextInt(n);
            if ((pick1 - pick2) > 1 || (pick2 - pick1) > 1) {
                int pick3 = rand.nextInt(1000) + 1;
                addToAL(pick1, pick2, pick3);
                addToAL(pick2, pick1, pick3);
                j++;

            }

        }

    }

     public void readFile(String f)  {

       // populating the graph using input from file
         
         try {
             BufferedReader reader = new BufferedReader(new FileReader(path + f + ".txt"));
             String line = null;
             line = reader.readLine();
             String[] parts = line.split("\\s");
             v = Integer.valueOf(parts[0]);
             e = Integer.valueOf(parts[1]);
             AL = new ArraylistNode[v];
             
             while ((line = reader.readLine()) != null) {
                 
                 parts = line.split("\\s");
                 addToAL((Integer.valueOf(parts[0])), (Integer.valueOf(parts[1])), (Integer.valueOf(parts[2])));
                 addToAL((Integer.valueOf(parts[1])), (Integer.valueOf(parts[0])), (Integer.valueOf(parts[2])));
                 
             }
         } catch (Exception e) {
             System.out.println(e.getMessage());
         } 
    }


    public void addToAL(int u2, int v2, int cost) {//function to populate adjacency list using array list
        ArraylistNode node = new ArraylistNode();
        node.setCost(cost);

        node.setU(u2);
        node.setV(v2);
        if (AL[u2] == null) {
            AL[u2] = node;

        } else {
            node.setNext(AL[u2]);
            AL[u2] = node;

        }

    }

    public ArraylistNode getStart(int u) {
        return AL[u];
    }

    public void primusingfibo() {// generating MST using prim's algorithm using fibonacchi heap scheme

        long start = 0;
        er.clear();
        start = System.currentTimeMillis();
        ArrayList<Integer> visited = new ArrayList<Integer>();
        mincost = 0;
        int temp1 = 0, temp2 = 0, min, pos = 0, t = 0;
        visited.add(0);
        oper heap = new oper();
        fibo node;
        ArraylistNode fibosnode;
        edges err = null;
        ArraylistNode node1 = AL[0];
        while (node1 != null) {

            heap.insert(node1.getCost(), node1.getU(), node1.getV());
            node1 = node1.getNext();
        }
        boolean flag = false;

        for (; visited.size() < v;) {

            flag = false;
            while (true) {

                node = heap.removeMin();

                if (!visited.contains(node.getV())) {

                    min = node.getCost();
                    flag = true;
                    err = new edges();

                    err.setUfinal(node.getU());
                    err.setVfinal(node.getV());

                    ArraylistNode tempnode = AL[node.getV()];
                    while (tempnode != null) {
                        if (!visited.contains(tempnode.getV()) && tempnode.getCost() > 0) {

                            heap.insert(tempnode.getCost(), node.getV(), tempnode.getV());
                        }
                        tempnode = tempnode.getNext();
                    }

                    break;
                }

            }
            if (!flag) {
                break;
            }
            mincost += min;
            visited.add(node.getV());
            er.add(err);

        }
        long stop = System.currentTimeMillis();
        long time = stop - start;
        System.out.println("*********************************");
        System.out.println("completion time" + time);
        System.out.println("min cost is using fibo" + mincost);
        for (int i = 0; i < er.size(); i++) {
            System.out.println(er.get(i).getUfinal() + " " + er.get(i).getVfinal());
        }
        System.out.println("*********************************");
    }

    public void prim() {// calculating MST using prim's algo implemented using simple scheme
        long start = 0;
        er.clear();

        start = System.currentTimeMillis();
        ArrayList<Integer> visited = new ArrayList<Integer>();

        mincost = 0;
        int temp1 = 0, temp2 = 0, min = 99999, pos = 0, t = 0;
        visited.add(0);
        edges err = null;

        for (; visited.size() < v;) {
            min = 9999;
            ArraylistNode node;
            for (i = 0; i < visited.size(); i++) {
                node = AL[visited.get(i)];

                while (node != null) {

                    if (!visited.contains(node.getV())) {

                        if (min > node.getCost()) {

                            min = node.getCost();
                            temp1 = node.getU();
                            temp2 = node.getV();

                            err = new edges();

                            err.setUfinal(temp1);
                            err.setVfinal(temp2);

                        }

                    }
                    node = node.getNext();
                }

            }

            mincost += min;
            visited.add(temp2);
            er.add(err);

        }
	long stop = System.currentTimeMillis();
        long time = stop - start;
        System.out.println("*********************************");
        System.out.println("min cost is using simple" + mincost);
        
        
        System.out.println("completion time" + time);
        for (int i = 0; i < er.size(); i++) {
            System.out.println(er.get(i).getUfinal() + " " + er.get(i).getVfinal());
        }
        System.out.println("*********************************");
    }

}
