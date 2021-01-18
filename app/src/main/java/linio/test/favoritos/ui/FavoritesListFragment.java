package linio.test.favoritos.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import linio.test.favoritos.R;
import linio.test.favoritos.databinding.ListFragmentBinding;
import linio.test.favoritos.model.RequestEntity;
import linio.test.favoritos.ui.adapters.FavoritesAdapter;
import linio.test.favoritos.ui.adapters.ProductsAdapter;
import linio.test.favoritos.viewmodel.FavoritosViewModel;


/**
 * Fragment to show favorites lists
 *
 * @author Rigoberto Torres
 * @version 0.0.1
 * @since January 15, 2021
 */
public class FavoritesListFragment extends Fragment {

    public static final String TAG = "ProductListFragment";

    FavoritosViewModel favoritosViewModel;
    private FavoritesAdapter mFavoritesAdapter;
    private ProductsAdapter mProductsAdapter;
    private ListFragmentBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.list_fragment, container, false);
        mFavoritesAdapter = new FavoritesAdapter();
        mProductsAdapter = new ProductsAdapter();
        mBinding.favoriteList.setAdapter(mFavoritesAdapter);
        mBinding.productsList.setAdapter(mProductsAdapter);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        favoritosViewModel = new ViewModelProvider(this).get(FavoritosViewModel.class);
        favoritosViewModel.init();
        mBinding.setLifecycleOwner(getViewLifecycleOwner());

        subscribeUi(favoritosViewModel.getRequestRepository());
        //TODO PRIVATE VALIDATION
        //subscribeUi(favoritosViewModel.getRequestWhitPermisionRepository());
    }

    /**
     * Subscribe livedata to link a view objects
     *
     * @param liveData RequestEntity list
     */
    private void subscribeUi(LiveData<List<RequestEntity>> liveData) {

        liveData.observe(getViewLifecycleOwner(), myProducts -> {
            if (myProducts != null) {
                mBinding.setIsLoading(true);
                mBinding.headerProductsTitle.setText(
                        getString(R.string.header_title_text,
                                favoritosViewModel.getProducts().size()));
                mFavoritesAdapter.setFavoriteList(myProducts);
                mProductsAdapter.setProductList(favoritosViewModel.getProducts());
            } else {
                mBinding.setIsLoading(false);
            }
            mBinding.executePendingBindings();
        });
    }


    @Override
    public void onDestroyView() {
        mBinding = null;
        mFavoritesAdapter = null;
        super.onDestroyView();
    }

}
