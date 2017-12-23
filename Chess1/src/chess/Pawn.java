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
        value=100;
        evaluate=new int[][]{{0,  0,  0,  0,  0,  0,  0,  0},{50, 50, 50, 50, 50, 50, 50, 50},{10, 10, 20, 30, 30, 20, 10, 10},{5,  5, 10, 25, 25, 10,  5,  5},{0,  0,  0, 20, 20,  0,  0,  0},{5, -5,-10,  0,  0,-10, -5,  5},{5, 10, 10,-20,-20, 10, 10,  5},{0,  0,  0,  0,  0,  0,  0,  0}};
    }

    public Pawn() {
        rep='p';
        value=100;
        evaluate=new int[][]{{0,  0,  0,  0,  0,  0,  0,  0},{50, 50, 50, 50, 50, 50, 50, 50},{10, 10, 20, 30, 30, 20, 10, 10},{5,  5, 10, 25, 25, 10,  5,  5},{0,  0,  0, 20, 20,  0,  0,  0},{5, -5,-10,  0,  0,-10, -5,  5},{5, 10, 10,-20,-20, 10, 10,  5},{0,  0,  0,  0,  0,  0,  0,  0}};
    }

    @Override
    public boolean canMove(point position) {
        boolean notjump = true;
        boolean wrongkill = true;
        if(pos.r==6&&!comp&&game.pcontain(new point(pos.r-1,pos.c))&&position.r==pos.r-2&&position.c==pos.c){
            notjump = false;
        }
        else if(pos.r==6&&!comp&&game.ccontain(new point(pos.r-1,pos.c))&&position.r==pos.r-2&&position.c==pos.c){
            notjump = false;
        }
          if(pos.r==1&&comp&&game.ccontain(new point(pos.r+1,pos.c))&&position.r==pos.r+2&&position.c==pos.c){
            notjump = false;
        }
        else if(pos.r==1&&!comp&&game.pcontain(new point(pos.r+1,pos.c))&&position.r==pos.r+2&&position.c==pos.c){
            notjump = false;
        }
          
          if(!comp&&game.ccontain(position)&&pos.r-1==position.r){
              wrongkill = false;
          }
          
          else if(comp&&game.pcontain(position)&&pos.r+1==position.r){
               wrongkill = false;
          }
    
    

        
        
        return super.canMove(position)&&!game.pcontain(position)&&!game.ccontain(position)&&notjump&&wrongkill; //To change body of generated methods, choose Tools | Templates.
    }
   
     @Override
    public void generate(){
        posmoves.clear();
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
     
      if(pos.r==1&&comp){
          p = new point(pos.r+2,pos.c);
          if(canMove(p)){
         posmoves.add(p);
            }
      }
      else if(pos.r==6&&!comp){
            p = new point(pos.r-2,pos.c);
            if(canMove(p)){
         posmoves.add(p);
         }
      }
     
    }

    @Override
    public piece clone() {
        Pawn p=new Pawn();
         point p1=new point(pos.r,pos.c);
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
