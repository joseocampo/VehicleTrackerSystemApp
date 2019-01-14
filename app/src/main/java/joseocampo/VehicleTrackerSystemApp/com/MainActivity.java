package joseocampo.VehicleTrackerSystemApp.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void iniciarSesion(View view){
        Intent intent = new Intent(this,PantallaPrincipal.class);
        startActivity(intent);

    }

}
