package br.com.teste.activity;


import com.example.testebd.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);		
	}

	public void iniciarActivity(View view){
		
		Button bt = (Button) view;
		Intent intent;
		
		if(bt.getText().toString().equalsIgnoreCase("Novo Cadastro")){
			intent = new Intent(this, DashboardActivity.class);
		}
		else{
			intent = new Intent(this, ListCadastroActivity.class);
		}
		
		startActivity(intent);
		
	}
	
	
}
