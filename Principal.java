import java.util.Scanner;

/**
 * Classe com menu interativo com o usuário
 * @author João Paulo Ferreira de Moraes - TADS/2
 * Criação 27/04/2021
 */

public class Principal {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		int linha, coluna, multCol;
		int i, j, opc;
		int[][] matP = null;
		int[][] matSe = null;
		int[][] matResult;
		String result = "";

		System.out.printf("%75s", "=-=-=-=-=-=-=-=-=-=- Calculadora de Matriz -=-=-=-=-=-=-=-=-=-=-=-=");
		do {
			//Opções de operações possíveis
			System.out.print("\n1-Classificar a matriz"
					+ "\n2-Somar com outra matriz (Possível realizar se as matrizes forem de mesma ordem)"
					+ "\n3-Subtrair com outra matriz (Possível realizar se as matrizes forem de mesma ordem)"
					+ "\n4-Multiplicar com outra matriz"
					+ "\n5-Mostrar a transposta da matriz"
					+ "\n6-Mostrar a diagonal principal e secundária da matriz"
					+ "\n0-Sair do programa"
					+ "\n  Informe a operação que deseja realizar: ");
			opc = input.nextInt();

			if(opc > 0 && opc < 7){
				//Informando a quantidade de linhas da matriz
				System.out.print("\nInforme a quantidade de linhas da sua matriz: ");
				linha = input.nextInt();
				while(linha <= 0) {
					//Repete a entrada de linha caso o usuário informe um número menor ou igual a zero
					System.out.println("\nNão é possível criar a matriz!");
					System.out.print("Informe novamente a quantidade de linhas da sua matriz: ");
					linha = input.nextInt();
				}
				//Informando a quantidade de colunas da matriz
				System.out.print("\nInforme a quantidade de colunas da sua matriz: ");
				coluna = input.nextInt(); 
				while(coluna <= 0) {
					//Repete a entrada de coluna caso o usuário informe um número menor ou igual a zero
					System.out.println("\nNão é possível criar a matriz!");
					System.out.print("Informe novamente a quantidade de colunas da sua matriz: ");
					coluna = input.nextInt();
				}
				System.out.println();
				
				switch(opc) {
				case 1:
					matP = new int[linha][coluna];
					GerenciaMatriz.preencheMatriz(matP, linha, coluna);
					result = GerenciaMatriz.tipoMatriz(matP, linha, coluna);
					System.out.println(result);
					break;
				case 2:
					matP = new int[linha][coluna];
					matSe = new int[linha][coluna];
					GerenciaMatriz.preencheMatriz(matP, linha, coluna);
					System.out.println("\nPreenchendo a 2ª Matriz");
					GerenciaMatriz.preencheMatriz(matSe, linha, coluna);
					matResult = GerenciaMatriz.somaMatrizes(matP, matSe, linha, coluna);
					
					System.out.println("\n=-=SOMA DAS MATRIZES=-=");
					for(i = 0; i<linha; i++) {
						for(j = 0; j<coluna; j++) {
							System.out.printf("|%3d", matResult[i][j]);
						}
						System.out.println("|");
					}
					break;
				case 3:
					matP = new int[linha][coluna];
					matSe = new int[linha][coluna];
					GerenciaMatriz.preencheMatriz(matP, linha, coluna);
					System.out.println("\nPreenchendo a 2ª Matriz");
					GerenciaMatriz.preencheMatriz(matSe, linha, coluna);
				
					matResult = GerenciaMatriz.subtraiMatrizes(matP, matSe, linha, coluna);
					System.out.println("\n=-=SUBTRAÇÃO DAS MATRIZES=-=");
					for(i = 0; i<linha; i++) {
						for(j = 0; j<coluna; j++) {
							System.out.printf("|%3d", matResult[i][j]);
						}
						System.out.println("|");
					}
					break;
				case 4:
					matP = new int[linha][coluna];
					GerenciaMatriz.preencheMatriz(matP, linha, coluna);
					
					System.out.print("\nAo escolher a opção de multiplicação o número de linhas da "
							+ "2ª Matriz será igual ao número de colunas da 1ª Matriz");
					System.out.print("\nInforme quantas colunas terá a matriz para multiplicação: ");
					multCol = input.nextInt();
					//Caso o número de colunas seja menor ou igual a zero, repete a entrada de colunas
					while(multCol <= 0) {
						System.out.println("\nNão é possível criar a matriz!");
						System.out.print("Informe novamente quantas colunas terá a matriz para multiplicação: ");
						multCol = input.nextInt();
					}

					System.out.println("\nPreenchendo a 2ª Matriz");
					//Cria e preenche a matriz
					matSe = new int[coluna][multCol];
					GerenciaMatriz.preencheMatriz(matSe, coluna, multCol);
					
					matResult = GerenciaMatriz.multiplicaMatrizes(matP, matSe, linha, coluna, multCol);
					System.out.println("\n=-=MULTIPLICAÇÃO DAS MATRIZES=-=");
					for(i = 0; i<linha; i++) {
						for(j = 0; j<multCol; j++) {
							System.out.printf("|%3d", matResult[i][j]);
						}
						System.out.println("|");
					}
					break;
				case 5:
					matP = new int[linha][coluna];
					GerenciaMatriz.preencheMatriz(matP, linha, coluna);
					matResult = GerenciaMatriz.matrizTransposta(matP, linha, coluna);
					
					System.out.println("\n=-=MATRIZ ORIGINAL=-=");
					for(i = 0; i<linha; i++) {
						for(j = 0; j<coluna; j++) {
							System.out.printf("|%3d", matP[i][j]);
						}
						System.out.println("|");
					}
					
					System.out.println("\n=-=TRANSPOSTA DA MATRIZ=-=");
					for(i = 0; i<coluna; i++) {
						for(j = 0; j<linha; j++) {
							System.out.printf("|%3d", matResult[i][j]);
						}
						System.out.println("|");
					}
					break;
				case 6:
					if(linha == coluna) {
						//Verifica se a matriz é quadrada para mostrar as diagonais
						matP = new int[linha][coluna];
						GerenciaMatriz.preencheMatriz(matP, linha, coluna);
						result = GerenciaMatriz.diagonalMatriz(matP, linha);
						System.out.println(result);
					}else {
						System.out.println("Não é possível obter diagonais! Matriz não é quadrada...");
					}
					break;
				}
			}else {
				if(opc == 0) {
					System.out.println("\nPrograma Encerrado...");
				}else {
					System.out.println("\nOpção inválida! Informe novamente uma opção válida...");
				}
			}

		}while(opc != 0);
	}
}
