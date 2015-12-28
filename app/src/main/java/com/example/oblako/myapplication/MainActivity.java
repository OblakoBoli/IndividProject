package com.example.oblako.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView writeText;
    EditText addNum;
    Button btnTriangle, btnOK;
    RadioButton areaWithHight, areaWithAllFront;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
      //  Area sqr = new Area();
     //   Area rect = new Area();
        final Area triangl = new Area();
        //Area crcl = new Area();

        areaWithAllFront = (RadioButton)findViewById(R.id.areaWithAllFront);
        areaWithHight = (RadioButton)findViewById(R.id.areaWithHight);
        btnTriangle = (Button) findViewById(R.id.btnTriangle);
        addNum = (EditText)findViewById(R.id.addNum);
        writeText = (TextView)findViewById(R.id.writeText);
        btnTriangle.setOnClickListener((View.OnClickListener) this);
        btnOK = (Button) findViewById(R.id.btnOK);
        btnOK.setOnClickListener((View.OnClickListener) this);
       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Поддержи проект - подкинь еды", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
               switch (view.getId()){
                   case R.id.btnTriangle:
                   if ( areaWithHight.isChecked()){

                       Toast toast = Toast.makeText(getApplicationContext(),
                               "Введите высоту треугольника  и нажмите ОК", Toast.LENGTH_SHORT);
                       toast.show();
                       toast.setGravity(Gravity.TOP, 0 , 0);


                       triangl.peremH=Float.parseFloat(addNum.getText().toString());
                       if (btnOK.isActivated()){
                            addNum.setText("");
                               toast = Toast.makeText(getApplicationContext(),
                                       "Введите основание треугольника и нажмите ОК", Toast.LENGTH_SHORT);
                               toast.show();
                       }
                        if (btnOK.isActivated()){
                    addNum.setText("");
                    triangl.peremW=Float.parseFloat(addNum.getText().toString());
                    triangl.area= (triangl.peremH*triangl.peremW)/2;
                        addNum.setText("");}
                       break;

               }
                   default:
                       break;}
                writeText.setText( (triangl.area).toString());
            }
        });
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

        return false;
    }

    public class Area{
        Float area;
        Float peremH;
        Float peremW;
      //  Float peremSh;
     //   Float stor1;
     //   Float stor2;
     //   Float stor3;
    }}

