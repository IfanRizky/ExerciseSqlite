package com.example.exercisesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity2 extends AppCompatActivity {

    String nama,
           alamat,
           email,
           no_tlp,
           emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]";

    EditText editNama,
            editNo_telp,
            editEmail,
            editAlamat;

    Button buttonSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editNama = findViewById(R.id.editNama);
        editNo_telp = findViewById(R.id.editNo_telp);
        editEmail = findViewById(R.id.editEmail);
        editAlamat = findViewById(R.id.editAlamat);
        buttonSimpan = findViewById(R.id.btnSimpan);

        buttonSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                email = editEmail.getText().toString().trim();
//                if (editNama.getText().toString().equals("") ||
//                        editNo_telp.getText().toString().equals("") ||
//                        editEmail.getText().toString().equals("") ||
//                        editAlamat.getText().toString().equals("")) {
//                    Toast.makeText(getApplicationContext(), "Data Harus Lengkap", Toast.LENGTH_SHORT).show();
//                } else if (email.matches(emailPattern)) {
//
//                }
//            }
                nama = editNama.getText().toString();
                no_tlp = editNo_telp.getText().toString();
                alamat = editAlamat.getText().toString();

                if (nama.equals("") || (no_tlp.equals("123") || (alamat.equals("")))) {
                    Toast.makeText(MainActivity2.this,
                            "Data Harus Lengkap", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Data Tersimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validasiEmail(EditText editEmail) {
        String emailInput = editEmail.getText().toString();

        if(!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            return true;
        } else {
            Toast.makeText(this, "Format Email Salah", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
