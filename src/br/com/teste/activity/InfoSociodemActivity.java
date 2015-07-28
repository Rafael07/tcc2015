package br.com.teste.activity;

import com.example.testebd.R;

import br.com.teste.entidades.Cidadao;
import android.app.Activity;
import android.os.Bundle;

public class InfoSociodemActivity extends Activity {

	private Cidadao info = new Cidadao();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inf_sociodem);
	}
}
