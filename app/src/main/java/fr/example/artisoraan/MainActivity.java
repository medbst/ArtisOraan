package fr.example.artisoraan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  String namee , passs ;
  Button connct ;

 TextView inscri ;
  EditText use , pas ;

  FirebaseAuth Mauth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mauth=FirebaseAuth.getInstance() ;


        use=(EditText)findViewById(R.id.userinscri) ;
        pas=(EditText)findViewById(R.id.passwd) ;

        inscri=(TextView) findViewById(R.id.tvinscrire) ;
        inscri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, Signup.class);

                startActivity(intent);
            }
        });


        connct=(Button) findViewById(R.id.bconnecter) ;
        connct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  namee = use.getText().toString();
                passs = pas.getText().toString();
                if(TextUtils.isEmpty(namee)||TextUtils.isEmpty(passs))
                {
                    Toast.makeText(MainActivity.this,"Remplir les champs",Toast.LENGTH_LONG).show();
                }
                else{
                Mauth.signInWithEmailAndPassword(namee,passs).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Query query = FirebaseDatabase.getInstance().getReference("artisan").orderByChild("email").equalTo(namee) ;
                        Toast.makeText(MainActivity.this,"Vous étes connecté",Toast.LENGTH_LONG).show();
                            FirebaseUser userrr = Mauth.getCurrentUser();

                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder().setDisplayName(namee).build();
                            if (userrr != null) {
                                userrr.updateProfile(profileUpdates) ;
                            }
                            Intent intent = new Intent( MainActivity.this, Inscri.class);
                            intent.putExtra("nom" , namee) ;
                            startActivity(intent);


                    }
                    else{Toast.makeText(MainActivity.this,"Erreur",Toast.LENGTH_LONG).show();}}
                });
                }
            }
            }) ;

            }
        }

