package br.ufc.missingyou.view.activitys;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import br.ufc.missingyou.R;
import br.ufc.missingyou.view.dialogs.PopUpExcluirUser;
import br.ufc.missingyou.view.fragments.AlterarDadosUser;
import br.ufc.missingyou.view.fragments.CadastrarCampanha;
import br.ufc.missingyou.view.fragments.Feed;
import br.ufc.missingyou.view.fragments.FeedCampanhasSalvas;
import br.ufc.missingyou.view.fragments.FeedNotificacoes;
import br.ufc.missingyou.view.fragments.MinhasCampanhas;


public class NavBar extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Dialog myDialog;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

//        MainActivity info = (MainActivity) getIntent().getSerializableExtra("info");
//        TextView nomeDesaparecido = (TextView) findViewById(R.id.nomeUsuario);
//        nomeDesaparecido.setText(info.getNomeUser());


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Feed tela = new Feed();
        getSupportFragmentManager().beginTransaction().replace(R.id.conteudo_fragment, tela).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.homeMenu) {
            Feed tela = new Feed();
            getSupportFragmentManager().beginTransaction().replace(R.id.conteudo_fragment, tela).commit();
        } else if (id == R.id.alterar_dados) {
            navigationView.getMenu().findItem(R.id.alterar_dados).setChecked(true);
            AlterarDadosUser tela =  new AlterarDadosUser();
            getSupportFragmentManager().beginTransaction().replace(R.id.conteudo_fragment, tela).commit();
            navigationView.getMenu().findItem(R.id.alterar_dados).setChecked(false);
        } else if (id == R.id.cadastrar_campanha) {
            navigationView.getMenu().findItem(R.id.cadastrar_campanha).setChecked(true);
            CadastrarCampanha tela =  new CadastrarCampanha();
            getSupportFragmentManager().beginTransaction().replace(R.id.conteudo_fragment, tela).commit();
            navigationView.getMenu().findItem(R.id.cadastrar_campanha).setChecked(false);

        } else if (id == R.id.excluir_user) {
            navigationView.getMenu().findItem(R.id.excluir_user).setChecked(true);

//            Dialog dialog = new Dialog(this);
//            dialog.setContentView(R.layout.custom_popup);
//            dialog.show();

            //botar aqui pra não ficar preto
            Intent intent = new Intent(this, PopUpExcluirUser.class);
            startActivity(intent);

        } else if (id == R.id.campanhas_cadastradas) {
            navigationView.getMenu().findItem(R.id.campanhas_cadastradas).setChecked(true);
            MinhasCampanhas tela =  new MinhasCampanhas();
            getSupportFragmentManager().beginTransaction().replace(R.id.conteudo_fragment, tela).commit();
            navigationView.getMenu().findItem(R.id.campanhas_cadastradas).setChecked(false);

        } else if (id == R.id.campanhas_salvas) {
            navigationView.getMenu().findItem(R.id.campanhas_salvas).setChecked(true);
            FeedCampanhasSalvas tela =  new FeedCampanhasSalvas();
            getSupportFragmentManager().beginTransaction().replace(R.id.conteudo_fragment, tela).commit();
            navigationView.getMenu().findItem(R.id.campanhas_salvas).setChecked(false);

        } else if (id == R.id.mapa) {
            navigationView.getMenu().findItem(R.id.mapa).setChecked(true);
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
            navigationView.getMenu().findItem(R.id.mapa).setChecked(false);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
