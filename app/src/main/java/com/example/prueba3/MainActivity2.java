package com.example.prueba3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button Volver;
    TextView white,nulow,boric,kast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        white=(TextView) findViewById(R.id.txt_white);
        nulow=(TextView) findViewById(R.id.txt_nulow);
        boric=(TextView) findViewById(R.id.txt_musolini);
        kast=(TextView) findViewById(R.id.txt_trump);

        Integer Totalblanco=0, Totalnulo=0,TotalBoric=0,TotalKast=0;
        SQLiteDatabase db;
        Dbhelper conn=new Dbhelper(getApplicationContext());
        db=conn.getReadableDatabase();
        Cursor C=db.query("Voto",null,null,null,null,null,null);
        if (C!=null)
        {
            if(C.moveToFirst()){
                do {
                    if (C.getString(2).equals("")){
                        Totalblanco++;
                    }
                    if (C.getString(3).equals("Nulo")){
                        Totalnulo++;
                    }
                    if (C.getString(4).equals("Gabriel Boric")){
                        TotalBoric++;
                    }
                    if (C.getString(5).equals("Jose Antonio Kast")){
                        TotalKast++;
                    }

                }
                while (C.moveToNext());



            }

            }
        white.setText(""+Totalblanco);
        nulow.setText(""+Totalnulo);
        boric.setText(""+TotalBoric);
        kast.setText(""+TotalKast);



    }


    }



