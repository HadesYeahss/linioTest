package linio.test.favoritos.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;


/**
 * Class that represents a RequestEntity as a model.
 *
 * @author Rigoberto Torres
 * @version 0.0.1
 * @since January 15, 2021
 */

public class RequestEntity {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("default")
    private boolean _default;
    @SerializedName("owner")
    private OwnerEntity ownerEntity;
    @SerializedName("createdAt")
    private String createdAt;
    @SerializedName("visibility")
    private String visibility;
    @SerializedName("products")
    private Map<String, ProductEntity> products;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDefault() {
        return _default;
    }

    public void setDefault(boolean _default) {
        this._default = _default;
    }

    public OwnerEntity getOwnerEntity() {
        return ownerEntity;
    }

    public void setOwnerEntity(OwnerEntity ownerEntity) {
        this.ownerEntity = ownerEntity;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Map<String, ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Map<String, ProductEntity> products) {
        this.products = products;
    }

    public Integer getProductsSize() {
        return this.products.size();
    }

}