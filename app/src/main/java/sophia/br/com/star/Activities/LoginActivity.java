package sophia.br.com.star.Activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import sophia.br.com.star.R;

/**
 * Created by cledson.alves on 28/09/2017.
 */

public class LoginActivity extends Activity {
    private Button btn_login;
    private EditText usuario;
    private EditText senha;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    //atributo da classe.
    private AlertDialog alerta;
    private Button btn_pai;
    private Button btn_mae;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        mAuth = FirebaseAuth.getInstance();


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                test();



                //initTelaPrincipal();

              /**      mAuth.createUserWithEmailAndPassword(usuario.getText().toString(), senha.getText().toString())
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                public static final String TAG = "nulai";

                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Toast.makeText(LoginActivity.this, "Usuario criado com sucesso!",
                                            Toast.LENGTH_SHORT).show();

                                    initTelaPrincipal();

                                    Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(LoginActivity.this, "Falhou",
                                                Toast.LENGTH_SHORT).show();


                                    }

                                }
                            });**/




            }
        });



        mAuthListener = new FirebaseAuth.AuthStateListener() {
            public static final String TAG = "NULO";

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void initViews() {
       btn_login = (Button) findViewById(R.id.cadastrar);
        /**   usuario = (EditText) findViewById(R.id.usuario);
        senha = (EditText) findViewById(R.id.senha);**/
    }

    private void initTelaPrincipal(){
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    public void btn_login(View view){
      Toast.makeText(getApplicationContext(), "Papai ? , Mamae ? Sophia ? ", Toast.LENGTH_LONG).show();
    }

    private void exemplo_simples() {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Selecione uma conta ");


        //define a mensagem
        builder.setMessage("Qualifique este software");

        //define um botão como positivo
        builder.setPositiveButton("Positivo", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(LoginActivity.this, "positivo=" + arg1, Toast.LENGTH_SHORT).show();
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Negativo", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(LoginActivity.this, "negativo=" + arg1, Toast.LENGTH_SHORT).show();
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }


    public void test(){
        Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.dados_bebe);
        dialog.setTitle("SELECIONE UMA CONTA");

        de.hdodenhof.circleimageview.CircleImageView btn_pai = (de.hdodenhof.circleimageview.CircleImageView)dialog.findViewById(R.id.btn_pai);
         btn_pai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initTelaPrincipal();
            }
        });
        de.hdodenhof.circleimageview.CircleImageView btn_mae = (de.hdodenhof.circleimageview.CircleImageView)dialog.findViewById(R.id.btn_pai);
         btn_mae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initTelaPrincipal();
            }
        });

        dialog.show();

    }

    public void btn_mae (View view){
        initTelaPrincipal();
    }
    public void pai(View view){
        initTelaPrincipal();
    }


}
