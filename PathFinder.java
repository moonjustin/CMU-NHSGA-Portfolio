import java.util.ArrayList;
import java.util.List;

public class e4b {
    public static void main(String[] args) {
        ArrayList<Integer> path = new ArrayList<Integer>(); 
        List<List<Integer>> map = new ArrayList<>();
        int M = 3;
        int N = 3;
        int[][] forest = new int[M][N];
        int num = 1;
        for (int i = 0; i <= M - 1; i++){
            for (int j = 0; j <= N - 1; j++){
                forest[i][j] = num;
                num += 1;
            }
        }
        compass(path, map, forest, 0, 0);
        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.get(i));
        }
    }
    public static void compass(ArrayList<Integer> path, List<List<Integer>> map, int[][] forest, int y, int x) {
        path.add(forest[y][x]);
        if (y == forest[0].length - 1 && x == forest.length - 1) {
            map.add(path);
            return;
        } 
        if (y < forest[0].length - 1) {
            compass(new ArrayList<>(path), map, forest, y + 1, x);
        } 
        if (x < forest.length - 1) {
            compass(new ArrayList<>(path), map, forest, y, x + 1);
        }
        if (y < forest[0].length - 1 && x < forest.length - 1) {
            compass(new ArrayList<>(path), map, forest, y + 1, x + 1);
        }
    }
}