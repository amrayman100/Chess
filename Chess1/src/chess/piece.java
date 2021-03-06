package chess;
import java.util.ArrayList;
public abstract class piece {
    ArrayList<point> posmoves=new ArrayList<>();
    point pos=new point();
    board game;
    boolean comp;
    protected int value;
    protected int[][] evaluate;
    char rep;
    public piece(board b) {
        game=b;
    }

    public piece() {
    }
    public abstract piece clone();
    public piece(piece p){
        this.pos=p.pos;
        this.comp=p.comp;
        this.game=p.game;
        this.posmoves=p.posmoves;
        this.rep=p.rep;
    }
    public int kingweight(){
        return 0;
    }
    public int weight(){
        return value+evaluate[(comp)?7-pos.r:pos.r][pos.c];
    }
    public boolean canMove(point position){
        if(position.r>7||position.r<0||position.c<0||position.c>7) return false;
        if(comp&&game.ccontain(position))return false;
        if(!comp&&game.pcontain(position))return false;
            return true; 
    }
    public abstract void generate();
}
