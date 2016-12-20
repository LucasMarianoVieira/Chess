import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Color;


class Canvas extends JPanel{
	private Move m;
	private Tabuleiro t;
	private boolean first;
	private boolean ready;
	
	public Canvas(){
		this.m=new Move(1,1,1,1);
		setPreferredSize(new Dimension(320,320));
		this.ready=false;
		this.first=true;
		
		this.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				int x=e.getX()/40+1;
				int y=e.getY()/40+1;
				
				if(ready){
					if(first){
						if(t.lugares[x][y].isOcupado()&& t.lugares[x][y].getPeca().getCor()==t.getPlayerAtual().getCor()){
							m.fromX=x;
							m.fromY=y;
							first=false;
							draw(t);
						}
					}else{
						
						m.toX=x;
						m.toY=y;
						first=true;
						
						if(!(m.toX==m.fromX && m.toY==m.fromY)){
							ready=false;
						}
						draw(t);
					}
				}
			}
		});
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawImages(g);
	}
	private void drawImages(Graphics g){
		
		Image i = new ImageIcon("pecas/board.gif").getImage();
		g.drawImage(i,0,0,320,320,0,0,320,320,null);
		
		for(int c=1;c<9;c++){
			for(int d=1;d<9;d++){
				if(this.t.lugares[c][d].isOcupado()){
					Peca p=this.t.lugares[c][d].getPeca();
					Image a=null;
					int x=c-1;
					x=x*40;
					int y=d-1;
					y=y*40;
					if(p.getCor()==1){
						a = new ImageIcon("pecas/"+p.printPeca()+"b.png").getImage();
					}else{
						a = new ImageIcon("pecas/"+p.printPeca()+"w.png").getImage();
					}
					g.drawImage(a,x,y,40,40,null);
					
				}
			}
		}
		
		if(this.isReady() && !this.first){
			g.setColor(Color.RED);
			g.drawRect((this.m.fromX-1)*40,(this.m.fromY-1)*40,39,39);
		}
			
		
	}
	public void draw(Tabuleiro t){
		this.t=t;	
		this.repaint();
	}
	public Move getMove(){
		return this.m;
	}
	public void setReady(boolean b){
		this.ready=b;
	}
	public boolean isReady(){
		return this.ready;
	}
	
}
