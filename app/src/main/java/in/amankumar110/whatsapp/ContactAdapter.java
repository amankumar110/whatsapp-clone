package in.amankumar110.whatsapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_1 = 1;
    private static final int VIEW_TYPE_2 = 2;
    private ItemClickListener itemClickListener;
    private  List contactsAndFeatures;

    public ContactAdapter(List contactsAndFeatures,ItemClickListener itemClickListener) {
        this.contactsAndFeatures = contactsAndFeatures;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || position == 1 || position == 2 || position == getItemCount()-1 || position == getItemCount()-2)  {
            return VIEW_TYPE_1;
        } else
            return  VIEW_TYPE_2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
       View v;
        if(viewType == VIEW_TYPE_1) {
            v = layoutInflater.inflate(R.layout.contact_feature_layout,parent,false);
            return  new FeatureHolder(v);
        } else {
            v = layoutInflater.inflate(R.layout.contact_layout,parent,false);
            return new ContactHolder(v);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof ContactHolder) {
            ContactHolder contactHolder = (ContactHolder) holder;
            Contact contact =  (Contact) contactsAndFeatures.get(position);
            contactHolder.name.setText(contact.getName());
            contactHolder.description.setText(contact.getDescription());
            contactHolder.imageView.setImageResource(contact.getImageResource());
        } else if (holder instanceof FeatureHolder) {
            FeatureHolder featureHolder = (FeatureHolder) holder;
             Feature feature = (Feature) contactsAndFeatures.get(position);
            featureHolder.name.setText(feature.getName());
            featureHolder.imageView.setImageResource(feature.getImageResource());
        }
    }

    @Override
    public int getItemCount() {
        return contactsAndFeatures.size();
    }



    public static class ContactHolder extends RecyclerView.ViewHolder {


        TextView name,description;
        ImageView imageView;

        public ContactHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.contactName);
            this.description = itemView.findViewById(R.id.contactDescription);
            this.imageView = itemView.findViewById(R.id.contactImage);
        }
    }

    public class FeatureHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name;
        ImageView imageView;
        public FeatureHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.featureName);
            this.imageView = itemView.findViewById(R.id.featureImage);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            itemClickListener.onClick(v,getAdapterPosition());

        }
    }
}

