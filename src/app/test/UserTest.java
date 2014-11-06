package app.test;

import java.util.List;
import org.junit.Test;
import app.api.DonationServiceAPI;
import app.model.User;

public class UserTest
{

  @Test
  public void testList() throws Exception
  {
    List<User> list = DonationServiceAPI.getUsers();
    System.out.println(list);
  }
}
