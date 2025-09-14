package org.example;

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class Main
{
    public static void main(String[] args)
    {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter rows: ");
            int rows = scanner.nextInt();
            if (rows < 0) throw new Exception("Rows must be positive!");
            System.out.print("Enter columns: ");
            int cols = scanner.nextInt();
            if (cols < 0) throw new Exception("Columns must be positive!");
            int[][] matrix = generateMatrix(rows, cols);
            printMatrix(matrix, rows, cols);
            System.out.print("Monotonic columns: ");
            boolean atLeastOneCol = false;
            for (int j = 0; j < cols; j++) {
                if (isColumnMonotonic(matrix, rows, j)) {
                    System.out.print(j + 1);
                    atLeastOneCol = true;
                }
                if (atLeastOneCol && j != cols - 1 && isColumnMonotonic(matrix, rows, j + 1)) {
                    System.out.print(", ");
                }
            }
            if (atLeastOneCol) System.out.println(".");
            else System.out.println("none!");
        }
        catch (InputMismatchException e)
        {
            System.out.println("Error: Invalid input!");
        }
        catch (Exception e)
        {
            System.out.print("Error: " + e.getMessage());
        }
    }

    private static int[][] generateMatrix(int rows, int cols)
    {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++) matrix[i][j] = rand.nextInt(100); // Numbers between 0-99
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix, int rows, int cols)
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    protected static boolean isColumnMonotonic(int[][] matrix, int rows, int colIndex)
    {
        if (rows == 0) return false;
        if (rows == 1) return true;
        boolean directionSet = false;
        boolean direction = false;
        for (int i = 1; i < rows; i++)
        {
            int previous = matrix[i - 1][colIndex];
            int current = matrix[i][colIndex];
            if (!directionSet && previous != current)
            {
                if (previous < current) direction = true;
                directionSet = true;
            }
            if (directionSet) if ((direction && previous > current) ||  (!direction && previous < current)) return false;
        }
        return true;
    }
}