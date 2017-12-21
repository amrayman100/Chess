
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
        value=320;
        evaluate=new int[][]{{-50,-40,-30,-30,-30,-30,-40,-50},
        {-40,-20,  0,  0,  0,  0,-20,-40},
{-30,  0, 10, 15, 15, 10,  0,-30},
{-30,  5, 15, 20, 20, 15,  5,-30},
{-30,  0, 15, 20, 20, 15,  0,-30},
{-30,  5, 10, 15, 15, 10,  5,-30},
{-40,-20,  0,  5,  5,  0,-20,-40},
{-50,-40,-30,-30,-30,-30,-40,-50,}};
    }

    public Knight() {
                rep='h';
value=320;
evaluate=new int[][]{{-50,-40,-30,-30,-30,-30,-40,-50},
        {-40,-20,  0,  0,  0,  0,-20,-40},
{-30,  0, 10, 15, 15, 10,  0,-30},
{-30,  5, 15, 20, 20, 15,  5,-30},
{-30,  0, 15, 20, 20, 15,  0,-30},
{-30,  5, 10, 15, 15, 10,  5,-30},
{-40,-20,  0,  5,  5,  0,-20,-40},
{-50,-40,-30,-30,-30,-30,-40,-50,}};
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
        posmoves.clear();
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
    
    

