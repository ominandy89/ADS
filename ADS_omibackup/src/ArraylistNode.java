/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Omi
 */
public class ArraylistNode { //implementation of adjacency list to store the vertices of the graph
 
    private int cost;
    private int u;
    private int v;
    private ArraylistNode next;

    /**
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * @return the u
     */
    public int getU() {
        return u;
    }

    /**
     * @param u the u to set
     */
    public void setU(int u) {
        this.u = u;
    }

    /**
     * @return the v
     */
    public int getV() {
        return v;
    }

    /**
     * @param v the v to set
     */
    public void setV(int v) {
        this.v = v;
    }

    /**
     * @return the next
     */
    public ArraylistNode getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(ArraylistNode next) {
        this.next = next;
    }
    
          
    
}


