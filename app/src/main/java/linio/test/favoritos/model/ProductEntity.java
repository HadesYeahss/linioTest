package linio.test.favoritos.model;

import com.google.gson.annotations.SerializedName;


/**
 * Class that represents a ProductEntity as a model.
 *
 * @author Rigoberto Torres
 * @version 0.0.1
 * @since January 15, 2021
 */
public class ProductEntity {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("wishListPrice")
    private int wishListPrice;
    @SerializedName("slug")
    private String slug;
    @SerializedName("url")
    private String url;
    @SerializedName("image")
    private String image;
    @SerializedName("linioPlusLevel")
    private int linioPlusLevel;
    @SerializedName("conditionType")
    private String conditionType;
    @SerializedName("freeShipping")
    private boolean freeShipping;
    @SerializedName("imported")
    private boolean imported;
    @SerializedName("active")
    private boolean active;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWishListPrice() {
        return wishListPrice;
    }

    public void setWishListPrice(int wishListPrice) {
        this.wishListPrice = wishListPrice;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLinioPlusLevel() {
        return linioPlusLevel;
    }

    public void setLinioPlusLevel(int linioPlusLevel) {
        this.linioPlusLevel = linioPlusLevel;
    }

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    public boolean isFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}