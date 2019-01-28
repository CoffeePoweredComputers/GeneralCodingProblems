import java.util.Random;
import java.lang.Math;

class SquareMatrixMultiply{

	//performs a brute force matrix multiplication of the two matricies
	static public int[][] matrixMultiplyBrute(int[][] m1, int[][] m2){

		int[][] product = new int[m1.length][m2.length];
		if(m1.length == m2.length){

			for(int r = 0; r < product.length; r++){
				for(int c = 0; c < product[r].length; c++){
					product[r][c] = 0;
					for(int k = 0; k < product.length; k++){
						product[r][c] += m1[r][k] + m2[k][c];
					}
				}
			}

		} else{

			System.exit(-1);
		}

		return product;

	}

	//performs a recursive matrix multiplication
	static public int[][] matrixMultiplyRecurs(int[][] m1, int[][] m2){

		int[][] n = m1.length;
		int[][] C = new int[n][n];

		if(n == 1){	
			return C[1][1] = m1[1][1] * m2[1][1]; 
		} else{


			//create our nest nxn subarrays
			int[][] A11 = new int[n/2][n/2];
			int[][] A12 = new int[n/2][n/2];
			int[][] A21 = new int[n/2][n/2];
			int[][] A22 = new int[n/2][n/2];
			int[][] B11 = new int[n/2][n/2];
			int[][] B12 = new int[n/2][n/2];
			int[][] B21 = new int[n/2][n/2];
			int[][] B22 = new int[n/2][n/2];



		}
		return product;
	}

	static public void main(String [] args){

		//some variables
		Random rand = new Random(System.currentTimeMillis());
		int[][] matrix2 = new int[2][2];
		int[][] matrix1 = new int[2][2];


		//generate a random matrix of NxN size
		for(int r = 0; r < matrix2.length; r++){
			for(int c = 0; c < matrix2[r].length; c++){
				matrix1[r][c] = rand.nextInt(1500);
			}
		}

		//generate a random matrix of NxN size
		for(int r = 0; r < matrix2.length; r++){
			for(int c = 0; c < matrix2[r].length; c++){
				matrix2[r][c] = rand.nextInt(1500);
			}
		}


		//Get the output and show it
		int[][] product_brute = matrixMultiplyBrute(matrix1,matrix2);
		System.out.print("[ ");
		for(int r = 0; r < product_brute.length; r++){
			for(int c = 0; c < product_brute.length; c++){
				System.out.printf("%d, ",matrix2[r][c]);
			}
		}
		System.out.println(" ]");

		//get the output for  the recursive algorith and show it
		int[] product_recurs = matrixMultiplyRecurs(matrix1,matrix2);


	}
}
