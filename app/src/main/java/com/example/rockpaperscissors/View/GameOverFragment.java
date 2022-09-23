package com.example.rockpaperscissors.View;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.Navigation;
import com.example.rockpaperscissors.R;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

public class GameOverFragment extends DialogFragment {
    private final int huScore, compScore, which;
    private final View view;
    private final Bundle bundle;

    public GameOverFragment(int userScore, int computerScore, View view, Bundle bundle, int which) {
        huScore = userScore;
        compScore = computerScore;
        this.view = view;
        this.bundle = bundle;
        this.which = which;
    }

    @NonNull
    @NotNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

        builder.setTitle("Game Over!");
        if (huScore > compScore) {
            builder.setMessage("Congratulations, Human. You have won this round. Enjoy it while it lasts! Hmmph.");
        } else if(huScore == compScore) {
            builder.setMessage("The heavens conspired to deny me victory; and somehow, someway they succeeded." +
                    "Not to worry; victory will return to its rightful place in my hands in the next round." +
                    "That is, of course, if you are brave enough to face me one more time.");
        } else {
            builder.setMessage("Muhahaha! Victory is mine! You have no choice but to admit defeat, human.");
        }
        builder.setPositiveButton("Go again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Objects.requireNonNull(GameOverFragment.this.getDialog()).dismiss();
                if(which == 1) {
                    Navigation.findNavController(view).navigate(R.id.basicGamePlayFragment, bundle);
                } else {
                    Navigation.findNavController(view).navigate(R.id.advancedGamePlayFragment, bundle);
                }
            }
        }).setNegativeButton("I Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Navigation.findNavController(view).navigate(R.id.homeFragment, bundle);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }
}
