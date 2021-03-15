package com.asennikolaev.learninganimals.score;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.asennikolaev.learninganimals.R;
import com.asennikolaev.learninganimals.model.QuizModel;

import java.util.List;

public class ScoreRecyclerViewAdapter  extends RecyclerView.Adapter<ScoreRecyclerViewAdapter.ViewHolder> {

    private List<QuizModel> quizGame;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView animalNameTextView;
        private final ImageView animalImage;



        public ViewHolder(View view) {
            super(view);
            animalNameTextView = (TextView) view.findViewById(R.id.animalNameTextView);
            animalImage= (ImageView) view.findViewById(R.id.animalImage);
        }

        public TextView getAnimalNameTextView() {
            return animalNameTextView;
        }

        public ImageView getAnimalImage() {
            return animalImage;
        }

    }

    public ScoreRecyclerViewAdapter(List<QuizModel> dataSet) {
        this.quizGame = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.score_recycler_view_row, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        QuizModel quizModel = this.quizGame.get(position);
        String correctAnswer = quizModel.getCorrectAnswer();
        Integer drawableImageId = quizModel.getDrawableImageId();

        Boolean answeredCorrectly = quizModel.getAnsweredCorrectly();
        viewHolder.getAnimalNameTextView().setText(correctAnswer + " - " + answeredCorrectly);
        viewHolder.getAnimalImage().setImageResource(drawableImageId);
    }

    @Override
    public int getItemCount() {
        return this.quizGame.size();
    }
}

