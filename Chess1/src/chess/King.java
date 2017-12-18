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
        int arr[]={0,1,-1};
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){
                if(canMove(new point(pos.x+i,pos.y+j))&&(i|j)!=0)posmoves.add(new point(pos.x+i,pos.y+j));
            }
    }
    
}
