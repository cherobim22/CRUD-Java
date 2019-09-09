package view;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.beanlogin;
import model.dao.loginDAO;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textPass;
	private JLabel label;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//verifica Login
		beanlogin ll = new beanlogin();
		loginDAO ld = new loginDAO();
		
		JButton btnEnviar = new JButton("enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbteste?useTimezone=true&serverTimezone=UTC","root","");
					Statement stmt=con.createStatement();
					String sql="Select * from login where usuario= '"+textUser.getText()+"' and senha = '"+textPass.getText()+"' ";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()) {
						inicial in = new inicial();
						JOptionPane.showMessageDialog(null, "Login bem sucedido");
						in.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Usuario ou senha invalidos\n"+"Tente novamente");
					}
					con.close();
				}catch(Exception e1) {System.out.print(e1);}
				
			}
		});
		btnEnviar.setBounds(43, 198, 89, 40);
		contentPane.add(btnEnviar);
		
		textUser = new JTextField();
		textUser.setBounds(80, 120, 86, 20);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		textPass = new JTextField();
		textPass.setBounds(80, 151, 86, 20);
		contentPane.add(textPass);
		textPass.setColumns(10);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setBounds(20, 123, 50, 14);
		contentPane.add(lblUser);
		
		JLabel lblPass = new JLabel("Senha");
		lblPass.setBounds(20, 153, 36, 17);
		contentPane.add(lblPass);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(login.class.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		label.setBounds(10, 211, 23, 14);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\lucas\\OneDrive\\Imagens\\i3.png"));
		label_1.setBounds(10, 11, 164, 95);
		contentPane.add(label_1);
	}


}
