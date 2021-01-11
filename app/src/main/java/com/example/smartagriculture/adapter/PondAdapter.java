package com.example.smartagriculture.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartagriculture.R;
import com.example.smartagriculture.entity.PondPruneEntity;
import com.example.smartagriculture.interfaces.AdapterListener;

import java.util.List;

public class PondAdapter extends RecyclerView.Adapter<PondAdapter.HolderView> {

    private final List<PondPruneEntity> ponds;
    private final AdapterListener<View> listener;
    private Context context;

    public PondAdapter(Context context, List<PondPruneEntity> ponds, AdapterListener<View> listener) {
        this.ponds = ponds;
        this.listener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_pond, parent, false);
        return new HolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderView holder, int position) {
        holder.setListener(listener);
        holder.initData(ponds.get(position));
    }

    @Override
    public int getItemCount() {
        return ponds.size();
    }

    static class HolderView extends RecyclerView.ViewHolder implements View.OnClickListener {

        AdapterListener<View> listener;
        private TextView tName;
        private TextView tNew;
        private TextView tHis;
        private TextView tControl;
        private ImageView iMenu;
        private TextView bFull;
        private TextView bManage;
        private LinearLayout lMenu;

        public HolderView(@NonNull View view) {
            super(view);
            tName = view.findViewById(R.id.pond_name);
            tNew = view.findViewById(R.id.pond_new);
            tHis = view.findViewById(R.id.pond_his);
            tControl = view.findViewById(R.id.pond_control);
            iMenu = view.findViewById(R.id.pond_con_menu);
            bFull = view.findViewById(R.id.pond_full);
            bManage = view.findViewById(R.id.pond_manage_device);
            lMenu = view.findViewById(R.id.pond_menu);


            tName.setOnClickListener(this);
            tNew.setOnClickListener(this);
            tHis.setOnClickListener(this);
            tControl.setOnClickListener(this);
            iMenu.setOnClickListener(this);
            bFull.setOnClickListener(this);
            bManage.setOnClickListener(this);
        }

        public void setListener(AdapterListener<View> listener) {
            this.listener = listener;
        }

        public void initData(PondPruneEntity pond){
            tName.setText(pond.getName());
        }

        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.pond_con_menu){
                if (lMenu.isShown()){
                    lMenu.setVisibility(View.GONE);
                } else {
                    lMenu.setVisibility(View.VISIBLE);
                }
            } else {
                lMenu.setVisibility(View.GONE);
                listener.onClickListener(v, getAdapterPosition());
            }
        }

    }

}
