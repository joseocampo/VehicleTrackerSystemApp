package joseocampo.VehicleTrackerSystemApp.com;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button btn_login;
    EditText et_id, et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login= findViewById(R.id.btn_login);
        et_id= findViewById(R.id.et_identification);
        et_pass= findViewById(R.id.et_password);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String user= et_id.getText().toString();
                final String password= et_pass.getText().toString();

                Response.Listener<String> responseListener= new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse= new JSONObject(response);
                            boolean success= jsonResponse.getBoolean("success");

                            if(success){
                               int role= jsonResponse.getInt("role");

                                Intent intent= new Intent(MainActivity.this, PantallaPrincipal.class);
                                intent.putExtra("user", user);
                                intent.putExtra("role", role);
                                intent.putExtra("password", password);

                                MainActivity.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("Error de Inicio de sesion").setNegativeButton("Retry", null).create().show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest= new LoginRequest(user, password, responseListener);
                RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);

            }
        });

    }

}
