package br.senai.sp.jandira.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.senai.sp.jandira.Arquivo;
import br.senai.sp.jandira.DadosContato;
import br.senai.sp.jandira.model.Contato;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtCidade;
	
	//Atributos referentes a criação/gravação de contatos
	Contato objContato = null;
	DadosContato objDadosContato = null;
	Arquivo objArquivo = null;

	public TelaCadastro() {
		
		objContato = new Contato();
		objDadosContato = new DadosContato();
		objArquivo = new Arquivo();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroContatos = new JLabel("Cadastro de contatos");
		lblCadastroContatos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCadastroContatos.setBounds(152, 11, 186, 14);
		contentPane.add(lblCadastroContatos);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(30, 53, 69, 14);
		contentPane.add(lblNome);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(30, 91, 69, 14);
		contentPane.add(lblEmail);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefone.setBounds(30, 133, 69, 14);
		contentPane.add(lblTelefone);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCidade.setBounds(30, 180, 69, 14);
		contentPane.add(lblCidade);

		txtNome = new JTextField();
		txtNome.setBounds(112, 51, 300, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(109, 89, 300, 20);
		contentPane.add(txtEmail);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(109, 131, 300, 20);
		contentPane.add(txtTelefone);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(109, 178, 300, 20);
		contentPane.add(txtCidade);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Captura dos dados para o objeto de contato
				objContato.setNome(txtNome.getText());
				objContato.setEmail(txtEmail.getText());
				objContato.setTelefone(txtTelefone.getText());
				objContato.setCidade(txtCidade.getText());
				
				//Preparação dos dados para a gravação mo arquivo txt
				String texto = objContato.getNome() + ";" + objContato.getEmail() + ";" + objContato.getTelefone() + ";" + objContato.getCidade() + "\n";
				
				//Gravação dos dados no arquivo txt
				String caminho = "C:\\Users\\21276327\\Desktop\\Contato\\contatos.txt";
				objArquivo.escrever(caminho, texto);
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCadastrar.setBounds(169, 222, 120, 50);
		contentPane.add(btnCadastrar);
	}
}
