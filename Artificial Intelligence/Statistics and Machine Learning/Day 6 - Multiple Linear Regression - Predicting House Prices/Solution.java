/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/predicting-house-prices/problem
 */

import java.util.*;

public class Solution {
    private Matrix trainingX;
    private Matrix trainingY;
    private double[] B;
    private double[][] testData;
    
    private void getB() {
        Matrix trainingXTransposed = trainingX.transpose();
        Matrix transponsedXMultipiedByTrianingX = trainingXTransposed.multiply(trainingX);
        Matrix transponsedXMultipiedByTrianingXInverse = transponsedXMultipiedByTrianingX.inverse();
        
        Matrix transponsedXMultipiedByTrainingY = trainingXTransposed.multiply(trainingY);
        
        Matrix transponsedXMultipiedByTrianingXInverseMultipliedByTransponsedXMultipiedByTrainingY = transponsedXMultipiedByTrianingXInverse.multiply(transponsedXMultipiedByTrainingY);
        
        int n = transponsedXMultipiedByTrianingXInverseMultipliedByTransponsedXMultipiedByTrainingY.getRow();
		B = new double[n];
		for (int i = 0; i < n; i++) {
            B[i] = transponsedXMultipiedByTrianingXInverseMultipliedByTransponsedXMultipiedByTrainingY.getArray()[i][0];
        }
    }
    
    private void printResult() {
        int BLength = B.length - 1;
        int testDataCount = testData.length;
        for (int row = 0; row < testDataCount; row++) {
            double sum = B[0];
            
            for (int column = 0; column < BLength; column++) {
                sum += B[column+1] * testData[row][column]; 
            }
            
            System.out.println(sum);
        }
    }
    
