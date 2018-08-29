package br.ufc.missingyou.view.activitys;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import br.ufc.missingyou.R;
import br.ufc.missingyou.services.FeedService;
import br.ufc.missingyou.services.ServiceListener;
import br.ufc.missingyou.services.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getSupportActionBar().setDisplayShowTitleEnabled(false);

        this.mViewHolder.buttonLogin = (Button) findViewById(R.id.button_login);
        this.mViewHolder.buttonCadastrese = (Button) findViewById(R.id.button_signup);
        this.mViewHolder.editEmailLogin = (EditText) findViewById(R.id.edit_email_login);
        this.mViewHolder.editSenhaLogin = (EditText) findViewById(R.id.edit_senha_login);

        this.mViewHolder.buttonLogin.setOnClickListener(this);
        this.mViewHolder.buttonCadastrese.setOnClickListener(this);

    }

    private static class ViewHolder {
        Button buttonLogin;
        Button buttonCadastrese;
        EditText editEmailLogin;
        EditText editSenhaLogin;
        String nomeUser;
        String idUser;

        public String getNomeUser() {
            return nomeUser;
        }

        public void setNomeUser(String nomeUser) {
            this.nomeUser = nomeUser;
        }

        public String getIdUserUser() {
            return nomeUser;
        }

        public void setIdUser(String idUser) {
            this.idUser = idUser;
        }

        public Button getButtonLogin() {
            return buttonLogin;
        }

        public void setButtonLogin(Button buttonLogin) {
            this.buttonLogin = buttonLogin;
        }

        public Button getButtonCadastrese() {
            return buttonCadastrese;
        }

        public void setButtonCadastrese(Button buttonCadastrese) {
            this.buttonCadastrese = buttonCadastrese;
        }

        public EditText getEditEmailLogin() {
            return editEmailLogin;
        }

        public void setEditEmailLogin(EditText editEmailLogin) {
            this.editEmailLogin = editEmailLogin;
        }

        public EditText getEditSenhaLogin() {
            return editSenhaLogin;
        }

        public void setEditSenhaLogin(EditText editSenhaLogin) {
            this.editSenhaLogin = editSenhaLogin;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_login) {
            String password = mViewHolder.editSenhaLogin.getText().toString();
            String email = mViewHolder.editEmailLogin.getText().toString();

            FeedService service = FeedService.getInstance(this);

            final User user = new User();
            user.setEmailUser(email);
            user.setSenhaUser(password);

            service.login(user, new ServiceListener<List<User>>() {
                @Override
                public void onComplete(List<User> users) {
                    Intent intent = new Intent(MainActivity.this, NavBar.class);
                    startActivity(intent);
                }

                @Override
                public void onError(String erro) {
                    if(null != user.getCpfUser()) {
                        Toast.makeText(MainActivity.this, "Serviço indisponível", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "E-mail ou senha inválidos", Toast.LENGTH_LONG).show();
                    }
                }
            });
        } else if (id == R.id.button_signup) {
            Intent intent = new Intent(this, CadastroUsuarioActivity.class);
            //intent.putExtra("info", row_pos);
            startActivity(intent);
        }
    }
}



