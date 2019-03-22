package java_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;

public class Detyra_1 {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField txtPassi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Detyra_1 window = new Detyra_1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Detyra_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 697, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox cmbShtetet = new JComboBox();
		cmbShtetet.setModel(new DefaultComboBoxModel(new String[] {"", "Kosova", "Shqiperai", "Amerika"}));
		cmbShtetet.setBounds(43, 40, 149, 20);
		frame.getContentPane().add(cmbShtetet);
		
		JButton btnParaqite = new JButton("Paraqite");
		btnParaqite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, cmbShtetet.getSelectedItem());
			}
		});
		btnParaqite.setBounds(66, 71, 89, 23);
		frame.getContentPane().add(btnParaqite);
		
		JComboBox cmbShteti1 = new JComboBox();
		cmbShteti1.setBounds(43, 122, 149, 20);
		frame.getContentPane().add(cmbShteti1);
		
		JCheckBox chckKNK = new JCheckBox("KNK\r\n");
		chckKNK.setBounds(66, 164, 97, 23);
		frame.getContentPane().add(chckKNK);
		
		JCheckBox chckPOO = new JCheckBox("POO");
		chckPOO.setBounds(66, 190, 97, 23);
		frame.getContentPane().add(chckPOO);
		
		JButton btnParaqite_1 = new JButton("Paraqite");
		btnParaqite_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckPOO.isSelected() == true && chckKNK.isSelected() == true) {
					JOptionPane.showMessageDialog(null, "Jane zgjedhur dy lendet!");
				} else if (chckPOO.isSelected()) {
					JOptionPane.showMessageDialog(null, "Eshte zgjedhur vetem POO!");					
				} else if (chckKNK.isSelected()) {
					JOptionPane.showMessageDialog(null, "Eshte zgjedhur vetem KNK!");	
				} else {
					JOptionPane.showMessageDialog(null, "Nuk eshte zgjedhur asnjera!");	
				}
			}
		});
		btnParaqite_1.setBounds(66, 234, 89, 23);
		frame.getContentPane().add(btnParaqite_1);
		
		JRadioButton rbMale = new JRadioButton("Male");
		buttonGroup.add(rbMale);
		rbMale.setBounds(229, 164, 109, 23);
		frame.getContentPane().add(rbMale);
		
		JRadioButton rbFemale = new JRadioButton("Female");
		buttonGroup.add(rbFemale);
		rbFemale.setBounds(229, 190, 109, 23);
		frame.getContentPane().add(rbFemale);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rbMale.isSelected()) {
					JOptionPane.showMessageDialog(null, "Male");
				} else {
					JOptionPane.showMessageDialog(null, "Female");
				}
			}
		});
		btnNewButton.setBounds(229, 234, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		txtPassi = new JPasswordField();
		txtPassi.setBounds(437, 40, 125, 20);
		frame.getContentPane().add(txtPassi);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String passi = txtPassi.getText();
				JOptionPane.showMessageDialog(null, passi);
			}
		});
		btnNewButton_1.setBounds(447, 71, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		String[] cmbData = new String[] {"Kosova","Belgjika","Anglia"};
		for (int i=0; i<cmbData.length; i++) {
			cmbShteti1.addItem(cmbData[i]);
		}
	}
}
