package com.me.dao;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.me.pojo.*;

public class PlacesDao extends DAO{

	float distance;
	public  List<Trip> populateTrips(String slat, String slon,int radius) 
	{
		//Float slat = Float.parseFloat(s);
		StringBuffer source = new StringBuffer();
		source.append(slat);
		source.append(",");
		source.append(slon);
		
	      
		
		//String v = "40.7878";
		Session session = getSession();
		//Query q = session.createQuery("from Places where latitude=:slat");
		Query q = session.createQuery("from Trip");
		
		//q.setString("slat",v);
		List<Trip> sourceIdList = q.list();
		System.out.println(sourceIdList);
		List<Trip> tripList = new ArrayList();
		
		for(Trip t : sourceIdList)
		{
			StringBuffer des = new StringBuffer();
			des.append(t.getSourceId().getLatitude());
			des.append(",");
			des.append(t.getSourceId().getLongitude());
			
		//	int sourceId = p.getPlaceId();
			distance = calcDistance(source, des);
			System.out.println("distance is : "+distance);
			if(distance <= radius )
			{
//				Query query = session.createQuery("from Trip where sourceid=:sourceId");
//				query.setInteger("sourceId", sourceId);
//				List<Trip> tempList = query.list();
				
					tripList.add(t);
				
			}
		}
		return tripList;
		
	
		
		//return null;
		// TODO Auto-generated method stub
		
	}
	
	private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
    
    public static float calcDistance(StringBuffer beg, StringBuffer end) {
		JSONObject json = null;
		Integer tem;
		Float dist = null;
		try {

			// json =
			// readJsonFromUrl("https://maps.googleapis.com/maps/api/distancematrix/json?origins="
			// + beg + "&destinations=" + end + "&mode=driving&sensor=false");
			json = readJsonFromUrl("https://maps.googleapis.com/maps/api/distancematrix/json?origins="
					+ beg + "&destinations=" + end + "&sensor=false");
			json.get("rows");
			JSONArray arr = null;
			arr = json.getJSONArray("rows");
			// tem = (Integer)
			// arr.getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("distance").getInt("value");
			// tem1 = (Integer)
			// arr.getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("duration").getInt("text");
			tem = arr.getJSONObject(0).getJSONArray("elements")
					.getJSONObject(0).getJSONObject("distance").getInt("value");
			// dist = (float) tem / 1000;
			dist = (float) (tem * 0.000621371);

		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dist;
	}

    public void feedPlacetable(String slat, String slong, String sadd,
			String dlat, String dlong, String dadd) {
		Session session = getSession();
		
		
		Query startadd = session
				.createQuery("From Places where latitude = :slat and longitude = :slong or places= :sadd ");

		startadd.setString("slat", slat);
		startadd.setString("slong", slong);
		startadd.setString("sadd", sadd);

		Places start = (Places) startadd.uniqueResult();

		if (start == null) {
			
			session.beginTransaction();
			Places p = new Places();
			p.setLatitude(slat);
			p.setLongitude(slong);
			p.setPlaces(sadd);

			session.save(p);
			session.getTransaction().commit();
			//session.close();
		}
		
		Query endadd = session
				.createQuery("FROM Places where latitude = :dlat and longitude = :dlong or places= :dadd ");

		endadd.setString("dlat", dlat);
		endadd.setString("dlong", dlong);
		endadd.setString("dadd", dadd);

		Places end = (Places) endadd.uniqueResult();

		if (end == null) {

			session.beginTransaction();
			Places p = new Places();
			p.setLatitude(dlat);
			p.setLongitude(dlong);
			p.setPlaces(dadd);

			session.save(p);
			session.getTransaction().commit();
			//session.close();	
		}

    }
    
    public Places returnPlaceByCoords(String lat, String lng)
	{
		try{
		Session s= getSession();
		
		Query q= s.createQuery("FROM Places WHERE latitude = :lat AND longitude= :lng ");
		q.setString("lat", lat);
		q.setString("lng", lng);
		Places p= (Places) q.uniqueResult();
		return p;
		}
		catch(Exception e)
		{
			System.out.println("ERROR IN FINDING THE PLACE");
		}
		return null;
	}

	

	
}
