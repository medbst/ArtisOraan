package fr.example.artisoraan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class Inscri extends AppCompatActivity  {



    TextView plombier , peintre , menuisier , electricien ,chaffag , metal, macon , carreleur ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscri);
        Button deco ;
        TextView nomm ;
        nomm=findViewById(R.id.nomart);


        deco=(Button)findViewById(R.id.btdeconn) ;

        deco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent( Inscri.this, Homeactivity.class);
                startActivity(intent);

            }
        });

        Bundle extras = getIntent().getExtras();
        String nomartis = extras.getString("nom") ;

        nomm.setText(nomartis);
        plombier=(TextView) findViewById(R.id.btplombier) ;
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
                Intent intent = new Intent( Inscri.this, userlist.class);
                intent.putExtra("travail" , "Plombier") ;
                startActivity(intent);
            }
        });
        electricien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Inscri.this, userlist.class);
                intent.putExtra("travail" , "Electricien") ;
                startActivity(intent);
            }
        });
        peintre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Inscri.this, userlist.class);
                intent.putExtra("travail" , "Peintre") ;
                startActivity(intent);
            }
        });
        carreleur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Inscri.this, userlist.class);
                intent.putExtra("travail" , "Carreleur") ;
                startActivity(intent);
            }
        });
        chaffag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Inscri.this, userlist.class);
                intent.putExtra("travail" , "Chauffagiste") ;
                startActivity(intent);
            }
        });
        macon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Inscri.this, userlist.class);
                intent.putExtra("travail" , "Maçon") ;
                startActivity(intent);
            }
        });
        metal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Inscri.this, userlist.class);
                intent.putExtra("travail" , "Métallier") ;
                startActivity(intent);
            }
        });
        menuisier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Inscri.this, userlist.class);
                intent.putExtra("travail" , "Menuisier") ;
                startActivity(intent);
            }
        });

    }
}