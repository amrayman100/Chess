/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.util.ArrayList;

/**
 *
 * @author ahmedsalah
 */
public class queen extends piece {

    public queen(board b,boolean comp) {
        super(b);
        rep='q';
        this.comp=comp;
        value=900;
        evaluate =new int[][]{{-20,-10,-10, -5, -5,-10,-10,-20},
                                {-10,  0,  0,  0,  0,  0,  0,-10},
                                {-10,  0,  5,  5,  5,  5,  0,-10},
                                { -5,  0,  5,  5,  5,  5,  0, -5},
                                { 0,  0,  5,  5,  5,  5,  0, -5},
                                {-10,  5,  5,  5,  5,  5,  0,-10},
                                {-10,  0,  5,  0,  0,  0,  0,-10},
                                {-20,-10,-10, -5, -5,-10,-10,-20}};
    }

    public queen() {
                rep='q';
                value=900;
                        evaluate =new int[][]{{-20,-10,-10, -5, -5,-10,-10,-20},
                                {-10,  0,  0,  0,  0,  0,  0,-10},
                                {-10,  0,  5,  5,  5,  5,  0,-10},
                                { -5,  0,  5,  5,  5,  5,  0, -5},
                                { 0,  0,  5,  5,  5,  5,  0, -5},
                                {-10,  5,  5,  5,  5,  5,  0,-10},
                                {-10,  0,  5,  0,  0,  0,  0,-10},
                                {-20,-10,-10, -5, -5,-10,-10,-20}};
    }
   @Override
    public piece clone() {
        queen p=new queen();
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
        for(int i=1;i<8;i++){
                point next=new point (pos.r,pos.c-i);
                if(canMove(next))posmoves.add(next);
                            else break;
            if(comp&&game.pcontain(next))break;
            if(!comp&&game.ccontain(next))break;
            }
            for(int i=1;i<8;i++){
                point next=new point (pos.r,pos.c+i);
                if(canMove(next))posmoves.add(next);
                            else break;
            if(comp&&game.pcontain(next))break;
            if(!comp&&game.ccontain(next))break;
            }
            for(int i=1;i<8;i++){
                point next=new point (pos.r-i,pos.c);
                if(canMove(next))posmoves.add(next);
                            else break;
            if(comp&&game.pcontain(next))break;
            if(!comp&&game.ccontain(next))break;
            }
            for(int i=1;i<8;i++){
                point next=new point (pos.r+i,pos.c);
                if(canMove(next))posmoves.add(next);
                            else break;
            if(comp&&game.pcontain(next))break;
            if(!comp&&game.ccontain(next))break;
            }
            for (int i=1;i<8;i++){
            point next =new point(pos.r+i,pos.c+i);
            if(canMove(next))posmoves.add(next);
                        else break;
            if(comp&&game.pcontain(next))break;
            if(!comp&&game.ccontain(next))break;
        }
        for (int i=1;i<8;i++){
            point next =new point(pos.r+i,pos.c-i);
            if(canMove(next))posmoves.add(next);
            else break;

            if(comp&&game.pcontain(next))break;
            if(!comp&&game.ccontain(next))break;
        }
        for (int i=1;i<8;i++){
            point next =new point(pos.r-i,pos.c+i);
            if(canMove(next))posmoves.add(next);
                        else break;
            if(comp&&game.pcontain(next))break;
            if(!comp&&game.ccontain(next))break;
        }
        for (int i=1;i<8;i++){
            point next =new point(pos.r-i,pos.c-i);
            if(canMove(next))posmoves.add(next);
                        else break;
            if(comp&&game.pcontain(next))break;
            if(!comp&&game.ccontain(next))break;   
        }
    }
}
