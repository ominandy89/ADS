/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Omi
 */
public class oper { //implentation of fibonacchi heap with all its functionalities

    fibo head;
    private fibo first;
    private fibo min;
    private fibo last;
    private fibo temp1;

    private int count = 0;

    fibo[] ar;

    public oper() {
        first = null;
        last = null;
    }

    oper(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(int item, int a, int b) {// inserting data into fibonacchi heap
        fibo newLink = new fibo(item, a, b);
        head = min;
        if (head == null) {
            head = newLink;
            head.setLeft(newLink);
            head.setRight(newLink);
        } else if (head.getLeft() == head && head.getRight() == head) {
            newLink.setLeft(head);
            newLink.setRight(head);
            head.setLeft(newLink);
            head.setRight(newLink);
            if (newLink.getCost() < head.getCost()) {
                head = newLink;
            }
        } else {
            newLink.setRight(head.getRight());
            head.setRight(newLink);
            newLink.setLeft(head);
            newLink.getRight().setLeft(newLink);
            if (newLink.getCost() < head.getCost()) {
                head = newLink;
            }
        }
        min = head;
        count++;

    }

    public fibo removeMin() {// emoving min from fibonacchi heap

        if (min == null) {

            return null;
        }
        count--;
        //return result
        temp1 = new fibo();
        temp1.cost = min.cost;

        temp1.u = min.u;
        temp1.v = min.v;

        //skip min
        min.left.right = min.right;
        min.right.left = min.left;

        //add child of the min into the main linked list
        fibo node = min;

        if (!(min.right == min && min.left == min)) {
            //System.out.println("inside if");
            min = min.right;
        } else {
            //System.out.println("inside else");
            min = null;
        }
//                node.child.left=node.left;
//                node.left=node.child.left;
//                node.child.right=node.right;
//                node.right=node.child.right;
//                node.degree--;
//                node.child=node.child.right;
        int degree = node.getDegree();

        if (degree > 0) {
            fibo firstchild = node.getChild();
            fibo nextchild = null;
            while (degree > 0) {

                nextchild = firstchild.getRight();
                this.addtosubtree(firstchild);
                degree--;
                firstchild = nextchild;
            }
        }

        if (count > 0 && min != null) {
            combine();
            updateMin();
        }
        return temp1;
    }

    public void addtosubtree(fibo newchild) {
        fibo node = newchild;
        node.parent = null;
        if (min == null) {

            min = node;
        }
        node.setLeft(min);
        node.setRight(min.getRight());
        min.setRight(node);
        node.getRight().setLeft(node);
    }

    public void combine() {// pairwise combining function after remove min in executed
        fibo tpar, tchild, childofparent;
        fibo temp = min.right;
        fibo last = min.left;
        boolean lastnoder = false;
        fibo nextnode;
        ar = new fibo[100];
        int i;

        while (true) {

            nextnode = temp.right;
            if (temp == last) {
                lastnoder = true;
            }
            i = temp.degree;
            if (ar[i] != null) {

                //decidding parent and child
                if (ar[i].cost < temp.cost) {
                    tpar = ar[i];
                    tchild = temp;
                } else {
                    tpar = temp;
                    tchild = ar[i];

                }

                tchild.left.right = tchild.right;
                tchild.right.left = tchild.left;

                if (tpar.degree > 0) {

                    //attach new child 
                    tchild.parent = tpar;
                    tpar.child.left.right = tchild;
                    tchild.left = tpar.child.left;
                    tchild.right = tpar.child;
                    tpar.child.left = tchild;
                    tpar.child = tchild;
                } else {

                    //attach first child
                    tpar.child = tchild;
                    tchild.parent = tpar;
                    tchild.left = tchild;
                    tchild.right = tchild;
                }

                min = tpar;
                tpar.degree++;
                int t = tpar.degree;
                ar[i] = null;

                if (ar[t] != null) {
                    reCombineNew(tpar);
                } else {
                    ar[t] = tpar;
                }
            } else {
                ar[i] = temp;
            }

            if (temp == last || lastnoder) {
                break;
            }
            temp = nextnode;
        }
    }

    public void reCombineNew(fibo tpar1) {
        fibo tpar, tchild;
        fibo tempnew = tpar1;
        int i = tempnew.degree;
        if (ar[i] != null) {

            //deciding parent and child
            if (ar[i].cost < tempnew.cost) {
                tpar = ar[i];
                tchild = tempnew;
            } else {
                tpar = tempnew;
                tchild = ar[i];

            }

            //removing child from main linked list                   
            tchild.left.right = tchild.right;
            tchild.right.left = tchild.left;

            if (tpar.degree > 0) {

                //attach new child 
                tchild.parent = tpar;
                tpar.child.left.right = tchild;
                tchild.left = tpar.child.left;
                tchild.right = tpar.child;
                tpar.child.left = tchild;
                tpar.child = tchild;
            } else {

                //attach first child
                tpar.child = tchild;
                tchild.parent = tpar;
                tchild.left = tchild;
                tchild.right = tchild;
            }

            min = tpar;
            tpar.degree++;

            int t = tpar.degree;

            ar[i] = null;

            if (ar[t] != null) {

                reCombineNew(tpar);
            } else {

                ar[t] = tpar;
                return;
            }
        }
    }

    public void updateMin() {// updating minimum after remove 

        fibo temp = min;
        fibo last = min.left;
        fibo nextnode;

        while (true) {
            nextnode = temp.right;
            if (min.cost > temp.cost) {
                min = temp;
            }

            if (temp == last) {
                break;
            }
            temp = nextnode;
        }

    }
}
