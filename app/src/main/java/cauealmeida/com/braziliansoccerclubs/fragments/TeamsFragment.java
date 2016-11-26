package cauealmeida.com.braziliansoccerclubs.fragments;

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
import cauealmeida.com.braziliansoccerclubs.models.Team;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamsFragment extends Fragment implements Callback<List<Team>> {
    protected RecyclerView recyclerView;
    private String type; // TODO remove it cause we dont need it
    private TeamListAdapter teamListAdapter;

    public TeamsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: remove it as well
        if (getArguments() != null) {
            this.type = getArguments().getString("type");
        }
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
    public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {

    }

    @Override
    public void onFailure(Call<List<Team>> call, Throwable t) {
        Toast.makeText(getContext(),
                "Error, " + t.getMessage(),
                Toast.LENGTH_LONG).show();
    }
}
