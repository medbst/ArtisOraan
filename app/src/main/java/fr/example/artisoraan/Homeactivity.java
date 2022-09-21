package fr.example.artisoraan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Homeactivity extends AppCompatActivity {
    private Button connecter , inscrire ;
    FirebaseAuth mAuth ;
    TextView plombier , peintre , menuisier , electricien ,chaffag , metal, macon , carreleur ;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser userr = mAuth.getCurrentUser() ;
        if(userr != null){
            String nomuse ;
            nomuse = userr.getDisplayName().toString();

            Intent intent = new Intent( Homeactivity.this, Inscri.class);
            intent.putExtra("nom" , nomuse) ;
            startActivity(intent);
        }

        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        mAuth = FirebaseAuth.getInstance() ;


       connecter= (Button) findViewById(R.id.btconnecter) ;
        inscrire= (Button) findViewById(R.id.btinscrire) ;
        plombier=(TextView)findViewById(R.id.btplombier) ;
        peintre=(TextView)findViewById(R.id.btpeintre) ;
        electricien=(TextView)findViewById(R.id.artelec) ;
        chaffag=(TextView)findViewById(R.id.artchauff) ;
        metal=(TextView)findViewById(R.id.artmetal) ;
        carreleur=(TextView)findViewById(R.id.artcarr) ;
        macon=(TextView)findViewById(R.id.artmac) ;
        menuisier=(TextView)findViewById(R.id.artmenui);



        plombier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent( Homeactivity.this, userlist.class);
               intent.putExtra("travail" , "Plombier") ;
               startActivity(intent);
            }
        });
        electricien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Homeactivity.this, userlist.class);
                intent.putExtra("travail" , "Electricien") ;
                startActivity(intent);
            }
        });
        peintre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Homeactivity.this, userlist.class);
                intent.putExtra("travail" , "Peintre") ;
                startActivity(intent);
            }
        });
        carreleur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Homeactivity.this, userlist.class);
                intent.putExtra("travail" , "Carreleur") ;
                startActivity(intent);
            }
        });
        chaffag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Homeactivity.this, userlist.class);
                intent.putExtra("travail" , "Chauffagiste") ;
                startActivity(intent);
            }
        });
        macon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Homeactivity.this, userlist.class);
                intent.putExtra("travail" , "Maçon") ;
                startActivity(intent);
            }
        });
        metal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Homeactivity.this, userlist.class);
                intent.putExtra("travail" , "Métallier") ;
                startActivity(intent);
            }
        });
        menuisier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Homeactivity.this, userlist.class);
                intent.putExtra("travail" , "Menuisier") ;
                startActivity(intent);
            }
        });

      connecter.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(new Intent( Homeactivity.this, MainActivity.class));
          }
      });
      inscrire.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(new Intent(Homeactivity.this, Signup.class));
          }
      });
    }
}