package regressionTestcases;

import org.testng.Assert;

import org.testng.annotations.Test;

import base.Base;
import pages.TourListingPage;






public class UI_TC1_Filters extends Base 
{
	@Test

	public void TC1() throws Exception
	{

		TourListingPage Listing = new TourListingPage(driver);
		Assert.assertTrue(Listing.validate_title());

		//Filters 
		Listing.select_departure_march();
		Listing.click_accept();
		Listing.update_dayslength_filter();
		Listing.select_country_france();
		Listing.select_country_italy();
		Listing.select_country_spain();
		Listing.get_filter_text();

		//Filter Assertions
		Assert.assertTrue(Listing.firstFilter_contains_march());
		Assert.assertTrue(Listing.check_alltours_length());
		Assert.assertTrue(Listing.check_alltours_destinations());

	}


}



