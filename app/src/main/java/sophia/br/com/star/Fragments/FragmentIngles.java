package sophia.br.com.star.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sophia.br.com.star.R;

/**
 * Created by cledson.alves on 27/09/2017.
 */

public class FragmentIngles extends Fragment {

    public static FragmentIngles newInstance() {
        FragmentIngles fragment = new FragmentIngles();
        return fragment;
    }

    public FragmentIngles() {
        // Deve existir um construtor vazio
        // na classe que estende um Fragment
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dados_fragment, container, false);
    }

}