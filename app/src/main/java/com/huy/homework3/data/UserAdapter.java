package com.huy.homework3.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huy.homework3.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> mListUser;

    public UserAdapter(List<User> list) {
        this.mListUser = list;
    }

    public void setData(List<User> list) {
        this.mListUser = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mListUser.get(position);
//        if (user == null){
//            return;
//        }
        holder.tvName.setText(user.getName());
        holder.tvNumber.setText(user.getNumber());
    }

    @Override
    public int getItemCount() {
//        if (mListUser != null) {
        return mListUser.size();
//        }
//        return 0;
    }

    protected class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvNumber;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvNumber = itemView.findViewById(R.id.tv_number);

        }
    }

}
