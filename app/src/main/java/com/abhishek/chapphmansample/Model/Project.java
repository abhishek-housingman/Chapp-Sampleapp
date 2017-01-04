package com.abhishek.chapphmansample.Model;

import android.content.Context;
import android.util.Log;

import com.abhishek.chapphmansample.API.APIInterface;
import com.abhishek.chapphmansample.API.ApiEndPoints;
import com.abhishek.chapphmansample.Activies.MainActivity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Abhishek on 03/01/17.
 */

public class Project {

    @SerializedName("projects")
    @Expose
    private ArrayList<ProjectInfo> projects = null;
    @SerializedName("page_info")
    @Expose
    private PageInfo pageInfo;

    public ArrayList<ProjectInfo> getProjects() {
        return projects;
    }

    private void setProjectsInfo(ArrayList<ProjectInfo> projectInfos) {
        this.projects = projectInfos;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    @SerializedName("keywords")
    @Expose
    private String keywords;
    @SerializedName("city_id")
    @Expose
    private String cityId;
    @SerializedName("search_filter")
    @Expose
    private SearchFilter searchFilter;

    @SerializedName("page")
    private Integer page;

    @SerializedName("per_page")
    private Integer per_page;

    @SerializedName("meta")
    private Meta meta;

    private searchApiListener listener;
    public interface searchApiListener {
        public void onCompletion();
        public void onPaginatedCallCompletion();
    }

    public void setSearchApiListener(searchApiListener listener) {
        this.listener = listener;
    }

    public Meta getMeta(){
        return meta;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public SearchFilter getSearchFilter() {
        return searchFilter;
    }

    public void setSearchFilter(SearchFilter searchFilter) {
        this.searchFilter = searchFilter;
    }

    private boolean isFirstCall = false;

    public Project(String keywords,String cityId, SearchFilter filter, Integer page, Integer per_page, boolean isFirstCall) {
            this.keywords = keywords;
            this.cityId = cityId;
            this.searchFilter = filter;
            this.page = page;
            this.per_page = per_page;
            //if false calls paginated completion listener
            this.isFirstCall = isFirstCall;
    }


    public void makeSearchCall(Project project, Context context) {
        ApiEndPoints searchProjectEndPoint = APIInterface.getInstance(context).create(ApiEndPoints.class);
        Call<Project> call = searchProjectEndPoint.searchProject(project);
        call.enqueue(new Callback<Project>() {
            @Override
            public void onResponse(Call<Project> call, Response<Project> response) {
                Log.i(MainActivity.NETWORK_TAG, "PROJECT CALL SIZE" +String.valueOf(response.body().getProjects().size()));
                Log.i(MainActivity.NETWORK_TAG, "PROJECT ID" +String.valueOf(response.body().getProjects().get(0).getId()));
                Log.i(MainActivity.NETWORK_TAG, "PROJECT IMAGE" +String.valueOf(response.body().getProjects().get(0).getProjectImage()));
                Log.i(MainActivity.NETWORK_TAG, "PROJECT IMAGE" +String.valueOf(response.body().getProjects().get(0).getProjectName()));
                setProjectsInfo(response.body().getProjects());
                if(isFirstCall) {
                    listener.onCompletion();
                } else {
                    listener.onPaginatedCallCompletion();
                }
            }

            @Override
            public void onFailure(Call<Project> call, Throwable t) {

            }
        });
    }


}
