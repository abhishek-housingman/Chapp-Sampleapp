package com.abhishek.chapphmansample.Activies;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhishek.chapphmansample.Model.PageInfo;
import com.abhishek.chapphmansample.Model.Project;
import com.abhishek.chapphmansample.Model.ProjectInfo;
import com.abhishek.chapphmansample.Model.SearchFilter;
import com.abhishek.chapphmansample.R;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.filter;
import static android.R.attr.x;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProjectsHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProjectsHome extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private ProjectRecyclerAdapter projectRecyclerAdapter;


    public ProjectsHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProjectsHome.
     */
    // TODO: Rename and change types and number of parameters
    public static ProjectsHome newInstance(String param1, String param2) {
        ProjectsHome fragment = new ProjectsHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_projects_home, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.projectRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        //Creating search filter
        SearchFilter filter = new SearchFilter();
        List<String> bhkRange = new ArrayList<String>();
        bhkRange.add("1");
        bhkRange.add("2");
        List<String> priceRange = new ArrayList<String>();
        priceRange.add("");
        priceRange.add("");
        filter.setBhkRangeAny(bhkRange);
        filter.setPriceRangeAny(priceRange);

        int page = 1;
        int per_page = 20;
        boolean isFirstCall = true;
        final Project project = new Project("","bangalore",filter,page,per_page, isFirstCall);

        project.makeSearchCall(project, getActivity());
        project.setSearchApiListener(new Project.searchApiListener() {
            @Override
            public void onCompletion() {
                if (project.getProjects() != null) {
                    ArrayList<ProjectInfo> projectInfos = new ArrayList<ProjectInfo>();
                    for(int x = 0; x < project.getProjects().size(); x++) {
                        projectInfos.add(project.getProjects().get(x));
                    }
                    //need first set of projects to be loaded. Need to initialize the adapter for the same.
                    projectRecyclerAdapter = new ProjectRecyclerAdapter(projectInfos);
                    recyclerView.setAdapter(projectRecyclerAdapter);
                    projectRecyclerAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onPaginatedCallCompletion() {

            }
        });
        return view;
    }

}
