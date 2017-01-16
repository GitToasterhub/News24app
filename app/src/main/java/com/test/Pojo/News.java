package com.test.Pojo;

/**
 * Created by Ayhan on 15.01.2017.
 */
import org.simpleframework.xml.*;
import java.util.*;
@Root(name="news",strict=false)
public class News {
    @ElementList
    private List<Item> news=new ArrayList<Item>();
    News(){
    }
    public List<Item> getNews(){
        return news;
    }
}
