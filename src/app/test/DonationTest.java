package app.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.api.DonationServiceAPI;
import app.model.Donation;
import app.model.User;

public class DonationTest
{
  User marge =  new User ("marge",  "simpson", "homer@simpson.com",  "secret");
  
  @Before
  public void setup() throws Exception
  { 
    marge = DonationServiceAPI.createUser(marge);
  }
  
  @After
  public void teardown() throws Exception
  {
    DonationServiceAPI.deleteUser(marge);
  }
  
  @Test
  public void testCreateDonation () throws Exception
  {
    Donation donation = new Donation (123, "cash");
    Donation returnedDonation = DonationServiceAPI.createDonation(marge, donation);
    assertEquals (donation, returnedDonation);
    
    DonationServiceAPI.deleteDonation(marge, returnedDonation);
  }
  
  
  @Test
  public void testCreateDonations () throws Exception
  {
    Donation donation1 = new Donation (123, "cash");
    Donation donation2 = new Donation (450, "cash");
    Donation donation3 = new Donation (43,  "paypal");
    
    Donation returnedDonation1 = DonationServiceAPI.createDonation(marge, donation1);
    Donation returnedDonation2 = DonationServiceAPI.createDonation(marge, donation2);
    Donation returnedDonation3 = DonationServiceAPI.createDonation(marge, donation3);
    
    assertEquals(donation1, returnedDonation1);
    assertEquals(donation2, returnedDonation2);
    assertEquals(donation3, returnedDonation3);

    DonationServiceAPI.deleteDonation(marge, returnedDonation1);
    DonationServiceAPI.deleteDonation(marge, returnedDonation2);    
    DonationServiceAPI.deleteDonation(marge, returnedDonation3);
  }
  
  @Test
  public void testListDonations () throws Exception
  {
    Donation donation1 = new Donation (123, "cash");
    Donation donation2 = new Donation (450, "cash");
    Donation donation3 = new Donation (43,  "paypal");
    
    DonationServiceAPI.createDonation(marge, donation1);
    DonationServiceAPI.createDonation(marge, donation2);
    DonationServiceAPI.createDonation(marge, donation3);
    
    List<Donation> donations = DonationServiceAPI.getDonations(marge);
    assertEquals (3, donations.size());
    
    assertTrue(donations.contains(donation1));
    assertTrue(donations.contains(donation2));
    assertTrue(donations.contains(donation3));

    DonationServiceAPI.deleteDonation(marge, donations.get(0));
    DonationServiceAPI.deleteDonation(marge, donations.get(1));    
    DonationServiceAPI.deleteDonation(marge, donations.get(2));
  }
  
}
