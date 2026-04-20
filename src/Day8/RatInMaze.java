package Day8;

public class RatInMaze {

    static int N = 4;

    public static void solveMaze(int[][] maze) {
        int[][] solution = new int[N][N];

        if (!solve(maze, 0, 0, solution)) {
            System.out.println("No solution exists");
        }
    }

    private static boolean solve(int[][] maze, int x, int y, int[][] sol) {
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            printSolution(sol);
            return true;
        }

        if (isSafe(maze, x, y)) {
            sol[x][y] = 1;

            if (solve(maze, x + 1, y, sol)) return true;

            if (solve(maze, x, y + 1, sol)) return true;

            if (solve(maze, x - 1, y, sol)) return true;

            if (solve(maze, x, y - 1, sol)) return true;

            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    private static boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    private static void printSolution(int[][] sol) {
        System.out.println("Path:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };

        solveMaze(maze);
    }
}