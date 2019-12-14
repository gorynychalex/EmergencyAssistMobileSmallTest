package ru.popovich.emergencyassistmobile.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.popovich.emergencyassistmobile.R;

public class AdapterOrganization extends RecyclerView.Adapter<AdapterOrganization.OrgViewHolder> {

    public AdapterOrganization() {
    }

    @NonNull
    @Override
    public OrgViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull OrgViewHolder orgViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class OrgViewHolder extends RecyclerView.ViewHolder{

        TextView nameOrg;

        public OrgViewHolder(@NonNull View itemView) {
            super(itemView);

            nameOrg = itemView.findViewById(R.id.nameOrg);
        }
    }

}
