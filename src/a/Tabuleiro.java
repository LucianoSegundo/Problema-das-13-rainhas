package a;

public class Tabuleiro {

	int[][] tabuleiro;
	int altura = 0;
	int largura = 0;
	int injesoes = 0;
	int maximo = 0;
	int nivel = 0;

	Tabuleiro pai;
	
	public Tabuleiro() {
		this.tabuleiro = new int[8][8];
		this.altura = this.tabuleiro.length;
		this.largura = this.tabuleiro[0].length;

	}

	public Tabuleiro(int tamanho) {
		this.tabuleiro = new int[tamanho][tamanho];
		this.altura = this.tabuleiro.length;
		this.largura = this.tabuleiro[0].length;

	}

	public Tabuleiro(Tabuleiro tabu) {
		
		this.altura = tabu.altura;
		this.largura = tabu.largura;
		this.pai = tabu;
		this.injesoes = pai.injesoes;
		
		this.tabuleiro = new int[altura][largura];
		
		for(int i = 0; i< altura; i++) {
			for(int j = 0; j< altura; j++) {
				tabuleiro[i][j] = tabu.tabuleiro[i][j];
				
			}
		}
		
	}
	
	public boolean assumir(int x, int y) {

		if (x >= 0 && x < this.largura && y >= 0 && y < this.altura) {
			if(this.tabuleiro[y][x] == 1 || this.tabuleiro[y][x] == 2) return false;
			else {

				for (int i = 0; i < largura; i++) {

					// horizontalmente
					if (x != i && this.tabuleiro[y][i] != 2)
						this.tabuleiro[y][i] = 1;

					// verticalmente
					if (y != i && this.tabuleiro[i][x] != 2)
						this.tabuleiro[i][x] = 1;

				}

				for (int i = 1; i < largura; i++) {

					if (y + i < altura && x - i >= 0)
						if(this.tabuleiro[y + i][x - i] != 2) this.tabuleiro[y + i][x - i] = 1;

					if (y - i >= 0 && x + i < largura)
						if(this.tabuleiro[y - i][x + i] != 2)this.tabuleiro[y - i][x + i] = 1;

					if (y - i >= 0 && x - i >= 0)
						if(this.tabuleiro[y - i][x - i] != 2)this.tabuleiro[y - i][x - i] = 1;

					if (y + i < altura && x + i < largura)
						if(this.tabuleiro[y + i][x + i] != 2)this.tabuleiro[y + i][x + i] = 1;

				}

				this.injesoes++;
				this.tabuleiro[y][x] = 2;
				
				return true;

			} 

		}
		else return false;
		
	}
	
	@Override
	public String toString() {
			
		if(this.pai!= null) pai.toString();
		String mensagem = "";
		
		for(int i = 0; i < altura; i++) {
			
			for(int j = 0; j < altura; j++) {
				 String caracter = " ";
				 
				if(this.tabuleiro[i][j] == 1) caracter = "x";
				else if(this.tabuleiro[i][j] == 2) caracter = "R";
				
				if(j == altura -1) mensagem += caracter;
				else mensagem += caracter + " , ";
				
			}
			
			mensagem += "\n";
			
		}
		
		System.out.println();
		System.out.println("nivel "+ (nivel+1) +" de "+ maximo);
		System.out.println(mensagem);
		System.out.println();

		return mensagem;
	}
}
