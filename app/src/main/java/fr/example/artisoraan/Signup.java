package fr.example.artisoraan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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

import java.util.Objects;

public class Signup extends AppCompatActivity{
    EditText nom , prenom , email , num , mdp ;
    String name, pren , passw , mail , type , numb ;
    Button inscrire ;
   String [] profession = {"Plombier" , "Electricien" , "Carreleur","Peintre","Métallier","Chauffagiste","Maçon","Menuisier"} ;
   AutoCompleteTextView auto ;
   ArrayAdapter<String> adapteritems ;
   TextView essai ;

    private FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth= FirebaseAuth.getInstance() ;
       inscrire = (Button)findViewById(R.id.btsinscrir);
     auto=(AutoCompleteTextView) findViewById(R.id.tvtype) ;

      nom=(EditText) findViewById(R.id.etnom) ;
        prenom=(EditText) findViewById(R.id.etprenom) ;

        email=(EditText) findViewById(R.id.etemail) ;
        num=(EditText) findViewById(R.id.etnumero) ;
        mdp=(EditText) findViewById(R.id.etpassword) ;

            

            adapteritems = new ArrayAdapter<>(Signup.this, R.layout.itemdrop,profession) ;
            auto.setAdapter(adapteritems);






            inscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              name = nom.getText().toString();
                 pren = prenom.getText().toString();
                 mail = email.getText().toString();
                passw = mdp.getText().toString();
                type = auto.getText().toString();
                numb = num.getText().toString();
                if(TextUtils.isEmpty(name)||TextUtils.isEmpty(pren)||TextUtils.isEmpty(mail)||TextUtils.isEmpty(passw)||TextUtils.isEmpty(type)||TextUtils.isEmpty(numb))
                {
                    Toast.makeText(Signup.this,"Veuillez remplir tout les champs",Toast.LENGTH_LONG).show();
                }
                else{  mAuth.createUserWithEmailAndPassword(mail,passw)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()){


                                    HelperClass user = new HelperClass(name, pren, mail, numb, type);
                                    FirebaseDatabase.getInstance().getReference("artisan")
                                            .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                                            .setValue(user);
                                    FirebaseUser userrr = mAuth.getCurrentUser();
                                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder().setDisplayName(name).build();
                                    userrr.updateProfile(profileUpdates) ;
                                    Toast.makeText(Signup.this,"Inscription Résussite",Toast.LENGTH_LONG).show();

                                    Intent intent = new Intent( Signup.this, Inscri.class);
                                    intent.putExtra("nom" , name) ;
                                    startActivity(intent);


                                }
                                else{  Toast.makeText(Signup.this,task.getException().toString(),Toast.LENGTH_LONG).show();}



                            }
                        }) ;}

















            }
        });
         }


}