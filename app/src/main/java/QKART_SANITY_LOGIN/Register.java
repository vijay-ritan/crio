
            

     package QKART_SANITY_LOGIN;

     import java.sql.Timestamp;
     
     import org.openqa.selenium.By;
     import org.openqa.selenium.WebElement;
     import org.openqa.selenium.chrome.ChromeDriver;
     import org.openqa.selenium.remote.RemoteWebDriver;
     
     public class Register {
         RemoteWebDriver driver;
         String url = "https://crio-qkart-frontend-qa.vercel.app/register";
         String lastGeneratedUsername = "";
     
         public Register(RemoteWebDriver driver) {
             this.driver = driver;
         }
     
         public void navigateToRegisterPage() {
             if (!driver.getCurrentUrl().equals(this.url)) {
                 driver.get(this.url);
             }
         }
     
         public Boolean registerUser(String Username, String Password, Boolean makeUsernameDynamic)
                 throws InterruptedException {
             // Find the Username Text Box
             WebElement username_txt_box = this.driver.findElement(By.id("username"));
     
             // Get time stamp for generating a unique username
             //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
     
             String test_data_username;
             //if (makeUsernameDynamic)
                 // Concatenate the timestamp to string to form unique timestamp
               //  test_data_username = Username + "_" + String.valueOf(timestamp.getTime());
             //else
     
             // Type the generated username in the username field
             username_txt_box.sendKeys(Username);
     
             // Find the password Text Box
             WebElement password_txt_box = this.driver.findElement(By.id("password"));
             String test_data_password = Password;
     
             // Enter the Password value
             password_txt_box.sendKeys(test_data_password);
     
     
              // Find the Confirm password text box
              WebElement confirm_password_txt_box =
              this.driver.findElement(By.id("confirmPassword"));
     
             // Enter the Confirm Password Value
             confirm_password_txt_box.sendKeys(test_data_password);
     
             // Find the register now button
             WebElement register_now_button = this.driver.findElement(By.className("button"));
     
             // Click the register now button
             register_now_button.click();
             Thread.sleep(3000);
     
     
             this.lastGeneratedUsername = Username;
     
             return this.driver.getCurrentUrl().endsWith("/login");
         }
     }
     