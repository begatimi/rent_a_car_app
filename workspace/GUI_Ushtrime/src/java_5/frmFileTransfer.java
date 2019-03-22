package java_5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;

public class frmFileTransfer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmFileTransfer frame = new frmFileTransfer();
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
	public frmFileTransfer() {
		setTitle("Kalkulatori per transferimin e fajllave");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKalkulatoriPerTransferimin = new JLabel("KALKULATORI PER TRANSFERIMIN E FAJLLAVE");
		lblKalkulatoriPerTransferimin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblKalkulatoriPerTransferimin.setBounds(77, 27, 398, 26);
		contentPane.add(lblKalkulatoriPerTransferimin);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Rregullimet", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(37, 83, 479, 74);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSasiaETe = new JLabel("Sasia e te dhenave:");
		lblSasiaETe.setBounds(21, 29, 123, 20);
		panel.add(lblSasiaETe);
		
		JComboBox<String> cmbData = new JComboBox<String>();
		cmbData.setModel(new DefaultComboBoxModel<String>(new String[] {"KB", "MB", "GB", "TB"}));
		cmbData.setBounds(139, 29, 78, 20);
		panel.add(cmbData);
		
		JLabel lblBandwidth = new JLabel("Bandwidth:");
		lblBandwidth.setBounds(294, 29, 68, 20);
		panel.add(lblBandwidth);
		
		JComboBox<String> cmbRate = new JComboBox<String>();
		cmbRate.setModel(new DefaultComboBoxModel<String>(new String[] {"Kbps", "Mbps", "Gbps"}));
		cmbRate.setBounds(367, 29, 78, 20);
		panel.add(cmbRate);
		
		JLabel lblSasiaETe_1 = new JLabel("Sasia e te dhenave:");
		lblSasiaETe_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSasiaETe_1.setBounds(88, 194, 114, 26);
		contentPane.add(lblSasiaETe_1);
		
		JSlider slData = new JSlider();
		
		slData.setMaximum(1024);
		slData.setMinimum(1);
		slData.setBounds(45, 231, 200, 26);
		contentPane.add(slData);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(266, 231, 64, 26);
		contentPane.add(lblData);
		
		JLabel lblShkallaETransferit = new JLabel("Shkalla e transferit:");
		lblShkallaETransferit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblShkallaETransferit.setBounds(88, 293, 114, 26);
		contentPane.add(lblShkallaETransferit);
		
		JSlider slRate = new JSlider();
		
		slRate.setMaximum(1000);
		slRate.setMinimum(1);
		slRate.setBounds(45, 330, 200, 26);
		contentPane.add(slRate);
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setBounds(266, 330, 64, 26);
		contentPane.add(lblRate);
		
		JLabel lblKoha = new JLabel("Koha e transferimit");
		lblKoha.setHorizontalAlignment(SwingConstants.CENTER);
		lblKoha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblKoha.setBounds(310, 280, 231, 26);
		contentPane.add(lblKoha);
		
		
		slData.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int totalSekonda = 0;
				
				if ( cmbData.getSelectedItem() == "KB") {
					if ( cmbRate.getSelectedItem() == "Kbps") {

						totalSekonda =  slData.getValue()*8/slRate.getValue();
						
					} else if (cmbRate.getSelectedItem() == "Mbps") {

						totalSekonda =  (slData.getValue()*8)/1024/slRate.getValue();
												
					} else {
						//Gbps
						totalSekonda =  (int) ((slData.getValue()*8)/Math.pow(1024, 2)/slRate.getValue());
												
					}
				} else if ( cmbData.getSelectedItem() == "MB") {
					if ( cmbRate.getSelectedItem() == "Kbps") {

						totalSekonda =  slData.getValue()*8*1024/slRate.getValue();
											
					} else if (cmbRate.getSelectedItem() == "Mbps") {

						totalSekonda = slData.getValue()*8/slRate.getValue();
												
					} else {

						totalSekonda = slData.getValue()*8/(slRate.getValue()*1024);
						
					}
				} else if ( ( cmbData.getSelectedItem() == "GB")) {
					if ( cmbRate.getSelectedItem() == "Kbps") {

						totalSekonda = (int) (slData.getValue()*8/(slRate.getValue()/Math.pow(1024, 3)));
												
					} else if (cmbRate.getSelectedItem() == "Mbps") {

						totalSekonda = (int) (slData.getValue()*8/(slRate.getValue()/Math.pow(1024, 2)));
												
					} else {

						totalSekonda = slData.getValue()*8/(slRate.getValue()/1024);
						
					}
				} else {
					//logartija per TB 
					if ( cmbRate.getSelectedItem() == "Kbps") {

						totalSekonda = (int) ((slData.getValue()*8)*Math.pow(1024, 3)/slRate.getValue());
																		
					} else if (cmbRate.getSelectedItem() == "Mbps") {
						
						totalSekonda = (int) ((slData.getValue()*8)*Math.pow(1024, 2)/slRate.getValue());
											
					} else {

						totalSekonda = (slData.getValue()*8)*1024/slRate.getValue();
											
					}
				}
				
				// Caktimi i vlerave per Data dhe Rate
				lblData.setText(String.valueOf(slData.getValue())+ " " + cmbData.getSelectedItem());
				lblRate.setText(String.valueOf(slRate.getValue())+ " " + cmbRate.getSelectedItem());
				
				// Llogaritja e Kohes permes klases CaktoKohen
				CaktoKohen.llogariteKohen(totalSekonda);
				lblKoha.setText(CaktoKohen.shtypKohen());
			}
		});
		
		
		slRate.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int totalSekonda = 0;
				
				if ( cmbData.getSelectedItem() == "KB") {
					if ( cmbRate.getSelectedItem() == "Kbps") {

						totalSekonda =  slData.getValue()*8/slRate.getValue();
						
					} else if (cmbRate.getSelectedItem() == "Mbps") {

						totalSekonda =  (slData.getValue()*8)/1024/slRate.getValue();
												
					} else {
						//Gbps
						totalSekonda =  (int) ((slData.getValue()*8)/Math.pow(1024, 2)/slRate.getValue());
												
					}
				} else if ( cmbData.getSelectedItem() == "MB") {
					if ( cmbRate.getSelectedItem() == "Kbps") {

						totalSekonda =  slData.getValue()*8*1024/slRate.getValue();
											
					} else if (cmbRate.getSelectedItem() == "Mbps") {

						totalSekonda = slData.getValue()*8/slRate.getValue();
												
					} else {

						totalSekonda = slData.getValue()*8/(slRate.getValue()*1024);
						
					}
				} else if ( ( cmbData.getSelectedItem() == "GB")) {
					if ( cmbRate.getSelectedItem() == "Kbps") {

						totalSekonda = (int) (slData.getValue()*8/(slRate.getValue()/Math.pow(1024, 3)));
												
					} else if (cmbRate.getSelectedItem() == "Mbps") {

						totalSekonda = (int) (slData.getValue()*8/(slRate.getValue()/Math.pow(1024, 2)));
												
					} else {

						totalSekonda = slData.getValue()*8/(slRate.getValue()/1024);
						
					}
				} else {
					//logartija per TB 
					if ( cmbRate.getSelectedItem() == "Kbps") {

						totalSekonda = (int) ((slData.getValue()*8)*Math.pow(1024, 3)/slRate.getValue());
																		
					} else if (cmbRate.getSelectedItem() == "Mbps") {
						
						totalSekonda = (int) ((slData.getValue()*8)*Math.pow(1024, 2)/slRate.getValue());
											
					} else {

						totalSekonda = (slData.getValue()*8)*1024/slRate.getValue();
											
					}
				}
				
				// Caktimi i vlerave per Data dhe Rate
				lblData.setText(String.valueOf(slData.getValue())+ " " + cmbData.getSelectedItem());
				lblRate.setText(String.valueOf(slRate.getValue())+ " " + cmbRate.getSelectedItem());
				
				// Llogaritja e Kohes permes klases CaktoKohen
				CaktoKohen.llogariteKohen(totalSekonda);
				lblKoha.setText(CaktoKohen.shtypKohen());
			}
		});
	}
}

final class CaktoKohen {
	static int dita,ora,minutat,sekondat;
	
	private CaktoKohen(){};
	
	static void llogariteKohen(int totalSekonda) {
	    dita = totalSekonda/86400;
		ora = (totalSekonda/3600)%24;
		minutat = (totalSekonda%3600)/60;
		sekondat = totalSekonda%60;
	}
	
	static String shtypKohen() {
		String koha = "Koha e transferimit";
		
		if ( dita == 0 ) {
			koha = String.format("%02d:%02d:%02d", ora, minutat, sekondat);
		} else {
			koha = String.format("%02d:%02d:%02d:%02d", dita,ora,minutat,sekondat);
		} 
		
		return koha;
	}
}
