/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

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
    }

    @Override
    public void move(point newPosition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public piece clone() {
        Pawn p=new Pawn();
        p.pos=this.pos;
        p.comp=this.comp;
        p.game=this.game;
        this.posmoves=p.posmoves;
        this.rep=p.rep; 
        return p;
    }

}
