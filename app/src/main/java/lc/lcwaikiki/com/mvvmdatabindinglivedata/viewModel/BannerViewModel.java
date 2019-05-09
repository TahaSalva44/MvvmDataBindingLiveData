package lc.lcwaikiki.com.mvvmdatabindinglivedata.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import lc.lcwaikiki.com.mvvmdatabindinglivedata.repository.BannerRepository;
import lc.lcwaikiki.com.mvvmdatabindinglivedata.response.GetBannerResponse;

public class BannerViewModel extends ViewModel {

    private MutableLiveData<GetBannerResponse> mutableLiveData;
    private BannerRepository bannerRepository;

    public BannerViewModel(){
        bannerRepository = new BannerRepository();
    }

    public void init(){
        if (this.mutableLiveData != null){
            return;
        }
        mutableLiveData = bannerRepository.getBanners();
    }

    public MutableLiveData<GetBannerResponse> getBannersList(){
        return this.mutableLiveData;
    }
}
