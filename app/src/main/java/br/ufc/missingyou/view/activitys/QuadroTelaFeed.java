package br.ufc.missingyou.view.activitys;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.ufc.missingyou.R;
import br.ufc.missingyou.model.Quadro;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuadroTelaFeed extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {


    public QuadroTelaFeed() {}

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_quadro_tela_feed);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Quadro quadro = (Quadro) getIntent().getSerializableExtra("quadro");
        TextView nomeDesaparecido = (TextView) findViewById(R.id.nomePessoa);
        nomeDesaparecido.setText(quadro.getNome());
        TextView localDesaparecimento = findViewById(R.id.local_desaparecimento);
        localDesaparecimento.setText(quadro.getLocal_desaparecimento());
        TextView dataNascimentoDesaparecido = findViewById(R.id.data_nascimento);
        dataNascimentoDesaparecido.setText(quadro.getDataNascimentoDesaparecido());
        TextView dataDesaparecimento = findViewById(R.id.data_desaparecimento);
        dataDesaparecimento.setText(quadro.getData_desaparecimento());
        TextView sexo = findViewById(R.id.genero);
        sexo.setText(quadro.getSexoDesaparecidos());
        TextView olhos = findViewById(R.id.olho);
        olhos.setText(quadro.getCorOlhosDesaparecidos());
        TextView cabelo = findViewById(R.id.cabelo);
        cabelo.setText(quadro.getCabelosDesaparecidos());
        TextView raca = findViewById(R.id.raca);
        raca.setText(quadro.getRacasDesaparecidos());

        this.mViewHolder.nomeDesaparecido = (TextView) findViewById(R.id.nomePessoa);
        this.mViewHolder.localDesaparecimento = (TextView) findViewById(R.id.local_desaparecimento);
        this.mViewHolder.dataDesaparecimento = (TextView) findViewById(R.id.data_desaparecimento);
        this.mViewHolder.dataNascimentoDesaparecido = (TextView) findViewById(R.id.data_nascimento);
        this.mViewHolder.cabeloDesaparecido = (TextView) findViewById(R.id.cabelo);
        this.mViewHolder.olhosDesaparecido = (TextView) findViewById(R.id.olho);
        this.mViewHolder.racaDesaparecido = (TextView) findViewById(R.id.raca);
        this.mViewHolder.sexoDesaparecido = (TextView) findViewById(R.id.genero);
        this.mViewHolder.foto = (ImageView) findViewById(R.id.foto_desaparecido);

        this.mViewHolder.salvarCampanha = (Button) findViewById(R.id.salvar);
        this.mViewHolder.ajudarCampanha = (Button) findViewById(R.id.ajudar);

        this.mViewHolder.salvarCampanha.setOnClickListener(this);
        this.mViewHolder.ajudarCampanha.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.salvar) {
            // Aqui precisa colocar logica do banco
        } else if (id == R.id.ajudar){
            // Tem que ver se a pessoa tem CPF, se ela nao tiver abre o popup seguinte
            //Intent intent = new Intent(this, PopUpCPF.class);
            //startActivity(intent);
            Intent intent = new Intent(this, AjudarCampanhaActivity.class);
            startActivity(intent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private static class ViewHolder {
        ImageView foto;
        Button salvarCampanha;
        Button ajudarCampanha;
        TextView nomeDesaparecido;
        TextView dataNascimentoDesaparecido;
        TextView dataDesaparecimento;
        TextView olhosDesaparecido;
        TextView cabeloDesaparecido;
        TextView sexoDesaparecido;
        TextView racaDesaparecido;
        TextView localDesaparecimento;
    }

}
