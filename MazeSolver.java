// This program takes a maze with a start point and an end point, and solves it recursively.

public class MazeSolver {
    final static char C = ' ', X = 'x', S = 's', E = 'e', V = '.';

    private static char[][] mazeBase = {
            {X, X, X, X, X, X, X, X, X, X, X, X, X, X, X},
            {X, C, C, C, C, C, C, X, C, C, C, C, C, C, X},
            {X, X, X, C, X, X, X, X, X, X, X, C, X, C, X},
            {X, C, X, C, C, C, C, C, C, C, C, C, X, C, X},
            {X, C, X, C, X, X, C, C, X, X, X, C, X, C, X},
            {X, C, C, C, X, C, C, C, C, C, X, C, X, C, X},
            {X, C, X, X, X, X, X, C, X, C, X, C, X, C, X},
            {X, C, C, C, C, S, C, C, X, C, C, X, E, C, X},
            {X, X, X, X, X, X, X, X, X, X, X, X, X, X, X}
    };
    private static Location start = new Location(7, 5);

    public static void main(String[] args) {
        System.out.println();
        solveRecursion(start);
    }

    public static void solveRecursion(Location current) {

        if (mazeBase[current.getR()][current.getC()] == E) {
            System.out.println("completed");
            print(mazeBase);
            return;
        }

        if (mazeBase[current.getR()][current.getC() + 1] == C || mazeBase[current.getR()][current.getC() + 1] == E)  {
            mazeBase[current.getR()][current.getC()] = V;
            current = current.Right();
            solveRecursion(current);
            current = current.Left();
        } if (mazeBase[current.getR() + 1][current.getC()] == C || mazeBase[current.getR() + 1][current.getC()] == E) {
            mazeBase[current.getR()][current.getC()] = V;
            current = current.Down();
            solveRecursion(current);
            current = current.Up();
        } if (mazeBase[current.getR() - 1][current.getC()] == C || mazeBase[current.getR() - 1][current.getC()] == E) {
            mazeBase[current.getR()][current.getC()] = V;
            current = current.Up();
            solveRecursion(current);
            current = current.Down();
        } if (mazeBase[current.getR()][current.getC() - 1] == C || mazeBase[current.getR()][current.getC() - 1] == E) {
            mazeBase[current.getR()][current.getC()] = V;
            current = current.Left();
            solveRecursion(current);
            current = current.Right();
        }
    }

    public static void print(char[][] maze) {
        for (char[] char1 : maze) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(char1[j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static char[][] copy(){
        char[][] temp = new char[mazeBase.length][mazeBase[0].length];
        for(int i = 0; i < mazeBase.length; i++){
            for(int j = 0; j < mazeBase[0].length; j++){
                temp[i][j] = mazeBase[i][j];
            }
        }
        return temp;
    }
}

