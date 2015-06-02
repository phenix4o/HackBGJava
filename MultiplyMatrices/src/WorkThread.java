

public class WorkThread extends Thread {
    private int row;
    private int col;
    private int [][] a;
    private int [][] b;
    private int [][] c;
   
    
   
    public WorkThread(int row, int col, int[][] a, int[][] b, int[][] c) {
        super();
        this.row = row;
        this.col = col;
        this.a = a;
        this.b = b;
        this.c = c;
    }



    public void run(){
       c[row][col]= (a[row][0] * b[0][col])+ (a[row][1]*b[1][col]) ;
       
    }

   
}

