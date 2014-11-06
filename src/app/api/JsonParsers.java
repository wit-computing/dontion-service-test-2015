package app.api;

import java.util.List;
import java.util.ArrayList;

import app.model.Donation;
import app.model.User;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class JsonParsers
{
  public static JSONSerializer userSerializer     = new JSONSerializer().exclude("class")
                                                                        .exclude("persistent")
                                                                        .exclude("entityId"); 
  public static JSONSerializer donationSerializer = new JSONSerializer().exclude("class")
                                                                        .exclude("persistent")
                                                                        .exclude("entityId"); 
  
  public static User json2User(String json)
  {
    return new JSONDeserializer<User>().deserialize(json, User.class); 
  }

  public static List<User> json2Users(String json)
  {
    return new JSONDeserializer<ArrayList<User>>().use("values", User.class)
                                                  .deserialize(json);
  }
  
  public static String user2Json(Object obj)
  {
    return userSerializer.serialize(obj);
  }
  
  public static List<User> users2Json(String json)
  {
    return new JSONDeserializer<ArrayList<User>>().use("values", User.class)
                                                  .deserialize(json);
  } 
    
 
  public static Donation json2Donation(String json)
  {
    return  new JSONDeserializer<Donation>().deserialize(json, Donation.class);    
  }
  
  public static String donation2Json(Object obj)
  {
    return donationSerializer.serialize(obj);
  }  
  
  public static List<Donation> json2Donations(String json)
  {
    return new JSONDeserializer<ArrayList<Donation>>().use("values", Donation.class)
        .deserialize(json);
  }  
}