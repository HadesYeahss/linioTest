package linio.test.favoritos.model;

import com.google.gson.annotations.SerializedName;


/**
 * Class that represents a OwnerEntity as a model.
 *
 * @author Rigoberto Torres
 * @version 0.0.1
 * @since January 15, 2021
 */
public class OwnerEntity {

    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("linioId")
    private String linioId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinioId() {
        return linioId;
    }

    public void setLinioId(String linioId) {
        this.linioId = linioId;
    }

}