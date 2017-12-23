package chess;

import java.util.*;
import javax.swing.ImageIcon;
public class board {
    ArrayList<piece> player;
    ArrayList<piece> comp;
    char b[][]=new char[8][8];
    piece[][] brd=new piece[8][8];
    public int color[][]=new int[8][8];
    public board(ArrayList<piece> player, ArrayList<piece> comp) {
        this.player = player;
        this.comp = comp;
        for(int i=0;i<8;i++)for(int j=0;j<8;j++)
            color[i][j]=0;
    }
    public board() {
        for(int i=0;i<8;i++)for(int j=0;j<8;j++)
            color[i][j]=0;
    }
    public board clone(){
        ArrayList<piece> comp1=new ArrayList();
        ArrayList<piece> player1=new ArrayList();
        int[][] clon=new int[8][8];
        for(int i=0;i<8;i++)for(int j=0;j<8;j++)
            clon[i][j]=this.color[i][j];
        for(piece p:comp) comp1.add(p.clone());
        for(piece p:player) player1.add(p.clone());
        board clone = new board(player1,comp1);
        piece[][] cln=new piece[8][8];
        char b1[][]=new char[8][8];
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++){
                if(brd[i][j]==null)continue;
                cln[i][j]=brd[i][j].clone();
                b1[i][j]=b[i][j];
            }
        clone.brd=cln;
        clone.b=b1;
        clone.color=clon;
        return clone;
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
        this.getBoard();
    for(piece p:player){
        b[p.pos.r][p.pos.c]=p.rep;
        p.generate();
    }
    for(piece p:comp){
        b[p.pos.r][p.pos.c]=p.rep;
        p.generate();
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
    public void getBoard(){
        for(piece p:comp)
            brd[p.pos.r][p.pos.c]=p;
        for(piece p:player)
            brd[p.pos.r][p.pos.c]=p;
    }
        public boolean possible(point oldp,point newp){
        for(point p:brd[oldp.r][oldp.c].posmoves)
            if(p.r==newp.r&&p.c==newp.c)return true;
        return false;
    }
    public void makeMove(point oldp,point newp){
    brd[newp.r][newp.c]=brd[oldp.r][oldp.c].clone();
        brd[newp.r][newp.c].pos=newp;
        
        for(int i=0;i<comp.size();i++){
            piece p=comp.get(i);
            if(p.pos.r==newp.r&&p.pos.c==newp.c)
                comp.remove(i);
        }
        for(int i=0;i<player.size();i++){
            piece p=player.get(i);
            if(p.pos.r==newp.r&&p.pos.c==newp.c)
                player.remove(i);
        }
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
        //System.out.println(newp.r+" "+newp.c);
        //this.print();
        for(piece p:comp){
            p.game=this;
            p.generate();
        }
        for(piece p:player){
            p.game=this;
            p.generate();
        }

    }
    public King getKing(boolean cmp){
        if(cmp){
            for(piece p:comp)
                if(p.getClass()==King.class)return (King)p;
        }
        else {
            for(piece p:player )      
                if(p.getClass()==King.class)return (King)p;
        }
        return new King();
    }
    public boolean check(piece p){
        if(p.comp){
            for(piece p1:player)
                for(point pnt:p1.posmoves)
                    if(pnt.c==p.pos.c&&p.pos.r==pnt.r)return true;
        }
        else{
            for(piece p1:comp)
                for(point pnt:p1.posmoves)
                    if(pnt.c==p.pos.c&&p.pos.r==pnt.r)return true;
        }
        return false;
        }
//    public int checkmate(piece p){
//        
//    }
}
