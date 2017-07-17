package com.dieznote.myfirstapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    Button buttonOtpr;
    Button buttonClean;
    EditText editText;
    final String TAG = "lifecycle";
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOtpr = (Button) findViewById(R.id.buttonOtpr);
        buttonOtpr.setOnClickListener(this);
        buttonClean = (Button) findViewById(R.id.buttonClean);
        buttonClean.setOnClickListener(this);
        editText = (EditText) findViewById(R.id.editText);
        Log.d(TAG, "MainActivity onCreate");
    }
    @Override
    public void onClick(View v){
        Intent intent = new Intent(this,Second.class);
        switch (v.getId()) {
            case R.id.buttonOtpr:
                if(editText.getText().toString().equals("")){
                    break;
                   /*toast.makeText(getApplicationContext(),"Заполните текстовое поле", Toast.LENGTH_SHORT);
                toast.show();*/
                }
                    else{
                intent.putExtra("text",editText.getText().toString());
                startActivityForResult(intent, 1);}
                break;
            case R.id.buttonClean:
                editText.setText("");
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null){
            return;
        }String nettext = data.getStringExtra("n");
        editText.setText(nettext);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"MainActivity onRestart");
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

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity onStop");
    }
}
