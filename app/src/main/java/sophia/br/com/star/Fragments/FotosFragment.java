package sophia.br.com.star.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import sophia.br.com.star.Adapters.ListaAdapter;
import sophia.br.com.star.Entidades.Pessoa;
import sophia.br.com.star.R;
import sophia.br.com.star.Util.Util;

/**
 * Created by cledson.alves on 06/09/2017.
 */


public class FotosFragment extends Fragment {
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView rvEnderecoPvs;
    private ListaAdapter enderecoAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fotos_fragment, container, false);


        ArrayList<Pessoa> lista = new ArrayList<Pessoa>();



        for (int i = 0; i < 4; i++) {

            Pessoa p = new Pessoa();
            p.setNome("");
            p.setIdade("");
            p.setSobrenome("");

            try {
                p.setFoto(R.drawable.sophia+i);
                lista.add(p);
            } catch (Exception err) {


            }

        }

        rvEnderecoPvs = (RecyclerView) view.findViewById(R.id.rv);

        RecyclerView.LayoutManager lLayout = new GridLayoutManager(view.getContext(), 2);
        rvEnderecoPvs.setLayoutManager(lLayout);
        enderecoAdapter = new ListaAdapter(view.getContext(), lista);

        rvEnderecoPvs.setAdapter(enderecoAdapter);
        Util.animateFragment(view);
        return view;

    }


}
