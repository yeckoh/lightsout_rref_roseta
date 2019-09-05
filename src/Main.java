
public class Main {

    static public class Matrix {
        public int rows = 3;
        public int cols = 4;
        public double mtx[][] = new double[3][4];

        public Matrix() {
            
        }
        
        public Matrix(int r, int c) {
            rows = r;
            cols = c;
            mtx = new double[r][c];
        }

        public void FillMtxSample() {
            mtx[0][0] = 1;
            mtx[0][1] = 2;
            mtx[0][2] = -1;
            mtx[0][3] = -4;

            mtx[1][0] = 2;
            mtx[1][1] = 3;
            mtx[1][2] = -1;
            mtx[1][3] = -11;

            mtx[2][0] = -2;
            mtx[2][1] = 0;
            mtx[2][2] = -3;
            mtx[2][3] = 22;
        }
        
        public void FillMtxSample2() {
            mtx[0][0] = 1;
            mtx[0][1] = 3;
            mtx[0][2] = -1;
            mtx[0][3] = 0;

            mtx[1][0] = 4;
            mtx[1][1] = 1;
            mtx[1][2] = 7;
            mtx[1][3] = 11;

            mtx[2][0] = 0;
            mtx[2][1] = 4;
            mtx[2][2] = -4;
            mtx[2][3] = -4;
            
            mtx[3][0] = 2;
            mtx[3][1] = 0;
            mtx[3][2] = 4;
            mtx[3][3] = 6; 
        }
        
        public void FillMtxSample9x10() {
            mtx[0][0] = 1;
            mtx[0][1] = 1;
            mtx[0][2] = 0;
            mtx[0][3] = 1;
            mtx[0][4] = 0;
            mtx[0][5] = 0;
            mtx[0][6] = 0;
            mtx[0][7] = 0;
            mtx[0][8] = 0;
            mtx[0][9] = 1;

            mtx[1][0] = 1;
            mtx[1][1] = 1;
            mtx[1][2] = 1;
            mtx[1][3] = 0;
            mtx[1][4] = 1;
            mtx[1][5] = 0;
            mtx[1][6] = 0;
            mtx[1][7] = 0;
            mtx[1][8] = 0;
            mtx[1][9] = 0;
            
            mtx[2][0] = 0;
            mtx[2][1] = 1;
            mtx[2][2] = 1;
            mtx[2][3] = 0;
            mtx[2][4] = 0;
            mtx[2][5] = 1;
            mtx[2][6] = 0;
            mtx[2][7] = 0;
            mtx[2][8] = 0;
            mtx[2][9] = 1;
            
            mtx[3][0] = 1;
            mtx[3][1] = 0;
            mtx[3][2] = 0;
            mtx[3][3] = 1;
            mtx[3][4] = 1;
            mtx[3][5] = 0;
            mtx[3][6] = 1;
            mtx[3][7] = 0;
            mtx[3][8] = 0;
            mtx[3][9] = 0;
            
            mtx[4][0] = 0;
            mtx[4][1] = 1;
            mtx[4][2] = 0;
            mtx[4][3] = 1;
            mtx[4][4] = 1;
            mtx[4][5] = 1;
            mtx[4][6] = 0;
            mtx[4][7] = 1;
            mtx[4][8] = 0;
            mtx[4][9] = 1;
            
            mtx[5][0] = 0;
            mtx[5][1] = 0;
            mtx[5][2] = 1;
            mtx[5][3] = 0;
            mtx[5][4] = 1;
            mtx[5][5] = 1;
            mtx[5][6] = 0;
            mtx[5][7] = 0;
            mtx[5][8] = 1;
            mtx[5][9] = 1;
            
            mtx[6][0] = 0;
            mtx[6][1] = 0;
            mtx[6][2] = 0;
            mtx[6][3] = 1;
            mtx[6][4] = 0;
            mtx[6][5] = 0;
            mtx[6][6] = 1;
            mtx[6][7] = 1;
            mtx[6][8] = 0;
            mtx[6][9] = 1;
            
            mtx[7][0] = 0;
            mtx[7][1] = 0;
            mtx[7][2] = 0;
            mtx[7][3] = 0;
            mtx[7][4] = 1;
            mtx[7][5] = 0;
            mtx[7][6] = 1;
            mtx[7][7] = 1;
            mtx[7][8] = 1;
            mtx[7][9] = 1;
            
            mtx[8][0] = 0;
            mtx[8][1] = 0;
            mtx[8][2] = 0;
            mtx[8][3] = 0;
            mtx[8][4] = 0;
            mtx[8][5] = 1;
            mtx[8][6] = 0;
            mtx[8][7] = 1;
            mtx[8][8] = 1;
            mtx[8][9] = 0;
        }
        
