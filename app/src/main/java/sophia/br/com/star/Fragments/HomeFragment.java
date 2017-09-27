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
    RelativeLayout loading;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.home_fragment, container, false);
        Util.animateFragment(view);
        loading = view.findViewById(R.id.success_green);

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

}
