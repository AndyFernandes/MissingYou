package br.ufc.missingyou.view.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.ufc.missingyou.R;
import br.ufc.missingyou.view.dialogs.PopUpAjudaEnviada;

public class AjudarViuActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajudar_viu);

        getSupportActionBar().setTitle("Ajudar Campanha");

        this.mViewHolder.editViu = (EditText) findViewById(R.id.editText_viu);
        this.mViewHolder.buttonConfirmarViu = (Button) findViewById(R.id.button_confirmar_viu);

        this.mViewHolder.buttonConfirmarViu.setOnClickListener(this);

    }



    private static class ViewHolder {
        EditText editViu;
        Button buttonConfirmarViu;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_confirmar_viu) {
            Intent intent = new Intent(this, PopUpAjudaEnviada.class);
            startActivity(intent);
        }
    }
}
