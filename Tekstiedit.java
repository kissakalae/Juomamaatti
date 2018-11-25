import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

public class Tekstiedit extends JFrame {


	JFrame myFrame = null;
	JEditorPane myPane = null;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tekstiedit frame = new Tekstiedit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tekstiedit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setContentType("text/plain");
		
		contentPane.add(editorPane, BorderLayout.CENTER);
		
		JMenu mnTiedosto = new JMenu("Tiedosto");
		menuBar.add(mnTiedosto);
		
		JMenuItem mntmUusi = new JMenuItem("Uusi");
		mntmUusi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				editorPane.setText("");		
				}
			});
		
		String teksti = editorPane.getText(); // Siirtää tekstikentästä tekstin Stringin muotoon
		
		
		JMenuItem mntmAvaa = new JMenuItem("Avaa");
		mntmAvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String line = ((AbstractButton) e.getSource()).getText(); // Alustaa line-muuttujan FileReaderia varten
				try {
					FileReader sisään = new FileReader("tiedosto.txt");
					char[] buffer = new char[1024];
					int n = sisään.read(buffer);
					String lukija = new String(buffer, 0, n);
					editorPane.setText(lukija);
					sisään.close();
				} catch (FileNotFoundException e1) {
					System.out.println("Tiedostoa ei löytynyt!");
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
			}
		});			
		mntmAvaa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnTiedosto.add(mntmAvaa);
		
		JMenuItem mntmTallenna = new JMenuItem("Tallenna");
		mntmTallenna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				String teksti = editorPane.getText();
				FileWriter ulos = new FileWriter("tiedosto.txt");
				ulos.write(teksti);
				ulos.close();
			} catch (IOException e1) {
				System.out.println("Tiedostoa ei löydy.");
				e1.printStackTrace();
			}
			}
		});
		mntmTallenna.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnTiedosto.add(mntmTallenna);
		
		JMenuItem mntmPoistu = new JMenuItem("Poistu");
		mntmPoistu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnTiedosto.add(mntmPoistu);
		
		JMenuItem mntmKorvaa = new JMenuItem("Poistu");
		mntmKorvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnTiedosto.add(mntmPoistu);
		
		JMenu mnMuokkaa = new JMenu("Muokkaa");
		menuBar.add(mnMuokkaa);
		
		JButton btnUusi = new JButton("");
		btnUusi.setIcon(new ImageIcon("C:\\Users\\Omistaja\\Documents\\GitHub\\Tekstieditori\\new.png"));
		buttonGroup.add(btnUusi);
		btnUusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Cleared!");
			editorPane.setText("");
			
			}
		});
		
		
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.SOUTH);
		btnUusi.setSelectedIcon(new ImageIcon("C:\\Users\\Omistaja\\Documents\\GitHub\\Tekstieditori\\new.png"));
		toolBar.add(btnUusi);
		
		JButton btnTallenna = new JButton("");
		btnTallenna.setIcon(new ImageIcon("C:\\Users\\Omistaja\\Documents\\GitHub\\Tekstieditori\\save.jpg"));
		btnTallenna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String teksti = editorPane.getText();
					FileWriter ulos = new FileWriter("tiedosto.txt");
					ulos.write(teksti);
					ulos.close();
				} catch (IOException e1) {
					System.out.println("Tiedostoa ei löydy.");
					e1.printStackTrace();
				}
			}
		});
		btnTallenna.setSelectedIcon(new ImageIcon("C:\\Users\\Omistaja\\Documents\\GitHub\\Tekstieditori\\save.jpg"));
		toolBar.add(btnTallenna);
	}

	String filename = "file:///D:/abc.txt";
	private final ButtonGroup buttonGroup = new ButtonGroup();
	 

	
}
