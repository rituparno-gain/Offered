package rigain.com.offered.models;

import com.google.firebase.database.IgnoreExtraProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rigain on 3/11/2018.
 */

@IgnoreExtraProperties
public class ESHitsObject {

    @SerializedName("hits")
    @Expose
    private ESHitsList hits;

    public ESHitsList getHits() {
        return hits;
    }

    public void setHits(ESHitsList hits) {
        this.hits = hits;
    }
}
