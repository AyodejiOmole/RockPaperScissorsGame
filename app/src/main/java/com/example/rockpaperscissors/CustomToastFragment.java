package com.example.rockpaperscissors;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import java.util.Objects;

public class CustomToastFragment extends DialogFragment {

    String message = "If you’ve ever had to work extremely long hours on a very challenging job/task -- physically, emotionally or mentally demanding -- then you would definitely have some knowledge of what burnout means, and how it always seems to sap the life out of everything you do. \n" +
            "Burnout is a state of physical, mental, or emotional exhaustion that arises from long-term exposure to extremely stressful situations. It could also arise at times when reality, sadly, doesn’t seem to align with our demands of it even after we have put in so much effort into trying to manifest this desire of ours. Hence, an overwhelming feeling of frustration at ones job could also be regarded as burnout. \n" +
            "As you might have be aware of if you’ve ever experienced burnout, this state tends to suck out all the light, love, and pleasure you would usually get from things like your career, relationships, life, interactions with close friends and family and also negatively affect your health (in case this happens, you can find centres dedicated to your mental well-being typing into your internet search page, the words: “mental wellness centre near me”). In short, what was once pleasurable to you and you always looked forward to doing becomes really tedious and a dread to carry out. \n";

//    public CustomToastFragment(String message) { }

    public CustomToastFragment() {}
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable  Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

        builder.setTitle("Instructions")
                .setMessage(message)
                .setPositiveButton("Very Well", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Objects.requireNonNull(CustomToastFragment.this.getDialog()).dismiss();
                    }
                });
        return builder.create();
    }
}
