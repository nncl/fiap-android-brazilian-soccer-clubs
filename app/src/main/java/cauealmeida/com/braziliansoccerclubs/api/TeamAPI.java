/**
 * Responsável por chamar o serviço
 */

package cauealmeida.com.braziliansoccerclubs.api;

import java.util.List;

import cauealmeida.com.braziliansoccerclubs.models.Team;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by cauealmeida on 11/26/16.
 */

public interface TeamAPI {
    @GET("/carros/tipo/{type}")
    Call<List<Team>> findBy(@Path("type") String args);
}
