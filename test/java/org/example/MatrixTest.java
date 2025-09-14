package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest
{
    @Test
    public void testMonotonicColumn() {
        int[][] matrix1 = {{1, 3}, {2, 5}, {3, 1}, {4, 7}};
        assertTrue(Main.isColumnMonotonic(matrix1, 3, 0));

        int[][] matrix2 = {{0, 5}, {999, 3}, {123, 1}};
        assertTrue(Main.isColumnMonotonic(matrix2, 3, 1));
    }

    @Test
    public void testConstantColumn() {
        int[][] matrix1 = {{0}, {0}, {0}, {0}, {0}, {0}, {0}};
        assertTrue(Main.isColumnMonotonic(matrix1, 7, 0));

        int[][] matrix2 = {{5}, {5}, {5}, {5}, {5}};
        assertTrue(Main.isColumnMonotonic(matrix2, 5, 0));
    }
    @Test
    public void testSingleLargeElement()
    {
        int[][] matrix = {{2147483647}};
        assertTrue(Main.isColumnMonotonic(matrix, 1, 0));
    }

    @Test
    public void testMixed()
    {
        int[][] matrix = {{1, 4, 2, 6}, {5, 2, 5, 2}, {3, 0, 8, 1}};
        assertFalse(Main.isColumnMonotonic(matrix, 3, 0));
    }

    @Test
    public void testEmpty()
    {
        int[][] matrix = {{}};
        assertFalse(Main.isColumnMonotonic(matrix, 0, 0));
    }
}