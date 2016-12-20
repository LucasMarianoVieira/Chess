public class Rei extends Peca{
	
	
	public Rei(int cor,int x,int y){
		super(cor,x,y);
		
	}
	
	@Override
	public boolean isMovValido(Tabuleiro t,int toX, int toY){
        int xOffset=Math.abs(this.getX()-toX);
		int yOffset=Math.abs(this.getY()-toY);
		
		
		if(xOffset==0 && yOffset==0){
			return false;
		}
		if(xOffset>1 || yOffset>1){
		    return false;
		}
		if(t.lugares[toX][toY].isOcupado() && t.lugares[toX][toY].getPeca().getCor()==this.getCor() ){
		    return false;
		}
		             
        		
		return true;
	}
	
	@Override
	public String printPeca(){
		if(this.getCor()==1){
			return "K";
		}else{
			return "k";
		}
	}
	
}
