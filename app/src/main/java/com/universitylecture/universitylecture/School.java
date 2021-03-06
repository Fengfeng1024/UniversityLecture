package com.universitylecture.universitylecture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengqingyundan on 2017/5/27.
 */
//学校类，掌管其学校举办的讲座

public class School {
    private String ID;
    private String name;
    private List lectures;

    public School(String pID , String pname ){
        ID = pID;
        name = pname;
        lectures = new ArrayList<Lecture>();
    }

    public void setID(String pID){
        ID = pID;
    }

    public String getID(){
        return ID;
    }

    public void setName(String pname){
        name = pname;
    }

    public String getName(){
        return name;
    }

    public List getLectures(){
        return lectures;
    }
}
