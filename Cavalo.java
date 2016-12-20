public class Cavalo extends Peca{
	
	
	public Cavalo(int cor,int x,int y){
		super(cor,x,y);
	
	}
	
	@Override
	public boolean isMovValido(Tabuleiro t,int toX, int toY){
		
		int xOffset=Math.abs(this.getX()-toX);
		int yOffset=Math.abs(this.getY()-toY);
		
		if((xOffset==1 && yOffset==2) || (xOffset==2 && yOffset==1) ){
		   if(t.lugares[toX][toY].isOcupado()){
		   		if(t.lugares[toX][toY].getPeca().getCor()!=this.getCor()){
		   			return true;
		   		}	
		   }else{
		    	return true;
		   }
		}
		
		return false;
		
	}
	
	@Override
	public String printPeca(){
		if(this.getCor()==1){
			return "H";
		}else{
			return "h";
		}
	}
	
}
