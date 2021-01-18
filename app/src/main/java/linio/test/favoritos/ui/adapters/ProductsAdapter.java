package linio.test.favoritos.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.util.List;

import linio.test.favoritos.R;
import linio.test.favoritos.model.ProductEntity;


/**
 * Adapter to show product list in recyclerview
 *
 * @author Rigoberto Torres
 * @version 0.0.1
 * @since January 15, 2021
 */
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder> {

    List<? extends ProductEntity> mProductsList;
    private static String PRODUCT_CONDITION_NEW = "new";
    private static String PRODUCT_CONDITION_REF = "refurbished";
    private static Integer IS_LINIO_PLUS_LEVEL_1 = 1;
    private static Integer IS_LINIO_PLUS_LEVEL_2 = 2;

    public ProductsAdapter() {
        setHasStableIds(true);
    }

    /**
     * Products view Holder
     */
    public static class ProductsViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        ImageView productNewproduct;
        ImageView productImported;
        ImageView productShipping;
        ImageView productPlus;

        public ProductsViewHolder(View view) {
            super(view);
            productImage = view.findViewById(R.id.product_image);
            productNewproduct = view.findViewById(R.id.icon_new_product);
            productImported = view.findViewById(R.id.image_imported);
            productPlus = view.findViewById(R.id.linio_plus);
            productShipping = view.findViewById(R.id.icon_free_shipping);
        }
    }

    /**
     * Set products list to populate recyclerview
     *
     * @param favoriteList ProductEntity list
     */
    public void setProductList(final List<? extends ProductEntity> favoriteList) {
        if (mProductsList == null) {
            mProductsList = favoriteList;
            notifyItemRangeInserted(0, favoriteList.size());
        } else {
            mProductsList = favoriteList;
        }
    }

    @Override
    @NonNull
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_item, parent, false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        ProductEntity product = mProductsList.get(position);
        holder.productNewproduct.setVisibility(
                (product.getConditionType().equals(PRODUCT_CONDITION_NEW)
                        || product.getConditionType().equals(PRODUCT_CONDITION_REF))
                        ? View.VISIBLE : View.GONE);
        if (product.getConditionType().equals(PRODUCT_CONDITION_REF)) {
            holder.productNewproduct.setImageResource(R.drawable.nd_ic_refurbished_30);
        }
        holder.productPlus.setVisibility(
                (product.getLinioPlusLevel() == IS_LINIO_PLUS_LEVEL_1
                        || product.getLinioPlusLevel() == IS_LINIO_PLUS_LEVEL_2)
                        ? View.VISIBLE : View.GONE);
        if (product.getLinioPlusLevel() == IS_LINIO_PLUS_LEVEL_2) {
            holder.productPlus.setImageResource(R.drawable.nd_ic_plus_48_30);
        }
        holder.productImported.setVisibility((product.isImported()) ? View.VISIBLE : View.GONE);
        holder.productShipping.setVisibility((product.isFreeShipping()) ? View.VISIBLE : View.GONE);
        setImage(product.getImage(), holder.productImage);
    }

    /**
     * Add image to ImageView whit Picasso
     *
     * @param image Url to attach
     * @param view ImageView to attach image
     */
    private void setImage(String image, ImageView view) {
        RequestCreator picaso = Picasso.get().load((!image.isEmpty()) ? image : null);
        picaso.placeholder(R.drawable.ic_nd_ic_fav_white_48)
                .error(R.drawable.ic_nd_ic_fav_white_48)
                .fit().centerCrop().into(view);
    }

    @Override
    public int getItemCount() {
        return mProductsList == null ? 0 : mProductsList.size();
    }

    @Override
    public long getItemId(int position) {
        return mProductsList.get(position).getId();
    }

}
