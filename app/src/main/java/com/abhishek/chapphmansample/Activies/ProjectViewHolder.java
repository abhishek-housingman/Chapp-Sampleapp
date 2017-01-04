package com.abhishek.chapphmansample.Activies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.abhishek.chapphmansample.Model.Project;
import com.abhishek.chapphmansample.Model.ProjectInfo;
import com.abhishek.chapphmansample.R;
import com.squareup.picasso.Picasso;


/**
 * Created by Abhishek on 03/01/17.
 */

public class ProjectViewHolder extends RecyclerView.ViewHolder  {

        private Project project;
        private Context context;
        private ImageView projectImageView;
        private TextView projectNameTextView;

       public ProjectViewHolder(View view, Context context) {
           super(view);
           this.context = context;
           projectImageView = (ImageView)view.findViewById(R.id.projectImageView);
           projectNameTextView = (TextView)view.findViewById(R.id.projectTile);
       }

        public void setUpUI(ProjectInfo projectInfo) {
            Picasso.with(context).load(projectInfo.getProjectImage()).into(projectImageView);
            projectNameTextView.setText(projectInfo.getProjectName());
        }

}
