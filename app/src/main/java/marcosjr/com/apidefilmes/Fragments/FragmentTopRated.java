package marcosjr.com.apidefilmes.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import marcosjr.com.apidefilmes.R;

public class FragmentTopRated extends Fragment {

    View view;


    public FragmentTopRated() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       view = inflater.inflate(R.layout.lista3_fragment,container,false);

        return view;
    }
}
