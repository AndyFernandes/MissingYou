package br.ufc.missingyou.view.dialogs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import br.ufc.missingyou.R;

public class PopUpExcluirUser extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_popup);
        getSupportActionBar().hide();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);

        this.mViewHolder.botaoSim = (Button) findViewById(R.id.botaoSim);
        this.mViewHolder.botaoNao = (Button) findViewById(R.id.botaoNao);

        this.mViewHolder.botaoNao.setOnClickListener(this);
        this.mViewHolder.botaoSim.setOnClickListener(this);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(height*.2));
    }

    private static class ViewHolder {
        Button botaoNao;
        Button botaoSim;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.botaoNao) {
            finish();
        }  if(id == R.id.botaoSim){
            //logica botao
        }
    }
}
