package java_4;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class frmMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMain frame = new frmMain();
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
	public frmMain() {
		setTitle("formaKryesore");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit objTk = Toolkit.getDefaultToolkit();
		int width = (int)objTk.getScreenSize().getWidth();
		int height = (int)objTk.getScreenSize().getHeight();
		
		setBounds(0, 0, 491, 378);
		
		//MAX
		
		this.setExtendedState(this.MAXIMIZED_BOTH);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
