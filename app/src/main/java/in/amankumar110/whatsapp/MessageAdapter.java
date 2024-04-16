package in.amankumar110.whatsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageHolder> {

    private List<Message> messages;

    public MessageAdapter(List<Message> messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item_without_notification_layout,parent,false);
        return new MessageHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {

        Message message = messages.get(position);
        holder.name.setText(message.getName());
        holder.message.setText(message.getMessage());
        holder.image.setImageResource(message.getImage());
        holder.time.setText(message.getTime());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public static class MessageHolder extends RecyclerView.ViewHolder {

        TextView name,message,time;
        ImageView image;
        public MessageHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.username);
            message = itemView.findViewById(R.id.userMessage);
            time = itemView.findViewById(R.id.time);
            image = itemView.findViewById(R.id.userImage);
        }
    }
}
