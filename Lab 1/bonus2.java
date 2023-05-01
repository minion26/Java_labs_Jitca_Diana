public class bonus2 {

    public static void main(String[] args) {
        int n=2;
        //making the adjency matrix
        printMatrix(adjencyMatrix(n));
        System.out.println();
        //multiplying the adjency matrix
        printMatrix(matrixMultiply(adjencyMatrix(n), 3));
    }

    private static int[][] adjencyMatrix(int n) {
        //create the adjency matrix
        int[][] matrix = new int[n][n];

        for(int i=0;i<n;i++){
            //if the node is the first one
            //the first node will have an edge with the last node and the second node
            if(i==0){
                matrix[i][i+1]=1;
                matrix[i][n-1]=1;
            }else{
                //if the node is the last one
                //the last node will have an edge with the first node and the second to last node
                if(i==n-1){
                    matrix[i][i-1]=1;
                    matrix[i][0]=1;
                }else{
                    //if the node is not the first or the last one
                    //the node will have an edge with the node before and the node after
                    matrix[i][i+1]=1;
                    matrix[i][i-1]=1;
                }
            }

        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        //print the matrix
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixMultiply(int[][] A, int times) {
        int n = A.length;
        int[][] B = new int[n][n];
        int[][] C = new int[n][n];

        // copy A to B
        for (int i = 0; i < n; i++) {
            System.arraycopy(A[i], 0, B[i], 0, n);
        }

        for (int i = 0; i < times-1; i++) {
            // perform matrix multiplication
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int sum = 0;
                    for (int l = 0; l < n; l++) {
                        sum += A[j][l] * B[l][k];
                    }
                    C[j][k] = sum;
                }
            }
            //valorile din matricea initiala A nu sunt inlocuite cu valorile calculate pana atunci
            //valorile sunt stocate temporar in matricea C si apoi copiate in matricea T

            // copy C to temporary matrix T
            int[][] T = new int[n][n];
            for (int m = 0; m < n; m++) {
                System.arraycopy(C[m], 0, T[m], 0, n);
            }

            //valorile din matricea T sunt copiate inapoi in matricea A
            //astfel incat sa putem continua sa inmultim matricea initiala A cu matricea B fara a pierde date
            // copy T back to A
            for (int m = 0; m < n; m++) {
                System.arraycopy(T[m], 0, A[m], 0, n);
            }
        }

        return C;
    }
}
