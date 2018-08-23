package com.gmail.republicweb1.republicweb;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> {

    private Context context;
    private List<Anggota> anggotas;

    public InfoAdapter(Context context, List<Anggota> anggotas) {
        this.context = context;
        this.anggotas = anggotas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.username.setText(anggotas.get(position).getUsername());
        holder.nama.setText(anggotas.get(position).getNama());
    }

    @Override
    public int getItemCount() {
        return anggotas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView username;
        public TextView nama;

        public ViewHolder(View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.username);
            nama = itemView.findViewById(R.id.nama);
            username.setOnClickListener(this);
            nama.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            showPopupMenu(v, position);
        }
    }

    private void showPopupMenu(View view, int pos) {
        PopupMenu popup = new PopupMenu(context, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_context, popup.getMenu());
        popup.setOnMenuItemClickListener(new MenuClickListener(pos));
        popup.show();
    }

    public class MenuClickListener implements PopupMenu.OnMenuItemClickListener {

        Integer pos;

        public MenuClickListener(int pos) {
            this.pos = pos;
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.item_detail:
                    Intent intentDetail = new Intent(context, DetailAnggota.class);
                    intentDetail.putExtra("username", anggotas.get(pos).getUsername());
                    intentDetail.putExtra("nama", anggotas.get(pos).getNama());
                    intentDetail.putExtra("tmpt_lahir", anggotas.get(pos).getTmpt_lahir());
                    intentDetail.putExtra("tgl_lahir", anggotas.get(pos).getTgl_lahir());
                    intentDetail.putExtra("jk", anggotas.get(pos).getJk());
                    intentDetail.putExtra("alamat", anggotas.get(pos).getAlamat());
                    intentDetail.putExtra("no_hp", anggotas.get(pos).getNo_hp());
                    intentDetail.putExtra("email", anggotas.get(pos).getEmail());
                    intentDetail.putExtra("riwayat_organisasi", anggotas.get(pos).getRiwayat_organisasi());
                    context.startActivity(intentDetail);
                    return true;
                default:
            }
            return false;
        }
    }
}