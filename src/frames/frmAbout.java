package frames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class frmAbout extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAbout frame = new frmAbout();
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
	public frmAbout() {
		setClosable(true);
		setFrameIcon(new ImageIcon(frmAbout.class.getResource("/images/info.png")));
		setTitle("Rreth Nesh");
		setBounds(100, 100, 680, 450);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(frmAbout.class.getResource("/images/University_of_Prishtina_logo.png")));
		label.setBounds(230, 11, 200, 217);
		getContentPane().add(label);
		
		JLabel lblUniversiteti = new JLabel("Universiteti i Prinshtin\u00EBs");
		lblUniversiteti.setHorizontalAlignment(SwingConstants.CENTER);
		if (Gjuha.gjuha == "albanian") {
			lblUniversiteti.setText("Universiteti i Prishtinës");
		} else {
			lblUniversiteti.setText("University of Prishtina");
		}
		lblUniversiteti.setFont(new Font("Courier New", Font.BOLD, 17));
		lblUniversiteti.setBounds(75, 244, 510, 27);
		getContentPane().add(lblUniversiteti);
		
		JLabel lblEmriUniversitetit = new JLabel("\"Hasan Prishtina\"");
		lblEmriUniversitetit.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblEmriUniversitetit.setFont(new Font("Courier New", Font.BOLD, 17));
		lblEmriUniversitetit.setBounds(75, 270, 510, 27);
		getContentPane().add(lblEmriUniversitetit);
		
		JLabel lblDrejtimi = new JLabel("Fakulteti i Inxhinieris\u00EB Elektrike dhe Kompjuterike");
		lblDrejtimi.setHorizontalAlignment(SwingConstants.CENTER);
		if (Gjuha.gjuha == "albanian") {
			lblDrejtimi.setText("Fakulteti i Inxhinieris\u00EB Elektrike dhe Kompjuterike");
		} else {
			lblDrejtimi.setText("Faculty of Electrical and Computer Engineering");
		}
		lblDrejtimi.setFont(new Font("Courier New", Font.BOLD, 17));
		lblDrejtimi.setBounds(10, 320, 644, 27);
		getContentPane().add(lblDrejtimi);
		
		JLabel lblAutoret = new JLabel("Punuar nga: Arber Mazrekaj, Begatim Lekaj, Getoar Gaxherri, Sadri Shehu, Said Sylejmani.");
		if (Gjuha.gjuha == "albanian") {
			lblAutoret.setText("Punuar nga: Arber Mazrekaj, Begatim Lekaj, Getoar Gaxherri, Sadri Shehu, Said Sylejmani.");
		} else {
			lblAutoret.setText("Worked by : Arber Mazrekaj, Begatim Lekaj, Getoar Gaxherri, Sadri Shehu, Said Sylejmani." );
		}
		lblAutoret.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutoret.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblAutoret.setBounds(10, 385, 644, 14);
		getContentPane().add(lblAutoret);

	}

}
