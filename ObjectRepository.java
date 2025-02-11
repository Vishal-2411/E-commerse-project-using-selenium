package framework;

import org.openqa.selenium.By;
// In this class we put all the weblocators 
public class ObjectRepository 
{
	public By username = By.name("email");
	public By password = By.name("pass");
	public By login = By.name("login");
}




// we can stored By.name