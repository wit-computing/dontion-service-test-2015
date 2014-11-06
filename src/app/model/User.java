package app.model;

import com.google.common.base.Objects;
import static com.google.common.base.Objects.toStringHelper;

public class User 
{
  public Long   id;
  public String firstName;
  public String lastName;
  public String email;
  public String password;
 
  public User()
  {}
  
  public User(String firstName, String lastName, String email, String password)
  {
    this.firstName = firstName;
    this.lastName  = lastName;
    this.email     = email;
    this.password  = password;
  } 
  
  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof User)
    {
      final User other = (User) obj;
      return Objects.equal(firstName,  other.firstName) 
          && Objects.equal(lastName,   other.lastName)
          && Objects.equal(email,      other.email)
          && Objects.equal(password,   other.password);                               
    }
    else
    {
      return false;
    }
  }  
  
  @Override
  public String toString()
  {
    return toStringHelper(this).addValue(id)
                               .addValue(firstName)
                               .addValue(lastName)
                               .addValue(password)
                               .addValue(email)  
                               .toString();
  }
}