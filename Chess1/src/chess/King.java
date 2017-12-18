/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;


public class King implements piece {

    @Override
    public void move(point newPosition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canMove(point position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void generate() {
         point a = new point(pos.x,pos.y-1);
     
     if(canMove(a)){
         posmoves.add(a);
     }
     
         point b = new point(pos.x,pos.y+1);
     
     if(canMove(b)){
         posmoves.add(b);
     }
     
        point c= new point(pos.x+1,pos.y);
     
     if(canMove(c)){
         posmoves.add(c);
     }
     
        point d= new point(pos.x-1,pos.y);
     
     if(canMove(d)){
         posmoves.add(d);
     }
    }
    
}
