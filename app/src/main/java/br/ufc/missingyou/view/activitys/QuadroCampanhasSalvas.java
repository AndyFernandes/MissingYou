package br.ufc.missingyou.view.activitys;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import br.ufc.missingyou.R;
import br.ufc.missingyou.model.Quadro;
import br.ufc.missingyou.view.fragments.FeedNotificacoes;


public class QuadroCampanhasSalvas extends AppCompatActivity implements  View.OnClickListener {


    public QuadroCampanhasSalvas() {
        // Required empty public constructor
    }
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_quadro_campanhas_cadastradas);

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

        this.mViewHolder.alterarDados = (Button) findViewById(R.id.alterarDados);
        this.mViewHolder.gerarFolder = (Button) findViewById(R.id.gerarFolder);
        this.mViewHolder.notificacoes = (Button) findViewById(R.id.notificacoes);

        this.mViewHolder.alterarDados.setOnClickListener(this);
        this.mViewHolder.gerarFolder.setOnClickListener(this);
        this.mViewHolder.notificacoes.setOnClickListener(this);

    }

    private static class ViewHolder {
        ImageView foto;
        Button alterarDados;
        Button notificacoes;
        Button gerarFolder;
        TextView nomeDesaparecido;
        TextView dataNascimentoDesaparecido;
        TextView dataDesaparecimento;
        TextView olhosDesaparecido;
        TextView cabeloDesaparecido;
        TextView sexoDesaparecido;
        TextView racaDesaparecido;
        TextView localDesaparecimento;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.desalvar) {
            // lógica do servidor
        } else if (id == R.id.notificacoes){
            FeedNotificacoes tela =  new FeedNotificacoes();
            getSupportFragmentManager().beginTransaction().replace(R.id.telaQuadroCampanhasSalvas, tela).commit();
            //logica do servidor
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:  finish();
        }


        return super.onOptionsItemSelected(item);
    }
}

