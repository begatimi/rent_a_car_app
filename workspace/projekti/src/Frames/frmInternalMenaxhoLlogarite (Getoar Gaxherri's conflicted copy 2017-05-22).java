package frames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class frmInternalMenaxhoLlogarite extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id; //variabla per marjen e id per fshirje
	private JTable tblLlogarite;
	private JTextField txtPerdoruesi;
	private JTextField txtEmri;
	private JTextField txtMbiemri;
	private JTextField txtNrTelit;
	private JTextField txtEmaili;
	private JTextField txtAdresa;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtKerko;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmInternalMenaxhoLlogarite frame = new frmInternalMenaxhoLlogarite();
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
	public frmInternalMenaxhoLlogarite() {
		setClosable(true);
		if (Gjuha.gjuha == "albanian") {
			setTitle("Menaxho Llogarit\u00EB");
		} else {
			setTitle("Manage Accounts");
		}
		
		setBounds(100, 100, 665, 461);
		getContentPane().setLayout(null);
		
		JLabel lblFormaPrMenaxhimin = new JLabel();
		lblFormaPrMenaxhimin.setHorizontalAlignment(SwingConstants.CENTER);
		if (Gjuha.gjuha == "albanian") {
			lblFormaPrMenaxhimin.setText("FORMA P\u00CBR MENAXHIMIN E LLOGARIVE");
		} else {
			lblFormaPrMenaxhimin.setText("ACCOUNT MANAGMENT FORM");
		}
		lblFormaPrMenaxhimin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFormaPrMenaxhimin.setBounds(23, 11, 595, 26);
		getContentPane().add(lblFormaPrMenaxhimin);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 90, 595, 166);
		getContentPane().add(scrollPane);
		
		
		
		JRadioButton rbPo = new JRadioButton("Po");
		if (Gjuha.gjuha == "albanian") {
			rbPo.setText("Po");
		} else {
			rbPo.setText("Yes");
		}
		buttonGroup.add(rbPo);
		rbPo.setBounds(57, 263, 48, 23);
		getContentPane().add(rbPo);
		
		JRadioButton rbJo = new JRadioButton("Jo");
		if (Gjuha.gjuha == "albanian") {
			rbJo.setText("Jo");
		} else {
			rbJo.setText("No");
		}
		buttonGroup.add(rbJo);
		rbJo.setBounds(107, 263, 53, 23);
		getContentPane().add(rbJo);
		
		
		
		tblLlogarite = new JTable();
		tblLlogarite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)tblLlogarite.getModel();
				id = (int)model.getValueAt(tblLlogarite.getSelectedRow(), 0);
				
				try {
					String sql = "select * from llogarite where id='"+id+"'";
					Database.pst = Database.conn.prepareStatement(sql);
					Database.res = Database.pst.executeQuery();
					
					String isActive = ""; 
					while(Database.res.next()) {
						txtPerdoruesi.setText(Database.res.getString("perdoruesi"));
						isActive = Database.res.getString("eshteAktiv");
						txtEmri.setText(Database.res.getString("emri"));
						txtMbiemri.setText(Database.res.getString("mbiemri"));
						txtNrTelit.setText(Database.res.getString("numriTelefonit"));
						txtEmaili.setText(Database.res.getString("emaili"));
						txtAdresa.setText(Database.res.getString("adresa"));
					}

					if ( isActive.equals("po") )
						rbPo.setSelected(true);
					else
						rbJo.setSelected(true);
					
					Database.pst.close();
				} catch (Exception e2) {
					
				}
			}
		});
		
		JPopupMenu ppMenu = new JPopupMenu();
		addPopup(tblLlogarite, ppMenu);
		ppMenu.setBounds(0, 0, 200, 50);
		
		JLabel lblPerdoruesi = new JLabel("Perdoruesi:");
		if (Gjuha.gjuha == "albanian") {
			lblPerdoruesi.setText("Perdoruesi:");
		} else {
			lblPerdoruesi.setText("Username:");
		}
		lblPerdoruesi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPerdoruesi.setBounds(23, 291, 74, 14);
		getContentPane().add(lblPerdoruesi);
		
		txtPerdoruesi = new JTextField();
		txtPerdoruesi.setBounds(107, 289, 130, 20);
		getContentPane().add(txtPerdoruesi);
		txtPerdoruesi.setColumns(10);
		
		JLabel lblEmri = new JLabel("Emri:");
		if (Gjuha.gjuha == "albanian") {
			lblEmri.setText("Emri:");
		} else {
			lblEmri.setText("Firstname:");
		}
		lblEmri.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmri.setBounds(23, 321, 74, 14);
		getContentPane().add(lblEmri);
		
		txtEmri = new JTextField();
		txtEmri.setColumns(10);
		txtEmri.setBounds(107, 319, 130, 20);
		getContentPane().add(txtEmri);
		
		JLabel lblMbiemri = new JLabel("Mbiemri:");
		if (Gjuha.gjuha == "albanian") {
			lblMbiemri.setText("Mbiemri:");
		} else {
			lblMbiemri.setText("Lasname:");
		}
		lblMbiemri.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMbiemri.setBounds(23, 354, 74, 14);
		getContentPane().add(lblMbiemri);
		
		txtMbiemri = new JTextField();
		txtMbiemri.setColumns(10);
		txtMbiemri.setBounds(107, 350, 130, 20);
		getContentPane().add(txtMbiemri);
		
		JLabel lblInfo = new JLabel("");
		lblInfo.setForeground(Color.RED);
		lblInfo.setBounds(23, 391, 465, 23);
		getContentPane().add(lblInfo);
		
		JLabel lblNrTelefonit = new JLabel("Nr. Telefonit:");
		if (Gjuha.gjuha == "albanian") {
			lblNrTelefonit.setText("Nr. Telefonit:");
		} else {
			lblNrTelefonit.setText("Telephone No.:");
		}
		lblNrTelefonit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNrTelefonit.setBounds(257, 291, 91, 14);
		getContentPane().add(lblNrTelefonit);
		
		txtNrTelit = new JTextField();
		txtNrTelit.setColumns(10);
		txtNrTelit.setBounds(358, 289, 130, 20);
		getContentPane().add(txtNrTelit);
		
		JLabel lblEmaili = new JLabel("Emaili:");
		if (Gjuha.gjuha == "albanian") {
			lblEmaili.setText("Emaili:");
		} else {
			lblEmaili.setText("Email:");
		}
		lblEmaili.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmaili.setBounds(257, 321, 60, 14);
		getContentPane().add(lblEmaili);
		
		txtEmaili = new JTextField();
		txtEmaili.setColumns(10);
		txtEmaili.setBounds(327, 319, 161, 20);
		getContentPane().add(txtEmaili);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		if (Gjuha.gjuha == "albanian") {
			lblAdresa.setText("Adresa:");
		} else {
			lblAdresa.setText("Address:");
		}
		lblAdresa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdresa.setBounds(257, 354, 60, 14);
		getContentPane().add(lblAdresa);
		
		txtAdresa = new JTextField();
		txtAdresa.setColumns(10);
		txtAdresa.setBounds(327, 350, 161, 20);
		getContentPane().add(txtAdresa);
		
		JLabel lblAktiv = new JLabel("Aktiv:");
		if (Gjuha.gjuha == "albanian") {
			lblAktiv.setText("Aktiv:");
		} else {
			lblAktiv.setText("Active:");
		}
		lblAktiv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAktiv.setBounds(23, 266, 53, 14);
		getContentPane().add(lblAktiv);
		
		JButton btnRuaj = new JButton("Ruaj");
		if (Gjuha.gjuha == "albanian") {
			btnRuaj.setText("Ruaj");
		} else {
			btnRuaj.setText("Save");
		}
		btnRuaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String isActive;
				if ( rbPo.isSelected() )
					isActive = "po";
				else
					isActive = "jo";
				
				String sql = "update llogarite set perdoruesi='"+ txtPerdoruesi.getText() +"', eshteAktiv ='" + isActive + "',  emri = '" + txtEmri.getText() + "', "
						+ "mbiemri = '" + txtMbiemri.getText() + "', numriTelefonit = '" + txtNrTelit.getText() + "', emaili = '" + txtEmaili.getText() + "',  "
						+ "adresa = '" + txtAdresa.getText() + "' where id ='" + id + "'";
				
				if ( id != 0) {
					try {
						Database.executeQueryDB(sql);
						lblInfo.setText("Ruajtja �sht� b�r� me sukses!");
						updateTable();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					lblInfo.setText("Nuk keni zgjedhur asnje rresht!");
				}
			}
		});
		btnRuaj.setBounds(529, 288, 89, 35);
		getContentPane().add(btnRuaj);
		
		JButton btnPastroFushat = new JButton("Pastro");
		if (Gjuha.gjuha == "albanian") {
			btnPastroFushat.setText("Pastro");
		} else {
			btnPastroFushat.setText("Clear");
		}
		btnPastroFushat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPerdoruesi.setText("");
				txtEmri.setText("");
				txtMbiemri.setText("");
				txtNrTelit.setText("");
				txtEmaili.setText("");
				txtAdresa.setText("");
				buttonGroup.clearSelection();
				updateTable();
			}
		});
		btnPastroFushat.setBounds(529, 379, 89, 35);
		getContentPane().add(btnPastroFushat);
		
		
		JButton btnFshij = new JButton("Fshij");
		if (Gjuha.gjuha == "albanian") {
			btnFshij.setText("Fshij");
		} else {
			btnFshij.setText("Delete");
		}
		btnFshij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ( id == 0) {
					lblInfo.setText("Nuk keni zgjedhur asnje rresht!");
				} else {
					
					String[] options;
					int pergjigja;
					
					if (Gjuha.gjuha == "albanian") {
						options = new String[] {"Po", "Jo"};
						pergjigja = JOptionPane.showOptionDialog(null, "A jeni i sigurt?", "Konfirmo",
						        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						        null, options, options[0]);
					} else {
						options = new String[] {"Yes", "No"};
						pergjigja = JOptionPane.showOptionDialog(null, "A you sure?", "Confirm",
						        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						        null, options, options[0]);
					}
					
					
					String sql="delete from llogarite where id='" + id + "'";
				
				
					if ( pergjigja == 0 ) {
						try {
							Database.executeQueryDB(sql);
							btnPastroFushat.doClick();
							if (Gjuha.gjuha == "albanian") {
								lblInfo.setText("Llogaria u fshi me sukses!");
							} else {
								lblInfo.setText("The account has been deleted succesfully!");
							}
							
							updateTable();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else {
						lblInfo.setText("");
					}
				}
			}
		});
		btnFshij.setBounds(529, 333, 89, 35);
		getContentPane().add(btnFshij);
		
		JMenuItem mnFshije = new JMenuItem("Fshije");
		mnFshije.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnFshij.doClick();
			}
		});
		if (Gjuha.gjuha == "albanian") {
			mnFshije.setText("Fshije");
		} else {
			mnFshije.setText("Delete");
		}
		ppMenu.add(mnFshije);
		scrollPane.setViewportView(tblLlogarite);
		
		JButton btnKerko = new JButton("K\u00EBrko");
		if (Gjuha.gjuha == "albanian") {
			btnKerko.setText("K\u00EBrko");
		} else {
			btnKerko.setText("Search");
		}
		btnKerko.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String kerko = txtKerko.getText().trim();
					String sql = "select id as 'ID', perdoruesi as 'Perdoruesi', eshteAktiv as 'Aktiv', emri as 'Emri', mbiemri as 'Mbiemri', numriTelefonit as 'Nr. Telefonit', emaili as 'Emaili', adresa as 'Adresa' "
							+ "from llogarite where perdoruesi like '%" + kerko + "%' or emri like '%" + kerko + "%'";
					Database.executeQueryWithResult(sql);
					
					tblLlogarite.setModel(DbUtils.resultSetToTableModel(Database.res));
				
					Database.pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnKerko.setBounds(529, 62, 89, 23);
		getContentPane().add(btnKerko);
		
		JLabel lblReshtat = new JLabel("");
		lblReshtat.setBounds(23, 71, 161, 14);
		getContentPane().add(lblReshtat);
		
		txtKerko = new JTextField();
		txtKerko.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String kerko = txtKerko.getText().trim();
					String sql = "select id as 'ID', perdoruesi as 'Perdoruesi', eshteAktiv as 'Aktiv', emri as 'Emri', mbiemri as 'Mbiemri', numriTelefonit as 'Nr. Telefonit', emaili as 'Emaili', adresa as 'Adresa' "
							+ "from llogarite where perdoruesi like '%" + kerko + "%' or emri like '%" + kerko + "%'";
					Database.executeQueryWithResult(sql);
					Database.res.last();
					int count = Database.res.getRow();
					tblLlogarite.setModel(DbUtils.resultSetToTableModel(Database.res));
					lblReshtat.setText("Rreshtat Pas kerkimit " + count);
					Database.pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		txtKerko.setColumns(10);
		txtKerko.setBounds(358, 62, 161, 22);
		getContentPane().add(txtKerko);

		updateTable();
	}
	
	public void updateTable() {
		try {
			//pyetsori per database
			String sql = "select id as 'ID', perdoruesi as 'Perdoruesi', eshteAktiv as 'Aktiv', emri as 'Emri', mbiemri as 'Mbiemri', numriTelefonit as 'Nr. Telefonit', emaili as 'Emaili', adresa as 'Adresa' from llogarite ";
			
			Database.pst = Database.conn.prepareStatement(sql);
			Database.res = Database.pst.executeQuery();
			
			tblLlogarite.setModel(DbUtils.resultSetToTableModel(Database.res));
			Database.pst.close();
		} catch (Exception e) {
			
		}
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
