/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

/**
 *
 * @author Omi
 */
import java.io.*;
public class fibo {//generation of nodes
    public int cost;      
    public int u,v;
    public fibo left;     

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getU() {
        return u;
    }

    public void setU(int u) {
        this.u = u;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public fibo getLeft() {
        return left;
    }

    public void setLeft(fibo left) {
        this.left = left;
    }

    public fibo getRight() {
        return right;
    }

    public void setRight(fibo right) {
        this.right = right;
    }

    public fibo getParent() {
        return parent;
    }

    public void setParent(fibo parent) {
        this.parent = parent;
    }

    public fibo getChild() {
        return child;
    }

    public void setChild(fibo child) {
        this.child = child;
    }

    public boolean isChildcut() {
        return childcut;
    }

    public void setChildcut(boolean childcut) {
        this.childcut = childcut;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
    public fibo right;  
    public fibo parent;
    public fibo child;
    public boolean childcut; 
    public int degree;
    fibo()
    {}
    public fibo (int item,int a,int b)
    {
        
        cost=item;
        u=a;
        v=b;
        right=null;
        left=null;
        parent=null;
        childcut=false;
        degree=0;
        
    }

    
    public void setLeft()
    {
        
    }       
  
    

}
