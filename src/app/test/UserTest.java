package app.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.api.DonationServiceAPI;
import app.model.User;


public class UserTest
{
  static User userArray [] = 
  { 
    new User ("homer",  "simpson", "homer@simpson.com",  "secret"),
    new User ("lisa",   "simpson", "lisa@simpson.com",   "secret"),
    new User ("maggie", "simpson", "maggie@simpson.com", "secret"),
    new User ("bart",   "simpson", "bart@simpson.com",   "secret"),
    new User ("marge",  "simpson", "marge@simpson.com",  "secret"),
  };  
  
  List <User> userList = new ArrayList<>();
  
  @Before
  public void setup() throws Exception
  { 
    for (User user : userArray)
    {
      User returned = DonationServiceAPI.createUser(user);
      userList.add(returned);
    }
  }
  
  @After
  public void teardown() throws Exception
  {
    for (User user : userList)
    {
      DonationServiceAPI.deleteUser(user);
    }
  }
  
  @Test
  public void testCreate () throws Exception
  {
    assertEquals (userArray.length, userList.size());
    for (int i=0; i<userArray.length; i++)
    {
      assertEquals(userList.get(i), userArray[i]);
    }
  }

  @Test
  public void testList() throws Exception
  {
    List<User> list = DonationServiceAPI.getUsers();
    assertTrue (list.containsAll(userList));
  }
  
  @Test
  public void testDelete () throws Exception
  {
    List<User> list1 = DonationServiceAPI.getUsers();
    User testUser = new User("mark",  "simpson", "marge@simpson.com",  "secret");
    User returnedUser = DonationServiceAPI.createUser(testUser);
    List<User> list2 = DonationServiceAPI.getUsers();
    assertEquals (list1.size()+1, list2.size());
    DonationServiceAPI.deleteUser(returnedUser);
    List<User> list3 = DonationServiceAPI.getUsers();
    assertEquals (list1.size(), list3.size());
  }
}