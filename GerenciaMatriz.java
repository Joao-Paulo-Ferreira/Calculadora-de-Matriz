import java.util.Scanner;

/**
 * Classe com métodos que realizam algumas operações com matrizes como: classificação,
 * soma, subtração, multiplicação, exibir a transposta da matriz e a 
 * diagonal primária e secundária.
 * @author João Paulo Ferreira de Moraes - TADS/2
 * Criação 27/04/2021
 */

public class GerenciaMatriz {
	
	public static void preencheMatriz(int matriz[][], int linha, int coluna){
		Scanner input = new Scanner(System.in);
		
		//Método responsável por preencher a matriz
		for(int i = 0; i<linha; i++) {
			for(int j = 0; j<coluna; j++) {
				System.out.print("\nInforme os valores da matriz da " + (i + 1) 
						+ "ª linha e da " + (j + 1) + "ª coluna:");
				matriz[i][j] = input.nextInt();
				while(matriz[i][j] < (-100) || matriz[i][j] > 100) {
					//Repete a entrada de valores da matriz caso seja informado um valor fora do intervalo
					System.out.println("\nValor informado fora do intervalo de - 100 até 100!");
					System.out.print("Informe os valores da matriz da " + (i + 1) 
							+ "ª linha e da " + (j + 1) + "ª coluna:");
					matriz[i][j] = input.nextInt();
				}		
			}
		}
		
	}
	
	public static String tipoMatriz(int matriz[][], int linha, int coluna) {
		String tipoMat = "";

		//Classificação da matriz 
		if(linha == coluna || (linha == 1 && coluna == 1)) {
			//Verifica se linha é igual coluna ou se ambos são iguais a 1
			tipoMat = "\nTipo de Matriz ==> Matriz QUADRADA!";
		}else if(linha == 1 && coluna != 1){
			//Verifica se é uma matriz linha
			tipoMat = "\nTipo de Matriz ==> Matriz LINHA!";
		}else if(coluna == 1 && linha != 1) {
			//Verifica se é uma matriz coluna
			tipoMat = "\nTipo de Matriz ==> Matriz COLUNA!";
		}else {
			//Caso não seja nehuma da verificações acima, verifica se a matriz é nula
			int primeiroElemento = matriz[0][0]; //Recebe o primeiro númeor da matriz
			boolean tudoIgual = true;
			for(int i = 0; i<linha; i++) {
				for(int j = 0; j<coluna; j++) {
					if(matriz[i][j] != primeiroElemento) {
						//Verifica se os elementos da matriz são diferentes ao primeiro elemento
						tudoIgual = false;
					}
				}
			}
			
			if(tudoIgual && primeiroElemento == 0) {
				//Verifica se todos os elementos da matriz são iguais e se o 1º elemento é zero
				tipoMat = "\nTipo de Matriz ==> Matriz NULA!";
			}else {
				tipoMat = "\nTipo de Matriz ==> Matriz COMUM!";
			}
		}
		return tipoMat;
	}
	
	public static int[][] somaMatrizes(int[][] mat1, int[][] mat2, int linha, int coluna){
		//Método que realiza a operação de soma
		int[][] matSoma = new int[linha][coluna];
		for(int i = 0; i<linha; i++) {
			for(int j = 0; j<coluna; j++) {
				matSoma[i][j] = mat1[i][j] + mat2[i][j];
			}
		}
		return matSoma;
	}

	public static int[][] subtraiMatrizes(int[][] mat1, int[][]mat2, int linha, int coluna) {
		//Método que realiza a operação de subtração
		int[][] matSub = new int[linha][coluna];
		for(int i = 0; i<linha; i++) {
			for(int j = 0; j<coluna; j++) {
				matSub[i][j] = mat1[i][j] - mat2[i][j];
			}
		}
		return matSub;
	}

	public static int[][] multiplicaMatrizes (int[][] mat1, int[][] mat2, int linha, int coluna, int multCol) {
		//Método que realiza a operação de multiplicação
		//Multiplicação de duas matrizes
		int[][] matMult = new int [linha][multCol];
		for(int i = 0; i<linha; i++) {
			for(int j = 0; j<multCol; j++) {
				matMult[i][j] = 0;
				for(int k = 0; k<coluna; k++) { //Referente ao número de colunas da matriz principal
					matMult[i][j] += mat1[i][k] * mat2[k][j];	
				}
			}
		}
		return matMult;
	}

	public static int[][] matrizTransposta(int[][] matriz, int linha, int coluna) {
		//Método responsável pela transposta da matriz
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
		//Método responsável pela diagonal principal e secundária da matriz
		String str = "Diagonal Principal ==> [";

		//Pega somente os valores da diagonal principal da matriz
		for(int i = 0; i<linha; i++) {
			//str recebe os valores onde linha é igual a coluna no caso (i == i)
			str += mat1[i][i] + ",";
		}
		str = str.substring(0, str.length()-1) + "]"; //Retira a o último elemento da string no caso a ","

		str += "\nDiagonal Secundária ==> [";
		//Pega somente os valores da diagonal secundária da matriz
		for(int i = 0; i<linha; i++) {
			//Str recebe os valores referentes a última coluna e a cada linha decrementa-se a coluna
			str += mat1[i][linha - (i+1)] + ",";
		}
		str = str.substring(0, str.length()-1) + "]"; //Retira a o último elemento da string no caso a ","
		return str;	
	}
}
