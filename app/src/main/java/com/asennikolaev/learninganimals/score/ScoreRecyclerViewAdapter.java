package com.asennikolaev.learninganimals.score;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.asennikolaev.learninganimals.R;
import com.asennikolaev.learninganimals.model.QuizModel;

import java.util.List;

public class ScoreRecyclerViewAdapter  extends RecyclerView.Adapter<ScoreRecyclerViewAdapter.ViewHolder> {

    private List<QuizModel> quizGame;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
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

        Boolean answeredCorrectly = quizModel.getAnsweredCorrectly();
        viewHolder.getTextView().setText(correctAnswer + " - " + answeredCorrectly);
    }

    @Override
    public int getItemCount() {
        return this.quizGame.size();
    }
}

