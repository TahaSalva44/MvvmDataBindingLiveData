package lc.lcwaikiki.com.mvvmdatabindinglivedata.network;

import lc.lcwaikiki.com.mvvmdatabindinglivedata.response.GetBannerResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/campaigns/{index}")
    Call<GetBannerResponse> getbanners();

}
