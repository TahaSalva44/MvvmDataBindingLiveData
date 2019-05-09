package lc.lcwaikiki.com.mvvmdatabindinglivedata.adapter;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import lc.lcwaikiki.com.mvvmdatabindinglivedata.R;
import lc.lcwaikiki.com.mvvmdatabindinglivedata.databinding.ItemBannerBinding;
import lc.lcwaikiki.com.mvvmdatabindinglivedata.model.Banner;

public class BannersAdapter extends RecyclerView.Adapter<BannersAdapter.BannerViewHolder> {

    private LayoutInflater inflater;
    private List<Banner> bannerList;

    public BannersAdapter(List<Banner> bannersList){
        this.bannerList = bannersList;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (inflater == null) {
            inflater = LayoutInflater.from(viewGroup.getContext());
        }

        ItemBannerBinding itemBannerBinding = DataBindingUtil.inflate(inflater, R.layout.item_banner, viewGroup, false);

        return new BannerViewHolder(itemBannerBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder bannerViewHolder, int i) {
        bannerViewHolder.itemBannerBinding.setBanners(bannerList.get(i));

    }

    @Override
    public int getItemCount() {
        return bannerList.size();
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder {
        private final ItemBannerBinding itemBannerBinding;

        public BannerViewHolder(final ItemBannerBinding itemBannerBinding) {
            super(itemBannerBinding.getRoot());
            this.itemBannerBinding = itemBannerBinding;
        }


    }

    @BindingAdapter({"ImageUrl"})
    public static void loadImage(ImageView imageView, String banner) {
        Glide.with(imageView.getContext())
                .load(banner)
                .into(imageView);
    }
}
