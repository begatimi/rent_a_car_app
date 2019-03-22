package java_4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class frmKalkulatoriKredise extends JFrame {

	private JPanel contentPane;
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
					frmKalkulatoriKredise frame = new frmKalkulatoriKredise();
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
	public frmKalkulatoriKredise() {
		setTitle("Kalkulatori i Kredise");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKalkulatoriIKredise = new JLabel("Kalkulatori i Kredise");
		lblKalkulatoriIKredise.setFont(new Font("Courier New", Font.PLAIN, 20));
		lblKalkulatoriIKredise.setBounds(76, 21, 252, 21);
		contentPane.add(lblKalkulatoriIKredise);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Te Dhenat Hyrese", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(27, 64, 350, 112);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblShkallaEInteresit = new JLabel("Shkalla e Interesit Total:");
		lblShkallaEInteresit.setBounds(10, 28, 178, 14);
		panel.add(lblShkallaEInteresit);
		
		JLabel lblNumriIViteve = new JLabel("Numri i Viteve Te Kredise:");
		lblNumriIViteve.setBounds(10, 53, 178, 14);
		panel.add(lblNumriIViteve);
		
		JLabel lblShumaTotaleE = new JLabel("Shuma Totale e Kredise:");
		lblShumaTotaleE.setBounds(10, 78, 178, 14);
		panel.add(lblShumaTotaleE);
		
		txtA = new JTextField();
		txtA.setBounds(235, 25, 86, 20);
		panel.add(txtA);
		txtA.setColumns(10);
		
		txtB = new JTextField();
		txtB.setBounds(235, 50, 86, 20);
		panel.add(txtB);
		txtB.setColumns(10);
		
		txtC = new JTextField();
		txtC.setBounds(235, 75, 86, 20);
		panel.add(txtC);
		txtC.setColumns(10);
		
		JButton btnKalkulo = new JButton("Kalkulo");
		btnKalkulo.addActionListener(new ActionListener() {
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
		btnKalkulo.setBounds(145, 187, 109, 35);
		contentPane.add(btnKalkulo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Te Dhenat Dalese", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(27, 233, 350, 83);
		contentPane.add(panel_1);
		
		JLabel lblPagesaMujtore = new JLabel("Pagesa Mujtore:");
		lblPagesaMujtore.setBounds(10, 27, 117, 14);
		panel_1.add(lblPagesaMujtore);
		
		JLabel lblPagesaTotale = new JLabel("Pagesa Totale:");
		lblPagesaTotale.setBounds(10, 52, 117, 14);
		panel_1.add(lblPagesaTotale);
		
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
