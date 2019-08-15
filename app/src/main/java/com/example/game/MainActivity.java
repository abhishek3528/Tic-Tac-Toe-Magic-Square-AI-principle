package com.example.game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean Xturn=true;
    private int totalcount;
    private TextView playx;
    private TextView playo;
    private int Xcount;
    private int xsum;
    private int xa;
    private int xb;
    private int xc;
    private int xd;
    private int Ocount;
    private int oa;
    private int ob;
    private int osum;
    private int oc;
    private int od;
    Button b00,b01,b02,b10,b11,b12,b20,b21,b22,reset;
    private int xe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playx=findViewById(R.id.p1);
        playo=findViewById(R.id.p2);

        b00 = (Button)findViewById(R.id.b8);

        b01 = (Button)findViewById(R.id.b3);

        b02 = (Button)findViewById(R.id.b4);
        b10 = (Button)findViewById(R.id.b1);
        b11 = (Button)findViewById(R.id.b5);

        b12 = (Button)findViewById(R.id.b9);

        b20 = (Button)findViewById(R.id.b6);

        b21 = (Button)findViewById(R.id.b7);

        b22 = (Button)findViewById(R.id.b2);
        totalcount=0;
        Xcount=0;
        Ocount=0;
        xsum=0;
        osum=0;
        Xturn=true;


        reset=findViewById(R.id.res);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b00.setText("");
                b01.setText("");
                b02.setText("");
                b10.setText("");
                b11.setText("");
                b12.setText("");
                b20.setText("");
                b21.setText("");
                b22.setText("");

                b00.setClickable(true);
                b01.setClickable(true);
                b02.setClickable(true);
                b10.setClickable(true);
                b11.setClickable(true);
                b12.setClickable(true);
                b20.setClickable(true);
                b21.setClickable(true);
                b22.setClickable(true);


                playx.setText("Player X : Your Turn");
                playo.setText("Player O :");

                Xcount = 0;
                Ocount = 0;
                xsum=0;
                osum=0;
                Xturn=true;
            }
        });


    }

    public void Click(View view) {
        if(!((Button)view).getText().toString().equals(""))
            return;

        if(Xturn)
        {
            ((Button)view).setText("X");
            Xcount++;
            checkforwinX(view);
            playx.setText("Player X :");
            playo.setText("Player O : Your Turn");
        }
        else
        {
            ((Button)view).setText("O");
            Ocount++;
            checkforwinO(view);
            playo.setText("Player O :");
            playx.setText("Player X : Your Turn");

        }
        totalcount++;
        Xturn=!Xturn;

    }


    private void checkforwinX(View view) {

        if(Xcount==1)
            xa=buttonvalue(view);
        else if(Xcount==2)
             xb=buttonvalue(view);
        else if(Xcount==3) {
            xc=buttonvalue(view);
            xsum = xa + xb + xc;
            if (xsum == 15) {
                disablebuttons();
                Toast.makeText(this,"PLayer X Wins!!!   " +
                        "Press 'Reset' to play again",Toast.LENGTH_LONG).show();
            }
        }
         else if(Xcount==4)
            {
                xd=buttonvalue(view);
                int sum1=xa+xb+xc;
                int sum2=xa+xb+xd;
                int sum3=xa+xc+xd;
                int sum4=xb+xc+xd;
                if(sum1==15||sum2==15||sum3==15||sum4==15)
                {
                    disablebuttons();
                    Toast.makeText(this,"PLayer X Wins!!!   " +
                            "Press 'Reset' to play again",Toast.LENGTH_LONG).show();


                }
            }
         else
        {
            int s1,s2,s3,s4,s5,s6;
            s1=15-(xa+xb);
            s2=15-(xa+xc);
            s3=15-(xa+xd);
            s4=15-(xb+xc);
            s5=15-(xb+xd);
            s6=15-(xc+xd);
            xe=buttonvalue(view);
            if(s1==xe||s2==xe||s3==xe||s4==xe||s5==xe||s6==xe)
            {

                disablebuttons();
                Toast.makeText(this,"PLayer X Wins!!!   " +
                        "Press 'Reset' to play again",Toast.LENGTH_LONG).show();
            }
            else
            {    disablebuttons();
                Toast.makeText(this,"Draw!!!   " +
                        "Press 'Reset' to play again",Toast.LENGTH_LONG).show();
            }


        }


    }
    private void checkforwinO(View view) {
        if(Ocount==1)
            oa=buttonvalue(view) ;
        else if(Ocount==2)
            ob=buttonvalue(view);
        else if(Ocount==3)
        {
            oc=buttonvalue(view);
            osum= oa+ob+oc;
            if(osum==15)
            {
                disablebuttons();
                Toast.makeText(this,"PLayer O Wins!!!   " +
                        "Press 'Reset' to play again",Toast.LENGTH_LONG).show();

            }
        }
        else
        {
            od=buttonvalue(view);
            int sum1=oa+ob+oc;
            int sum2=oa+ob+od;
            int sum3=oa+oc+od;
            int sum4=ob+oc+od;
            if(sum1==15||sum2==15||sum3==15||sum4==15)
            {
                disablebuttons();
                Toast.makeText(this,"PLayer O Wins!!!" +
                        "Press 'Reset' to play again",Toast.LENGTH_LONG).show();

            }

        }


    }
    private void disablebuttons() {
        b00.setClickable(false);
        b01.setClickable(false);
        b02.setClickable(false);
        b10.setClickable(false);
        b11.setClickable(false);
        b12.setClickable(false);
        b20.setClickable(false);
        b21.setClickable(false);
        b22.setClickable(false);
    }


    private int buttonvalue(View v) {
        switch(v.getId())
        {
            case R.id.b1 : return 1;
            case R.id.b2 : return 2;
            case R.id.b3 : return 3;
            case R.id.b4 : return 4;
            case R.id.b5 : return 5;
            case R.id.b6 : return 6;
            case R.id.b7 : return 7;
            case R.id.b8 : return 8;
            case R.id.b9 : return 9;
            default:return 0;

        }
    }

}
