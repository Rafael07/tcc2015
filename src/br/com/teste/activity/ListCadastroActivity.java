package br.com.teste.activity;

import java.util.List;

import br.com.teste.CadastroAdapter;
import br.com.teste.database.BD;
import br.com.teste.entidades.Cidadao;

import android.app.ListActivity;
import android.os.Bundle;

public class ListCadastroActivity extends ListActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.listar_cadastros);
		
		BD bd = new BD(this);
		
		List<Cidadao> list = bd.buscar();
		setListAdapter(new CadastroAdapter(this, list));
	}

}
