import java.util.Scanner;
/**
 * Solution
 * UVa 108
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=44
 * @author Joe Hernandez
 */

public class MaximumSum {
	
	//Maximum Sum Rectangular Submatrix in Matrix dynamic programming/2D
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[][] matrixOriginal = new int[n][n];
			
			for (int i = 0; i < matrixOriginal.length; i++) {
				for (int j = 0; j < matrixOriginal[0].length; j++) {
					matrixOriginal[i][j] = scanner.nextInt();
				}
			}
			
			int rst = MaximumSum(matrixOriginal);
			
			
			System.out.println(rst);
		}
		scanner.close();
		
	}
	
	public static int MaximumSum(int[][] matrix) {
		int maxSum = 0, maxLeft = 0, maxRight = 0, maxUp = 0, maxDown = 0, currentSum = 0;
		int r = 0, l = 0;
		int[] subMatrix;
		
		
		for (int i = 0; i < matrix.length; i++) {
			l = i;
			subMatrix = new int[matrix.length];
			for (int j = i; j < matrix[0].length; j++) {
				r = j;
				subMatrix = subMatrix(matrix, subMatrix, r);
				
				int[] matrixTemp = maxSumArray(subMatrix);
				currentSum = matrixTemp[0];
				
				if (currentSum>maxSum) {
					maxLeft = l;
					maxRight = r;
					maxSum = currentSum;
					maxUp = matrixTemp[1];
					maxDown = matrixTemp[2];
				}
				
			}
		}
//		System.out.println(maxSum);
//		System.out.println(maxLeft);
//		System.out.println(maxRight);
//		System.out.println(maxUp);
//		System.out.println(maxDown);
		
		return maxSum;
	}
	
	public static int[] subMatrix(int[][] matrix, int[] subMatrix, int r) {
		int[] rst = subMatrix.clone();
		for (int i = 0; i < subMatrix.length; i++) 
			rst[i] += matrix[i][r];
		
		return rst;
	}
	
	public static int[] maxSumArray(int[] subMatrix) {
		int[] rst = new int[3];
		int max = 0, actual = 0;
		int up = -1, down = -1, currentStart = 0;
		for (int i = 0; i < subMatrix.length; i++) {
			actual += subMatrix[i];
			if (actual < 0) {
				actual = 0;
				currentStart = i+1;
			}
			if (max < actual) {
				up = currentStart;
				down = i;
				max = actual;
			}
		}
		//Max sum
		rst[0] = Math.max(max, actual);
		//Up
		rst[1] = up;
		//Down
		rst[2] = down;
		return rst;
	}
	

}
