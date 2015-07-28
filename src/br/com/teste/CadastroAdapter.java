package br.com.teste;

import java.util.List;

import br.com.teste.activity.NovoCadastroActivity;
import br.com.teste.database.BD;
import br.com.teste.entidades.Cidadao;

import com.example.testebd.R;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CadastroAdapter extends BaseAdapter {
	
	private Context context;
	private List<Cidadao> list;
	
	public CadastroAdapter(Context context, List<Cidadao> list) {
		
		this.context = context;
		this.list = list;
		
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}
	
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0).getId();
	}
	
	@Override
	public View getView(int position, View arg1, ViewGroup arg2) {

		final int auxPosition = position;
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.cadastro, null);
		
				
		TextView tv = (TextView) layout.findViewById(R.id.nome);
		tv.setText(list.get(position).getNome());
		
		Button editarBt = (Button) layout.findViewById(R.id.editar);
		editarBt.setOnClickListener(new Button.OnClickListener(){
		
			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(context, NovoCadastroActivity.class);
				intent.putExtra("cartao_sus", list.get(auxPosition).getCartao_sus());
				intent.putExtra("nome", list.get(auxPosition).getNome());
				intent.putExtra("nome_social", list.get(auxPosition).getNome_social());
				intent.putExtra("nis", list.get(auxPosition).getNis());
				intent.putExtra("nome_mae", list.get(auxPosition).getNome_mae());
				intent.putExtra("responsavel", list.get(auxPosition).getResponsavel());
				intent.putExtra("pais_nascimento", list.get(auxPosition).getPais_nascimento());
				intent.putExtra("municipio", list.get(auxPosition).getMunicipio());
				intent.putExtra("telefone", list.get(auxPosition).getTelefone());
				intent.putExtra("email", list.get(auxPosition).getEmail());
				intent.putExtra("aniversario", list.get(auxPosition).getAniversario());
				intent.putExtra("id", list.get(auxPosition).getId());
				context.startActivity(intent);
			}
		});
		
		Button deletarBt = (Button) layout.findViewById(R.id.deletar);
		deletarBt.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				BD bd = new BD(context);
				bd.deletar(list.get(auxPosition));
				
				layout.setVisibility(View.GONE);
			}
		});
		
			
		return layout;
	}
	
	
}
