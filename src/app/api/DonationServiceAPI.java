package app.api;

import java.util.List;
import app.model.Donation;
import app.model.User;

public class DonationServiceAPI
{ 
  public static List<User> getUsers() throws Exception
  {
    String response =  Rest.get("/api/users");
    List<User> userList = JsonParsers.json2Users(response);
    return userList;
  }
  
  public static User getUser(Long id) throws Exception
  {
    String response =  Rest.get("/api/users/" + id);
    User user = JsonParsers.json2User(response);
    return user;
  }
  
  public static User createUser(User user) throws Exception
  {
    String response = Rest.post ("/api/users", JsonParsers.user2Json(user));
    return JsonParsers.json2User(response);
  }
  
  public static void deleteUser(User user) throws Exception
  {
    Rest.delete ("/api/users/" + user.id);
  }  
  
  public static List<Donation> getDonations(User user) throws Exception
  {
    String response =  Rest.get("/api/users/" + user.id + "/donations");
    List<Donation> donationList = JsonParsers.json2Donations(response);
    return donationList;
  }
  
  public static Donation createDonation(User user, Donation donation) throws Exception
  {
    String response = Rest.post ("/api/users/" + user.id + "/donations", JsonParsers.donation2Json(donation));
    return JsonParsers.json2Donation(response);
  }
  
  public static void deleteDonation(User user, Donation donation) throws Exception
  {
    Rest.delete ("/api/users/" + user.id + "/donations/" + donation.id);
  }   
}

