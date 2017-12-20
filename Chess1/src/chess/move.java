package chess;

public class move {
public point oldp;
public point newp;
public double value;

    public move(double value) {
        this.value = 0;
    }

    public move(point oldp, point newp, double value) {
        this.oldp = oldp;
        this.newp = newp;
        this.value = value;
    }

    public int utility(board brd){
        return 1;
    }
    public void alpha(board b,int depth){
        move v=max(b,Integer.MIN_VALUE,Integer.MAX_VALUE,depth,null);
        b.makeMove(v.oldp, v.newp);
    }
    private move Max(move a,move b){
        if(a.value<b.value)return a;
        else return b;
    }
    private move Min(move a,move b){
        if(a.value<b.value)return a;
        else return b;
    }
    
    move max(board brd,int alpha,int beta,int depth,move old){
        if(depth==0){
            move v=new move(utility(brd));
            v.oldp=old.oldp;
            v.newp=old.oldp;
            return v;
        }
        move v=new move(null,null,Integer.MIN_VALUE);
        for(int i=0;i<brd.comp.size();i++)
            for(int j=0;j<(int)brd.comp.get(i).posmoves.size();j++){
                board clone=brd.clone();
                clone.makeMove(clone.comp.get(i).pos, clone.comp.get(i).posmoves.get(j));
                v=Max(v,min(clone,alpha,beta,depth-1,new move(brd.comp.get(i).pos, brd.comp.get(i).posmoves.get(j),0)));
                if(v.value>=beta)return v;
                if(v.value>alpha)alpha=(int)v.value;
            }
        return v;
    }
    move min(board brd,int alpha,int beta,int depth,move old){
        if(depth==0){
            move v=new move(utility(brd));
            v.oldp=old.oldp;
            v.newp=old.oldp;
            return v;
        }
        move v=new move(null,null,Integer.MIN_VALUE);
        for(int i=0;i<brd.player.size();i++)
            for(int j=0;j<(int)brd.player.get(i).posmoves.size();j++){
                 board clone=brd.clone();
                clone.makeMove(clone.player.get(i).pos, clone.player.get(i).posmoves.get(j));
                v=Min(v,max(clone,alpha,beta,depth-1,new move(clone.player.get(i).pos,clone.player.get(i).posmoves.get(j),0)));
                if(v.value<=alpha)return v;
                if(v.value<beta)beta=(int)v.value;
            }
        return v;
    }
}
