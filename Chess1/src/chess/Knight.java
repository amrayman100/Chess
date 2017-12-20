
package chess;

import java.util.ArrayList;

/**
 *
 * @author LoayHamdy
 */
public class Knight extends piece{

    public Knight(board b,boolean comp) {
        super(b);
        rep='h';
        this.comp=comp;
    }

    public Knight() {
                rep='h';

    }
   
    @Override
    public void move(point newPosition) {
    }

@Override
    public piece clone() {
        Knight p=new Knight();
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

    @Override
    public void generate() {
     int arr1[]={1,-1},arr2[]={-2,2};
        for(int i=0;i<2;i++)
            for(int j=0;j<2;j++)
            {
                point pos1=new point(pos.r+arr1[i],pos.c+arr2[j]),pos2=new point(pos.r+arr2[i],pos.c+arr1[j]);
                if(canMove(pos2))posmoves.add(pos2);
                if(canMove(pos1))posmoves.add(pos1);
            }
    } 
     
    }
    
    

