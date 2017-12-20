/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.util.ArrayList;

/**
 *
 * @author Amr Ayman
 */
public class Pawn extends piece {

    public Pawn(board b,boolean comp) {
        super(b);
        rep='p';
        this.comp=comp;
    }

    public Pawn() {
        rep='p';
    }
   

     @Override
    public void generate(){
        point p;
        if(comp) p = new point(pos.r+1,pos.c); 
        else p=new point(pos.r-1,pos.c);
        
     if(canMove(p)){
         posmoves.add(p);
     }
     point p1 = new point(pos.r+1,pos.c-1);
     point p2 = new point(pos.r+1,pos.c+1);
     if(comp&&game.pcontain(p1)){
         posmoves.add(p1);
        
     }
     if(comp&&game.pcontain(p2)){
          posmoves.add(p2);
     }
     
      point p3 = new point(pos.r-1,pos.c-1);
     point p4 = new point(pos.r-1,pos.c+1);
     if(!comp&&game.ccontain(p3)){
         posmoves.add(p3);
        
     }
     if(!comp&&game.ccontain(p4)){
          posmoves.add(p4);
     }
     
    }

    @Override
    public void move(point newPosition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public piece clone() {
        Pawn p=new Pawn();
         point p1=new point(pos.c,pos.r);
        p.pos=p1;
        p.comp=this.comp;
        p.game=this.game.clone();
        ArrayList<point> posmoves1=new ArrayList();
        for(point p2:posmoves)posmoves1.add(p2);
        p.posmoves=posmoves1;
        this.rep=p.rep; 
        return p;
    }

}
