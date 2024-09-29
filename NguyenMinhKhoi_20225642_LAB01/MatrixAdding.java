package LAB01_NguyenMinhKhoi;

import java.util.Scanner;

public class MatrixAdding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input matrix dimensions
        System.out.println("Enter the number of rows for the matrix: ");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of columns for the matrix: ");
        int columns = scanner.nextInt();
        System.out.println("Enter the number of matrices to sum: ");
        int matricesCount = scanner.nextInt();

        // Declare the 2D sumMatrix to hold the result
        int[][] sumMatrix = new int[rows][columns];

        // Iterate over each matrix to sum them
        for (int matrixIndex = 0; matrixIndex < matricesCount; matrixIndex++) {
            System.out.println("Enter the elements of matrix " + (matrixIndex + 1) + ": ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print("Element at position [" + (i + 1) + "][" + (j + 1) + "]: ");
                    int element = scanner.nextInt(); // Read the current element
                    sumMatrix[i][j] += element; // Add it to the sumMatrix
                }
            }
        }

        // Output the sum of all matrices
        System.out.println("Sum of all matrices: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(sumMatrix[i][j] + " ");
            }
            System.out.println(); // New line after each row
        }

        scanner.close();
    }
}
