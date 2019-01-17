package joseocampo.VehicleTrackerSystemApp.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

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

    }

}
