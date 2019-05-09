package lc.lcwaikiki.com.mvvmdatabindinglivedata.model;

import com.google.gson.annotations.SerializedName;

public class Banner {

    @SerializedName("image")
    Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
