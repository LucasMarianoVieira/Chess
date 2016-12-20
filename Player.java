import java.util.Scanner;


public class Player{
	private String nome;
	private int cor;
	private boolean xeque;
	private Canvas inter;
	
	public Peca[] pecas=new Peca[17];
	public Peca rei;

	
	public Player(int cor, String nome,Canvas inter){
		this.nome=nome;
		this.cor=cor;
		this.xeque=false;
		this.inter=inter;
		
		int c;
		for(c=1;c<17;c++){
			this.pecas[c]=null;
		}
		
		c=1;
		if(this.cor==1){
			this.pecas[c]=(new Torre(this.cor,c++,1));
			this.pecas[c]=(new Cavalo(this.cor,c++,1));
			this.pecas[c]=(new Bispo(this.cor,c++,1));
			this.rei=new Rei(this.cor,c,1);
			this.pecas[c++]=(this.rei);
			this.pecas[c]=(new Rainha(this.cor,c++,1));
			this.pecas[c]=(new Bispo(this.cor,c++,1));
			this.pecas[c]=(new Cavalo(this.cor,c++,1));
			this.pecas[c]=(new Torre(this.cor,c++,1));
		
		
		
			for(c=1;c<9;c++){
				this.pecas[c+8] =new Peao(this.cor,c,2,true);
			}
		}else{
			this.pecas[c]=(new Torre(this.cor,c++,8));
			this.pecas[c]=(new Cavalo(this.cor,c++,8));
			this.pecas[c]=(new Bispo(this.cor,c++,8));
			this.rei=new Rei(this.cor,c,8);
			this.pecas[c++]=(this.rei);
			this.pecas[c]=(new Rainha(this.cor,c++,8));
			this.pecas[c]=(new Bispo(this.cor,c++,8));
			this.pecas[c]=(new Cavalo(this.cor,c++,8));
			this.pecas[c]=(new Torre(this.cor,c++,8));
		
		
		
			for(c=1;c<9;c++){
				this.pecas[c+8] =new Peao(this.cor,c,7,false);
			}
		}
	}
	public void setXeque(boolean b){
		this.xeque=b;
	}
	public boolean isXeque(){
		return this.xeque;
	}
	public boolean isXequeMate(){
		return this.rei.isCapturada();
	}
	public int getCor(){
		return this.cor;
	}
	public String printNome(){
		return this.nome;
	}
	public Move gerarMov(){
				
		this.inter.setReady(true);
		while(this.inter.isReady()){
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
			
			}
		}
		
		Move m=this.inter.getMove();	
		return m;
	}
	
}
