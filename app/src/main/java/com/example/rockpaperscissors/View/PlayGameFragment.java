package com.example.rockpaperscissors.View;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.rockpaperscissors.R;

public class PlayGameFragment extends Fragment {
    Button basicButton, advancedButton;

    public PlayGameFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_game, container, false);

        basicButton = view.findViewById(R.id.basicButton);
        basicButton.setOnClickListener(view1 -> {
            ChooserDialogFragment chooser = new ChooserDialogFragment(view, savedInstanceState, 1);
            chooser.show(requireActivity().getSupportFragmentManager(), "Chooser");
        });

        advancedButton = view.findViewById(R.id.advancedButton);
        advancedButton.setOnClickListener(view1 -> {
            ChooserDialogFragment chooser = new ChooserDialogFragment(view, savedInstanceState, 2);
            chooser.show(requireActivity().getSupportFragmentManager(), "Chooser");
        });

        return view;
    }
}