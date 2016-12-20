import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JOptionPane;


public class Chess{
	public static void main(String[] args){
		Player p1,p2;
		JFrame janela;
		Canvas can;
		Tabuleiro t;
		
		JLabel labelJogadorAtual;
		JLabel labelJogadorCheque0;
		JLabel labelJogadorCheque1;
		JLabel labelXequeMate;
		
		JPanel p;
		JPanel pLateral;
		
		boolean con;
		boolean repete=false;
		do{
			janela= new JFrame("Xadrez");
			can=new Canvas();
			p1=new Player(1,"Jogador 1: Preto",can);
			p2=new Player(0,"Jogador 2: Branco",can);
			t=new Tabuleiro(p1,p2);
			
			labelJogadorAtual=new JLabel("Jogador atual: "+t.getPlayerAtual().printNome());
			labelJogadorAtual.setPreferredSize(new Dimension(230,50));
			
			labelJogadorCheque0=new JLabel("");
			labelJogadorCheque0.setPreferredSize(new Dimension(230,50));
			
			labelJogadorCheque1=new JLabel("");
			labelJogadorCheque1.setPreferredSize(new Dimension(230,50));
			
			labelXequeMate=new JLabel("");
			labelXequeMate.setPreferredSize(new Dimension(230,50));
			
			p=new JPanel();
			pLateral=new JPanel();
			
			p.setPreferredSize(new Dimension(650,320));
			pLateral.setPreferredSize(new Dimension(230,320));
			
			p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
			pLateral.setLayout(new BoxLayout(pLateral,BoxLayout.Y_AXIS));
			
			pLateral.add(labelJogadorAtual);
			pLateral.add(labelJogadorCheque1);
			pLateral.add(labelJogadorCheque0);
			pLateral.add(labelXequeMate);
			
			p.add(can);
			p.add(pLateral);
			
			janela.add(p);
			janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			janela.pack();
			janela.setVisible(true);
			
			t.desenharTabuleiro(can);
			
			con=true;
			while(con){
				if(p1.isXeque()){
					labelJogadorCheque1.setText("Jogador 1 Xeque");
				}else{
					labelJogadorCheque1.setText("");
				}
				if(p2.isXeque()){
					labelJogadorCheque0.setText("Jogador 2 Xeque ");
				}else{
					labelJogadorCheque0.setText("");
				}
				
				labelJogadorAtual.setText("Jogador atual: "+t.getPlayerAtual().printNome());
							
				if(t.nextMov()){
					if(!t.isXequeMate()){
						t.trocarVez();
						
					}else{
						con=false;
					}
				}
				t.desenharTabuleiro(can);
			}
			
			labelXequeMate.setText("XequeMate \n");
			labelXequeMate.setText(labelXequeMate.getText()+"Vencedor: "+t.getPlayerAtual().printNome());
						
			if(JOptionPane.showConfirmDialog(null,"Novo Jogo?","XequeMate",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				janela.dispose();
				repete=true;
			}else{
				janela.dispose();
				repete=false;
			}
		}while(repete);
	}
}
