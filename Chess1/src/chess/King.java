/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.util.ArrayList;


public class King extends piece {

    public King(board b,boolean comp) {
        super(b);
        rep='k';
        this.comp=comp;
    }

    public King() {
        super();
        rep='k';
    }
    @Override
    public void move(point newPosition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void generate() {
        posmoves.clear();
        int arr[]={0,1,-1};
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){
                if(canMove(new point(pos.r+arr[i],pos.c+arr[j])))posmoves.add(new point(pos.r+arr[i],pos.c+arr[j]));
            }
    }

    @Override
    public piece clone() {
        King p=new King();
        point p1=new point(pos.r,pos.c);
        p.pos=p1;
        p.comp=this.comp;
        p.game=this.game.clone();
        ArrayList<point> posmoves1=new ArrayList();
        posmoves.forEach((p2) -> {
            posmoves1.add(p2);
        });
        p.posmoves=posmoves1;
        this.rep=p.rep; 
        return p;
    }
    
}
