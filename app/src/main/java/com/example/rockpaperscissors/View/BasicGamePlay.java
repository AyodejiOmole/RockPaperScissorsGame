package com.example.rockpaperscissors.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.rockpaperscissors.GameActivity;
import com.example.rockpaperscissors.R;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BasicGamePlay extends Fragment {
    TextView humanScore, computerScore, currentRound;
    Button rockButton, paperButton, sciButton;
    ImageView humanImage, computerImage, backArrow;
    private final List<String> options = Arrays.asList("Rock", "Paper", "Scissors");
    private View thisView;
    private Bundle thisBundle;
    public BasicGamePlay() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_basic_game_play, container, false);
        thisView = view;
        thisBundle = savedInstanceState;

        // Score text views being initialized
        humanScore = view.findViewById(R.id.humanScore);
        computerScore = view.findViewById(R.id.computerScore);

        // Setting the amount of rounds from the user's choice.
        currentRound = view.findViewById(R.id.currentRound);
        currentRound.setText(String.valueOf(ChooserDialogFragment.rounds));

        // Game Choice Buttons being initialized
        rockButton = view.findViewById(R.id.rockButton);
        rockButton.setOnClickListener(view1 -> played("Rock"));

        paperButton = view.findViewById(R.id.paperButton);
        paperButton.setOnClickListener(view1 -> played("Paper"));

        sciButton = view.findViewById(R.id.sciButton);
        sciButton.setOnClickListener(view1 -> played("Scissors"));

        // Images being initialized
        humanImage = view.findViewById(R.id.usersChoice);
        computerImage = view.findViewById(R.id.computerChoice);

        backArrow = view.findViewById(R.id.backArrow);
        backArrow.setOnClickListener(view1 -> startActivity(new Intent(requireActivity().getApplicationContext(), GameActivity.class)));

        return view;
    }

    private void played(String played) {
        changeHumanImage(played);
        String comp = changeComputerImage();
        compare(played, comp);
    }

    private void changeHumanImage(String image) {
        switch(image) {
            case "Rock":
                humanImage.setImageResource(R.drawable.rock);
                break;
            case "Paper":
                humanImage.setImageResource(R.drawable.paper);
                break;
            case "Scissors":
                humanImage.setImageResource(R.drawable.sciccors);
                break;
            default:
                break;
        }
    }

    private String changeComputerImage() {
        Uri computer;
        String comp = options.get(new Random().nextInt(3));
        switch(comp) {
            case "Rock":
                computer = Uri.parse("android.resource://com.example.rockpaperscissors/drawable/rock");
                computerImage.setImageURI(computer);
                break;
            case "Paper":
                computer = Uri.parse("android.resource://com.example.rockpaperscissors/drawable/paper");
                computerImage.setImageURI(computer);
                break;
            case "Scissors":
                computer = Uri.parse("android.resource://com.example.rockpaperscissors/drawable/sciccors");
                computerImage.setImageURI(computer);
                break;
            default:
                break;
        }
        return comp;
    }

    private void compare(String human, String comp) {
        if(human.equals(comp)) {
            Toast.makeText(requireActivity().getApplicationContext(), "You draw", Toast.LENGTH_LONG).show();
        } else if(human.equals("Rock") && comp.equals("Scissors")) {
            Toast.makeText(requireActivity().getApplicationContext(), "You win", Toast.LENGTH_LONG).show();
            changeHumanScore();
        } else if(human.equals("Paper") && comp.equals("Rock")) {
            Toast.makeText(requireActivity().getApplicationContext(), "You win", Toast.LENGTH_LONG).show();
            changeHumanScore();
        } else if(human.equals("Scissors") && comp.equals("Paper")) {
            Toast.makeText(requireActivity().getApplicationContext(), "You win", Toast.LENGTH_LONG).show();
            changeHumanScore();
        } else if(comp.equals("Scissors") && human.equals("Paper")) {
            Toast.makeText(requireActivity().getApplicationContext(),
                    "You lost. The computer won.", Toast.LENGTH_LONG).show();
            changeComputerScore();
        } else if(comp.equals("Rock") && human.equals("Scissors")) {
            Toast.makeText(requireActivity().getApplicationContext(),
                    "You lost. The computer won.", Toast.LENGTH_LONG).show();
            changeComputerScore();
        } else if(comp.equals("Paper") && human.equals("Rock")) {
            Toast.makeText(requireActivity().getApplicationContext(),
                    "You lost. The computer won.", Toast.LENGTH_LONG).show();
            changeComputerScore();

        } else {
            Toast.makeText(requireActivity().getApplicationContext(),
                    "Abeg, free me.", Toast.LENGTH_LONG).show();
        }

        String current = currentRound.getText().toString();
        int i = Integer.parseInt(current) - 1;
        currentRound.setText(String.valueOf(i));

        check(currentRound.getText().toString());
    }

    private void check(String current) {
        if(current.equals("0")) {
            int i1 = Integer.parseInt(humanScore.getText().toString());
            int i2 = Integer.parseInt(computerScore.getText().toString());
            GameOverFragment game = new GameOverFragment(i1, i2, thisView, thisBundle, 1);
            game.show(requireActivity().getSupportFragmentManager(), "Game Over");
        }
    }

    private void changeHumanScore() {
        int score = Integer.parseInt(humanScore.getText().toString()) + 1;
        humanScore.setText(String.valueOf(score));
    }

    private void changeComputerScore() {
        int score = Integer.parseInt(computerScore.getText().toString()) + 1;
        computerScore.setText(String.valueOf(score));
    }
}