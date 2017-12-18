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
public class Pawn implements piece {
     @Override
    public void generate(){
  

     point p = new point(pos.x,pos.y-1);
     
     if(canMove(p)){
         posmoves.add(p);
     }
     
    }

    @Override
    public void move(point newPosition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canMove(point position) {
          if(position.x<8&&position.x>-1&&position.y>-1&&position.x<8)return false;
            return false;
    }
    
    
}
