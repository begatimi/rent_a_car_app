package java_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;

public class frmKalkulatoriPagaBrutoNeto {

	private JFrame frmLlogaritjaEPages;
	private JTextField txtPagaBruto;
	private JTextField txtKontributiPunetorit;
	private JTextField txtGjithsejKontributiPunetorit;
	private JTextField txtKontributiPunedhenesit;
	private JTextField txtGjithsejKontributiPunedhenesit;
	private JTextField txtGjithsejKontribute;
	private JTextField txtPagaQeTatohet;
	private JTextField txtGjithsejTatimi;
	private JTextField txtPagaNeto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmKalkulatoriPagaBrutoNeto window = new frmKalkulatoriPagaBrutoNeto();
					window.frmLlogaritjaEPages.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmKalkulatoriPagaBrutoNeto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLlogaritjaEPages = new JFrame();
		frmLlogaritjaEPages.setIconImage(Toolkit.getDefaultToolkit().getImage(frmKalkulatoriPagaBrutoNeto.class.getResource("/Images/pagaBrutoNeto.png")));
		frmLlogaritjaEPages.setTitle("Llogaritja e pages Bruto ne Neto");
		frmLlogaritjaEPages.setBounds(100, 100, 609, 472);
		frmLlogaritjaEPages.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLlogaritjaEPages.getContentPane().setLayout(null);
		
		JLabel lblPunedhenesi = new JLabel("Pun\u00EBdh\u00EBn\u00EBsi:");
		lblPunedhenesi.setFont(new Font("Courier New", Font.PLAIN, 17));
		lblPunedhenesi.setBounds(20, 36, 120, 21);
		frmLlogaritjaEPages.getContentPane().add(lblPunedhenesi);
		
