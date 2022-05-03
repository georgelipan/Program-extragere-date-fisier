package Program;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.BorderLayout;

class GUI {
	private JFrame gui;

	public GUI() {
		gui = new JFrame("Program");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(600, 400);
		initGUI();
		
		gui.setVisible(true);
	}

	private void initGUI() {
		gui.getContentPane().setBackground(new Color(88, 217, 219));
		gui.setLayout(null);
		
		JTextField oras = new JTextField("Oras");
		gui.add(oras);
		oras.setBounds(300,80,150,30);

		JTextField centre = new JTextField("Nr. centre");
		gui.add(centre);
		centre.setBounds(300,120,150,30);
		
		JTextField doze = new JTextField("Doze");
		gui.add(doze);
		doze.setBounds(300,160,150,30);
		
		JTextField pozitie = new JTextField("Pozitie");
		gui.add(pozitie);
		pozitie.setBounds(50,300,150,30);
		String calea="C:\\Users\\georg\\PIP\\PIP\\src\\Exercitii_2\\datain.txt";
		
		JButton printare = new JButton("Update");
		gui.add(printare);
		printare.setBounds(100, 50, 150, 30);
		
		JMenuBar menuBar = new JMenuBar();
		//setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Fisier");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Citire");
		mnNewMenu.add(mntmNewMenuItem);
		printare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msjIntrodus = pozitie.getText();
				System.out.println(msjIntrodus);
				File fisier = new File(calea);
				FileReader fr = null;
				try {
					fr = new FileReader(fisier);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BufferedReader bfr = new BufferedReader(fr);
				String linie = null;
				try {
					linie = bfr.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				int i=1;
				int poz = Integer.parseInt(msjIntrodus);
				
				while(linie != null)
				{
					if(i==poz)
					{
						String [] cuvinte = linie.split(" ", 3);
						oras.setText(cuvinte[0]);
						centre.setText(cuvinte[1]);
						doze.setText(cuvinte[2]);
					}
					
					try {
						linie=bfr.readLine();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					i++;
				}
				
			}
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Modificare");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println();
				
				
			}
		});
		
		oras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
			
		});
		
		
	}
}

public class Problema {

	public static void main(String[] args) {
		new GUI();
		
		System.out.println("Se executa programul...");
	}

}
































