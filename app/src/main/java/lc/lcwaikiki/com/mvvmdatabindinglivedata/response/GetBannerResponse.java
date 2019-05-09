package lc.lcwaikiki.com.mvvmdatabindinglivedata.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lc.lcwaikiki.com.mvvmdatabindinglivedata.model.Banner;

public class GetBannerResponse {

    @SerializedName("banners")
    List<Banner> banners;

    public List<Banner> getBannerList() {
        return banners;
    }

    public void setBannerList(List<Banner> banners) {
        this.banners = banners;
    }
}
