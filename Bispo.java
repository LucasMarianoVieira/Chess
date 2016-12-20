public class Bispo extends Peca{
	
	
	public Bispo(int cor,int x,int y){
		super(cor,x,y);
	}
	
	@Override
	public boolean isMovValido(Tabuleiro t,int toX, int toY){
		int xOffset=toX-this.getX();
		int yOffset=toY-this.getY();
		int dir=0;
		
		if((Math.abs(xOffset)!=Math.abs(yOffset)) || (xOffset==0 && yOffset==0)){
			return false;
		}
		
		if(xOffset>0 && yOffset>0 ){
			dir =1;
		}else if(xOffset>0 && yOffset<0){
			dir=4;
		}else if(xOffset<0 && yOffset>0){
			dir=2;
		}else{
			dir=3;
		}
		
		
		int x=this.getX(),y=this.getY();
		
		
		Lugar l=null;
		
		while(!(x==toX && y==toY)){
			switch(dir){
				case 1:
					y++;
					x++;
				break;
				case 2:
					x--;
					y++;
				break;
				case 3:
					x--;
					y--;
				break;
				case 4:
					x++;
					y--;
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
			return "B";
		}else{
			return "b";
		}
	}
	
}