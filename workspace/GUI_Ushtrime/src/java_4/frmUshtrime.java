package java_4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class frmUshtrime extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmUshtrime frame = new frmUshtrime();
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
	public frmUshtrime() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSasia = new JLabel("Sasia");
		lblSasia.setBounds(30, 45, 46, 14);
		contentPane.add(lblSasia);
		
		JSpinner spnSasia = new JSpinner();
		spnSasia.setBounds(72, 42, 46, 20);
		contentPane.add(spnSasia);
		
		JButton btnParaqit = new JButton("Paraqit");
		btnParaqit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Sasia s="+spnSasia.getValue());
			}
		});
		btnParaqit.setBounds(29, 82, 89, 23);
		contentPane.add(btnParaqit);
		
		JToggleButton tglA = new JToggleButton("Off");
		tglA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tglA.isSelected()) {
					tglA.setText("On");
				} else {
					tglA.setText("Off");
				}
			}
		});
		tglA.setBounds(23, 128, 121, 23);
		contentPane.add(tglA);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 162, 121, 14);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(23, 116, 121, 14);
		contentPane.add(separator_1);
		
		JSlider slider = new JSlider();
		slider.setBounds(23, 187, 205, 46);
		contentPane.add(slider);
		
		//distanca ne mes numrave kryesor
		slider.setMajorTickSpacing(20);
		//numri i vizave te vogela
		slider.setMinorTickSpacing(5);
		//paraqitja e numrave kryesor
		slider.setPaintLabels(true);
		//paraqitja e vizave te vogela
		slider.setPaintTicks(true);
		//caktimi i veleres default
		slider.setValue(10);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(262, 29, 319, 204);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Regjistro", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblEmri = new JLabel("Emri");
		lblEmri.setBounds(30, 31, 46, 14);
		panel.add(lblEmri);
		
		JLabel lblMbiemri = new JLabel("Mbiemri");
		lblMbiemri.setBounds(30, 56, 46, 14);
		panel.add(lblMbiemri);
		
		textField = new JTextField();
		textField.setBounds(101, 28, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 53, 86, 20);
		panel.add(textField_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Fshij", null, panel_1, null);
		
		JRadioButton rdbtnA = new JRadioButton("A");
		rdbtnA.setToolTipText("Ky eshte nje radiobutton dhe shkurtesa per te eshte ALT + A\r\n");
		buttonGroup.add(rdbtnA);
		rdbtnA.setMnemonic('a');
		rdbtnA.setBounds(35, 281, 109, 23);
		contentPane.add(rdbtnA);
		
		JRadioButton rdbtnB = new JRadioButton("B");
		rdbtnB.setMnemonic('b');
		buttonGroup.add(rdbtnB);
		rdbtnB.setBounds(35, 307, 109, 23);
		contentPane.add(rdbtnB);
		
		JRadioButton rdbtnC = new JRadioButton("C");
		rdbtnC.setMnemonic('c');
		buttonGroup.add(rdbtnC);
		rdbtnC.setBounds(35, 333, 109, 23);
		contentPane.add(rdbtnC);
	}
}
