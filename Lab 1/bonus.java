
public class bonus {
    //In graph theory, a regular graph is a graph where each vertex has the
// same number of neighbors; i.e. every vertex has the same degree
    public static void main(String[] args) {
        int vertex = 4;
        int degree = 2;
        Matrix(vertex, degree);
    }

    private static void Matrix(int n, int k) {
        //create the adjency matrix
        int matrix[][] = new int[n][n];

        //initial, punem in matrice pe diagonala principala 0 deoarece un nod nu va avea muchie cu el insusi
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                }
            }
        }

        //the conditions to have a graph k-regular
        if (n * k % 2 == 0 && (n >= k + 1)) {
            //when n and k are even
            if (n % 2 == 0 && k % 2 == 0) {
                //for each node
                for (int i = 0; i < n; i++) {
                    int poz = 1;
                    matrix[i][(poz + i) % n] = 1;
                    matrix[(poz + i) % n][i] = 1;
                    poz = poz + 2;
                    while (poz < k) {
                        matrix[i][(poz + i - 1) % n] = 1;
                        matrix[(poz + i - 1) % n][i] = 1;
                        poz = poz + 2;
                    }
                }
                //print the matrix
                PrintMatrix(matrix, n);
                //when n is even and k is odd
            }
            else if(n %2 ==0 && k%2==1){
                int[][] adjMatrix = new int[n][n];

                int[] group1 = new int[n/2];
                int[] group2 = new int[n/2];

                int j = 0;
                for (int i = 0; i < n; i++) {
                    if (i < n/2) {
                        group1[i] = i;
                    } else {
                        group2[j++] = i;
                    }
                }

                for (int i = 0; i < n/2; i++) {
                    for (int l = 1; l <= k/2; l++) {
                        adjMatrix[group1[i]][group1[(i + l) % (n/2)]] = 1;
                        adjMatrix[group1[(i + l) % (n/2)]][group1[i]] = 1;

                        adjMatrix[group2[i]][group2[(i + l) % (n/2)]] = 1;
                        adjMatrix[group2[(i + l) % (n/2)]][group2[i]] = 1;
                    }

                    adjMatrix[group1[i]][group2[i]] = 1;
                    adjMatrix[group2[i]][group1[i]] = 1;
                }

                PrintMatrix(adjMatrix, n);

            }
            } else {
            System.out.println("Not possible to have a k-regular graph");
        }

    }



    private static void PrintMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int l = 0; l < n; l++) {
                System.out.print(matrix[i][l] + " ");
            }
            System.out.println();
        }
    }

}