package es.iesnervion.android.ignacio.adaptadorlistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AdaptadorListView extends Activity implements OnItemClickListener {

	private Titulos[] opciones = new Titulos[]{
			new Titulos("T�tulo 1", "Subt�tulo fdfgdfdfgfd ffdg1"),
			new Titulos("T�tulo 2", "Subt�tulo sdgf 2"),
			new Titulos("T�tulo 3", "Subt�tulo fdgdfdfgdfg 3"),
			new Titulos("T�tulo 4", "Subt�tulo dfgdfgdg 4"),
			new Titulos("T�tulo 5", "Subt�tulo dfgdfgdfgdfgdgdf 5"),
			new Titulos("T�tulo 6", "Subt�tulo dfgdfgdsdfg 6"),
			new Titulos("T�tulo 7", "Subt�tulo dfgdfgsfsdffsfdsfsdfdg 7"),
			new Titulos("T�tulo 8", "Subt�tulo dfgdffdffddfgdg 8"),
			new Titulos("T�tulo 9", "Subt�tulo dfgdsdfsdgsdfgdg 9"),
			new Titulos("T�tulo 10", "Subt�tulo dfgdfgdg 10"),
			new Titulos("T�tulo 11", "Subt�tulo dfgsdgsdgdfgdgdfgdg 11"),
			new Titulos("T�tulo 12", "Subt�tulo dfgdfgdfgdfgdg 12"),
			new Titulos("T�tulo 13", "Subt�tulo dfgdfgdg 13")};

	private TextView lblEtiqueta;
	private ListView listaOpciones;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);
		lblEtiqueta = (TextView)findViewById(R.id.lblEtiqueta);
		listaOpciones = (ListView) findViewById(R.id.listaOpciones);
		//ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opciones);
		/* XML*/// ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.valoresOpciones, android.R.layout.simple_list_item_1);
		AdaptadorTitulos adaptador = new AdaptadorTitulos(this);
		listaOpciones.setAdapter(adaptador);
		listaOpciones.setOnItemClickListener(this);

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_view, menu);
		return true;
	}


	class AdaptadorTitulos extends ArrayAdapter<Titulos> {

		Activity context;

		AdaptadorTitulos(Activity context) {
			super(context, R.layout.lista_con_titulos, opciones);
			this.context = context;
		}

		public View getView(int posicion, View convertView, ViewGroup parent) {

			View vItem = convertView;
			ViewHolder holder; // guardar los controles

			if (vItem == null){
				LayoutInflater inflater = context.getLayoutInflater();
				vItem = inflater.inflate(R.layout.lista_con_titulos, null);

				holder = new ViewHolder();
				holder.titulo = (TextView)vItem.findViewById(R.id.lblTitulo);
				holder.subtitulo = (TextView)vItem.findViewById(R.id.lblSubtitulo);
				vItem.setTag(holder);
			}
			else
			{
				holder = (ViewHolder)vItem.getTag();
			}

			holder.titulo.setText(opciones[posicion].getTitulo());
			holder.subtitulo.setText(opciones[posicion].getSubtitulo());

			return(vItem);
		}

	}

	static class ViewHolder {
		TextView titulo;
		TextView subtitulo;
	}

	@Override
	public void onItemClick(AdapterView<?> adap, View v, int posicion, long arg3) {
		lblEtiqueta.setText("Opci�n seleccionada: " + opciones[posicion].getTitulo());
	}
}

