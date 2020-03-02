package com.yessa.tugas4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeroesFragment extends Fragment {

    public HeroesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_heroes, container, false);

        RecyclerView rvHero = (RecyclerView) rootView.findViewById(R.id.activityMain_rv_hero);

        rvHero.setLayoutManager(new LinearLayoutManager(getActivity()));

        HeroesAdapter heroesAdapter = new HeroesAdapter(getActivity());

        heroesAdapter.setHeroes(HeroesData.getHeroesList());

        rvHero.setAdapter(heroesAdapter);

        return rootView;
    }
}
