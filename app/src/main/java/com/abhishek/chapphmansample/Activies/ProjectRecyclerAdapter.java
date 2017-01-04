package com.abhishek.chapphmansample.Activies;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhishek.chapphmansample.Model.Project;
import com.abhishek.chapphmansample.Model.ProjectInfo;
import com.abhishek.chapphmansample.Model.SearchFilter;
import com.abhishek.chapphmansample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhishek on 03/01/17.
 */

public class ProjectRecyclerAdapter extends RecyclerView.Adapter<ProjectViewHolder> {

    private ArrayList<ProjectInfo> projectArrayList;
    private Context context;
    private int page = 1;
    private int rowIndex = 15;
    private ProgressDialog progressDialog;
    private paginationListener listener;
    public interface paginationListener{
        public void onNextPageFetched();
    }

    public void setpaginationListener(paginationListener listener) {
        this.listener = listener;
    }

    public ProjectRecyclerAdapter(ArrayList<ProjectInfo> projectArrayList) {
        this.projectArrayList = projectArrayList;
    }


    @Override
    public int getItemCount() {
        return projectArrayList.size();
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        holder.setUpUI(projectArrayList.get(position));
        if(position == rowIndex) {
            rowIndex += 10;
            configureSearchCall();
        }
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_row_item, parent, false);
        return new ProjectViewHolder(view, parent.getContext());
    }

    public void configureSearchCall() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Fetching projects...");
        progressDialog.show();
        SearchFilter filter = new SearchFilter();
        List<String> bhkRange = new ArrayList<String>();
        bhkRange.add("1");
        bhkRange.add("2");
        List<String> priceRange = new ArrayList<String>();
        priceRange.add("");
        priceRange.add("");
        filter.setBhkRangeAny(bhkRange);
        filter.setPriceRangeAny(priceRange);
        page += 1;
        int per_page = 20;

        final Project project = new Project("","bangalore",filter,page,per_page, false);

        project.makeSearchCall(project, context);
        project.setSearchApiListener(new Project.searchApiListener() {
            @Override
            public void onCompletion() {

            }
            @Override
            public void onPaginatedCallCompletion() {
                progressDialog.dismiss();
                if (project.getProjects() != null) {
                    for (int x = 0; x < project.getProjects().size(); x++) {
                        projectArrayList.add(project.getProjects().get(x));
                    }
                    notifyDataSetChanged();
                }
            }
        });

    }
}
