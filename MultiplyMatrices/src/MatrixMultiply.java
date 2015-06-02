import java.util.Random;

public class MatrixMultiply {
	public static int rowfirstMarrix = 4;
	public static int rowsecondMarrix = 4;
	public static int collfirstMatrix = 4;
	public static int collsecondMatrix = 4;
	public static int[][] firstMatrix = new int[rowfirstMarrix][collfirstMatrix];
	public static int[][] secondMartix = new int[rowsecondMarrix][collsecondMatrix];
	public static int[][] resultMatrix = new int[rowfirstMarrix][rowfirstMarrix];
	public static WorkThread[][] thread = new WorkThread[rowfirstMarrix][rowfirstMarrix];

	public static int[][] multiplication(int[][] a, int[][] b) {
		int size = a.length;
		int[][] c = new int[size][size];
		int i, j;
		for (i = 0; i < size; i++) {
			for (j = 0; j < size; j++)
				c[i][j] += (a[i][j] * b[j][i]);
		}
		return c;
	}

	private static void fillMatrix(int[][] matrix) {
		Random random = new Random();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				matrix[i][j] = random.nextInt(100) + 1;
		}
	}

	public static void main(String[] args) {
		fillMatrix(firstMatrix);
		fillMatrix(secondMartix);
		for (int i = 0; i < rowfirstMarrix; i++) {
			for (int j = 0; j < collsecondMatrix; j++) {
				thread[i][j] = new WorkThread(i, j, firstMatrix, secondMartix,
						resultMatrix);
				thread[i][j].start();
			}
		}
		for (int i = 0; i < rowfirstMarrix; i++) {
			for (int j = 0; j < collsecondMatrix; j++) {
				System.out.println("(" + i + ", " + j + ") ="
						+ resultMatrix[i][j]);
			}
		}
	}
}
