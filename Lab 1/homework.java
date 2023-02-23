public class homework {
    public static void main (String[] args){

        try
        {
            Integer.parseInt(args[0]);
            System.out.println(args[0] + " is a valid integer");

            int n = Integer.parseInt(args[0]);
            long startTime = 0;
            if (n >= 30000){
                startTime = System.currentTimeMillis();;
            }

            //matrix of n*n
            int [][] m = new int [n+1][n+1];
            int i;
            int j;

            //completez diagonala principala cu 1
            for (i=1; i <=n ; i++){
                m[i][i] = 1;
            }

            for (i=2; i<=n;i++){
                int number = n;
                for (j=i-1; j>=1; j--){
                    m[i][j] = number;
                    number --;
                }
            }

            for (i=1; i<=n-1;i++){
                int number = 2;
                for (j=i+1;j<=n;j++){
                    m[i][j] = number;
                    number ++;
                }
            }

            PrintMatrix(m, n);
            Concatenate(m, n);

            if (n >= 30000){
                long endTime   = System.currentTimeMillis();
                long totalTime = (endTime - startTime)/1000;
                System.out.println("Total time is: " + totalTime + " seconds");
            }

        }
        catch (NumberFormatException e)
        {
            System.out.println(args[0] + " is not a valid integer");
        }

    }

    static void PrintMatrix(int[][] matrix, int n){
        int i;
        int j;
        for (i = 1; i <= n; i++){

            for ( j = 1; j <= n; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void Concatenate(int[][] matrix, int n){
        int i;
        int j;
        //pe linie
        for (i = 1; i <= n; i++){
            String display = "";
            for (j=1; j <=n ;j++){
                //String number = String.valueOf(matrix[i][j]);
                display += Integer.toString(matrix[i][j]);
            }
            System.out.println(display);
        }

        System.out.println();
        //pe coloana
        for (j = 1; j <= n; j++){
            String display = "";
            for (i=1; i <=n ;i++){
                //String number = String.valueOf(matrix[i][j]);
                display += Integer.toString(matrix[i][j]);
            }
            System.out.println(display);
        }
    }
}
