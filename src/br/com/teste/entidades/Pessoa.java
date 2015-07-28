package br.com.teste.entidades;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class Pessoa {
	
	public static String[] colunas = new String[] { Pessoas._ID, Pessoas.CARTAO_SUS, Pessoas.NOME, Pessoas.NOME_SOCIAL,
												Pessoas.NIS, Pessoas.NOME_MAE, Pessoas.PAIS_NASCIMENTO, Pessoas.MUNICIPIO,
												Pessoas.EMAIL, Pessoas.TELEFONE, Pessoas.ANIVERSARIO, Pessoas.RESPONSAVEL }; 
	
	public static final String AUTHORITY = "br.com.teste.entidades.provider.pessoa"; 
	
	private String cartao_sus, nome, nome_social, nis, nome_mae, 
	pais_nascimento, municipio, email, telefone, aniversario, responsavel; 
	
	public long id; 
	

	 public Pessoa(){
		 
	 }

	 public Pessoa(String cartao_sus, String nome, String nome_social, String nis, String nome_mae,
			 		String pais_nascimento, String municipio, String email, String telefone, String aniversario,
			 		String responsavel) {
		super();
		this.cartao_sus = cartao_sus;
		this.nome = nome;
		this.nome_social = nome_social;
		this.nis = nis;
		this.nome_mae = nome_mae;
		this.pais_nascimento = pais_nascimento;
		this.municipio = municipio;
		this.email = email;
		this.telefone = telefone;
		this.aniversario = aniversario;
		this.responsavel = responsavel;		 
		 
	 }
	 
	 public Pessoa(long id, String cartao_sus, String nome, String nome_social, String nis, String nome_mae,
		 		String pais_nascimento, String municipio, String email, String telefone, String aniversario,
		 		String responsavel) {
		super();
		this.id = id;
		this.cartao_sus = cartao_sus;
		this.nome = nome;
		this.nome_social = nome_social;
		this.nis = nis;
		this.nome_mae = nome_mae;
		this.pais_nascimento = pais_nascimento;
		this.municipio = municipio;
		this.email = email;
		this.telefone = telefone;
		this.aniversario = aniversario;
		this.responsavel = responsavel;		 
	 
}
	 /* 
	  * Classe interna para representar as colunas a serem utilizadas por um
	  * Content Provider
	  * Filha de BaseColumns que já define _id e _count, para seguir o padrão Android
	  * 
	  */
	 
	 public static final class Pessoas implements BaseColumns {
		 
		 private Pessoas(){			 
		 }
		 
		 public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/pessoas"); 

		 public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.google.pessoas";
		 
		 public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.google.pessoas";
		 
		 public static final String DEFAULT_SORT_ORDER = "_id ASC";

		 public static final String CARTAO_SUS = "cartão sus";
		 public static final String NOME = "nome";
		 public static final String NOME_SOCIAL = "nome social";
		 public static final String NIS = "nis";
		 public static final String NOME_MAE = "nome mãe";
		 public static final String PAIS_NASCIMENTO = "país de nascimento";
		 public static final String MUNICIPIO = "município";
		 public static final String EMAIL = "e-mail";
		 public static final String TELEFONE = "telefone";
		 public static final String ANIVERSARIO = "aniversário";
		 public static final String RESPONSAVEL = "responsável";
		 
		 
		 public static Uri getUriId(long id) { 
			 // Adiciona o id na URI default do /pessoas 
			 Uri uriPessoas = ContentUris.withAppendedId(Pessoas.CONTENT_URI, id); 
			 return uriPessoas;
			 }
		 
		 }

	@Override
	public String toString() {
		return "cartao_sus: " + cartao_sus + ", nome: " + nome
				+ ", nome_social: " + nome_social + ", nis: " + nis
				+ ", nome_mae: " + nome_mae + ", pais_nascimento: "
				+ pais_nascimento + ", municipio: " + municipio + ", email: "
				+ email + ", telefone: " + telefone + ", aniversario: "
				+ aniversario + ", responsavel: " + responsavel + "]";
	}

			 
		 
	  
	 
}
