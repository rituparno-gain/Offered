package rigain.com.offered.models;

import com.google.firebase.database.IgnoreExtraProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rigain on 3/11/2018.
 */
@IgnoreExtraProperties
public class ESHitsList {

    @SerializedName("hits")
    @Expose
    private List<ESPostSource> esPostIndex;

    public List<ESPostSource> getEsPostIndex() {
        return esPostIndex;
    }

    public void setEsPostIndex(List<ESPostSource> esPostIndex) {
        this.esPostIndex = esPostIndex;
    }
}
