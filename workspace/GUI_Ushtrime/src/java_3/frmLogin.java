package java_3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;


public class frmLogin {
	
	int count = 0;
	char[] fjalekalimi = {'1','2','3'};
	
	private JFrame frmFormaPerLogin;
	private JTextField txtPerdoruesi;
	private JPasswordField txtFjalekalimi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin window = new frmLogin();
					window.frmFormaPerLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmLogin() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFormaPerLogin = new JFrame();
		frmFormaPerLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(frmLogin.class.getResource("/Images/login.png")));
		frmFormaPerLogin.setTitle("Forma per Login");
		frmFormaPerLogin.setBounds(100, 100, 594, 418);
		frmFormaPerLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFormaPerLogin.getContentPane().setLayout(null);
		
		JLabel lblMirsevini = new JLabel("Mir\u00EBsevini!");
		lblMirsevini.setFont(new Font("Courier New", Font.BOLD, 25));
		lblMirsevini.setBounds(310, 33, 172, 29);
		frmFormaPerLogin.getContentPane().add(lblMirsevini);
		
		JLabel label = new JLabel("Perdoruesi:");
		label.setFont(new Font("Courier New", Font.PLAIN, 15));
		label.setBounds(267, 118, 105, 14);
		frmFormaPerLogin.getContentPane().add(label);
		
		txtPerdoruesi = new JTextField();
		txtPerdoruesi.setColumns(10);
		txtPerdoruesi.setBounds(397, 115, 155, 20);
		frmFormaPerLogin.getContentPane().add(txtPerdoruesi);
		
		JLabel label_1 = new JLabel("Fjalekalimi:");
		label_1.setFont(new Font("Courier New", Font.PLAIN, 15));
		label_1.setBounds(267, 156, 110, 14);
		frmFormaPerLogin.getContentPane().add(label_1);
		
		txtFjalekalimi = new JPasswordField();
		txtFjalekalimi.setBounds(397, 153, 155, 20);
		frmFormaPerLogin.getContentPane().add(txtFjalekalimi);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(frmLogin.class.getResource("/Images/security.png")));
		lblNewLabel.setBounds(21, 62, 256, 256);
		frmFormaPerLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblInfo = new JLabel("");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setForeground(Color.RED);
		lblInfo.setBounds(267, 182, 285, 14);
		frmFormaPerLogin.getContentPane().add(lblInfo);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String perdoruesi, perdoruesiDB;
				perdoruesi = txtPerdoruesi.getText();
				perdoruesiDB = "fiek";
				
				if ( perdoruesi.equals(perdoruesiDB) && Arrays.equals(txtFjalekalimi.getPassword(), fjalekalimi)) {
					//lblInfo.setText("Jeni qasur me sukses");
					
					frmFormaPerLogin.dispose();
					frmMain objMain = new frmMain();
					objMain.setVisible(true);
				} else {
					count++;
					lblInfo.setText("Perdoruesi ose fjalekalimi gabim!");
					if (count >= 4 ) {
						System.exit(0);
					}
					if (count >= 3) {
						lblInfo.setText("Llogaria juaj eshte bllokuar!");
						fjalekalimi = null;
					}
					
				}
			}
		});
		
		
		btnLogin.setFont(new Font("Courier New", Font.PLAIN, 17));
		btnLogin.setBounds(363, 224, 93, 29);
		frmFormaPerLogin.getContentPane().add(btnLogin);
			
	}
	

}


