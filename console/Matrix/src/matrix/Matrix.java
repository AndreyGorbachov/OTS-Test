package matrix;

import java.util.HashSet;

/**
 * 
 * @author Andrey Gorbachov
 *
 */

public class Matrix {

	private int M;
	private int N;
	private int array[][];

	public Matrix() {
		super();
	}

	public Matrix(int M, int N) {
		super();
		this.M = M;
		this.N = N;
		this.array = new int[M][N];
	}

	public int getM() {
		return M;
	}

	public void setM(int m) {
		M = m;
	}

	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}

	public int[][] getArray() {
		return array;
	}

	public void setArray(int[][] array) {
		this.array = array;
	}

	public void print() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print("\t" + array[i][j]);
			}
			System.out.println();
		}
	}

	public int searchMin() {
		int min = array[0][0];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (array[i][j] < min) {
					min = array[i][j];
				}
			}
		}
		return min;
	}

	public void deleteColumn() {
		int min = searchMin();
		HashSet<Integer> delCol = new HashSet<Integer>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (array[i][j] == min) {
					delCol.add(j);
				}
			}
		}
		int newArray[][] = new int[M][N - delCol.size()];
		int k = 0;
		for (int i = 0; i < M; i++) {
			k = 0;
			for (int j = 0; j < N; j++) {
				if (delCol.contains(j)) {
					k ++;
					continue;
				}
				newArray[i][j - k] = array[i][j];
			}
		}
		N = N - delCol.size();
		array = newArray;
	}
}
