package com.example.andres.prueba;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.andres.prueba.R.id.listViewRestaurantes;


public class MainActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "com.example.andres.prueba.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /** Called when the user clicks the Configuracion */
    public void configuracion(View view) {
        Intent intent = new Intent(this, ConfiguracionActivity.class);
        startActivity(intent);
    }

    /** Called when the user clicks on one of the restaurants */
    public void darRestaurante(View view) {
        Intent intent = new Intent(this, RestauranteActivity.class);

        ListView lv = (ListView)findViewById(R.id.listViewRestaurantes);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                TextView textView = (TextView) view.findViewById(R.id.textViewZona);
                String text = textView.getText().toString();

            }});
        EditText editText = (EditText) findViewById(listViewRestaurantes);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
