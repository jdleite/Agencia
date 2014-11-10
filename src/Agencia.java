import java.text.DecimalFormat;
import java.util.Scanner;

public class Agencia {
	static Scanner e = new Scanner(System.in);
	static DecimalFormat df = new DecimalFormat("R$#,##0.00"); 
	public static void main(String args[]) {
		String[] carros = new String[] { "Uno", "Palio", "Siena", "Brava",
				"Strada", "Idea" };
		double[] preco = new double[] { 25370, 26490, 30000, 56800, 36200,
				43890 };

		int[][] vendaTri = venda(carros);
		
		
		relatorioGerencial(carros, preco, vendaTri);
		
		
		

		

	}
	public static void ranking(double[] totVenda,String[] carros){
	  
	  double auxV = 0;
	  String auxC= null;
	  for (int tri = 0; tri < 5; tri++) {
			for (int carro = 0; carro < 4; carro++) {
				if(totVenda[carro] < totVenda[carro +1]){
					auxV = totVenda[carro];
					auxC = carros[carro]; 
					
					totVenda[carro] = totVenda[carro+1];
					carros[carro] = carros[carro +1];
					
					totVenda[carro+1] = auxV;
					carros[carro +1] = auxC;				
				}
			}
			
			
	  }
	  for(int i = 0;i<3;i++){
			System.out.println("Carro mais vendido é: " + carros[i] + "\t Valor em Vendas " + df.format(totVenda[i]));
		}
	
	}

	public static int[][] venda(String[] carros) {
		int[][] vendas = new int[3][6];

		for (int tri = 0; tri < 3; tri++) {
			System.out.println("Vendas do " + (tri + 1) + " trimestre");
			for (int carro = 0; carro < 6; carro++) {
				System.out.print("Carro - " + carros[carro] + ":");
				vendas[tri][carro] = e.nextInt();

			}
		}

		return vendas;
	}

	public static double[] vendaTot(double[] preco, int[][] vendaTri) {
		double[] totVenda = new double[6];
		for (int carro = 0; carro < 6; carro++) {
			for (int tri = 0; tri < 3; tri++) {
				totVenda[carro] += (preco[carro] * vendaTri[tri][carro]);

			}
		}

		return totVenda;
	}

	public static int[] quanVenda(int[][] vendaTri) {
		int[] quantTot = new int[6];
		for (int carro = 0; carro < 6; carro++) {
			for (int tri = 0; tri < 3; tri++) {
				quantTot[carro] += vendaTri[tri][carro];
			}
		}
		return quantTot;
	}
	
	public static  int[] totTrimeste(int[][] vendaTri ){
		int[] totTrimestre = new int[3];
		for (int tri = 0; tri < 3; tri++) {
			for (int carro = 0; carro < 6; carro++) {
				totTrimestre[tri] += vendaTri[tri][carro];
				
			}
		}
		
		return totTrimestre;
	}
	public static void relatorioGerencial(String[] carros,double[] preco,int[][] vendaTri){
		double totalGeral= 0;
		int[] totQuantidade = quanVenda(vendaTri);
		

		double[] totalVendas = vendaTot(preco, vendaTri);
		

		int[] totTrimestre = totTrimeste(vendaTri);
		System.out.println("----------RELATORIO GERAL------------------");
		
		for(int i = 0;i<6;i++){
			System.out.println("Carro - " + carros[i] +"\t Quantidade geral - " +totQuantidade[i] + "\t Total R$" + totalVendas[i] );
			totalGeral += totalVendas[i];
		}
		System.out.println("----------TOTAL GERAL------------");
		
		System.out.println("Total geral das vendas para 2014 R$" + totalGeral);
		System.out.println("--------------RANKING DAS VENDAS---------------");
		ranking(totalVendas, carros);
		
		
	}
	

}
