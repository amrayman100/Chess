package chess;

import java.util.*;
public class board {
    ArrayList<piece> player;
    ArrayList<piece> comp;
    char b[][]=new char[8][8];
    piece[][] brd=new piece[8][8];
    public board(ArrayList<piece> player, ArrayList<piece> comp) {
        this.player = player;
        this.comp = comp;
    }
    public board() {
    }
    public boolean ccontain(point p){
        for(piece p1:comp)
            if(p1.pos.r==p.r&&p1.pos.c==p.c)
                return true;
        return false;
    }
    public boolean pcontain(point p){
        for(piece p1:player)
            if(p1.pos.r==p.r&&p1.pos.c==p.c)
                return true;
        return false;
    }
    public void print(){
    for(piece p:player){
        b[p.pos.r][p.pos.c]=p.rep;
        p.generate();
        System.out.println(p.pos.r+" "+p.pos.c);
        for(point p1:p.posmoves){
        System.out.println(p1.r+" "+p1.c);
        }
        System.out.println("end"); 
    }
    for(piece p:comp){
        b[p.pos.r][p.pos.c]=p.rep;
        p.generate();
        System.out.println(p.pos.r+" "+p.pos.c);
        for(point p1:p.posmoves){
        System.out.println(p1.r+" "+p1.c);
        }
        System.out.println("end");
    }
    for(int i=0;i<8;i++){
        for(int j=0;j<8;j++){
            if(brd[i][j]==null)
                System.out.print(".");
            else System.out.print(brd[i][j].rep);
        }
        System.out.println("");
    }
    }
    public piece[][] getBoard(){
        for(piece p:comp)
            brd[p.pos.r][p.pos.c]=p;
        for(piece p:player)
            brd[p.pos.r][p.pos.c]=p;
        return brd;
    }
        public boolean possible(point oldp,point newp){
        for(point p:brd[oldp.r][oldp.c].posmoves)
            if(p.r==newp.r&&p.c==newp.c)return true;
        return false;
    }
    public void makeMove(point oldp,point newp){
        brd[newp.r][newp.c]=brd[oldp.r][oldp.c].clone();
        brd[newp.r][newp.c].pos=newp;
        for(piece p: comp){
            if(oldp.r==p.pos.r&&oldp.c==p.pos.c){
                comp.remove(p);
                comp.add(brd[newp.r][newp.c]);
                break;
            }
        }
        for(piece p: player){
            if(oldp.r==p.pos.r&&oldp.c==p.pos.c){
                player.remove(p);
                player.add(brd[newp.r][newp.c]);
                break;
            }
        }
        brd[oldp.r][oldp.c]=null;
        brd[newp.r][newp.c].generate();
    }
}
