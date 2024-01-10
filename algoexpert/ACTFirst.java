package algoexpert;

//Time complexity O(R * C) where R is the number of Rows and C is the number of columns, Space complexity O(1)
public class ACTFirst {


    public static int solution(int[][] A) {
        int count = 0;
        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < A[0].length; col++) {
                int current = A[row][col];
                if (current != -1) {
                    explore(A, row, col, current);
                    count += 1;
                }
            }
        }
        return count;
    }

    private static void explore(int[][] array, int row, int col, int current) {
        boolean rowInBound = row < array.length && row >= 0;
        boolean colInBound = col < array[0].length && col >= 0;
        if (!rowInBound || !colInBound) {
            return;
        }
        if (array[row][col] != current) {
            return;
        }
        if (array[row][col] == current) {
            array[row][col] = -1;
        }
        explore(array, row, col + 1, current);
        explore(array, row, col - 1, current);
        explore(array, row + 1, col, current);
        explore(array, row - 1, col, current);
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{5, 4, 4}, {4, 3, 4}, {3, 2, 4}, {2, 2, 2}, {3, 3, 4}, {1, 4, 4}, {4, 1, 1}};
        int[][] test = new int[][]{{5, 5, 5}, {4, 4, 4}, {2, 2, 2}};
        int[][] check = new int[][]{{}};
        System.out.println(solution(test));
    }
}
