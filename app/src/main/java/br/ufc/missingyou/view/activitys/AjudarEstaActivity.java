package br.ufc.missingyou.view.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.ufc.missingyou.R;
import br.ufc.missingyou.view.dialogs.PopUpAjudaEnviada;

public class AjudarEstaActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajudar_esta);

        getSupportActionBar().setTitle("Ajudar Campanha");

        this.mViewHolder.editEsta = (EditText) findViewById(R.id.editText_esta);
        this.mViewHolder.buttonConfirmarEsta = (Button) findViewById(R.id.button_confirmar_esta);

        this.mViewHolder.buttonConfirmarEsta.setOnClickListener(this);

    }

    private static class ViewHolder {
        EditText editEsta;
        Button buttonConfirmarEsta;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_confirmar_esta) {
            Intent intent = new Intent(this, PopUpAjudaEnviada.class);
            startActivity(intent);
        }
    }
}
