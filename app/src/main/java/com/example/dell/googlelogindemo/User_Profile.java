package com.example.dell.googlelogindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class User_Profile extends AppCompatActivity {
    ImageView iv;
    TextView tvname,tvemail;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__profile);
        iv=findViewById(R.id.iv);
        tvname=findViewById(R.id.tvname);
        tvemail=findViewById(R.id.tvemail);
        //
        mAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=mAuth.getCurrentUser();
        Picasso.with(User_Profile.this).load(firebaseUser.getPhotoUrl()).into(iv);
        tvname.setText(firebaseUser.getDisplayName());
        tvemail.setText(firebaseUser.getEmail());

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser()==null)
        {//not logged in
            finish();
            startActivity(new Intent(this,MainActivity.class));

        }
    }
}
