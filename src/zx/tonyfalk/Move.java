package zx.tonyfalk;

public class Move {
    private int X1;
    private int Y1;
    private int X2;
    private int Y2;

    public Move(int X1, int Y1,int X2,int Y2) {
        this.X1 = X1;
        this.Y1 = Y1;
        this.X2 = X2;
        this.Y2 = Y2;
    }

    public int getX1() {
        return X1;
    }
    public int getY1() {
        return Y1;
    }
    public int getX2() {
        return X2;
    }
    public int getY2() {
        return Y2;
    }
}
