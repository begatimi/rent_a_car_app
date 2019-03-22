package java_4;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmFrameKryesore extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmFrameKryesore frame = new frmFrameKryesore();
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
	public frmFrameKryesore() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnProgrami = new JMenu("Programs");
		menuBar.add(mnProgrami);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Toolkit objTk = Toolkit.getDefaultToolkit();
		int width = (int)objTk.getScreenSize().getWidth();
		int height = (int)objTk.getScreenSize().getHeight();
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, width, height);
		contentPane.add(desktopPane);
		
		JMenuItem mntmKalkulatori = new JMenuItem("Kalkulatori i Kredise");
		mntmKalkulatori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//frmKalkulatoriKredise objKK = new frmKalkulatoriKredise();
				//objKK.setVisible(true);
				frmKKInternal objKK = new frmKKInternal();
				desktopPane.add(objKK);
				objKK.setVisible(true);
			}
		});
		mnProgrami.add(mntmKalkulatori);
		
	}
}
