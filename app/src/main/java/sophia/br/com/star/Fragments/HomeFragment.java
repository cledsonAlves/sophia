package sophia.br.com.star.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import sophia.br.com.star.R;
import sophia.br.com.star.Util.CircleDisplay;
import sophia.br.com.star.Util.Util;

/**
 * Created by cledson.alves on 06/09/2017.
 */

public class HomeFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        View view =  inflater.inflate(R.layout.home_fragment, container, false);

        CircleDisplay cd = (CircleDisplay) view.findViewById(R.id.circleDisplay);
        cd.setAnimDuration(3000);
        cd.setValueWidthPercent(55f);
        cd.setTextSize(16f);
        cd.setColor(Color.MAGENTA);
        cd.setDrawText(true);
        cd.setDrawInnerCircle(true);
        cd.setFormatDigits(1);
        cd.setTouchEnabled(true);
      //cd.setSelectionListener();
        cd.setUnit("%");
        cd.setStepSize(0.5f);
        // cd.setCustomText(new String[]{"Azul","Amarelo","Vermelho"}); // sets a custom array of text
        cd.showValue(75f, 100f, true);

        Util.animateFragment(view);

        return view;

    }

}
