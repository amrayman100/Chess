package chess;

import java.util.ArrayList;

/**
 *
 * @author ahmedsalah
 */
public class Chess {

    public static void main(String[] args) {
        board start =new board();
        ArrayList<piece> cmp=new ArrayList<>();
        for(int i=0;i<8;i++){
            Pawn p=new Pawn(start,true);
            p.pos=new point(1,i);
            cmp.add(p);
        }
        piece k=new King(start,true);
        k.pos=new point(0,3);
        piece q=new queen(start,true);
        q.pos=new point(0,4);
        piece b=new bishop(start,true);
        b.pos=new point(0,2);
        piece kn=new Knight(start,true);
        kn.pos=new point(0,1);
        piece r=new rook(start,true);
        r.pos=new point(0,0);
        piece r1=new rook(start,true);
        r1.pos=new point(0,7);
        piece b1=new bishop(start,true);
        b1.pos=new point(0,5);
        piece kn1=new Knight(start,true);
        kn1.pos=new point(0,6);
        cmp.add(k);
        cmp.add(q);
        cmp.add(b);
        cmp.add(kn);
        cmp.add(r);
        cmp.add(r1);
        cmp.add(b1);
        cmp.add(kn1);
        ArrayList<piece> pl=new ArrayList();
        piece kp=new King(start,false);
        kp.pos=new point(7,3);
        piece qp=new queen(start,false);
        qp.pos=new point(7,4);
        piece bp=new bishop(start,false);
        bp.pos=new point(7,2);
        piece knp=new Knight(start,false);
        knp.pos=new point(7,1);
        piece rp=new rook(start,false);
        rp.pos=new point(7,0);
        piece rp1=new rook(start,false);
        rp1.pos=new point(7,7);
        piece bp1=new bishop(start,false);
        bp1.pos=new point(7,5);
        piece knp1=new Knight(start,false);
        knp1.pos=new point(7,6);
        pl.add(kp);
        pl.add(qp);
        pl.add(bp);
        pl.add(knp);
        pl.add(rp);
        pl.add(rp1);
        pl.add(bp1);
        pl.add(knp1);
        for(int i=0;i<8;i++){
            Pawn p=new Pawn(start,false);
            p.pos=new point(6,i);
            pl.add(p);
        }
        start.comp=cmp;
        start.player=pl;
        start.print();
    }
    
}
