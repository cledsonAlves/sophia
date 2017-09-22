package sophia.br.com.star;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Toast;

import java.util.ArrayList;

import sophia.br.com.star.Adapters.ListaAdapter;
import sophia.br.com.star.Enties.Pessoa;
import sophia.br.com.star.Fragments.AprendizadoFragment;
import sophia.br.com.star.Fragments.AtividadesFragment;
import sophia.br.com.star.Fragments.AudiosFragment;
import sophia.br.com.star.Fragments.ComerFragment;
import sophia.br.com.star.Fragments.DadosFragment;
import sophia.br.com.star.Fragments.FotosFragment;
import sophia.br.com.star.Fragments.GostosFragment;
import sophia.br.com.star.Fragments.HomeFragment;
import sophia.br.com.star.Fragments.LeituraFragment;
import sophia.br.com.star.Fragments.SaudeFragment;
import sophia.br.com.star.Fragments.VideosFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private HomeFragment homeFragment;
    private DadosFragment dadosFragment;
    private SaudeFragment saudeFragment;
    private AprendizadoFragment aprendizadoFragment;
    private AtividadesFragment atividadesFragment;
    private  AudiosFragment audiosFragment;
    private ComerFragment comerFragment;
    private  FotosFragment fotosFragment;
    private  VideosFragment videoFragment;
    private LeituraFragment leituraFragment;
    private GostosFragment gostoFragment;
    private FragmentTransaction ft;
    private Toolbar toolbar;
    FragmentManager fm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // inicia os Fragments
         setupFragments();

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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            updateToolbar("Home");
            ft = fm.beginTransaction();
            ft.replace(R.id.container, homeFragment);
            ft.commit();


        } else if (id == R.id.nav_dados) {
            updateToolbar("Dados da Sophia");
            ft = fm.beginTransaction();
            ft.replace(R.id.container, dadosFragment);
            ft.commit();

        } else if (id == R.id.nav_saude) {
            updateToolbar("Saúde");
            ft = fm.beginTransaction();
            ft.replace(R.id.container, saudeFragment);
            ft.commit();

        } else if (id == R.id.nav_comer) {
            updateToolbar("Comer comer");
            ft = fm.beginTransaction();
            ft.replace(R.id.container, comerFragment);
            ft.commit();


        } else if (id == R.id.nav_atividades) {
            updateToolbar("Atividades");
            ft = fm.beginTransaction();
            ft.replace(R.id.container, atividadesFragment);
            ft.commit();

        } else if (id == R.id.nav_leitura) {
            updateToolbar("Cantinho da leitura");
            ft = fm.beginTransaction();
            ft.replace(R.id.container, leituraFragment);
            ft.commit();

        } else if (id == R.id.nav_aprendizado) {
            updateToolbar("Curva de aprendizado");
            ft = fm.beginTransaction();
            ft.replace(R.id.container, aprendizadoFragment);
            ft.commit();

        } else if (id == R.id.nav_galeria_fotos) {
            updateToolbar("Galeria de fotos");
            ft = fm.beginTransaction();
            ft.replace(R.id.container, fotosFragment);
            ft.commit();

        } else if (id == R.id.nav_galeria_videos) {
            updateToolbar("Galeria de videos");
            ft = fm.beginTransaction();
            ft.replace(R.id.container, videoFragment);
            ft.commit();

        } else if (id == R.id.nav_galeria_audios) {
            updateToolbar("Galeria de audios");
            ft = fm.beginTransaction();
            ft.replace(R.id.container, audiosFragment);
            ft.commit();

        } else if (id == R.id.nav_gostos) {
            updateToolbar("Gostos da Sophia");
            ft = fm.beginTransaction();
            ft.replace(R.id.container, gostoFragment);
            ft.commit();

        }
        
        

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setupFragments(){
        homeFragment = new HomeFragment();
        dadosFragment = new DadosFragment();
        saudeFragment = new SaudeFragment();
        aprendizadoFragment = new AprendizadoFragment();
        atividadesFragment = new AtividadesFragment();
        audiosFragment = new AudiosFragment();
        comerFragment = new ComerFragment();
        fotosFragment = new FotosFragment();
        videoFragment = new VideosFragment();
        leituraFragment = new LeituraFragment();
        gostoFragment = new GostosFragment();



        fm = getSupportFragmentManager();

        // Abre uma transação e adiciona
        ft = fm.beginTransaction();
        ft.add(R.id.container, homeFragment);
        ft.commit();

    }

    private void updateToolbar(String titulo){
        final String  titul = titulo;

        AlphaAnimation fadeOut = new AlphaAnimation(1f, 0f);
        fadeOut.setDuration(250);
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                toolbar.setTitle(titul);
                AlphaAnimation fadeIn = new AlphaAnimation(0f, 1f);
                fadeIn.setDuration(250);
                toolbar.startAnimation(fadeIn);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

       toolbar.startAnimation(fadeOut);
    }


}
