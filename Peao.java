public class Peao extends Peca{
	private boolean paraBaixo;
	
	public Peao(int cor,int x,int y,boolean paraBaixo){
		super(cor,x,y);
		this.paraBaixo=paraBaixo;
	}
	
	@Override
	public boolean isMovValido(Tabuleiro t,int toX, int toY){
		
		
		if(paraBaixo){
			if(toY<=this.getY()){
				return false;
			}
			
			if(toX==this.getX()){
				
				if(this.getY()==2){
					if((toY-this.getY())==1 && !t.lugares[toX][toY].isOcupado() ){
						return true;
					}else if((toY-this.getY())==2 && !t.lugares[toX][toY].isOcupado() && !t.lugares[toX][toY-1].isOcupado() ){
						return true;
					}
				}else if((toY-this.getY())==1 && !t.lugares[toX][toY].isOcupado() ){
					
					return true;
				}
								
			}else{
				
				if( (toY-this.getY()==1) && Math.abs(this.getX()-toX)==1){
					if(t.lugares[toX][toY].isOcupado() && t.lugares[toX][toY].getPeca().getCor()!=this.getCor()){
						return true;
					}
				}
			}
			
		}else{
			if(toY>=this.getY()){
				return false;
			}
			
			if(toX==this.getX()){
				if(this.getY()==7){
					if((toY-this.getY())==-1 && !t.lugares[toX][toY].isOcupado() ){
						return true;
					}else if((toY-this.getY())==-2 && !t.lugares[toX][toY].isOcupado() && !t.lugares[toX][toY+1].isOcupado() ){
						return true;
					}
				}else if((toY-this.getY())==-1 && !t.lugares[toX][toY].isOcupado() ){
					return true;
				}
								
			}else{
				if( (toY-this.getY()==-1) && Math.abs(this.getX()-toX)==1){
					if(t.lugares[toX][toY].isOcupado() && t.lugares[toX][toY].getPeca().getCor()!=this.getCor()){
						return true;
					} 
				}
			}
			
		}
		
		return false;
		
	}
	
	@Override
	public String printPeca(){
		if(this.getCor()==1){
			return "P";
		}else{
			return "p";
		}
	}
	
}