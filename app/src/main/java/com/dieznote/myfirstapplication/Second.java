package com.dieznote.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Second extends ActionBarActivity implements View.OnClickListener{
    Button buttonOk;
    Button buttonOtklonit;
    TextView textView;
    final String TAG = "lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        buttonOk = (Button) findViewById(R.id.buttonOk);
        buttonOk.setOnClickListener(this);

        buttonOtklonit = (Button) findViewById(R.id.buttonNet);
        buttonOtklonit.setOnClickListener(this);

        textView = (TextView) findViewById(R.id.textView);

        Intent intent  = getIntent();
        String text = intent.getStringExtra("text");
        textView.setText(text);
        Log.d(TAG, "Second onCreate");

    }
    @Override
    public void onClick(View v){
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.buttonOk:
                intent.putExtra("n","");
                break;
            case R.id.buttonNet:
                intent.putExtra("n",textView.getText().toString());
                break;
        }
            setResult(RESULT_OK,intent);
            finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Second onRestart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Second onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Second onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Second onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Second onStop");
    }
}

