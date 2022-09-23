package com.example.rockpaperscissors.View;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.Navigation;
import com.example.rockpaperscissors.R;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

public class ChooserDialogFragment extends DialogFragment {
    private final View view;
    private final Bundle bundle;
    public static int rounds;
    private final int whichGame;

    public ChooserDialogFragment(View view, Bundle bundle, int i) {
        this.view = view;
        this.bundle = bundle;
        this.whichGame = i;
    }

    @NonNull
    @NotNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

        View layout = getLayoutInflater().inflate(R.layout.round_chooser_view, null);

        builder.setView(layout);

        RadioGroup chooserRadio = layout.findViewById(R.id.roundsGroup);
        chooserRadio.setOnCheckedChangeListener((radioGroup, i) -> {
            int id = radioGroup.getCheckedRadioButtonId();
            if( id == R.id.fiveRadio) {
                rounds = 5;
                Log.e("Logger", "" + rounds);
            } else if (id == R.id.tenRadio ) {
                rounds = 10;
                Log.e("Logger", "" + rounds);
            } else {
                rounds = 15;
                Log.e("Logger", "" + rounds);
            }
        });

        builder.setTitle("How many rounds are you bold enough to play?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Objects.requireNonNull(ChooserDialogFragment.this.getDialog()).dismiss();
                        changeView(whichGame);
                    }
                });

        return builder.create();
    }


    private void changeView(int which) {
        if(which == 1) {
            Navigation.findNavController(view).navigate(R.id.basicGamePlayFragment, bundle);
        } else {
            Navigation.findNavController(view).navigate(R.id.advancedGamePlayFragment, bundle);
        }
    }
}
