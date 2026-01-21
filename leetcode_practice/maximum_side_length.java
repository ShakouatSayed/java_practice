package leetcode_practice;
class maximum_side_length {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] p = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                p[i][j] = p[i - 1][j] + p[i][j - 1] - p[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int left = 1;
        int right = Math.min(m, n);
        int ans = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            boolean find = false;
            for(int i = 1; i <= m - mid + 1; i++){
                for(int j = 1; j <= n - mid + 1; j++){
                    int sum = p[i + mid - 1][j + mid -1] - p[i - 1][j + mid -1] - p[i + mid - 1][j - 1] + p[i - 1][j - 1];
                    if(sum <= threshold){
                        find = true;
                        break;
                    }
                }
                if(find) 
                    break;
            }
            if(find) {
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String args[]){
        maximum_side_length msl = new maximum_side_length();
        int[][] mat = {
            {1,1,3,2,4,3,2},
            {1,1,3,2,4,3,2},
            {1,1,3,2,4,3,2}
        };

        int thershold = 4;
        int result = msl.maxSideLength(mat, thershold);

        System.out.println("The result is: "+result);
    }
}