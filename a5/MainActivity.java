package com.example.prasad.aa5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public TextView textView;
    double calc;
    double temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        calc=0;
        textView = (TextView) findViewById(R.id.textView);
    }
    ArrayList<String> arrayList =new ArrayList<String>();
    String string= "";
    String string1= "";
    //this function accepts the equation and sorts it
    public void onClick1(View v)
    {
        TextView textView2= (TextView) findViewById(R.id.textView2);
        Button button = (Button) v;
        string= (String) button.getText().toString();
        if ( !string.contains("+") && !string.contains("-")
            && !string.contains("*") && !string.contains("/"))
    {
        string1= string1+ string;
        if(arrayList.size()>0)
        {
            arrayList.remove(arrayList.size()-1);
        }
        arrayList.add(string1);
    }
    else
    {
        arrayList.add(string);
        arrayList.add(string);
        string1="";
    }
        textView2.setText(textView2.getText().toString()+ string);
//textView2.setText(arrayList.toString());
    }
    //this function performs the actual calculation
    public void onClick (View v)
    {
//int calc=0;
        int c= arrayList.size();
        while(c!=1)
        {
            if (c>3)
            {
                if(arrayList.get(3).contains("*")
                        ||arrayList.get(3).contains("/"))
                {
                    if(arrayList.get(3).contains("*"))
                    { calc= Double.parseDouble(arrayList.get(2))
                            * Double.parseDouble(arrayList.get(4));}
                    if(arrayList.get(3).contains("/"))
                    { calc= Double.parseDouble(arrayList.get(2));
                        Double.parseDouble(arrayList.get(4));}
                    arrayList.remove(2);
                    arrayList.remove(2);
                    arrayList.remove(2);
                    arrayList.add(2, Double.toString(calc));
                    c=arrayList.size();
                }
                else
                {
                    if (arrayList.get(1).contains("+"))
                    {calc= Double.parseDouble(arrayList.get(0))
                            +Double.parseDouble(arrayList.get(2));}
                    if (arrayList.get(1).contains("-"))
                    {calc= Double.parseDouble(arrayList.get(0))
                            - Double.parseDouble(arrayList.get(2));}
                    if (arrayList.get(1).contains("*"))
                    {calc= Double.parseDouble(arrayList.get(0))
                            * Double.parseDouble(arrayList.get(2));}
                    if (arrayList.get(1).contains("/"))
                    {calc= Double.parseDouble(arrayList.get(0))
                            / Double.parseDouble(arrayList.get(2));}
                    arrayList.remove(0);
                    arrayList.remove(0);
                    arrayList.remove(0);
                    arrayList.add(0, Double.toString(calc));
                    c=arrayList.size();
                }
            }
            else
            {
                if (arrayList.get(1).contains("+"))
                {calc= Double.parseDouble(arrayList.get(0)) +
                        Double.parseDouble(arrayList.get(2));}
                if (arrayList.get(1).contains("-"))
                {calc= Double.parseDouble(arrayList.get(0)) -
                        Double.parseDouble(arrayList.get(2));}
                if (arrayList.get(1).contains("*"))
                {calc= Double.parseDouble(arrayList.get(0)) *
                        Double.parseDouble(arrayList.get(2));}
                if (arrayList.get(1).contains("/"))
                {calc= Double.parseDouble(arrayList.get(0))
                        / Double.parseDouble(arrayList.get(2));}
                arrayList.remove(0);
                arrayList.remove(0);
                arrayList.remove(0);
                arrayList.add(0, Double.toString(calc));
                c=arrayList.size();
            }
        }
        if(arrayList.size()==1)
        {
            calc= Double.parseDouble(arrayList.get(0));
        }
        textView.setText(""+calc);
    }
    public void sinFunct(View v)
    {
        textView.setText("" + Math.sin(calc));
    }
    public void cosecfn(View v)
    {
        textView.setText("" + 1/(Math.sin(calc)));
    }
    public void secfn(View v)
    {
        textView.setText("" + 1/(Math.cos(calc)));
    }
    public void cosfn(View v)
    {
        textView.setText("" + Math.cos(calc));
    }
    public void sqrtfn(View v)
    {
        textView.setText("" + Math.sqrt(calc));
        }
    public void storeres(View v)
    {
        try {
            FileWriter f = new FileWriter("result.txt");
            f.write("" + calc);
            textView.setText("");
            FileReader r= new FileReader("result.txt");
//f.close();
        }
        catch(Exception e)
        {
        }
    }
    public void ansres(View v) {
        TextView textView2= (TextView) findViewById(R.id.textView2);
        temp = calc;
        textView2.setText(""+temp);
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
    //this function is used whith the clear key to clear the text view and result tab
    public void clear(View v)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        TextView textView2 =(TextView) findViewById(R.id.textView2);
        string1="";
        string="";
        textView.setText("0");
        textView2.setText("");
        arrayList.clear();
    }
}