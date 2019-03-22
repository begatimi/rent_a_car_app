package java_6;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.UpdatableResultSet;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmStudentet extends JFrame {

	private JPanel contentPane;
	private JTable tblStudentet;
	
	// objekti per lidhje
	Connection conn = null;
	// objekti per vendosje te rezultatit
	ResultSet res = null;
	// objekti per query
	PreparedStatement pst = null;
	
	
	private int id; //variabla per marjen e id per delete
	private JLabel lblEmri;
	private JTextField txtEmri;
	private JTextField txtMbiemri;
	private JLabel lblInfo;
	private JButton btnDelete;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmStudentet frame = new frmStudentet();
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
	public frmStudentet() {
		
		// lidhja me klasen sqlFiekDBconnection
		conn = sqlFiekDBconnect.connectFiekDb();
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFormaPerRegjistrimin = new JLabel("FORMA PER REGJISTRIMIN E STUDENTEVE");
		lblFormaPerRegjistrimin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFormaPerRegjistrimin.setBounds(178, 34, 336, 14);
		contentPane.add(lblFormaPerRegjistrimin);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 741, 147);
		contentPane.add(scrollPane);
		
		tblStudentet = new JTable();
		tblStudentet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)tblStudentet.getModel();
				id = (int)model.getValueAt(tblStudentet.getSelectedRow(), 0);
				//JOptionPane.showMessageDialog(null, "id= "+id);
				try {
					String sql = "select * from tblstudentet where id='"+id+"'";
					pst = conn.prepareStatement(sql);
					res = pst.executeQuery();
					
					while(res.next()) {
						txtEmri.setText(res.getString("emri"));
						txtMbiemri.setText(res.getString("mbiemri"));
					}
					pst.close();
				} catch (Exception e2) {
					
				}
			}
		});
		scrollPane.setViewportView(tblStudentet);
		
		lblEmri = new JLabel("Emri");
		lblEmri.setBounds(10, 271, 46, 14);
		contentPane.add(lblEmri);
		
		txtEmri = new JTextField();
		txtEmri.setBounds(76, 268, 86, 20);
		contentPane.add(txtEmri);
		txtEmri.setColumns(10);
		
		JLabel lblMbiemri = new JLabel("Mbiemri");
		lblMbiemri.setBounds(10, 299, 46, 14);
		contentPane.add(lblMbiemri);
		
		txtMbiemri = new JTextField();
		txtMbiemri.setColumns(10);
		txtMbiemri.setBounds(76, 296, 86, 20);
		contentPane.add(txtMbiemri);
		
		JButton btnRegjistro = new JButton("Regjistro");
		btnRegjistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtEmri.getText().isEmpty() && !txtMbiemri.getText().isEmpty() ) {
					try {
						String sql = "insert into tblstudentet (id,emri,mbiemri) values"+"(default,'"+ txtEmri.getText()+"','"+txtMbiemri.getText()+"')";
						pst = conn.prepareStatement(sql);
						pst.execute();
						pst.close();
						updateTable();
						txtEmri.setText("");
						txtMbiemri.setText("");
						lblInfo.setText("Regjistrimi eshte bere me sukses!");
						
					} catch (Exception e) {
						
					}
				} else {
					lblInfo.setText("Kontrollo te dhenat hyrese!");
				}
			}
		});
		btnRegjistro.setBounds(256, 290, 89, 23);
		contentPane.add(btnRegjistro);
		
		lblInfo = new JLabel("");
		lblInfo.setForeground(Color.RED);
		lblInfo.setBounds(10, 324, 233, 14);
		contentPane.add(lblInfo);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					String sql="delete from tblstudentet where id='"+id+"'";
					pst=conn.prepareStatement(sql);
					pst.execute();
					updateTable();
					txtEmri.setText("");
					txtMbiemri.setText("");
					lblInfo.setText("Studenti u fshi me sukses!");
					pst.close();
				} 
				catch (Exception e2) 
				{
					JOptionPane.showMessageDialog(null, "Error gjate fshirjes");
				}
			}
		});
		btnDelete.setBounds(256, 324, 89, 23);
		contentPane.add(btnDelete);
		
		updateTable();
	}
	
	public void updateTable() {
		try {
			//pyetsori per database
			String sql = "select id as 'ID', emri as 'Emri', mbiemri as 'Mbiemri' from tblstudentet";
			pst = conn.prepareStatement(sql);
			res = pst.executeQuery();
			
			tblStudentet.setModel(DbUtils.resultSetToTableModel(res));
			pst.close();
		} catch (Exception e) {
			
		}
	}
}
