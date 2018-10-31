package com.firebase.nikhilmanali.a100pi_api;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.nikhilmanali.a100pi_api.Model.Result;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

   List<Result> list;

    Adapter( List<Result> list){
     this.list=list;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Adapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_recycler_view, parent, false));
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {

        holder.Currency.setText(list.get(position).getCurrency());
        holder.CurrencyLong.setText(list.get(position).getCurrencyLong());
        holder.MinConfirmation.setText(list.get(position).getMinConfirmation()+"");
        holder.TxFee.setText(list.get(position).getTxFee()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

    TextView Currency,CurrencyLong,MinConfirmation,TxFee;
        public ViewHolder(View itemView) {
            super(itemView);
            Currency=(TextView)itemView.findViewById(R.id.currency);
            CurrencyLong=(TextView)itemView.findViewById(R.id.currencyLong);
            MinConfirmation=(TextView)itemView.findViewById(R.id.minConf);
            TxFee=(TextView)itemView.findViewById(R.id.txfee);
        }
    }
}
