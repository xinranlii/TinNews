package com.laioffer.tinnews.ui.save;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.model.Article;

import java.util.ArrayList;
import java.util.List;

public class SaveNewsAdapter extends RecyclerView.Adapter<SaveNewsAdapter.SaveNewsViewHolder> {

    private List<Article> articles = new ArrayList<>();

    public void setArticles(List<Article> newsList) {
        articles.clear();
        articles.addAll(newsList);
        notifyDataSetChanged();
    }

    interface ItemCallback {
        void onOpenDetails(Article article);
        void onRemoveFavorite(Article article);
    }

    private ItemCallback itemCallback;

    public void setItemCallback(ItemCallback itemCallback) {
        this.itemCallback = itemCallback;
    }

    @NonNull
    @Override
    public SaveNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_news_item, parent, false);
        return new SaveNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SaveNewsAdapter.SaveNewsViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.authorTextView.setText(article.author);
        holder.descriptionTextView.setText(article.description);
        holder.favoriteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemCallback.onRemoveFavorite(article);
            }
        });
        holder.itemView.setOnClickListener(view -> {
            itemCallback.onOpenDetails(article);
        });
//        holder.favoriteIcon.setImageResource(R.drawable.ic_thumb_up_24dp);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public static class SaveNewsViewHolder extends RecyclerView.ViewHolder {

        TextView authorTextView;
        TextView descriptionTextView;
        ImageView favoriteIcon;

        public SaveNewsViewHolder(@NonNull View itemView) {
            super(itemView);
            authorTextView = itemView.findViewById(R.id.saved_item_author_content);
            descriptionTextView = itemView.findViewById(R.id.saved_item_description_content);
            favoriteIcon = itemView.findViewById(R.id.saved_item_favorite_image_view);
        }
    }
}
