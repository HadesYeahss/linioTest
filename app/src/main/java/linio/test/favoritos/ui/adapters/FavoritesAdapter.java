package linio.test.favoritos.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.util.List;
import java.util.Map;

import linio.test.favoritos.R;
import linio.test.favoritos.model.ProductEntity;
import linio.test.favoritos.model.RequestEntity;


/**
 * Adapter to show favorite lists in recyclerview
 *
 * @author Rigoberto Torres
 * @version 0.0.1
 * @since January 15, 2021
 */
public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoriteListViewHolder> {

    List<? extends RequestEntity> mFavoritesList;

    public FavoritesAdapter() {
        setHasStableIds(true);
    }

    /**
     * Favorite lists view Holder
     */
    public static class FavoriteListViewHolder extends RecyclerView.ViewHolder {

        TextView favoriteListName;
        TextView favoriteListSize;
        ImageView productImageOne;
        ImageView productImageTop;
        ImageView productImageBottom;

        public FavoriteListViewHolder(View view) {
            super(view);
            favoriteListName = view.findViewById(R.id.title_list);
            favoriteListSize = view.findViewById(R.id.list_size);
            productImageOne = view.findViewById(R.id.products_list_one);
            productImageTop = view.findViewById(R.id.image_top);
            productImageBottom = view.findViewById(R.id.image_bottom);
        }
    }

    /**
     * Set favorite list to populate recyclerview
     *
     * @param favoriteList ProductEntity list
     */
    public void setFavoriteList(final List<? extends RequestEntity> favoriteList) {
        if (mFavoritesList == null) {
            mFavoritesList = favoriteList;
            notifyItemRangeInserted(0, favoriteList.size());
        } else {
            mFavoritesList = favoriteList;
        }
    }

    @Override
    @NonNull
    public FavoriteListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.favorite_list_item, parent, false);

        return new FavoriteListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteListViewHolder holder, int position) {
        RequestEntity favoritelist = mFavoritesList.get(position);
        holder.favoriteListName.setText(favoritelist.getName());
        holder.favoriteListSize.setText(favoritelist.getProductsSize().toString());
        int counter = 0;
        for (Map.Entry<String, ProductEntity> entry : favoritelist.getProducts().entrySet()) {
            setImage(entry.getValue().getImage(), counter, holder);
            counter++;
        }


    }

    /**
     * Add image to ImageView whit Picasso
     *
     * @param image Url to attach image
     */
    private void setImage(String image, int counter, FavoriteListViewHolder holder) {
        RequestCreator picaso = Picasso.get().load((!image.isEmpty()) ? image : null);
        picaso.placeholder(R.drawable.ic_nd_ic_fav_white_48)
                .error(R.drawable.ic_nd_ic_fav_white_48)
                .fit().centerCrop();
        switch (counter) {
            case 0: {
                picaso.into(holder.productImageOne);
                break;
            }
            case 1: {
                picaso.into(holder.productImageTop);
                break;
            }
            case 2: {
                picaso.into(holder.productImageBottom);
                break;
            }
            default: {
                break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return mFavoritesList == null ? 0 : mFavoritesList.size();
    }

    @Override
    public long getItemId(int position) {
        return mFavoritesList.get(position).getId();
    }

}
