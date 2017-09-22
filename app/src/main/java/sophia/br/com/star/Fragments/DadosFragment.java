package sophia.br.com.star.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sophia.br.com.star.R;
import sophia.br.com.star.Util.Util;

/**
 * Created by cledson.alves on 06/09/2017.
 */

public class DadosFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.dados_fragment, container, false);
        Util.animateFragment(view);
        return view;

    }

}
