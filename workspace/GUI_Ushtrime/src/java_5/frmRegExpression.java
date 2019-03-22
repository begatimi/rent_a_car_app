package java_5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class frmRegExpression extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumri;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegExpression frame = new frmRegExpression();
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
	public frmRegExpression() {
		setTitle("Regular Expressions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNumri = new JTextField();
		txtNumri.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// validimi per me shenu vetem numra
				char vchar = e.getKeyChar();
				
				if (!(Character.isDigit(vchar))) {
					if(vchar != '.') {
						getToolkit().beep();
						e.consume();
					} else if ( txtNumri.getText().isEmpty() ) {
						getToolkit().beep();
						e.consume();
					}
				}
				
				char[] charArray = txtNumri.getText().toCharArray();
				
				// Iteracioni per te mos shenuar piken dy here
				for ( int i = 0; i < charArray.length; i++) {
					if (charArray[i] == '.' && vchar == '.') {
						e.consume();
					}
					
				}

			}
		});
		
		txtNumri.setBounds(45, 52, 201, 28);
		contentPane.add(txtNumri);
		txtNumri.setColumns(10);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char vchar = e.getKeyChar();
				if (!(Character.isLetter(vchar))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		textField.setColumns(10);
		textField.setBounds(272, 52, 201, 28);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char vchar = e.getKeyChar();
				if(Character.isLowerCase(vchar)) {
					e.setKeyChar(Character.toUpperCase(vchar));
				}
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(272, 132, 201, 28);
		contentPane.add(textField_1);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(45, 132, 201, 28);
		contentPane.add(txtEmail);
		
		JLabel lblEmail = new JLabel("");
		lblEmail.setForeground(Color.RED);
		lblEmail.setBounds(45, 167, 164, 14);
		contentPane.add(lblEmail);
		
		JButton btnKontrollo = new JButton("Kontrollo");
		btnKontrollo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//filanfisteku@gmail.com
				String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				Pattern pattern = Pattern.compile(emailPattern);
				Matcher regMatcher = pattern.matcher(txtEmail.getText());
				
				if(!regMatcher.matches()) {
					lblEmail.setText("Formati i email-it GABIM!");
				} else {
					lblEmail.setText("Formati OK!");
				}
			}
		});
		btnKontrollo.setBounds(157, 192, 89, 23);
		contentPane.add(btnKontrollo);
		
		JLabel lblShkruaniNumra = new JLabel("Numra:");
		lblShkruaniNumra.setBounds(45, 27, 102, 14);
		contentPane.add(lblShkruaniNumra);
		
		JLabel lblShkruaniTekst = new JLabel("Tekst:");
		lblShkruaniTekst.setBounds(272, 27, 108, 14);
		contentPane.add(lblShkruaniTekst);
		
		JLabel lblEmail_1 = new JLabel("Email:");
		lblEmail_1.setBounds(45, 107, 102, 14);
		contentPane.add(lblEmail_1);
		
		JLabel lblShkruaniTekstUppercase = new JLabel("Tekst Uppercase:");
		lblShkruaniTekstUppercase.setBounds(272, 107, 108, 14);
		contentPane.add(lblShkruaniTekstUppercase);
	}
}
