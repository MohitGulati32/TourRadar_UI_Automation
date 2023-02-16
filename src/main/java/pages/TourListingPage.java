package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Utility;

public class TourListingPage {


	WebDriver driver=null;



	public TourListingPage (WebDriver driver)
	{
		this.driver= driver;
	}



	public Boolean validate_title () throws IOException
	{
		By Home_title = By.xpath(Utility.fetchlocatorValue("HomePagetitle_xpath"));
		Boolean Title_is_correct = driver.findElement(Home_title).getText().equals(Utility.fetchPropertyValue("HomePagetitle"));
		return Title_is_correct;
	}


	public void update_dayslength_filter() throws IOException

	{
		WebElement sliderB = driver.findElement(By.xpath(Utility.fetchlocatorValue("dayslength_max_slider_xpath")));
		Actions move = new Actions(driver);		
		move.dragAndDropBy(sliderB, -110, 0).click();				
		move.build().perform();	
	}

	public void select_departure_march() throws IOException

	{

		By  march_check = By.xpath(Utility.fetchlocatorValue("departure_date_march2023_checkbox_xpath"));
		driver.findElement(march_check).click();
	}

	


	public void sort_byLength() throws IOException

	{
		Select sort = new Select (driver.findElement(By.xpath(Utility.fetchlocatorValue("sort_filter_xpath"))));
		sort.selectByValue(Utility.fetchPropertyValue("sort_by_tour_length_asc"));
	}


	public void sort_byReviews() throws IOException

	{
		Select sort = new Select (driver.findElement(By.xpath(Utility.fetchlocatorValue("sort_filter_xpath"))));
		sort.selectByValue(Utility.fetchPropertyValue("sort_by_tour_reviews"));
	}



	public void click_accept() throws IOException

	{
		By  accept_button = By.xpath(Utility.fetchlocatorValue("accpet_button_xpath"));
		driver.findElement(accept_button).click();

	}


	public void select_country_france() throws IOException

	{
		By  france_country = By.xpath(Utility.fetchlocatorValue("country_france_xpath"));
		driver.findElement(france_country).click();

	}

	public void select_country_italy() throws IOException

	{
		By  italy_country = By.xpath(Utility.fetchlocatorValue("country_italy_xpath"));
		driver.findElement(italy_country).click();

	}


	public void select_country_spain() throws IOException

	{
		By  spain_country = By.xpath(Utility.fetchlocatorValue("country_spain_xpath"));
		driver.findElement(spain_country).click();

	}


	public void select_country_austria() throws IOException

	{

		By  austria_country = By.xpath(Utility.fetchlocatorValue("country_austria_xpath"));
		driver.findElement(austria_country).click();

	}




	public void get_filter_text() throws IOException

	{
		By  no_of_filters = By.xpath(Utility.fetchlocatorValue("no_of_filters_xpath"));
		String noOffilters = driver.findElement(no_of_filters).getText();
		System.out.println(noOffilters);

	}


	public Boolean firstFilter_contains_march() throws IOException

	{
		By  first_filter = By.xpath(Utility.fetchlocatorValue("first_filter_xpath"));
		String filter_text = driver.findElement(first_filter).getText();
		System.out.println(filter_text);
		Boolean March_Filter = filter_text.contains(Utility.fetchPropertyValue("filter_month"));
		return March_Filter;

	}




	public void click_downloadbrochure() throws IOException

	{  
		int attempts = 0;
		while(attempts < 2) {

			try {

				By  downloadbrochure = By.xpath(Utility.fetchlocatorValue("downloadbrochure_button_xpath"));
				driver.findElement(downloadbrochure).click();
			}

			catch (StaleElementReferenceException e) 
			{

			}
			attempts ++;
		}

	}


	public Boolean validate_popup_header() throws IOException

	{   By  popup_header = By.xpath(Utility.fetchlocatorValue("popup_header_xpath"));
	String header = driver.findElement(popup_header).getText();
	System.out.println(header);
	Boolean validate_header = header.contains(Utility.fetchPropertyValue("popup_hearder_exp"));
	return validate_header;

	}


	public void get_popup_email() throws IOException

	{   
		By  popup_email_textbox = By.xpath(Utility.fetchlocatorValue("popup_email_xpath"));
		driver.findElement(popup_email_textbox).sendKeys(Utility.fetchPropertyValue("email_to_enter"));
	}



	public void clck_popup_submit() throws IOException

