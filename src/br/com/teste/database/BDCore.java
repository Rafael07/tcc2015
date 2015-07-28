package br.com.teste.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDCore extends SQLiteOpenHelper{
	
	public static final String NOME_BD = "teste";
	public static final int VERSAO_BD = 8;
	
	public BDCore(Context ctx) {
		super(ctx, NOME_BD, null, VERSAO_BD);
	}

	//coluna responsavel retirada
	@Override
	public void onCreate(SQLiteDatabase bd) {
		bd.execSQL("create table cadastro(_id integer primary key autoincrement, " +
				"cartao_sus text not null, nome text not null, " +
				"nome_social text not null, nis text not null, nome_mae text not null," +
				" pais_nascimento text not null, municipio text not null, " +
				"email text not null, telefone text not null, aniversario text not null);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
		
		bd.execSQL("drop table cadastro;");
		onCreate(bd);		
	}
	
}