		JComboBox<String> cmbPuna = new JComboBox<String>();
		cmbPuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGjithsejTatimi.setText("");
				txtPagaNeto.setText("");
			}
		});
		
		cmbPuna.setFont(new Font("Courier New", Font.PLAIN, 15));
		cmbPuna.setModel(new DefaultComboBoxModel<String>(new String[] {"Primar", "Sekondar"}));
		cmbPuna.setBounds(441, 37, 142, 20);
		frmLlogaritjaEPages.getContentPane().add(cmbPuna);
		
		JLabel lblPagaBruto = new JLabel("Paga BRUTO*:");
		lblPagaBruto.setFont(new Font("Courier New", Font.PLAIN, 17));
		lblPagaBruto.setBounds(20, 67, 120, 21);
		frmLlogaritjaEPages.getContentPane().add(lblPagaBruto);
		
		txtPagaBruto = new JTextField();
		txtPagaBruto.setBounds(441, 68, 142, 20);
		frmLlogaritjaEPages.getContentPane().add(txtPagaBruto);
		txtPagaBruto.setColumns(10);
		
		JLabel lblKontributiIPunetorit = new JLabel("Kontributi i pun\u00EBtorit (%)*:");
		lblKontributiIPunetorit.setFont(new Font("Courier New", Font.PLAIN, 17));
		lblKontributiIPunetorit.setBounds(20, 98, 280, 21);
		frmLlogaritjaEPages.getContentPane().add(lblKontributiIPunetorit);
		
		JLabel lblGjithesejKontributiI = new JLabel("Gjithsej kontributi i pun\u00EBtorit:");
		lblGjithesejKontributiI.setFont(new Font("Courier New", Font.PLAIN, 17));
		lblGjithesejKontributiI.setBounds(20, 130, 328, 21);
		frmLlogaritjaEPages.getContentPane().add(lblGjithesejKontributiI);
		
		JLabel lblGjithsejKontribue = new JLabel("Kontributi i pun\u00EBdh\u00EBn\u00EBsit (%)*:");
		lblGjithsejKontribue.setFont(new Font("Courier New", Font.PLAIN, 17));
		lblGjithsejKontribue.setBounds(20, 162, 316, 21);
		frmLlogaritjaEPages.getContentPane().add(lblGjithsejKontribue);
		
		txtKontributiPunetorit = new JTextField();
		txtKontributiPunetorit.setColumns(10);
		txtKontributiPunetorit.setBounds(441, 99, 142, 20);
		frmLlogaritjaEPages.getContentPane().add(txtKontributiPunetorit);
		
		txtGjithsejKontributiPunetorit = new JTextField();
		txtGjithsejKontributiPunetorit.setEditable(false);
		txtGjithsejKontributiPunetorit.setColumns(10);
		txtGjithsejKontributiPunetorit.setBounds(441, 131, 142, 20);
		frmLlogaritjaEPages.getContentPane().add(txtGjithsejKontributiPunetorit);
		
		txtKontributiPunedhenesit = new JTextField();
		txtKontributiPunedhenesit.setColumns(10);
		txtKontributiPunedhenesit.setBounds(441, 163, 142, 20);
		frmLlogaritjaEPages.getContentPane().add(txtKontributiPunedhenesit);
		
		
		
		JButton btnKalkulo = new JButton("KALKULO");
		btnKalkulo.setFont(new Font("Courier New", Font.PLAIN, 20));
		btnKalkulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if (txtPagaBruto.getText().isEmpty() || txtKontributiPunetorit.getText().isEmpty() || txtKontributiPunedhenesit.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ju lutem plotesoni te gjitha fushat me ylli (*)!");
				} else {
					double pagaBruto =  Double.parseDouble(txtPagaBruto.getText());
					
					if (pagaBruto < 0) {
						JOptionPane.showMessageDialog(null, "Paga nuk mund te jete negative!");
						pagaBruto = 0;
					}
					
					double kontributiPunetorit = Double.parseDouble(txtKontributiPunetorit.getText());
					double kontributiPunedhenesit = Double.parseDouble(txtKontributiPunedhenesit.getText());
					
					if( kontributiPunetorit > 15) {
						kontributiPunetorit = 15;
						JOptionPane.showMessageDialog(null, "Kontributi i punetorit nuk mund te jete me i madhe se 15%!");
						txtKontributiPunetorit.setText("15");
					} else if ( kontributiPunetorit < 5) {
						kontributiPunetorit = 5;
						JOptionPane.showMessageDialog(null, "Kontributi i punetorit nuk mund te jete me i vogel se 5%!");
						txtKontributiPunedhenesit.setText("5");
					}
					
					if( kontributiPunedhenesit > 15) {
						kontributiPunedhenesit = 15;
						JOptionPane.showMessageDialog(null, "Kontributi i punedhenesit nuk mund te jete me i madhe se 15%!");
						txtKontributiPunedhenesit.setText("15");
					} else if ( kontributiPunedhenesit < 5) {
						kontributiPunedhenesit = 5;
						JOptionPane.showMessageDialog(null, "Kontributi i punedhenesit nuk mund te jete me i vogel se 5%!");
						txtKontributiPunedhenesit.setText("5");
					}
					
					double gjithsejKontributiPunetorit = (pagaBruto*Double.parseDouble(txtKontributiPunetorit.getText()))/100;
					txtGjithsejKontributiPunetorit.setText(String.valueOf(gjithsejKontributiPunetorit));
					double gjithsejKontributiPunedhenesit = (pagaBruto*Double.parseDouble(txtKontributiPunedhenesit.getText()))/100;
					txtGjithsejKontributiPunedhenesit.setText(String.valueOf(gjithsejKontributiPunedhenesit));
					txtGjithsejKontribute.setText(String.valueOf(gjithsejKontributiPunetorit+gjithsejKontributiPunedhenesit));
					double pagaQeTatohet = pagaBruto - gjithsejKontributiPunetorit;
					txtPagaQeTatohet.setText(String.valueOf(pagaQeTatohet));
					double gjithsejTatimi = 0;
					
					if(cmbPuna.getSelectedItem().toString() == "Primar") {
						if(pagaQeTatohet > 80 && pagaQeTatohet <= 250)
							gjithsejTatimi = gjithsejTatimi + (pagaQeTatohet-80)*0.04;
						else if(pagaQeTatohet > 80 && pagaQeTatohet <= 450)
							gjithsejTatimi = gjithsejTatimi + ((pagaQeTatohet-250)*0.08+6.80);
						else if(pagaQeTatohet > 80 && pagaQeTatohet> 450)
							gjithsejTatimi = gjithsejTatimi + ((pagaQeTatohet-450)*0.1+22.80);
						
					} else {
						gjithsejTatimi = pagaQeTatohet / 10;
					}
					
					txtGjithsejTatimi.setText(String.valueOf(gjithsejTatimi));
					double pagaNeto = pagaQeTatohet - gjithsejTatimi;
					txtPagaNeto.setText(String.valueOf(pagaNeto));
				}
			}
		});
		btnKalkulo.setBounds(193, 375, 190, 47);
		frmLlogaritjaEPages.getContentPane().add(btnKalkulo);
		
		
		JLabel lblGjithsejKontributiI = new JLabel("Gjithsej kontributi i pun\u00EBdh\u00EBn\u00EBsit:");
		lblGjithsejKontributiI.setFont(new Font("Courier New", Font.PLAIN, 17));
		lblGjithsejKontributiI.setBounds(20, 191, 363, 21);
		frmLlogaritjaEPages.getContentPane().add(lblGjithsejKontributiI);
		
		txtGjithsejKontributiPunedhenesit = new JTextField();
		txtGjithsejKontributiPunedhenesit.setEditable(false);
		txtGjithsejKontributiPunedhenesit.setColumns(10);
		txtGjithsejKontributiPunedhenesit.setBounds(441, 192, 142, 20);
		frmLlogaritjaEPages.getContentPane().add(txtGjithsejKontributiPunedhenesit);
		
		JLabel lblGjithsejKontributet = new JLabel("Gjithsej kontributet:");
		lblGjithsejKontributet.setFont(new Font("Courier New", Font.PLAIN, 17));
		lblGjithsejKontributet.setBounds(20, 223, 210, 21);
		frmLlogaritjaEPages.getContentPane().add(lblGjithsejKontributet);
		
		txtGjithsejKontribute = new JTextField();
		txtGjithsejKontribute.setEditable(false);
		txtGjithsejKontribute.setColumns(10);
		txtGjithsejKontribute.setBounds(441, 224, 142, 20);
		frmLlogaritjaEPages.getContentPane().add(txtGjithsejKontribute);
		
		JLabel lblPagaNeto = new JLabel("Gjithsej tatimi:");
		lblPagaNeto.setFont(new Font("Courier New", Font.PLAIN, 17));
		lblPagaNeto.setBounds(20, 287, 160, 21);
		frmLlogaritjaEPages.getContentPane().add(lblPagaNeto);
		
		JLabel lblPagaQTatohet = new JLabel("Paga q\u00EB tatohet:");
		lblPagaQTatohet.setFont(new Font("Courier New", Font.PLAIN, 17));
		lblPagaQTatohet.setBounds(20, 255, 160, 21);
		frmLlogaritjaEPages.getContentPane().add(lblPagaQTatohet);
		
		txtPagaQeTatohet = new JTextField();
		txtPagaQeTatohet.setEditable(false);
		txtPagaQeTatohet.setColumns(10);
		txtPagaQeTatohet.setBounds(441, 256, 142, 20);
		frmLlogaritjaEPages.getContentPane().add(txtPagaQeTatohet);
		
		txtGjithsejTatimi = new JTextField();
		txtGjithsejTatimi.setEditable(false);
		txtGjithsejTatimi.setColumns(10);
		txtGjithsejTatimi.setBounds(441, 288, 142, 20);
		frmLlogaritjaEPages.getContentPane().add(txtGjithsejTatimi);
		
		txtPagaNeto = new JTextField();
		txtPagaNeto.setEditable(false);
		txtPagaNeto.setColumns(10);
		txtPagaNeto.setBounds(441, 320, 142, 20);
		frmLlogaritjaEPages.getContentPane().add(txtPagaNeto);
		
		JLabel label = new JLabel("PAGA NETO:");
		label.setFont(new Font("Courier New", Font.PLAIN, 17));
		label.setBounds(20, 319, 190, 21);
		frmLlogaritjaEPages.getContentPane().add(label);
	}
}