	{   By  popup_submit = By.xpath(Utility.fetchlocatorValue("popup_submit_xpath"));
	driver.findElement(popup_submit).click();

	}


	public Boolean validate_download_success() throws IOException

	{  

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((Utility.fetchlocatorValue("popup_successmessage_xpath")))));


		WebElement success_message = driver.findElement(By.xpath((Utility.fetchlocatorValue("popup_successmessage_xpath"))));
		String message = success_message.getText();
		System.out.println(message);
		Boolean success = message.contains("We’ve sent the");
		return success;


	}



	public boolean check_alltours_length() throws IOException
	{   
		int attempts = 0;
		while(attempts < 2) {

			try {

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Utility.fetchlocatorValue("tour_length_xpath"))));
				By tour_length_field = By.xpath(Utility.fetchlocatorValue("tour_length_xpath"));
				List <WebElement> tour_length_list =driver.findElements(tour_length_field);
				System.out.println("no of tours is " + tour_length_list.size());
				int tourlength_limit = 10 ;
				System.out.println("max tour length should be " + tourlength_limit );
				for (int i=0; i< tour_length_list.size() ;i++)
				{


					String tl_str1 = tour_length_list.get(i).getText().replaceAll("[^0-9]", "");

					int actual_tour_length =Integer.parseInt(tl_str1);
					System.out.println(actual_tour_length);

					if (actual_tour_length>tourlength_limit)
						return false;

				}

			}

			catch (StaleElementReferenceException e) 
			{

			}
			attempts ++;
		}
		return true;


	}


	public boolean check_alltours_destinations() throws IOException
	{

		By tour_destinations_field = By.xpath(Utility.fetchlocatorValue("tour_destinations_xpath"));
		List <WebElement> tour_list =driver.findElements(tour_destinations_field);
		System.out.println("no of tours is " + tour_list.size());

		for (int i=0; i< tour_list.size() ;i++)
		{


			String tour_destinations = tour_list.get(i).getText();


			System.out.println(tour_destinations);

			if (!tour_destinations.contains(Utility.fetchPropertyValue("destination1"))
					&& !tour_destinations.contains(Utility.fetchPropertyValue("destination2"))
					&& !tour_destinations.contains(Utility.fetchPropertyValue("destination3"))
					&& !tour_destinations.contains(Utility.fetchPropertyValue("destination4"))
					&& !tour_destinations.contains(Utility.fetchPropertyValue("destination5")))
				return false;

		}

		return true;
	}



	public boolean check_tourlength_sort() throws IOException
	{
		By tour_length_field = By.xpath(Utility.fetchlocatorValue("tour_length_xpath"));
		List <WebElement> tour_length_list =driver.findElements(tour_length_field);
		System.out.println("no of tours is " + tour_length_list.size());


		ArrayList<Integer> tourlengths = new ArrayList<Integer>();
		for (int i=0; i< tour_length_list.size()-1 ;i++)
		{



			String tl_str1 = tour_length_list.get(i).getText().replaceAll("[^0-9]", "");
			int actual_tour_length =Integer.parseInt(tl_str1);
			System.out.println(actual_tour_length);
			tourlengths.add(actual_tour_length);
		}  


		for (int j=1; j< tourlengths.size()-1 ;j++)
		{
			if (tourlengths.get(j)<tourlengths.get(j-1))
				return false;
		}  
		return true;



	}


	public boolean check_reviews_sort() throws IOException
	{
		int attempts = 0;
		while(attempts < 2) {

			try { 

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Utility.fetchlocatorValue("tour_reviews_xpath"))));

				By tour_reviews_field = By.xpath(Utility.fetchlocatorValue("tour_reviews_xpath"));
				List <WebElement> tour_revews_list =driver.findElements(tour_reviews_field);
				System.out.println("no of tours is " + tour_revews_list.size());


				ArrayList<Integer> tourRevs = new ArrayList<Integer>();
				for (int i=0; i< tour_revews_list.size()-1 ;i++)
				{



					String tr_str1 = tour_revews_list.get(i).getText().replaceAll("[^0-9]", "");
					int actual_tour_reviews =Integer.parseInt(tr_str1);
					System.out.println(actual_tour_reviews);
					tourRevs.add(actual_tour_reviews);
				}  


				for (int j=1; j< tourRevs.size()-1 ;j++)
				{
					if (tourRevs.get(j)>tourRevs.get(j-1))
						return false;
				}
			}
			catch (StaleElementReferenceException e) 
			{

			}
			attempts ++;

		}  
		return true;



	}


}



