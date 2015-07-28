package br.com.teste.activity;


import com.example.testebd.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
		
	}
	
	public void selecionarOpcao(View view){
		
		switch (view.getId()) {
		case R.id.id_usuario:
			startActivity(new Intent(this, NovoCadastroActivity.class));
			break;
			
		case R.id.inf_sociodem:
			startActivity(new Intent(this, InfoSociodemActivity.class));
			break;
		
		case R.id.condicoes:
			startActivity(new Intent(this, CondicoesActivity.class));
			break;
			
		case R.id.cadastros:
			//startActivity(new Intent(this, CadastroListActivity.class));
			break;
		}	
	}
}
