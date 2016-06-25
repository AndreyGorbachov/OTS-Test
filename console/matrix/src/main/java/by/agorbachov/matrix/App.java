package by.agorbachov.matrix;

import java.util.Scanner;

/**
 * 
 * @author Andrey Gorbachov
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = 0;
		int n = 0;
		try {
			m = Integer.parseInt(args[0]);
			n = Integer.parseInt(args[1]);
		} catch (Exception e) {
			System.out.print("M = ");
			m = in.nextInt();
			System.out.print("N = ");
			n = in.nextInt();
		}
		Matrix matrix = new Matrix(m, n);
		int array[][] = new int[m][n];
		System.out.println("Enter the matrix: ");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = in.nextInt();
			}
		}
		matrix.setArray(array);
		System.out.println("Matrix: ");
		matrix.print();
		System.out.println("Min: " + matrix.searchMin());
		matrix.deleteColumn();
		System.out.println("Result: ");
		matrix.print();
		in.close();
	}
}
