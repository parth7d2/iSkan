package com.example.iscany;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogOut = findViewById(R.id.btn_logout);
        TextView txtEmail = findViewById(R.id.txt_email);
        TextView txtName = findViewById(R.id.txt_name);

        Intent intent_info = getIntent();

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        } else {
            txtEmail.setText(user.getEmail());
            String name = intent_info.getStringExtra("name");
            txtName.setText(name);

        }

        btnLogOut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

//        //Single Node Data
//        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("FirstProgram");
//        databaseReference.setValue("Hello World!");
//
//        //Multiple Nested Child Data
//        DatabaseReference contactRef = FirebaseDatabase.getInstance().getReference("info");
//
//        String custumID = contactRef.push().getKey();
//        CustomModel customModel = new CustomModel("Ram", "0123456789");
//        contactRef.child(custumID).setValue(customModel);
//
//        //Receiving Data
//        contactRef.child(custumID).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                CustomModel model = snapshot.getValue(CustomModel.class);
//                Log.d("Contact", model.getName() + ", " + model.getMobNo());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Log.e("DBError", error.toString());
//            }
//        });
    }
}