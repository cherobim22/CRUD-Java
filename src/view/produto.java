package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;


import model.bean.beanprodutos;
import model.dao.produtoDAO;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class produto extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textValor;
	private JTextField textUn;
	private static JTable tableP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					produto frame = new produto();
					ReadTable1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	beanprodutos pp = new beanprodutos();
	produtoDAO pd = new produtoDAO();
	private JTextField textId;
	
	public static void ReadTable1() {
		DefaultTableModel readd = (DefaultTableModel) tableP.getModel();
		readd.setNumRows(0);
		produtoDAO pd = new produtoDAO();
		for(beanprodutos pp: pd.readProduto() ) {
			readd.addRow(new Object[] {
					pp.getId(),
					pp.getNome(),
					pp.getValor(),
					pp.getUnidade(),
				
					
			});
		}
		
	}
	/**
	 * Create the frame.
	 */
	public produto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(73, 84, 33, 14);
		contentPane.add(lblNome);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(171, 84, 24, 14);
		contentPane.add(lblValor);
		
		JLabel lblUnidades = new JLabel("Unidades");
		lblUnidades.setBounds(269, 84, 46, 14);
		contentPane.add(lblUnidades);
		
		textNome = new JTextField();
		textNome.setBounds(105, 81, 60, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textValor = new JTextField();
		textValor.setBounds(205, 81, 60, 20);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		textUn = new JTextField();
		textUn.setBounds(325, 81, 60, 20);
		contentPane.add(textUn);
		textUn.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//SetProduto
				
				pp.setNome(textNome.getText());
				pp.setValor(textValor.getText());
				pp.setUnidade(textUn.getText());
				
				try {
					pd.Create(pp);
					JOptionPane.showMessageDialog(null, "Cadastradado com sucesso");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ReadTable1();
			}
		});
		btnCadastrar.setBounds(19, 227, 87, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableP.getSelectedRow() != -1) {
					beanprodutos bp = new beanprodutos();
					produtoDAO dao = new produtoDAO();
							bp.setId((int)tableP.getValueAt(tableP.getSelectedRow(),0));
							dao.DeletP(bp);
							
							textId.setText("");
							textNome.setText("");
							textValor.setText("");
							textUn.setText("");
					
							ReadTable1();		
					}
			}
		});
		btnExcluir.setBounds(205, 227, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beanprodutos bp = new beanprodutos();
				produtoDAO pd = new produtoDAO();
				if(tableP.getSelectedRow() != -1) {
					try {		
						bp.setId(Integer.parseInt(textId.getText()));
						bp.setNome(String.valueOf(textNome.getText()));
						bp.setValor(String.valueOf(textValor.getText()));
						bp.setUnidade(String.valueOf(textUn.getText()));
					
					
				
						pd.UpdateP(bp);
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ReadTable1();
						
								
				}
			}
		});
		btnAlterar.setBounds(114, 227, 81, 23);
		contentPane.add(btnAlterar);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicial in = new inicial();
				in.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(304, 227, 81, 22);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				textId.setText(tableP.getValueAt(tableP.getSelectedRow(), 0).toString());
				textNome.setText(tableP.getValueAt(tableP.getSelectedRow(), 1).toString());
				textValor.setText(tableP.getValueAt(tableP.getSelectedRow(), 2).toString());
				textUn.setText(tableP.getValueAt(tableP.getSelectedRow(), 3).toString());
			}
		});
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tableP.getSelectedRow() != -1) {
					textId.setText(tableP.getValueAt(tableP.getSelectedRow(), 0).toString());
					textNome.setText(tableP.getValueAt(tableP.getSelectedRow(), 1).toString());
					textValor.setText(tableP.getValueAt(tableP.getSelectedRow(), 2).toString());
					textUn.setText(tableP.getValueAt(tableP.getSelectedRow(), 3).toString());
				}
			}
		});
		scrollPane.setBounds(19, 109, 366, 95);
		contentPane.add(scrollPane);
		
		tableP = new JTable();
		tableP.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "Valor", "Unidade"
			}
		));
		tableP.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableP.getColumnModel().getColumn(1).setPreferredWidth(50);
		tableP.getColumnModel().getColumn(2).setPreferredWidth(50);
		tableP.getColumnModel().getColumn(3).setPreferredWidth(50);
		scrollPane.setViewportView(tableP);
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setBounds(30, 81, 33, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 84, 15, 14);
		contentPane.add(lblId);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\lucas\\OneDrive\\Imagens\\i1.png"));
		label.setBounds(88, 11, 175, 59);
		contentPane.add(label);
	}
}
