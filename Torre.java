public class Torre extends Peca{
	
	
	public Torre(int cor,int x,int y){
		super(cor,x,y);
	
	}
	
	@Override
	public boolean isMovValido(Tabuleiro t,int toX, int toY){
		int xOffset=this.getX()-toX;
		int yOffset=this.getY()-toY;
		int dir=0;
		
		if((xOffset!=0 && yOffset!=0)|| (xOffset==0 && yOffset==0)){
			
			return false;
		}
		
		if(xOffset==0){
			if(yOffset>0){
				dir=1;
			}else if(yOffset<0){
				dir=3;
			}
		}
		
		if(yOffset==0){
		
			if(xOffset>0){
				dir=4;
			}else if(xOffset<0){
				dir=2;
			}
		
		}
		
		int x=this.getX(),y=this.getY();
		
		
		Lugar l=null;
		
		while(!(x==toX && y==toY)){
			switch(dir){
				case 1:
					y--;
				break;
				case 2:
					x++;
				break;
				case 3:
					y++;
				break;
				case 4:
					x--;
				break;
			}
			if(t.lugares[x][y].isOcupado()){
				break;
			}			
		}
		
		if(x==toX && y==toY){
			if(!t.lugares[x][y].isOcupado()){
				return true;
			}

			if(t.lugares[x][y].getPeca().getCor()!=this.getCor()){
				return true;
			}
		}
		return false;
		
	}
	
	@Override
	public String printPeca(){
		if(this.getCor()==1){
			return "T";
		}else{
			return "t";
		}
	}
	
}