        public void print() {
            for(int i = 0;i < rows;i++) {
                for(int j = 0;j < cols-1;j++) {
                    System.out.print((int)mtx[i][j] + " ");
                }
                
                System.out.println("| " + (int)mtx[i][cols-1]);
            }
        }
        
        public void printB() {
            int val = 0;
            int sq = (int) Math.sqrt(rows);
            
            String[] buffer = new String[rows];
            for(int i = 0; i < rows;i++)
                buffer[i] = "";
            
            int k = 0;
            for(int i = 0;i < rows;i++) {
                //val = (int) mtx[i][cols-1] % 2;
                buffer[k] += (int) mtx[i][cols-1] + " ";
                if(i % sq == sq-1) {
                    k++;
//                if(i % sq == 0) {
                    //System.out.println();
                }
                //System.out.println(val);
            }
            
            for(int i = 0; i < sq;i++)
                System.out.println(buffer[i]);
        }
        
        
        public void Swap(int r1, int r2) {
            double temp;
            for(int i = 0;i < cols;i++) {
                temp = mtx[r1][i];
                mtx[r1][i] = mtx[r2][i];
                mtx[r2][i] = temp;
            }
        }
        
        public void DivR(int r, double val) {
            for(int i = 0;i < cols; i++) {
                mtx[r][i] = mtx[r][i] / val;
            }
        }

        public double[] MultR(double val, int r) {
            double[] temp = new double[cols];
            for(int i = 0;i< cols;i++) {
                temp[i] = mtx[r][i] * val;
            }
            return temp;
        }
        
        public void Subt(int r1, double[] r2) {
            for(int i = 0;i < cols; i++) {
                mtx[r1][i] -= r2[i];
            }
        }
                
        
    } // end.Matrix class

    
    static public int convertDecimalToFraction(double x){
        if (x < 0){
            return convertDecimalToFraction(-x);
        }
        double tolerance = 1.0E-6;
        double h1=1; double h2=0;
        double k1=0; double k2=1;
        double b = x;
        do {
            double a = Math.floor(b);
            double aux = h1; h1 = a*h1+h2; h2 = aux;
            aux = k1; k1 = a*k1+k2; k2 = aux;
            b = 1/(b-a);
        } while (Math.abs(x-h1/k1) > x*tolerance);

        //return h1+"/"+k1;
        return (int)h1;
    }
    
    // r is current row
    public static void ToRREF(Matrix M) {
        int lead = 0;                                           //  lead := 0
        int rowCount = M.rows;                                  // rowCount := the number of rows in M
        int colCount = M.cols;                                  // columnCount := the number of columns in M

        for (int r = 0; r < rowCount; r++) {                    // for 0 <= r < rowCount do

            if(colCount <= lead)
                return;
            
            int i = r;                                          // i = r
            
            while(M.mtx[i][lead] == 0) {
                i++;
                if(rowCount == i) {
                    i = r;
                    lead++;
                    if(colCount == lead)
                        return;
                }
            }
            
            
            M.Swap(i,r);
            
            if(M.mtx[r][lead] != 0) {
                M.DivR(r, M.mtx[r][lead]);
            }
            
            for(i = 0;i < rowCount;i++) {
                if(i != r) {
                    // subtract m[i,lead] multiplied by row r from row i
                    
                    // multiply M[i][lead] by row r 
                    // subtract row i by MultR
                    double[] multR = M.MultR(M.mtx[i][lead], r);
                    M.Subt(i, multR);
                }
            }
            lead++;
            
        } // end.for
        for(int i = 0;i < rowCount;i++) {
            M.mtx[i][colCount-1] = convertDecimalToFraction(M.mtx[i][colCount-1]);
            M.mtx[i][colCount-1] %= 2;
        }
        return;
    } // end.RREF function
    
    public static void main(String[] args) {
        
//        System.out.println("sample rref should be:\n"
//                + "1 0 0 -8\n"
//                + "0 1 0 1\n"
//                + "0 0 1 -2\n\n");
        Matrix m = new Matrix(3, 4);
        m.FillMtxSample();
        System.out.println("input:");
        m.print();
        ToRREF(m);
        System.out.println("output:");
        m.print();        
        System.out.println("\nrref:");
        m.printB();
        
    }
} // end.Main
