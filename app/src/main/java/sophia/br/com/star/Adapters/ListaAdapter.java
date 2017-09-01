package sophia.br.com.star.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sophia.br.com.star.Enties.Pessoa;
import sophia.br.com.star.R;

/**
 * Created by cledson.alves on 31/08/2017.
 */


public class ListaAdapter  extends RecyclerView.Adapter<ListaAdapter.MyViewHolder>{
    private List<Pessoa> mlist;
    private LayoutInflater lt;


    public ListaAdapter(Context context, List<Pessoa> mlist) {
       lt = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mlist = mlist;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = lt.inflate(R.layout.item_lista, parent, false);
        MyViewHolder mv = new MyViewHolder(view);
        return mv;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nome.setText("a");
        holder.sobrenome.setText("b");
        holder.idade.setText("20");
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nome;
        public TextView sobrenome;
        public TextView idade;

        public MyViewHolder(View itemView) {
            super(itemView);
            nome = (TextView)itemView.findViewById(R.id.nome);
            sobrenome = (TextView)itemView.findViewById(R.id.sobrenome);
            idade = (TextView)itemView.findViewById(R.id.idade);
        }
    }
}
