import java.util.Scanner;

/**
 * Classe com menu interativo com o usu�rio
 * @author Jo�o Paulo Ferreira de Moraes - TADS/2
 * Cria��o 27/04/2021
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
			//Op��es de opera��es poss�veis
			System.out.print("\n1-Classificar a matriz"
					+ "\n2-Somar com outra matriz (Poss�vel realizar se as matrizes forem de mesma ordem)"
					+ "\n3-Subtrair com outra matriz (Poss�vel realizar se as matrizes forem de mesma ordem)"
					+ "\n4-Multiplicar com outra matriz"
					+ "\n5-Mostrar a transposta da matriz"
					+ "\n6-Mostrar a diagonal principal e secund�ria da matriz"
					+ "\n0-Sair do programa"
					+ "\n  Informe a opera��o que deseja realizar: ");
			opc = input.nextInt();

			if(opc > 0 && opc < 7){
				//Informando a quantidade de linhas da matriz
				System.out.print("\nInforme a quantidade de linhas da sua matriz: ");
				linha = input.nextInt();
				while(linha <= 0) {
					//Repete a entrada de linha caso o usu�rio informe um n�mero menor ou igual a zero
					System.out.println("\nN�o � poss�vel criar a matriz!");
					System.out.print("Informe novamente a quantidade de linhas da sua matriz: ");
					linha = input.nextInt();
				}
				//Informando a quantidade de colunas da matriz
				System.out.print("\nInforme a quantidade de colunas da sua matriz: ");
				coluna = input.nextInt(); 
				while(coluna <= 0) {
					//Repete a entrada de coluna caso o usu�rio informe um n�mero menor ou igual a zero
					System.out.println("\nN�o � poss�vel criar a matriz!");
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
					System.out.println("\nPreenchendo a 2� Matriz");
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
					System.out.println("\nPreenchendo a 2� Matriz");
					GerenciaMatriz.preencheMatriz(matSe, linha, coluna);
				
					matResult = GerenciaMatriz.subtraiMatrizes(matP, matSe, linha, coluna);
					System.out.println("\n=-=SUBTRA��O DAS MATRIZES=-=");
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
					
					System.out.print("\nAo escolher a op��o de multiplica��o o n�mero de linhas da "
							+ "2� Matriz ser� igual ao n�mero de colunas da 1� Matriz");
					System.out.print("\nInforme quantas colunas ter� a matriz para multiplica��o: ");
					multCol = input.nextInt();
					//Caso o n�mero de colunas seja menor ou igual a zero, repete a entrada de colunas
					while(multCol <= 0) {
						System.out.println("\nN�o � poss�vel criar a matriz!");
						System.out.print("Informe novamente quantas colunas ter� a matriz para multiplica��o: ");
						multCol = input.nextInt();
					}

					System.out.println("\nPreenchendo a 2� Matriz");
					//Cria e preenche a matriz
					matSe = new int[coluna][multCol];
					GerenciaMatriz.preencheMatriz(matSe, coluna, multCol);
					
					matResult = GerenciaMatriz.multiplicaMatrizes(matP, matSe, linha, coluna, multCol);
					System.out.println("\n=-=MULTIPLICA��O DAS MATRIZES=-=");
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
						//Verifica se a matriz � quadrada para mostrar as diagonais
						matP = new int[linha][coluna];
						GerenciaMatriz.preencheMatriz(matP, linha, coluna);
						result = GerenciaMatriz.diagonalMatriz(matP, linha);
						System.out.println(result);
					}else {
						System.out.println("N�o � poss�vel obter diagonais! Matriz n�o � quadrada...");
					}
					break;
				}
			}else {
				if(opc == 0) {
					System.out.println("\nPrograma Encerrado...");
				}else {
					System.out.println("\nOp��o inv�lida! Informe novamente uma op��o v�lida...");
				}
			}

		}while(opc != 0);
	}
}
