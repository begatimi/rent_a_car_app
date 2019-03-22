package java_1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Detyra_1 {

	private JFrame frame;
	private JTextField txtNum1;
	private JTextField txtNum2;
	private JTextField txtRez;
	private JLabel lblRezultati;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitulli = new JLabel("Mbledhja e Numrave");
		lblTitulli.setFont(new Font("Courier New", Font.PLAIN, 20));
		lblTitulli.setBounds(99, 11, 275, 29);
		frame.getContentPane().add(lblTitulli);
		
		JLabel lblNum1 = new JLabel("Numri i par\u00EB:");
		lblNum1.setFont(new Font("Courier New", Font.BOLD, 15));
		lblNum1.setBounds(87, 56, 117, 14);
		frame.getContentPane().add(lblNum1);
		
		txtNum1 = new JTextField();
		txtNum1.setFont(new Font("Courier New", Font.PLAIN, 15));
		txtNum1.setBounds(220, 53, 122, 20);
		frame.getContentPane().add(txtNum1);
		txtNum1.setColumns(10);
		
		JLabel lblNum2 = new JLabel("Numri i dyt\u00EB:");
		lblNum2.setFont(new Font("Courier New", Font.BOLD, 15));
		lblNum2.setBounds(87, 84, 117, 14);
		frame.getContentPane().add(lblNum2);
		
		txtNum2 = new JTextField();
		txtNum2.setFont(new Font("Courier New", Font.PLAIN, 15));
		txtNum2.setColumns(10);
		txtNum2.setBounds(220, 81, 122, 20);
		frame.getContentPane().add(txtNum2);
		
		JButton btnKalkulo = new JButton("KALKULO");
		btnKalkulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				double num1,num2,rez;
				num1=Double.parseDouble(txtNum1.getText());
				num2=Double.parseDouble(txtNum2.getText());
				rez=num1+num2;
				JOptionPane.showMessageDialog(null, "Rezultati r="+rez);
				txtRez.setText(String.valueOf(rez));
			}
		});
		btnKalkulo.setFont(new Font("Courier New", Font.PLAIN, 20));
		btnKalkulo.setBounds(147, 164, 152, 47);
		frame.getContentPane().add(btnKalkulo);
		
		txtRez = new JTextField();
		txtRez.setBounds(220, 112, 122, 20);
		frame.getContentPane().add(txtRez);
		txtRez.setColumns(10);
		
		lblRezultati = new JLabel("Rezultati:");
		lblRezultati.setFont(new Font("Courier New", Font.BOLD, 15));
		lblRezultati.setBounds(87, 115, 117, 14);
		frame.getContentPane().add(lblRezultati);
	}
}
