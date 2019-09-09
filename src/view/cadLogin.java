package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.beanlogin;
import model.dao.loginDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class cadLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textUs;
	private JTextField textSe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadLogin frame = new cadLogin();
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
	public cadLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 103, 46, 14);
		contentPane.add(lblUsuario);
		
		textUs = new JTextField();
		textUs.setBounds(66, 100, 86, 20);
		contentPane.add(textUs);
		textUs.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 131, 46, 14);
		contentPane.add(lblSenha);
		
		textSe = new JTextField();
		textSe.setBounds(66, 128, 86, 20);
		contentPane.add(textSe);
		textSe.setColumns(10);
		
		beanlogin ll = new beanlogin();
		loginDAO ld = new loginDAO();
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ll.setUsuario(textUs.getText());
				ll.setSenha(textSe.getText());
				try {
					ld.Create(ll);
					JOptionPane.showMessageDialog(null, "Cadastradado com sucesso");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCadastrar.setBounds(46, 159, 89, 40);
		contentPane.add(btnCadastrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicial in = new inicial();
				in.setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(46, 210, 89, 40);
		contentPane.add(btnSair);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(cadLogin.class.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		lblNewLabel.setBounds(10, 172, 26, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(cadLogin.class.getResource("/com/sun/javafx/scene/web/skin/DecreaseIndent_16x16_JFX.png")));
		lblNewLabel_1.setBounds(10, 223, 26, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\lucas\\OneDrive\\Imagens\\i2.png"));
		lblNewLabel_2.setBounds(10, 0, 164, 89);
		contentPane.add(lblNewLabel_2);
	}
}
