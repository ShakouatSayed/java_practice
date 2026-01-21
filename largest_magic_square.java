class Main {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // prefix sum of each row
        int[][] rowSum = new int[m][n];
        for(int i = 0; i < m; ++i){
            rowSum[i][0] = grid[i][0];
            for(int j = 1; j < n; ++j){
                rowSum[i][j] = rowSum[i][j - 1] + grid[i][j];
            }
        }

        // prefix sum of each column
        int[][] colSum = new int[m][n];
        for(int j = 0; j < n; ++j){
            colSum[0][j] = grid[0][j];
            for(int i = 1; i < m; ++i){
                colSum[i][j] = colSum[i - 1][j] + grid[i][j];
            }
        }

        // enumerate edge lengths from largest to smallest 
        for(int edge = Math.min(m, n); edge >= 2; --edge){ 
            // enumerate the top-left corner position (i, j) of the square
            for(int i = 0; i + edge <= m; ++i){
                for(int j = 0; j + edge <= n; ++j){
                    // the value for each row, column, and diagonal should be calculated (using the first row as a simple)
                    int stdSum = rowSum[i][j + edge - 1] - (j > 0 ? rowSum[i][j - 1] : 0);
                    boolean check = true;

                    // enumerate each row and derectly compute the sum using prefix sums
                    for(int i1 = i + 1; i1 < i + edge; ++i1){
                        if(rowSum[i1][j + edge - 1] - (j > 0 ? rowSum[i1][j - 1] : 0) != stdSum){
                            check = false;
                            break;
                        }
                    }

                    if(!check)
                        continue;
                    
                    // enumerate each column and deriectly calculate the sum using prefix sums
                    for(int j1 = j; j1 < j + edge; ++j1){
                        if(colSum [i + edge - 1][j1] - (i > 0 ? colSum[i - 1][j1] : 0) != stdSum){
                            check = false;
                            break;
                        }
                    }

                    if(!check) 
                        continue;
                    
                    int d1 = 0, d2 = 0;
                    for(int k = 0; k < edge; ++k){
                        d1 += grid[i + k][j + k];
                        d2 += grid[i + k][j + edge - 1 - k]; 
                    }

                    if(d1 == stdSum && d2 == stdSum){
                        return edge;
                    }
                }
            }
        }

        return 1;
    }

    public static void main(String args[]){
        int[][] grid = {
            {7,1,4,5,6},
            {2,5,1,6,4},
            {1,5,4,3,2},
            {1,2,7,3,4}
        };

        Main obj = new Main();
        int result = obj.largestMagicSquare(grid);

        System.out.println("Lagest Magic Square Size: "+result);
    }
}

