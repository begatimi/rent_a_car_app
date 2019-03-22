package java_3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.Window.Type;

public class frmInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmInfo frame = new frmInfo();
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
	public frmInfo() {
		setType(Type.POPUP);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmInfo.class.getResource("/Images/info.png")));
		setTitle("Info");
		setBounds(100, 100, 633, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel image = new JLabel("");
		image.setHorizontalAlignment(SwingConstants.CENTER);
		image.setIcon(new ImageIcon(frmInfo.class.getResource("/Images/University_of_Prishtina_logo.png")));
		image.setBounds(195, 27, 200, 217);
		contentPane.add(image);
		
		JLabel lblUniversitetiIPrinshtines = new JLabel("Universiteti i Prinshtin\u00EBs");
		lblUniversitetiIPrinshtines.setFont(new Font("Courier New", Font.BOLD, 17));
		lblUniversitetiIPrinshtines.setBounds(165, 270, 260, 27);
		contentPane.add(lblUniversitetiIPrinshtines);
		
		JLabel lblHasanPrishtina = new JLabel("\"Hasan Prishtina\"");
		lblHasanPrishtina.setFont(new Font("Courier New", Font.BOLD, 17));
		lblHasanPrishtina.setBounds(210, 296, 170, 27);
		contentPane.add(lblHasanPrishtina);
		
		JLabel lblFakultetiIInxhinieris = new JLabel("Fakulteti i Inxhinieris\u00EB Elektrike dhe Kompjuterike");
		lblFakultetiIInxhinieris.setFont(new Font("Courier New", Font.BOLD, 17));
		lblFakultetiIInxhinieris.setBounds(50, 346, 510, 27);
		contentPane.add(lblFakultetiIInxhinieris);
		
	}

}
