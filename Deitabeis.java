import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JToggleButton;
import java.awt.Color;

public class Deitabeis {

	private JFrame frame;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;

	public static void main(String[] args) {
		
		
				ArrayList<Object[]> data = new ArrayList<Object[]>();
				JScrollPane scrollPane = new JScrollPane();

				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Kirjan nimi");
				model.addColumn("Tekij‰");
				model.addColumn("Julkaisuvuosi");

				JTable table = new JTable(model);
				JFrame ikkuna = new JFrame();
				ikkuna.setTitle("Tehtava 4 - Java Advanced");
				
				JMenuBar menuBar = new JMenuBar();
				ikkuna.getContentPane().add(menuBar, BorderLayout.NORTH);
				
				

				ikkuna.getContentPane().add(scrollPane);
				scrollPane.setViewportView(table);
				
				JPanel alaPaneeli = new JPanel();
				alaPaneeli.setPreferredSize(new Dimension(10, 100));
				ikkuna.getContentPane().add(alaPaneeli, BorderLayout.SOUTH);
				alaPaneeli.setLayout(null);
				alaPaneeli.setVisible(false);
				
				JLabel lblNewLabel = new JLabel("Kirja");
				lblNewLabel.setLocation(new Point(-20, 10));
				lblNewLabel.setBounds(10, 8, 90, 14);
				alaPaneeli.add(lblNewLabel);
				
				textField = new JTextField();
				textField.setBounds(100, 5, 200, 20);
				textField.setPreferredSize(new Dimension(300, 20));
				textField.setMinimumSize(new Dimension(300, 20));
				alaPaneeli.add(textField);
				textField.setColumns(10);
				
				JLabel lblNewLabel_1 = new JLabel("Kirjan tekij‰");
				lblNewLabel_1.setSize(90, 14);
				lblNewLabel_1.setLocation(new Point(10, 40));
				alaPaneeli.add(lblNewLabel_1);
				
				textField_1 = new JTextField();
				textField_1.setBounds(100, 37, 200, 20);
				textField_1.setPreferredSize(new Dimension(300, 20));
				textField_1.setMinimumSize(new Dimension(300, 20));
				alaPaneeli.add(textField_1);
				textField_1.setColumns(10);
				
				JLabel label = new JLabel("Julkaisuvuosi");
				label.setLocation(new Point(10, 40));
				label.setBounds(10, 75, 90, 14);
				alaPaneeli.add(label);
				
				textField_2 = new JTextField();
				textField_2.setPreferredSize(new Dimension(300, 20));
				textField_2.setMinimumSize(new Dimension(300, 20));
				textField_2.setColumns(10);
				textField_2.setBounds(100, 72, 200, 20);
				alaPaneeli.add(textField_2);
				
				JButton btnNewButton = new JButton("x");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						alaPaneeli.setVisible(false);
					}
				});
				btnNewButton.setBounds(401, 4, 46, 23);
				alaPaneeli.add(btnNewButton);
				
				JButton lisaaTiedot = new JButton("Lis‰‰ tiedot");
				lisaaTiedot.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String kirjanNimi = textField.getText();
						String tekija = textField_1.getText();
						String vuosi = textField_2.getText();
	
						try {
							Connection con = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net/sql7265178","sql7265178", "ZJlKDCDHjS");
							if (con == null) {
								JOptionPane.showMessageDialog(null, "Yhteytt‰ ei voitu muodostaa. :(");
							}
							PreparedStatement ps = con.prepareStatement("INSERT INTO kirja (kirjan_nimi, tekij‰, julkaisuvuosi) \n" +
																"VALUES ('" + kirjanNimi + "', '" + tekija +"', '" + vuosi + "');");
							ps.executeUpdate();
							con.close();
						} catch (Exception e1) {
							System.out.println(e1);
						}						
					}
				});
				lisaaTiedot.setBackground(Color.GREEN);
				lisaaTiedot.setBounds(326, 35, 121, 25);
				alaPaneeli.add(lisaaTiedot);
				
				JButton poistaTiedot = new JButton("Poista tiedot");
				poistaTiedot.setBackground(Color.RED);
				poistaTiedot.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String kirjanNimi = textField.getText();
						String tekija = textField_1.getText();
						
						try {
							Connection con = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net/sql7265178","sql7265178", "ZJlKDCDHjS");
							if (con == null) {
								JOptionPane.showMessageDialog(null, "Yhteytt‰ ei voitu muodostaa. :(");
							}
							PreparedStatement ps = con.prepareStatement("DELETE FROM kirja WHERE kirjan_nimi = '" + kirjanNimi + "' AND tekij‰ = '" + tekija +"';");
							ps.executeUpdate();
							con.close();
						} catch (Exception e1) {
							System.out.println(e1);
						}	
					}
				});
				poistaTiedot.setBounds(326, 70, 121, 25);
				alaPaneeli.add(poistaTiedot);
				
				JButton btnUusi = new JButton("Lis‰‰ / poista tietoa");
				btnUusi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						alaPaneeli.setVisible(true);
					}
				});	
				
				JButton btnHaeKaikki = new JButton("Hae kaikki");
				btnHaeKaikki.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Connection con = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net/sql7265178","sql7265178", "ZJlKDCDHjS");
							if (con == null) {
								JOptionPane.showMessageDialog(null, "Yhteytt‰ ei voitu muodostaa. :(");
							}
							Statement stmt = con.createStatement();

							ResultSet rs = stmt.executeQuery("SELECT * FROM kirja");
							data.clear();
							while (rs.next()) {
								data.add( new Object[] { rs.getString(1), rs.getString(2), rs.getString(3) } );
							}
							con.close();
						} catch (Exception e1) {
							System.out.println(e1);
						}
						for (int i=0; i < data.size(); i++ ) {
							model.addRow(data.get(i));
						}
					}
				});
				menuBar.add(btnHaeKaikki);
				
				
				menuBar.add(btnUusi);
				
				JButton btnPoistu = new JButton("Poistu");
				btnPoistu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				
				JButton btnTyhjennaTaulu = new JButton("Tyhjenn‰ taulu");
				btnTyhjennaTaulu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (int j=0; j < data.size(); j++) {
							model.removeRow(0);
						}
					}
				});
				menuBar.add(btnTyhjennaTaulu);
				menuBar.add(btnPoistu);

				ikkuna.pack();
				ikkuna.setVisible(true);
				
	}
}
