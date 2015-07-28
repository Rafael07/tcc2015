package br.com.teste.database;

import java.util.ArrayList;
import java.util.List;

import br.com.teste.entidades.Cidadao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BD {

	private SQLiteDatabase bd;
	
	public BD(Context context){
		BDCore auxBd = new BDCore(context);
		bd = auxBd.getWritableDatabase();
	}
	
	public void inserir(Cidadao cadastro){
		ContentValues valores = new ContentValues();
		
		valores.put("cartao_sus", cadastro.getCartao_sus());
		//valores.put("responsavel", cadastro.getResponsavel());
		valores.put("nome", cadastro.getNome());
		valores.put("nome_social", cadastro.getNome_social());
		valores.put("nis", cadastro.getNis());
		valores.put("nome_mae", cadastro.getNome_mae());
		valores.put("pais_nascimento", cadastro.getPais_nascimento());
		valores.put("municipio", cadastro.getMunicipio());
		valores.put("email", cadastro.getEmail());
		valores.put("telefone", cadastro.getTelefone());
		valores.put("aniversario", cadastro.getAniversario());
		
		bd.insert("cadastro", null, valores);		
	}
	
	public void atualizar(Cidadao cadastro){
		ContentValues valores = new ContentValues();
		
		valores.put("cartao_sus", cadastro.getCartao_sus());
		//valores.put("responsavel", cadastro.getResponsavel());
		valores.put("nome", cadastro.getNome());
		valores.put("nome_social", cadastro.getNome_social());
		valores.put("nis", cadastro.getNis());
		valores.put("nome_mae", cadastro.getNome_mae());
		valores.put("pais_nascimento", cadastro.getPais_nascimento());
		valores.put("municipio", cadastro.getMunicipio());
		valores.put("email", cadastro.getEmail());
		valores.put("telefone", cadastro.getTelefone());
		valores.put("aniversario", cadastro.getAniversario());
		
		bd.update("cadastro", valores, "_id = ?", new String[]{""+ cadastro.getId()});
	}
	
	public void deletar(Cidadao cadastro){		
		bd.delete("cadastro", "_id = "+ cadastro.getId(), null);
	}
	
	//adicionar coluna responsavel
	public List<Cidadao> buscar(){
		List<Cidadao> list = new ArrayList<Cidadao>();
		String[] colunas = new String[]{"_id", "cartao_sus", "nome", "nome_social", "nis", "nome_mae", 
				"pais_nascimento", "municipio", "email", "telefone", "aniversario"};
		
		Cursor cursor = bd.query("cadastro", colunas, null, null, null, null, "nome ASC");
		
		if (cursor.getCount() > 0) {
			cursor.moveToFirst();
			
			do{
				
				Cidadao c = new Cidadao();
				c.setId(cursor.getLong(0));
				c.setCartao_sus(cursor.getString(1));
				//c.setResponsavel(cursor.getString(2));
				c.setNome(cursor.getString(2));
				c.setNome_social(cursor.getString(3));
				c.setNis(cursor.getString(4));
				c.setNome_mae(cursor.getString(5));
				c.setPais_nascimento(cursor.getString(6));
				c.setMunicipio(cursor.getString(7));
				c.setEmail(cursor.getString(8));
				c.setTelefone(cursor.getString(9));
				c.setAniversario(cursor.getString(10));
				list.add(c);
				
			} while (cursor.moveToNext());
		}
		
		return(list);
	}
	
	
}
