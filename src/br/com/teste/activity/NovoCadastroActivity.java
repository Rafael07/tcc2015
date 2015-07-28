package br.com.teste.activity;

import br.com.teste.Mask;
import br.com.teste.Validator;
import br.com.teste.database.BD;
import br.com.teste.entidades.Cidadao;

import com.example.testebd.R.id;
import com.example.testebd.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class NovoCadastroActivity extends Activity {
	
	private Cidadao cadastro = new Cidadao();
	
	private EditText cartao_susET, nomeET, nome_maeET, nome_socialET, nisET, aniversarioET,
					paisET, municipioET, telefoneET, emailET, aniversario2ET, cartao_sus2ET;
	
	private Button salvarBT, editarBT;
	
	private RadioGroup responsavelRG;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(com.example.testebd.R.layout.novo_cadastro);
		
		cartao_susET = (EditText) findViewById(id.cartao_sus);
		cartao_sus2ET = (EditText) findViewById(id.cartao_sus2);
		nomeET = (EditText) findViewById(id.nome);
		nome_maeET = (EditText) findViewById(id.nome_mae);
		nome_socialET = (EditText) findViewById(id.nome_social);
		nisET = (EditText) findViewById(id.nis);		
		aniversarioET = (EditText) findViewById(id.aniversario);
		aniversarioET.addTextChangedListener(Mask.insert("##/##/####", aniversarioET));		
		aniversario2ET = (EditText) findViewById(id.aniversario2);
		aniversario2ET.addTextChangedListener(Mask.insert("##/##/####", aniversario2ET));
		paisET = (EditText) findViewById(id.pais);
		municipioET = (EditText) findViewById(id.municipio);		
		telefoneET = (EditText) findViewById(id.telefone);
		telefoneET.addTextChangedListener(Mask.insert("(##)#####-####", telefoneET));
		emailET = (EditText) findViewById(id.email);
		salvarBT = (Button) findViewById(id.button1);
		editarBT = (Button) findViewById(id.button2);
		responsavelRG = (RadioGroup) findViewById(id.responsavel);
		
		
		Intent intent = getIntent();
		if (intent != null) {
			Bundle bundle = intent.getExtras();
			if (bundle != null) {
				
				cadastro.setId(bundle.getLong("id"));
				cadastro.setCartao_sus(bundle.getString("cartao_sus"));
				cadastro.setNome(bundle.getString("nome"));
				cadastro.setNome_mae(bundle.getString("nome_mae"));
				cadastro.setNome_social(bundle.getString("nome_social"));
				cadastro.setNis(bundle.getString("nis"));
				cadastro.setAniversario(bundle.getString("aniversario"));
				cadastro.setPais_nascimento(bundle.getString("pais_nascimento"));
				cadastro.setMunicipio(bundle.getString("municipio"));
				cadastro.setTelefone(bundle.getString("telefone"));
				cadastro.setEmail(bundle.getString("email"));
				//cadastro.setResponsavel(bundle.getString("responsavel"));
				
				nomeET.setText(cadastro.getNome());
				cartao_susET.setText(cadastro.getCartao_sus());
				nome_socialET.setText(cadastro.getNome_social());
				nome_maeET.setText(cadastro.getNome_mae());
				nisET.setText(cadastro.getNis());
				aniversarioET.setText(cadastro.getAniversario());
				paisET.setText(cadastro.getPais_nascimento());
				municipioET.setText(cadastro.getMunicipio());
				telefoneET.setText(cadastro.getTelefone());
				emailET.setText(cadastro.getEmail());
				
			
				salvarBT.setVisibility(View.GONE);
				editarBT.setVisibility(View.VISIBLE);
				
			}
		}
		
	}

	
	public void salvarCadastro(View view){
		
		
		Validator.validateNotNull(nomeET, "Por favor, preencha este campo.");
		Validator.validateNotNull(nome_maeET, "Por favor, preencha este campo.");
		Validator.validateNotNull(nome_socialET, "Por favor, preencha este campo.");		
		Validator.validateNotNull(paisET, "Por favor, preencha este campo.");
		Validator.validateNotNull(municipioET, "Por favor, preencha este campo.");
		
		boolean email_valido = Validator.validateEmail(emailET.getText().toString());
        if(!email_valido){
            emailET.setError("Email inválido");
            emailET.setFocusable(true);
            emailET.requestFocus();
        }
		
		cadastro.setCartao_sus(cartao_susET.getText().toString());
		cadastro.setNome(nomeET.getText().toString());
		cadastro.setNome_social(nome_socialET.getText().toString());
		cadastro.setNis(nisET.getText().toString());
		cadastro.setNome_mae(nome_maeET.getText().toString());
		cadastro.setNome_social(nome_socialET.getText().toString());
		cadastro.setAniversario(aniversarioET.getText().toString());
		cadastro.setPais_nascimento(paisET.getText().toString());
		cadastro.setMunicipio(municipioET.getText().toString());
		cadastro.setTelefone(telefoneET.getText().toString());
		cadastro.setEmail(emailET.getText().toString());
				
		if (responsavelRG.getCheckedRadioButtonId() == R.id.responsavel_sim) {
			// Implementar lógica de negócio para o "SIM"
			String responsavelET = ((RadioButton) this.findViewById(responsavelRG.getCheckedRadioButtonId())).getText().toString();
			cadastro.setResponsavel(responsavelET);
			//cadastro.setResponsavel(responsavelRG.getCheckedRadioButtonId());
			Log.i("ESus", "O usuário é o responsável.");
		} else {
			// Implementar lógica de negócio para o "SIM"
			Log.i("ESus", "O usuário não é o responsável.");
		}
		
		//int opcao = responsavelRG.getCheckedRadioButtonId();
		
		//if (opcao == R.id.responsavel_sim) {
		//	cadastro.setResponsavel(responsavelRG.getCheckedRadioButtonId());
		//}
		
		BD bd = new BD(this);
		bd.inserir(cadastro);
		
		Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
	}
	
	public void editarCadastro(View view){
		
		cadastro.setCartao_sus(cartao_susET.getText().toString());
		//cadastro.setResponsavel(responsavelRG.getCheckedRadioButtonId());
		cadastro.setNome(nomeET.getText().toString());
		cadastro.setNome_social(nome_socialET.getText().toString());
		cadastro.setNis(nisET.getText().toString());
		cadastro.setNome_mae(nome_maeET.getText().toString());
		cadastro.setNome_social(nome_socialET.getText().toString());
		cadastro.setAniversario(aniversarioET.getText().toString());
		cadastro.setPais_nascimento(paisET.getText().toString());
		cadastro.setMunicipio(municipioET.getText().toString());
		cadastro.setTelefone(telefoneET.getText().toString());
		cadastro.setEmail(emailET.getText().toString());
		
		BD bd = new BD(this);
		bd.atualizar(cadastro);
		
		Toast.makeText(this, "Cadastro atualizado com sucesso!", Toast.LENGTH_SHORT).show();
		
	
	}
	
}
