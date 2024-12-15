package org.firstinspires.ftc.teamcode;

public class LinearAlgebra {
        // Function to multiply
        // two matrices A[][] and B[][]
        static double[][] multiplyMatrix(int row1, int col1,
                                   double A[][], int row2,
                                   int col2, double B[][])
        {

            // Matrix to store the result
            // The product matrix will
            // be of size row1 x col2
            double C[][] = new double[row1][col2];

            // Multiply the two matrices
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col2; j++) {
                    for (int k = 0; k < row2; k++)
                        C[i][j] += A[i][k] * B[k][j];
                }
            }
            return C;
        }


    static double[][] substractMatrix(int row1, int col1,
                                     double A[][], int row2,
                                     int col2, double B[][])
    {

        // Matrix to store the result
        // The product matrix will
        // be of size row1 x col2
        double C[][] = new double[row1][col2];

        // Multiply the two matrices
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                C[i][j] += A[i][j] - B[i][j];
            }
        }
        return C;
    }

}
