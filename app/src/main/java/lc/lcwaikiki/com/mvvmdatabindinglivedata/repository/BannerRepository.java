package lc.lcwaikiki.com.mvvmdatabindinglivedata.repository;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import lc.lcwaikiki.com.mvvmdatabindinglivedata.network.ApiClient;
import lc.lcwaikiki.com.mvvmdatabindinglivedata.network.ApiInterface;
import lc.lcwaikiki.com.mvvmdatabindinglivedata.response.GetBannerResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BannerRepository {
    private ApiInterface apiInterface;

    public BannerRepository(){

    }

    public MutableLiveData<GetBannerResponse> getBanners(){
        final MutableLiveData<GetBannerResponse> bannerResponseMutableLiveData = new MutableLiveData<>();
        apiInterface = ApiClient.getRetrofitInstance().create(ApiInterface.class);
        Call<GetBannerResponse> call = apiInterface.getbanners();
        call.enqueue(new Callback<GetBannerResponse>() {
            @Override
            public void onResponse(Call<GetBannerResponse> call, Response<GetBannerResponse> response) {
                if (response.body() != null)
                bannerResponseMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<GetBannerResponse> call, Throwable t) {

            }
        });
        return bannerResponseMutableLiveData;
    }
}
