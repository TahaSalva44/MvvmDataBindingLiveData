package lc.lcwaikiki.com.mvvmdatabindinglivedata.ui;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import lc.lcwaikiki.com.mvvmdatabindinglivedata.R;
import lc.lcwaikiki.com.mvvmdatabindinglivedata.adapter.BannersAdapter;
import lc.lcwaikiki.com.mvvmdatabindinglivedata.model.Banner;
import lc.lcwaikiki.com.mvvmdatabindinglivedata.response.GetBannerResponse;
import lc.lcwaikiki.com.mvvmdatabindinglivedata.viewModel.BannerViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class BannersFragments extends Fragment {

    private BannerViewModel bannerViewModel;
    private List<Banner> bannerList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BannersAdapter bannersAdapter;

    public static BannersFragments newInstance() {
        return new BannersFragments();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_banners_fragments, container, false);
        recyclerView =  view.findViewById(R.id.recycler_view);
        bannersAdapter = new BannersAdapter(bannerList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(bannersAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bannerViewModel = ViewModelProviders.of(this).get(BannerViewModel.class);
        bannerViewModel.init();
        bannerViewModel.getBannersList().observe(this, new Observer<GetBannerResponse>() {
            @Override
            public void onChanged(@Nullable GetBannerResponse getBannerResponse) {
                bannerList.addAll(getBannerResponse.getBannerList());
                bannersAdapter.notifyDataSetChanged();
            }
        });
    }
}
