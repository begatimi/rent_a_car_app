package java_3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class frmTempConverter extends JFrame {

	private JPanel contentPane;
	private JTextField txtTempInput;
	private JTextField txtTempOutput;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmTempConverter frame = new frmTempConverter();
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
	public frmTempConverter() {
		setType(Type.POPUP);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmTempConverter.class.getResource("/Images/temperature.png")));
		setTitle("Konvertimi i Temperatures");
		setBounds(100, 100, 387, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Prej", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(23, 31, 121, 98);
		contentPane.add(panel);
		
		JRadioButton rdCelsius = new JRadioButton("Celsius");
		buttonGroup.add(rdCelsius);
		rdCelsius.setSelected(true);
		rdCelsius.setBounds(6, 16, 109, 23);
		panel.add(rdCelsius);
		
		JRadioButton rdFahrenheit = new JRadioButton("Fahrenheit");
		buttonGroup.add(rdFahrenheit);
		rdFahrenheit.setBounds(6, 42, 109, 23);
		panel.add(rdFahrenheit);
		
		JRadioButton rdKelvin = new JRadioButton("Kelvin");
		buttonGroup.add(rdKelvin);
		rdKelvin.setBounds(6, 68, 109, 23);
		panel.add(rdKelvin);
		
		JComboBox cmbTemp = new JComboBox();
		cmbTemp.setModel(new DefaultComboBoxModel(new String[] {"Zgjedh", "Celsius", "Fahrenheit", "Kelvin"}));
		cmbTemp.setBounds(55, 190, 89, 20);
		contentPane.add(cmbTemp);
		
		txtTempInput = new JTextField();
		txtTempInput.setColumns(10);
		txtTempInput.setBounds(223, 49, 89, 20);
		contentPane.add(txtTempInput);
		
		txtTempOutput = new JTextField();
		txtTempOutput.setEditable(false);
		txtTempOutput.setColumns(10);
		txtTempOutput.setBounds(223, 190, 89, 20);
		contentPane.add(txtTempOutput);
		
		NumberFormat formateri = new DecimalFormat("#0.000");   
		
		JButton btnKonverto = new JButton("Konverto");
		btnKonverto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double celsius, kelvin, fahrenheit;
				
				if (txtTempInput.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ju lutem shkruajeni vleren qe deshironi ta konvertoni!");
					txtTempInput.requestFocusInWindow();
				} else {
					if(rdCelsius.isSelected()) {
						celsius = Double.parseDouble(txtTempInput.getText());
						if( cmbTemp.getSelectedIndex() == 3) {
							kelvin = celsius + 273.15;
							txtTempOutput.setText(String.valueOf(formateri.format(kelvin)));
						} else if (cmbTemp.getSelectedIndex() == 2) {
							fahrenheit = celsius * 9 / 5 + 32;
							txtTempOutput.setText(String.valueOf(formateri.format(fahrenheit)));
						} else if (cmbTemp.getSelectedIndex() == 1) {
							txtTempOutput.setText(String.valueOf(formateri.format(celsius)));
						}
					} else if (rdFahrenheit.isSelected()) {
						fahrenheit = Double.parseDouble(txtTempInput.getText());
						if( cmbTemp.getSelectedIndex() == 3) {
							kelvin = (fahrenheit + 459.67) * 5/9.;
							txtTempOutput.setText(String.valueOf(formateri.format(kelvin)));
						} else if (cmbTemp.getSelectedIndex() == 2) {
							txtTempOutput.setText(String.valueOf(formateri.format(fahrenheit)));
						} else if (cmbTemp.getSelectedIndex() == 1) {
							celsius = (fahrenheit - 32) * 5/9.;
							txtTempOutput.setText(String.valueOf(formateri.format(celsius)));
						}
					} else if (rdKelvin.isSelected()) {
						kelvin = Double.parseDouble(txtTempInput.getText());
						if( cmbTemp.getSelectedIndex() == 3) {
							txtTempOutput.setText(String.valueOf(formateri.format(kelvin)));
						} else if (cmbTemp.getSelectedIndex() == 2) {
							fahrenheit = kelvin * 9/5. - 459.67;
							txtTempOutput.setText(String.valueOf(formateri.format(fahrenheit)));
						} else if (cmbTemp.getSelectedIndex() == 1) {
							celsius = kelvin - 273.15;
							txtTempOutput.setText(String.valueOf(formateri.format(celsius)));
						}
					}
				}
				
			}
		});
		btnKonverto.setBounds(223, 118, 89, 23);
		contentPane.add(btnKonverto);
		
		JLabel lblN = new JLabel("N\u00EB");
		lblN.setBounds(35, 193, 23, 14);
		contentPane.add(lblN);
	}
}
