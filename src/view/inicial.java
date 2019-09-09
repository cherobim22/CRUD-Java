package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class inicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicial frame = new inicial();
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
	public inicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarProduto = new JButton("Produtos");
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produto pp = new produto();
				pp.setVisible(true);
				dispose();
			}
		});
		btnCadastrarProduto.setBounds(34, 146, 140, 45);
		contentPane.add(btnCadastrarProduto);
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				login ll = new login();
				ll.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(57, 213, 70, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cadastrar Usuario");
		btnNewButton_2.addActionListener(new ActionListener() {
			cadLogin cl = new cadLogin();
			public void actionPerformed(ActionEvent arg0) {
				cl.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(34, 95, 140, 45);
		contentPane.add(btnNewButton_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(inicial.class.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		label.setBounds(10, 110, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(inicial.class.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		label_1.setBounds(10, 161, 23, 14);
		contentPane.add(label_1);
		
		JLabel lblNewLabelIMG = new JLabel("");
		lblNewLabelIMG.setIcon(new ImageIcon("C:\\Users\\lucas\\OneDrive\\Imagens\\i1.png"));
		lblNewLabelIMG.setBounds(10, 11, 164, 65);
		contentPane.add(lblNewLabelIMG);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(inicial.class.getResource("/com/sun/javafx/scene/web/skin/DecreaseIndent_16x16_JFX.png")));
		label_2.setBounds(34, 224, 23, 14);
		contentPane.add(label_2);
	}
}
