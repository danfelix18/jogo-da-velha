package trabalho;

//library
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.*;

public class JogoDaVelha extends JFrame	{
	
	//creat button
	JButton [] bt = new JButton [9];
	JLabel modo = new JLabel ("Modo de Jogo:");
	JButton p1p2 = new JButton ("P1 X P2");
	JButton p1cpu = new JButton ("P1 X CPU");
	JLabel placar = new JLabel ("Placar:");
	JLabel px = new JLabel ("X: 0");
	JLabel po = new JLabel ("O: 0");
	JButton novo = new JButton ("Novo Jogo");
	JButton zerar = new JButton ("Zerar Placar");
	JLabel lvl = new JLabel ("Dificuldade:");
	JButton fa = new JButton ("Facil");
	JButton me = new JButton ("Médio");
	JButton di = new JButton ("Dificil");
	int PX = 0;
	int PO = 0;
	
	//to button action
	boolean xo = false;
	boolean [] click = new boolean [9];
	
	
	public JogoDaVelha () {
		
		//config to window
		setVisible (true);
		setTitle ("jogo da velha");
		setDefaultCloseOperation (3);
		setLayout (null);
		setBounds (0,100,700,500);
		add (modo);
		add (p1p2);
		add (p1cpu);
		add (placar);
		add (px);
		add (po);
		add (novo);
		add (zerar);
		add (lvl);
		add (fa);
		add (me);
		add (di);
		
		modo.setBounds(400, 35, 100, 30);
		p1p2.setBounds(400, 60, 100, 30);
		p1cpu.setBounds(510, 60, 100, 30);
		placar.setBounds(400, 90, 100, 30);
		px.setBounds(400, 115, 100, 30);
		po.setBounds(450, 115, 100, 30);
		novo.setBounds(400, 145, 140, 30);
		zerar.setBounds(400, 180, 140, 30);
		lvl.setBounds(400, 220, 100, 30);
		fa.setBounds(400, 250, 140, 30);
		me.setBounds(400, 285, 140, 30);
		di.setBounds(400, 320, 140, 30);
		
		//fuction button 
		p1cpu.addActionListener (new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				limpar ();
				}
			});		
		novo.addActionListener (new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				limpar ();
				}
			});
		zerar.addActionListener (new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				PO = 0;
				PX = 0;
				atualizar ();
				}
			});
		
		//config button
		int cont = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				bt [cont] = new JButton ();
				add (bt [cont]);
				bt [cont].setBounds ((100 * i) + 50, (100 * j) + 50, 95, 95);
				bt [cont].setFont(new Font ("Arial", Font.BOLD, 40));
				cont++;
			}
		}
		
		for (int i = 0; i < 9; i++) {
			click [i] = false;
		}
		
		//button action
		bt [0].addActionListener (new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (click [0] == false) {
					click [0] = true;
					mudar (bt [0]);	
				}
			}
		});
		
		bt [1].addActionListener (new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (click [1] == false) {
					click [1] = true;
					mudar (bt [1]);	
				}
			}
		});
		
		bt [2].addActionListener (new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (click [2] == false) {
					click [2] = true;
					mudar (bt [2]);	
				}
			}
		});
		
		bt [3].addActionListener (new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (click [3] == false) {
					click [3] = true;
					mudar (bt [3]);	
				}
			}
		});
		
		bt [4].addActionListener (new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (click [4] == false) {
					click [4] = true;
					mudar (bt [4]);	
				}
			}
		});
		
		bt [5].addActionListener (new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (click [5] == false) {
					click [5] = true;
					mudar (bt [5]);	
				}
			}
		});
		
		bt [6].addActionListener (new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (click [6] == false) {
					click [6] = true;
					mudar (bt [6]);	
				}
			}
		});
		
		bt [7].addActionListener (new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (click [7] == false) {
					click [7] = true;
					mudar (bt [7]);	
				}
			}
		});
		
		bt [8].addActionListener (new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (click [8] == false) {
					click [8] = true;
					mudar (bt [8]);	
				}
			}
		});
	}

	//select to X or O
	public void mudar (JButton btn) {
		if (xo) {
			btn.setText ("O");
			xo = false;
		} else {
			btn.setText ("X");
			xo = true;
		}
		ganhou ();
	}
	
	//points
	public void atualizar () {
		px.setText("X " + PX);
		po.setText("O " + PO);
	}
	
	// result
	public void ganhou () {
		int cont = 0;
		for (int i = 0; i < 9; i++) {
			if (click [i] == true) {
				cont ++;
			}
		}
		
		if ((bt [0].getText() == "X" && bt [1].getText() == "X" && bt [2].getText() == "X")
				|| (bt [3].getText() == "X" && bt [4].getText() == "X" && bt [5].getText() == "X")
				|| (bt [6].getText() == "X" && bt [7].getText() == "X" && bt [8].getText() == "X")
				|| (bt [0].getText() == "X" && bt [3].getText() == "X" && bt [6].getText() == "X")
				|| (bt [1].getText() == "X" && bt [4].getText() == "X" && bt [7].getText() == "X")
				|| (bt [2].getText() == "X" && bt [5].getText() == "X" && bt [8].getText() == "X")
				|| (bt [0].getText() == "X" && bt [4].getText() == "X" && bt [8].getText() == "X")
				|| (bt [6].getText() == "X" && bt [4].getText() == "X" && bt [2].getText() == "X")) {
			JOptionPane.showMessageDialog (null, "X Ganhou");
			PX++;
			atualizar ();
			limpar ();
		}else if ((bt [0].getText() == "O" && bt [1].getText() == "O" && bt [2].getText() == "O")
				|| (bt [3].getText() == "O" && bt [4].getText() == "O" && bt [5].getText() == "O")
				|| (bt [6].getText() == "O" && bt [7].getText() == "O" && bt [8].getText() == "O")
				|| (bt [0].getText() == "O" && bt [3].getText() == "O" && bt [6].getText() == "O")
				|| (bt [1].getText() == "O" && bt [4].getText() == "O" && bt [7].getText() == "O")
				|| (bt [2].getText() == "O" && bt [5].getText() == "O" && bt [8].getText() == "O")
				|| (bt [0].getText() == "O" && bt [4].getText() == "O" && bt [8].getText() == "O")
				|| (bt [6].getText() == "O" && bt [4].getText() == "O" && bt [2].getText() == "O")) {
			JOptionPane.showMessageDialog (null, "O Ganhou");
			PO++;
			atualizar ();
			limpar ();
		}else if (cont == 9) {
			JOptionPane.showMessageDialog (null, "Empate");
			limpar ();
		}
	}
	
	// clean
	public void limpar () {
		for (int i = 0; i < 9; i++) {
			bt [i].setText("");
			click [i] = false;
			xo = false;
		}
	}

	// CPU
	public static void p1Cpu () {
		Random aleatorio = new Random ();
		int cpu = aleatorio.nextInt(9);
		
		System.out.println(cpu);
		
	}
	
	public static void main(String[] args) {
		new JogoDaVelha ();
		
	}

}
