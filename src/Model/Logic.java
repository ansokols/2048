package Model;

import java.io.*;

public class Logic {
    private final int N = 4, M = 4;
    private final int[][] matrix;
    private int score = 0;
    private int highScore;

    public Logic() {
        loadHighScore();
        matrix = new int[N][M];
        spawn();
        spawn();
    }


    public int getMatrixN(int i, int j) {
        return matrix[i][j];
    }

    public String getMatrixNString(int i, int j) {
        if (matrix[i][j] != 0) {
            return String.valueOf(matrix[i][j]);
        } else {
            return "";
        }
    }

    public int getScore() {
        return score;
    }

    public int getHighScore() {
        return highScore;
    }

    private static void copyMatrix(int[][] sourceMatrix, int[][] destinationMatrix)
    {
        for (int i = 0; i < sourceMatrix.length; i++)
        {
            System.arraycopy(sourceMatrix[i], 0, destinationMatrix[i], 0, sourceMatrix[i].length);
        }
    }

    public void spawn() {
        double random = Math.random();
        int newDigit;
        boolean isSpawned = false;

        if (random < 0.9) {
            newDigit = 2;
        } else {
            newDigit = 4;
        }

        while (!isSpawned) {
            int i = (int) (Math.random() * 4);
            int j = (int) (Math.random() * 4);
            if (matrix[i][j] == 0) {
                matrix[i][j] = newDigit;
                isSpawned = true;
            }
        }
    }

    public boolean up() {
        boolean isSorted;
        boolean isChanged = false;
        for (int j = 0; j < M; j++) {
            isSorted = false;
            for (int i = 0; i < N - 1; i++) {
                for (int z = i + 1; z < N; z++) {
                    if (matrix[i][j] == 0) {
                        break;
                    }
                    if (matrix[i][j] == matrix[z][j]) {
                        matrix[i][j] += matrix[i][j];
                        matrix[z][j] = 0;
                        score += matrix[i][j];
                        if (score > highScore) {
                            highScore = score;
                            saveHighScore();
                        }
                        isChanged = true;
                        i++;
                        break;
                    }
                    if (matrix[z][j] != 0) {
                        break;
                    }
                }
            }
            while (!isSorted) {
                isSorted = true;
                for (int i = 0; i < N - 1; i++) {
                    if (matrix[i][j] == 0 && matrix[i+1][j] != 0) {
                        matrix[i][j] = matrix[i+1][j];
                        matrix[i+1][j] = 0;
                        isSorted = false;
                        isChanged = true;
                    }
                }
            }
        }
        if (isChanged) {
            spawn();
            saveHighScore();
        }
        return isChanged;
    }

    public boolean down() {
        boolean isSorted;
        boolean isChanged = false;
        for (int j = 0; j < M; j++) {
            isSorted = false;
            for (int i = N - 1; i > 0; i--) {
                for (int z = i - 1; z >= 0; z--) {
                    if (matrix[i][j] == 0) {
                        break;
                    }
                    if (matrix[i][j] == matrix[z][j]) {
                        matrix[i][j] += matrix[i][j];
                        matrix[z][j] = 0;
                        score += matrix[i][j];
                        if (score > highScore) {
                            highScore = score;
                            saveHighScore();
                        }
                        isChanged = true;
                        i--;
                        break;
                    }
                    if (matrix[z][j] != 0) {
                        break;
                    }
                }
            }
            while (!isSorted) {
                isSorted = true;
                for (int i = N - 1; i > 0; i--) {
                    if (matrix[i][j] == 0 && matrix[i-1][j] != 0) {
                        matrix[i][j] = matrix[i-1][j];
                        matrix[i-1][j] = 0;
                        isSorted = false;
                        isChanged = true;
                    }
                }
            }
        }
        if (isChanged) {
            spawn();
            saveHighScore();
        }
        return isChanged;
    }

    public boolean left() {
        boolean isSorted;
        boolean isChanged = false;
        for (int i = 0; i < N; i++) {
            isSorted = false;
            for (int j = 0; j < M - 1; j++) {
                for (int z = j + 1; z < M; z++) {
                    if (matrix[i][j] == 0) {
                        break;
                    }
                    if (matrix[i][j] == matrix[i][z]) {
                        matrix[i][j] += matrix[i][j];
                        matrix[i][z] = 0;
                        score += matrix[i][j];
                        if (score > highScore) {
                            highScore = score;
                            saveHighScore();
                        }
                        isChanged = true;
                        j++;
                        break;
                    }
                    if (matrix[i][z] != 0) {
                        break;
                    }
                }
            }
            while (!isSorted) {
                isSorted = true;
                for (int j = 0; j < M - 1; j++) {
                    if (matrix[i][j] == 0 && matrix[i][j+1] != 0) {
                        matrix[i][j] = matrix[i][j+1];
                        matrix[i][j+1] = 0;
                        isSorted = false;
                        isChanged = true;
                    }
                }
            }
        }
        if (isChanged) {
            spawn();
            saveHighScore();
        }
        return isChanged;
    }

    public boolean right() {
        boolean isSorted;
        boolean isChanged = false;
        for (int i = 0; i < N; i++) {
            isSorted = false;
            for (int j = M - 1; j > 0; j--) {
                for (int z = j - 1; z >= 0; z--) {
                    if (matrix[i][j] == 0) {
                        break;
                    }
                    if (matrix[i][j] == matrix[i][z]) {
                        matrix[i][j] += matrix[i][j];
                        matrix[i][z] = 0;
                        score += matrix[i][j];
                        if (score > highScore) {
                            highScore = score;
                            saveHighScore();
                        }
                        isChanged = true;
                        j--;
                        break;
                    }
                    if (matrix[i][z] != 0) {
                        break;
                    }
                }
            }
            while (!isSorted) {
                isSorted = true;
                for (int j = M - 1; j > 0; j--) {
                    if (matrix[i][j] == 0 && matrix[i][j-1] != 0) {
                        matrix[i][j] = matrix[i][j-1];
                        matrix[i][j-1] = 0;
                        isSorted = false;
                        isChanged = true;
                    }
                }
            }
        }
        if (isChanged) {
            spawn();
            saveHighScore();
        }
        return isChanged;
    }

    public boolean checkFullness() {
        boolean isFull = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0 ; j < M; j++) {
                if (matrix[i][j] == 0) {
                    isFull = false;
                    break;
                }
            }
            if (!isFull) {
                break;
            }
        }
        if (isFull) {
            int[][] tempMatrix = new int[N][M];
            copyMatrix(matrix, tempMatrix);
            if (left() || right() || up() || down()) {
                isFull = false;
                copyMatrix(tempMatrix, matrix);
            }
        }
        return isFull;
    }

    private void saveHighScore() {
        try {
            File oldFile = new File("HighScore");
            File tempFile = new File("tempHighScore");
            File newFile = new File("HighScore");

            if (!tempFile.exists()) {
                tempFile.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream("tempHighScore");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(highScore);
                objectOutputStream.close();
                oldFile.delete();
                tempFile.renameTo(newFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadHighScore() {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        try {
            fileInputStream = new FileInputStream("HighScore");
            objectInputStream = new ObjectInputStream(fileInputStream);
            highScore = (int) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
