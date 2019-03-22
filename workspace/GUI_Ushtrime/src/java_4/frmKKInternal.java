package java_4;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class frmKKInternal extends JInternalFrame {
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txtD;
	private JTextField txtE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmKKInternal frame = new frmKKInternal();
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
	public frmKKInternal() {
		setClosable(true);
		setTitle("Kalkulatori i Kredise Internal");
		setBounds(100, 100, 450, 410);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Kalkulatori i Kredise");
		label.setFont(new Font("Courier New", Font.PLAIN, 20));
		label.setBounds(91, 41, 252, 21);
		getContentPane().add(label);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Te Dhenat Hyrese", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(42, 84, 350, 112);
		getContentPane().add(panel);
		
		JLabel label_1 = new JLabel("Shkalla e Interesit Total:");
		label_1.setBounds(10, 28, 178, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Numri i Viteve Te Kredise:");
		label_2.setBounds(10, 53, 178, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Shuma Totale e Kredise:");
		label_3.setBounds(10, 78, 178, 14);
		panel.add(label_3);
		
		txtA = new JTextField();
		txtA.setColumns(10);
		txtA.setBounds(235, 25, 86, 20);
		panel.add(txtA);
		
		txtB = new JTextField();
		txtB.setColumns(10);
		txtB.setBounds(235, 50, 86, 20);
		panel.add(txtB);
		
		txtC = new JTextField();
		txtC.setColumns(10);
		txtC.setBounds(235, 75, 86, 20);
		panel.add(txtC);
		
		JButton button = new JButton("Kalkulo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double shkallaInteresitTotal, shkallaInteresitMujor,pagesaMujore,pagesaTotale,shumaKreditit;
				int numriViteve;
				
				shkallaInteresitTotal = Double.parseDouble(txtA.getText());
				numriViteve = Integer.parseInt(txtB.getText());
				shumaKreditit = Double.parseDouble(txtC.getText());
				
				shkallaInteresitMujor = shkallaInteresitTotal/1200;
				
				pagesaMujore = shumaKreditit*shkallaInteresitMujor/(1-1/Math.pow(1+shkallaInteresitMujor, numriViteve*12));
				pagesaTotale = pagesaMujore * numriViteve*12;
				
				txtD.setText(String.valueOf(pagesaMujore));
				txtE.setText(String.valueOf(pagesaTotale));
			}
		});
		button.setBounds(160, 207, 109, 35);
		getContentPane().add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Te Dhenat Dalese", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(42, 253, 350, 83);
		getContentPane().add(panel_1);
		
		JLabel label_4 = new JLabel("Pagesa Mujtore:");
		label_4.setBounds(10, 27, 117, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Pagesa Totale:");
		label_5.setBounds(10, 52, 117, 14);
		panel_1.add(label_5);
		
		txtD = new JTextField();
		txtD.setHorizontalAlignment(SwingConstants.RIGHT);
		txtD.setEditable(false);
		txtD.setColumns(10);
		txtD.setBounds(193, 24, 139, 20);
		panel_1.add(txtD);
		
		txtE = new JTextField();
		txtE.setHorizontalAlignment(SwingConstants.RIGHT);
		txtE.setEditable(false);
		txtE.setColumns(10);
		txtE.setBounds(193, 49, 139, 20);
		panel_1.add(txtE);
		


	}
}
