package rigain.com.offered.util;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;
import rigain.com.offered.models.ESHitsObject;

/**
 * Created by rigain on 3/11/2018.
 */

public interface ElasticSearchAPI {

    @GET("_search/")
    Call<ESHitsObject> search(
            @HeaderMap Map<String, String> headers,
            @Query("default_operator") String operator, //1st query (prepends '?')
            @Query("q") String query //second query (prepends '&')

    );
}
