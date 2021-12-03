package br.senai.sp.jandira;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {

	//Cria o arquivo quando esse não existir e grava dados no arquivo
	public boolean escrever(String caminho, String texto) {
		
		try {
			//Objeto que representa o arquivo
			FileWriter arquivo = new FileWriter(caminho);
			
			//Objeto que representa a manipulação dos dados do arquivo
			PrintWriter escreverArquivo = new PrintWriter(arquivo);
			
			escreverArquivo.append(texto);
			escreverArquivo.close();
			return true; 
		
		}catch(IOException e) {
			System.out.println("Erro: " + e.getMessage());
			return false;
		}
	}
	
	//Realizando a leitura do arquivo
	public String  ler(String caminho) {
		
		String conteudo = "";
		
		try {
			//Representa o arquivo em modo de leitura
			FileReader arquivo = new FileReader(caminho);
			
			//Representa o dado de leitura na memória principal do programa
			BufferedReader lerArquivo = new BufferedReader(arquivo);
			
			String linha = "";
			linha = lerArquivo.readLine();
			
			while(linha != null) {
				conteudo += linha + "\n";
				linha = lerArquivo.readLine();
			}
			arquivo.close();
			return conteudo;
			
		}catch(IOException e){
			System.out.println("Erro: " + e.getMessage());
			return "";
		}
	}
	
}
