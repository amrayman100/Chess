package chess;

public class move {
public point step;
public double value;

    public move(point step, double value) {
        this.value = 0;
    }
    public move(double value, point move) {
        this.value =value;
        this.step = move;
    }
    
}
