/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author ahmedsalah
 */
public class queen implements piece {

    @Override
    public void move(point newPosition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canMove(point position) {
if(position.x<8&&position.x>-1&&position.y>-1&&position.x<8)return true;
            return false;
    }

    @Override
    public void generate() {
            for(int i=0;i<8;i++)if(canMove(new point (pos.x,i)))posmoves.add(new point(pos.x,i));
            for(int i=0;i<8;i++)if(canMove(new point (i,pos.y)))posmoves.add(new point(i,pos.y));
            int arr[]={-1,1};
            for(int i=1;i<8;i++)
            for(int j=0;j<2;j++)
                for(int k=0;k<2;k++)
                    if(canMove(new point(pos.x+i*j,pos.y+i*k)))posmoves.add(new point(pos.x+i*j,pos.y+i*k));
    }
}
