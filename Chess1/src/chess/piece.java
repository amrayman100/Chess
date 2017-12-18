package chess;
import java.util.ArrayList;
public interface piece {
    ArrayList<point> posmoves=new ArrayList<>();
    point pos=new point();
    public abstract void move(point newPosition);
    public abstract boolean canMove(point position);
    public abstract void generate();
}
