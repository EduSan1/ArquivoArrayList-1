package br.senai.sp.jandira;

import br.senai.sp.jandira.model.Contato;
import br.senai.sp.jandira.ui.TelaCadastro;

public class App {

	public static void main(String[] args) {
		
		DadosContato objDadosContato = new DadosContato();
		Arquivo objArquivo = new Arquivo();
		
		String caminho = "C:\\Users\\21276327\\Desktop\\Contato\\contatos.txt";
		
		//Objetos de contato para teste:
		Contato contato1 = new Contato("Ana Silva", "ana.silva@gmail.com", "1111-2222", "Jandira");
		Contato contato2 = new Contato("Maria Eduarda", "maria.eduarda@gmail.com", "3333-4444", "Barueri");
		Contato contato3 = new Contato("João Santos", "joão.santos@gmail.com", "5555-6666", "Osasco");
		Contato contato4 = new Contato("Carlos Alberto", "carlos.alberto@gmail.com", "7777-8888", "Itapevi");
		
		//Teste de cadastro de contatos
		objDadosContato.cadastrarContato(contato1);
		objDadosContato.cadastrarContato(contato2);
		objDadosContato.cadastrarContato(contato3);
		objDadosContato.cadastrarContato(contato4);
		
		//Percorre o ArrayList de contatos e grava os dados no arquivo txt
		
		//Primeiro exemplo
		/*ArrayList<Contato> listagem = objDadosContato.listarContatos();
		for(Contato contato : listagem) {
			System.out.println("Nome: " + contato.getNome() + "Email: " + contato.getEmail() + "Telefone: " + contato.getTelefone() + "Cidade: " + contato.getCidade());
		}*/
		
		//Segundo exemplo
		String texto = "";
		for(Contato contato : objDadosContato.listarContatos()) {
			//System.out.println(contato.getNome() + ";" + contato.getEmail() + ";" + contato.getTelefone() + ";" + contato.getCidade());
			texto += contato.getNome() + ";" + contato.getEmail() + ";" + contato.getTelefone() + ";" + contato.getCidade() + "\n";
		}
		
		System.out.println(texto);
		
		objArquivo.escrever(caminho, texto);
		
		System.out.println("Total de contatos cadastrados: " + objDadosContato.contarContatos());
		
		TelaCadastro tela = new TelaCadastro();
		tela.setVisible(true);
	}

}
