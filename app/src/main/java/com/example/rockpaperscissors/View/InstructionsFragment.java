package com.example.rockpaperscissors.View;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.rockpaperscissors.CustomToastFragment;
import com.example.rockpaperscissors.R;

public class InstructionsFragment extends Fragment {
    Button basicButton, advancedButton;

    public InstructionsFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_instructions, container, false);

        basicButton = view.findViewById(R.id.basicInstructions);
        basicButton.setOnClickListener(view1 -> {
            CustomToastFragment toast = new CustomToastFragment();
            toast.show(requireActivity().getSupportFragmentManager(), "Instructions");
        });

        advancedButton = view.findViewById(R.id.advancedInstructions);
        advancedButton.setOnClickListener(view2 -> {
            new CustomToastFragment()
                    .show(requireActivity().getSupportFragmentManager(), "Instructions");
        });
        return view;
    }
}