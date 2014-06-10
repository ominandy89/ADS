/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Omi
 */
public class edges {//class to store visited edges in the MST generated
    
    private int ufinal;
    private int vfinal;

    /**
     * @return the ufinal
     */
    
    edges()
    {}
    public int getUfinal() {
        return ufinal;
    }

    /**
     * @param ufinal the ufinal to set
     */
    public void setUfinal(int ufinal) {
        this.ufinal = ufinal;
    }

    /**
     * @return the vfinal
     */
    public int getVfinal() {
        return vfinal;
    }

    /**
     * @param vfinal the vfinal to set
     */
    public void setVfinal(int vfinal) {
        this.vfinal = vfinal;
    }
    
}
