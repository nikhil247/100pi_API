package com.firebase.nikhilmanali.a100pi_api;

import com.firebase.nikhilmanali.a100pi_api.Model.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhil Manali on 10/31/2018.
 */

public class Paginator {

    int currentPage;
    static List<Result> list;
    Paginator(int currentPage, List<Result> list){
        this.currentPage=currentPage;
        this.list=list;
    }

    public static final int TOTAL_NUM_ITEMS=list.size();
    public static final int ITEMS_PER_PAGE=10;


    public ArrayList<Result> generatePage()
    {
        int startItem=currentPage*ITEMS_PER_PAGE;
        int numOfData=startItem+ITEMS_PER_PAGE;
        ArrayList<Result> pageData=new ArrayList<>();


        if(startItem!=TOTAL_NUM_ITEMS){

            for(int i=startItem;i<startItem+numOfData;i++){
                pageData.add(list.get(i));
            }

        }


        return pageData;
    }
}
