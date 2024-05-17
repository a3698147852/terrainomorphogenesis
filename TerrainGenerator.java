import java.util.Random;

public class TerrainGenerator {
    public static void main(String[] args) {
        int rows = 13; // 行數
        int cols = 11; // 列數
        int complexity = 95/2; // 複雜度

        // 如果提供了參數，則使用提供的參數
        if (args.length == 3) {
            rows = Integer.parseInt(args[0]);
            cols = Integer.parseInt(args[1]);
            complexity = Integer.parseInt(args[2]);
        }

        // 生成並輸出隨機地形
        char[][] terrain = generateTerrain(rows, cols, complexity);
        printTerrain(terrain);
    }

    // 生成隨機地形的方法
    public static char[][] generateTerrain(int rows, int cols, int complexity) {
        char[][] terrain = new char[rows * 2][cols * 2];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 根據複雜度決定是障礙物還是可行走部分
                if (random.nextInt(100) < complexity) {
                    // 2x2區塊的障礙物
                    terrain[i * 2][j * 2] = '■';
                    terrain[i * 2][j * 2 + 1] = '■';
                    terrain[i * 2 + 1][j * 2] = '■';
                    terrain[i * 2 + 1][j * 2 + 1] = '■';
                } else {
                    // 2x2區塊的可行走部分
                    terrain[i * 2][j * 2] = '┌';
                    terrain[i * 2][j * 2 + 1] = '┐';
                    terrain[i * 2 + 1][j * 2] = '└';
                    terrain[i * 2 + 1][j * 2 + 1] = '┘';
                }
            }
        }

        // 設置正中心的目標點
        int centerRow = rows / 2;
        int centerCol = cols / 2;
        terrain[centerRow * 2][centerCol * 2] = 'X';
        terrain[centerRow * 2][centerCol * 2 + 1] = 'X';
        terrain[centerRow * 2 + 1][centerCol * 2] = 'X';
        terrain[centerRow * 2 + 1][centerCol * 2 + 1] = 'X';

        return terrain;
    }

    // 輸出地形的方法
    public static void printTerrain(char[][] terrain) {
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[i].length; j++) {
                System.out.print(terrain[i][j] + " ");
            }
            System.out.println();
        }
    }
}
