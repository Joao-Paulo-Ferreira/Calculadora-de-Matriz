import java.util.Scanner;

/**
 * Classe com m�todos que realizam algumas opera��es com matrizes como: classifica��o,
 * soma, subtra��o, multiplica��o, exibir a transposta da matriz e a 
 * diagonal prim�ria e secund�ria.
 * @author Jo�o Paulo Ferreira de Moraes - TADS/2
 * Cria��o 27/04/2021
 */

public class GerenciaMatriz {
	
	public static void preencheMatriz(int matriz[][], int linha, int coluna){
		Scanner input = new Scanner(System.in);
		
		//M�todo respons�vel por preencher a matriz
		for(int i = 0; i<linha; i++) {
			for(int j = 0; j<coluna; j++) {
				System.out.print("\nInforme os valores da matriz da " + (i + 1) 
						+ "� linha e da " + (j + 1) + "� coluna:");
				matriz[i][j] = input.nextInt();
				while(matriz[i][j] < (-100) || matriz[i][j] > 100) {
					//Repete a entrada de valores da matriz caso seja informado um valor fora do intervalo
					System.out.println("\nValor informado fora do intervalo de - 100 at� 100!");
					System.out.print("Informe os valores da matriz da " + (i + 1) 
							+ "� linha e da " + (j + 1) + "� coluna:");
					matriz[i][j] = input.nextInt();
				}		
			}
		}
		
	}
	
	public static String tipoMatriz(int matriz[][], int linha, int coluna) {
		String tipoMat = "";

		//Classifica��o da matriz 
		if(linha == coluna || (linha == 1 && coluna == 1)) {
			//Verifica se linha � igual coluna ou se ambos s�o iguais a 1
			tipoMat = "\nTipo de Matriz ==> Matriz QUADRADA!";
		}else if(linha == 1 && coluna != 1){
			//Verifica se � uma matriz linha
			tipoMat = "\nTipo de Matriz ==> Matriz LINHA!";
		}else if(coluna == 1 && linha != 1) {
			//Verifica se � uma matriz coluna
			tipoMat = "\nTipo de Matriz ==> Matriz COLUNA!";
		}else {
			//Caso n�o seja nehuma da verifica��es acima, verifica se a matriz � nula
			int primeiroElemento = matriz[0][0]; //Recebe o primeiro n�meor da matriz
			boolean tudoIgual = true;
			for(int i = 0; i<linha; i++) {
				for(int j = 0; j<coluna; j++) {
					if(matriz[i][j] != primeiroElemento) {
						//Verifica se os elementos da matriz s�o diferentes ao primeiro elemento
						tudoIgual = false;
					}
				}
			}
			
			if(tudoIgual && primeiroElemento == 0) {
				//Verifica se todos os elementos da matriz s�o iguais e se o 1� elemento � zero
				tipoMat = "\nTipo de Matriz ==> Matriz NULA!";
			}else {
				tipoMat = "\nTipo de Matriz ==> Matriz COMUM!";
			}
		}
		return tipoMat;
	}
	
	public static int[][] somaMatrizes(int[][] mat1, int[][] mat2, int linha, int coluna){
		//M�todo que realiza a opera��o de soma
		int[][] matSoma = new int[linha][coluna];
		for(int i = 0; i<linha; i++) {
			for(int j = 0; j<coluna; j++) {
				matSoma[i][j] = mat1[i][j] + mat2[i][j];
			}
		}
		return matSoma;
	}

	public static int[][] subtraiMatrizes(int[][] mat1, int[][]mat2, int linha, int coluna) {
		//M�todo que realiza a opera��o de subtra��o
		int[][] matSub = new int[linha][coluna];
		for(int i = 0; i<linha; i++) {
			for(int j = 0; j<coluna; j++) {
				matSub[i][j] = mat1[i][j] - mat2[i][j];
			}
		}
		return matSub;
	}

	public static int[][] multiplicaMatrizes (int[][] mat1, int[][] mat2, int linha, int coluna, int multCol) {
		//M�todo que realiza a opera��o de multiplica��o
		//Multiplica��o de duas matrizes
		int[][] matMult = new int [linha][multCol];
		for(int i = 0; i<linha; i++) {
			for(int j = 0; j<multCol; j++) {
				matMult[i][j] = 0;
				for(int k = 0; k<coluna; k++) { //Referente ao n�mero de colunas da matriz principal
					matMult[i][j] += mat1[i][k] * mat2[k][j];	
				}
			}
		}
		return matMult;
	}

	public static int[][] matrizTransposta(int[][] matriz, int linha, int coluna) {
		//M�todo respons�vel pela transposta da matriz
		int[][] mat = new int [coluna][linha];
		//Cria a matriz transposta 
		for(int i = 0; i<coluna; i++) {
			for(int j = 0; j<linha; j++) {
				mat[i][j] = matriz[j][i];
			}
		}
		return mat;
	}

	public static String diagonalMatriz(int[][] mat1, int linha) {
		//M�todo respons�vel pela diagonal principal e secund�ria da matriz
		String str = "Diagonal Principal ==> [";

		//Pega somente os valores da diagonal principal da matriz
		for(int i = 0; i<linha; i++) {
			//str recebe os valores onde linha � igual a coluna no caso (i == i)
			str += mat1[i][i] + ",";
		}
		str = str.substring(0, str.length()-1) + "]"; //Retira a o �ltimo elemento da string no caso a ","

		str += "\nDiagonal Secund�ria ==> [";
		//Pega somente os valores da diagonal secund�ria da matriz
		for(int i = 0; i<linha; i++) {
			//Str recebe os valores referentes a �ltima coluna e a cada linha decrementa-se a coluna
			str += mat1[i][linha - (i+1)] + ",";
		}
		str = str.substring(0, str.length()-1) + "]"; //Retira a o �ltimo elemento da string no caso a ","
		return str;	
	}
}
