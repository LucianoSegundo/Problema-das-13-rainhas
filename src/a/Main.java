package a;

public class Main {

	
	public static void main(String[] args) throws InterruptedException {
		// modo convencional 8x8
		//	rodar();
		// Tabuleiro custumizado com uma quantidade proporcional de rainhas.
		   rodarCustumizado(32);
	}
	
	public static void rodar() throws InterruptedException {
		
		Tabuleiro aaa =procurar(new Tabuleiro(), 0, 0, 8);
		
		if(aaa != null) aaa.toString();
		else System.out.println("\n \n Não foi possivel achar um resultado.");
	}
	
	public static void rodarCustumizado(int tamanho) throws InterruptedException {
			
		if(tamanho< 8) System.out.println("O tabuleiro precisa ser maior que 8x8 para ficar interessamte.");
		
		Tabuleiro aaa =procurar(new Tabuleiro(tamanho), 0, 0, tamanho);
		
		if(aaa != null) {
			aaa.toString();
			System.out.println("concluido");
		}
		else System.out.println("\n \n Não foi possivel achar um resultado.");
	}
	
	public static Tabuleiro procurar(Tabuleiro tabu, int linha, int nivel, int profunMAx) throws InterruptedException {
		
		if(tabu.injesoes == tabu.tabuleiro.length) return tabu;
		if(profunMAx == nivel) return null;
		
		// gerar filhos
		for(int i =0 ; i< tabu.largura; i++) {
			
			Tabuleiro leiro = new Tabuleiro(tabu);

			boolean promissor = false;
							
			promissor = leiro.assumir(linha, i);
			
			if(promissor == true) {
				leiro.nivel = nivel;
				leiro.maximo = profunMAx;
				
				Tabuleiro  eiro =  procurar(leiro, linha+1, nivel+1, profunMAx);
			
				if(eiro != null) return eiro;
				
			}
		}
		
		return null;
		
	}

}
