package chess;

import java.util.*;

public class board {
    ArrayList<piece> player;
    ArrayList<piece> comp;
    char b[][]=new char[8][8];
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
            System.out.print(b[i][j]);
        }
        System.out.println("");
    }
    }
}
