package cauealmeida.com.braziliansoccerclubs.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import cauealmeida.com.braziliansoccerclubs.R;
import cauealmeida.com.braziliansoccerclubs.adapters.TeamListAdapter;
import cauealmeida.com.braziliansoccerclubs.api.TeamAPI;
import cauealmeida.com.braziliansoccerclubs.models.Team;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamsFragment extends Fragment implements Callback<List<Team>> {
    protected RecyclerView recyclerView;
    private TeamListAdapter teamListAdapter;

    public TeamsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_teams, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        loadContent();
    }

    private void loadContent() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.heiderlopes.com.br")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // prepara a chamada no Retrofit 2.0
        TeamAPI teamAPI = retrofit.create(TeamAPI.class);
        Call<List<Team>> call = teamAPI.get();

        // async call
        call.enqueue(this);
    }

    /*
    * Trazendo esse cara para ser trabalhado no fragment como se fosse um controller, e não no
    * nosso adapter.
    */

    @Override
    public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
        teamListAdapter = new TeamListAdapter(getContext(), response.body());
        recyclerView.setAdapter(teamListAdapter);
    }

    @Override
    public void onFailure(Call<List<Team>> call, Throwable t) {
        Toast.makeText(getContext(),
                "Error, " + t.getMessage(),
                Toast.LENGTH_LONG).show();
    }
}
