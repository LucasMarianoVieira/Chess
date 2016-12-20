public class Lugar{
	private Peca peca;
	private boolean ocupado;
	
	public Lugar(){
		this.ocupado=false;
	}
	public void setPeca(Peca peca){
		this.peca=peca;
		this.setOcupado(true);	
	}
	public void setOcupado(boolean b){
		this.ocupado=b;
	}
	public boolean isOcupado(){
		return this.ocupado;
	}
	public Peca getPeca(){
		return peca;
	}
}