    private void readInput() {
        Scanner scanner = new Scanner(System.in);
        int featureCount = scanner.nextInt();
        int trainingDataCount = scanner.nextInt();
        double[][] trainingXArray = new double[trainingDataCount][featureCount+1];
        double[] trainingYArray = new double[trainingDataCount];
        
        for (int row = 0; row < trainingDataCount; row++) {
            trainingXArray[row][0] = 1.0;
            
            for (int column = 1; column < featureCount+1; column++) {
                trainingXArray[row][column] = scanner.nextDouble();
            }
            
            trainingYArray[row] = scanner.nextDouble();
        }
        
        trainingX = new Matrix(trainingXArray, trainingDataCount, featureCount+1);
        trainingY = new Matrix(trainingYArray, trainingDataCount, 1);
        
        int testDataCount = scanner.nextInt();
        testData = new double[testDataCount][featureCount];
        
        for (int row = 0; row < testDataCount; row++) {
            for (int column = 0; column < featureCount; column++) {
                testData[row][column] = scanner.nextDouble();
            }
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.readInput();
        solution.getB();
        solution.printResult();
    }
    
    class Matrix {
        private double[][] matrix;
        private int row;
        private int column;
        
        public Matrix(int row, int column) {
            this.matrix = new double[row][column];
            this.row = row;
            this.column = column;
        }
        
        public Matrix(double[][] matrix, int row, int column) {
            this.matrix = matrix;
            this.row = row;
            this.column = column;
        }
        
        public Matrix(double[] arr, int row, int column) {
            matrix = new double[row][column];
            this.row = row;
            this.column = column;
            
            if (row == 1)
            {
                for (int i = 0; i < column; i++) {
                    matrix[0][i] = arr[i];
                }
            } else {
                 for (int i = 0; i < row; i++) {
                    matrix[i][0] = arr[i];
                }   
            }
        }
        
        public double get(int row, int column) {
            return matrix[row][column];
        }
        
        public void set(int row, int column, double value) {
            matrix[row][column] = value;
        }
        
        public double[][] getArray() {
            return matrix;
        }
        
        public double[][] getArrayCopy() {
            double[][] result = new double[row][column];
            
            for (int row = 0; row < this.row; row++) {
                for (int column = 0; column < this.column; column++) {
                    result[row][column] = matrix[row][column];
                }
            }
            
            return result;
        }
        
        public Matrix getMatrix (int[] r, int j0, int j1) {
            Matrix X = new Matrix(r.length, j1-j0+1);
            double[][] B = X.getArray();
            try {
                for (int i = 0; i < r.length; i++) {
                    for (int j = j0; j <= j1; j++) {
                        B[i][j-j0] = matrix[r[i]][j];
                    }
                }
            } catch(ArrayIndexOutOfBoundsException e) {
                throw new ArrayIndexOutOfBoundsException("Submatrix indices");
            }
            
            return X;
        }
        
        public Matrix transpose() {
            Matrix result = new Matrix(column,row);
            double[][] matrixArray = result.getArray();
            
            for (int row = 0; row < this.row; row++) {
                for (int column = 0; column < this.column; column++) {
                    matrixArray[column][row] = matrix[row][column];
                }
            }
            
            return result;
        }
        
        public Matrix multiply(Matrix multiplier) {
            Matrix result = new Matrix(row, multiplier.getColumn());
            
            for (int row = 0; row < this.row; row++) {
                for (int column = 0; column < multiplier.getColumn(); column++) {
                    double value = 0.0;
                    
                    for (int mulitplierRow = 0; mulitplierRow < multiplier.getRow(); mulitplierRow++) {
                        value += matrix[row][mulitplierRow] * multiplier.get(mulitplierRow, column);
                    }
                    result.set(row, column, value); 
                }
            }
            
            return result;
        }
        
        public Matrix inverse() {
            Matrix identity = new Matrix(row, column);
            identity.setAsIdentity();
            
            return solve(identity);
        }
        
        public void setAsIdentity() {
            for (int row = 0; row < this.row; row++) {
                for (int column = 0; column < this.column; column++) {
                    double value = (row == column) ? 1.0 : 0.0;
                    
                    set(row, column, value);
                }
            }
        }
        
        public int getRow() {
            return row;
        }
        
        public int getColumn() {
            return column;
        }
        
        public void print() {
            for (int row = 0; row < this.row; row++) {
                for (int column = 0; column < this.column; column++) { 
                    System.out.print(matrix[row][column] + " ");
                }
                
                System.out.println();
            }
        }
        
        private Matrix solve(Matrix B) {
            return (new LUSolver(this)).solve(B);
        }
    }
    
    class LUSolver {
        private double[][] LUMatrixArr;
        private int row;
        private int column;
        private int[] pivot;
        private int pivotSign;
        
        public LUSolver(Matrix matrixToDecompose) {
            LUMatrixArr = matrixToDecompose.getArrayCopy();
            row = matrixToDecompose.getRow();
            column = matrixToDecompose.getColumn();
            pivot = new int[row];
            
            for (int i = 0; i < row; i++) {
                pivot[i] = i;
            }
            
            double[] LURowi;
            double[] LUColumnj = new double[row];
            pivotSign = 1;
            
            for (int j = 0; j < column; j++) {
                for (int i = 0; i < row; i++) {
                    LUColumnj[i] = LUMatrixArr[i][j];
                }
                
                for (int i = 0; i < row; i++) {
                    LURowi = LUMatrixArr[i];
                    
                    int kmax = Math.min(i, j);
                    double s = 0.0;
                    for (int k = 0; k < kmax; k++) {
                        s += LURowi[k] * LUColumnj[k];
                    }
                    
                    LURowi[j] = LUColumnj[i] -= s;
                }
                
                int p = j;
                for (int i = j + 1; i < row; i++) {
                    if (Math.abs(LUColumnj[i]) > Math.abs(LUColumnj[p])) {
                        p = i;
                    }
                }
                
                if (p != j) {
                    for (int k = 0; k < row; k++) {
                        double t = LUMatrixArr[p][k];
                        LUMatrixArr[p][k] = LUMatrixArr[j][k];
                        LUMatrixArr[j][k] = t;
                    }
                    
                    int k = pivot[p];
                    pivot[p] = pivot[j];
                    pivot[j] = k;
                }
                
                if (j < row & LUMatrixArr[j][j] != 0.0) {
                    for (int i = j + 1; i < row; i++) {
                        LUMatrixArr[i][j] /= LUMatrixArr[j][j];
                    }
                }
            } 
        }
        
        public Matrix solve(Matrix B) {
            int Brow = B.getColumn();
            Matrix result = B.getMatrix(pivot, 0, Brow-1);
            double[][] X = result.getArray();

            for (int i = 0; i < column; i++) {
                for (int j = i+1; j < column; j++) {
                    for (int k = 0; k < Brow; k++) {
                        X[j][k] -= X[i][k] * LUMatrixArr[j][i];
                    }
                }
            }
            
            for (int i = column - 1; i >= 0; i--) {
                for (int j = 0; j < Brow; j++) {
                    X[i][j] /= LUMatrixArr[i][i];
                }
                
                for (int k = 0; k < i; k++) {
                    for (int j = 0; j < Brow; j++) {
                        X[k][j] -= X[i][j] * LUMatrixArr[k][i];
                    }
                }
            }
            
            return result;
        }
    }
    
}