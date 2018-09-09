package com.example.afrodita.personalinformationtest.mvp.bithdaylist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.afrodita.personalinformationtest.MainApplication;
import com.example.afrodita.personalinformationtest.R;
import com.example.afrodita.personalinformationtest.mvp.birthday.BirthdayAdapter;
import com.example.afrodita.personalinformationtest.mvp.birthday.BirthdayModel;
import java.util.List;

import javax.inject.Inject;

public class BirthdayListFragment extends Fragment implements BirthdayListContract.View {
    @Inject
    BirthdayListPresenter presenter;
    ListView listView;
    BirthdayAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_birthday, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainApplication) getActivity().getApplication()).getComponent().inject(this);
        listView = view.findViewById(R.id.list_view_birthday);
        int position = getArguments().getInt("position");
        presenter.onAttach(this);
        presenter.loadDates(position);
    }


    @Override
    public void dates(List<BirthdayModel> datesList) {
        adapter = new BirthdayAdapter(getContext(), datesList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onError() {
        Toast.makeText(getContext(), R.string.loading_error, Toast.LENGTH_SHORT).show();
    }
}
