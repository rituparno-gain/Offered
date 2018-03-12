package rigain.com.offered.models;

import com.google.firebase.database.IgnoreExtraProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rigain on 3/11/2018.
 */

@IgnoreExtraProperties
public class ESPostSource {

    @SerializedName("_source")
    @Expose
    private Post post;


    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
