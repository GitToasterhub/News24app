package com.test;

/**
 * Created by Ayhan on 15.01.2017.
 */
import java.io.*;
import java.net.*;
import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;
import com.test.Pojo.*;
public class XMLParser {

    String url;
    //default constructor works with "http://24tv.ua/rss/all.xml";
    XMLParser(){
        url="http://24tv.ua/rss/all.xml";
    }
    XMLParser(String url){
        this.url=url;
    }
    public StringBuilder requestGet() throws Exception{
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response;
    }
    public void formatXML(StringBuilder response){
        int end=0;
        end=response.indexOf("<item>");
        response.replace(0, end, "<rss xmlns:dc=\"http://purl.org/dc/elements/1.1/\" version=\"2.0\"><news>");
        int start=response.indexOf("</channel>");
        response.replace(start, response.length(), "</news></rss>");
    }
    public News deSerialize(StringBuilder response) throws Exception{
        Serializer ser=new Persister();
        News news=ser.read(News.class,response.toString());
        return news;
    }
}
