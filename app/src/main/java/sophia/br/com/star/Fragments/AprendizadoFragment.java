package sophia.br.com.star.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import sophia.br.com.star.R;
import sophia.br.com.star.Util.CircleDisplay;

/**
 * Created by cledson.alves on 06/09/2017.
 */

public class AprendizadoFragment extends Fragment {
    RelativeLayout loading;
    CircleDisplay cd;
    CircleDisplay cd_ingles;
    CircleDisplay cd_espanhol;
    CircleDisplay cd_matematica;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view =  inflater.inflate(R.layout.aprendizado_fragment, container, false);

        loading = view.findViewById(R.id.success_green);

        /** Circle Chart Display **/
        cd = (CircleDisplay) view.findViewById(R.id.circleDisplay);
        cd_ingles = (CircleDisplay) view.findViewById(R.id.cd_ingles);
        cd_espanhol = (CircleDisplay) view.findViewById(R.id.cd_espanhol);
        cd_matematica = (CircleDisplay) view.findViewById(R.id.cd_matematica);
        setAnimation(cd, 86f, Color.MAGENTA,16f);
        setAnimation(cd_ingles, 85f, Color.YELLOW,10f);
        setAnimation(cd_espanhol, 78f, Color.RED,10f);
        setAnimation(cd_matematica, 97f, Color.BLUE,10f);


        new Thread(new Runnable() {
            public void run() {
                loading.postDelayed(new Runnable() {
                    public void run() {
                            loading.setVisibility(View.GONE);

                    }
                },2000);
            }
        }).start();

        return view;

    }

    /** Seta a Animação para o chart **/
    private void setAnimation(CircleDisplay cd, float valor, int cor, float size){
        cd.setAnimDuration(3000);
        cd.setValueWidthPercent(55f);
        cd.setTextSize(size);
        cd.setColor(cor);
        cd.setDrawText(true);
        cd.setDrawInnerCircle(true);
        cd.setFormatDigits(1);
        cd.setTouchEnabled(true);
        //cd.setSelectionListener();
        cd.setUnit("%");
        cd.setStepSize(0.5f);
        // cd.setCustomText(new String[]{"Azul","Amarelo","Vermelho"}); // sets a custom array of text
        cd.showValue(valor, 100f, true);


    }




        }