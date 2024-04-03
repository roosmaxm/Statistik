package fi.arcada.codechallenge;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataItemViewAdapter extends RecyclerView.Adapter<DataItemViewAdapter.DataItemViewHolder> {
    @NonNull
    @Override
    public DataItemViewAdapter.DataItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DataItemViewAdapter.DataItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DataItemViewHolder extends RecyclerView.ViewHolder {
        public DataItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
