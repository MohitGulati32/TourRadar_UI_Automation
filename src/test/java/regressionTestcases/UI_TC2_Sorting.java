package regressionTestcases;

import org.testng.Assert;

import org.testng.annotations.Test;

import base.Base;
import pages.TourListingPage;





public class UI_TC2_Sorting extends Base 
{
	@Test

	public void TC2() throws Exception
	{

		TourListingPage Listing = new TourListingPage(driver);
		Assert.assertTrue(Listing.validate_title());

		//Filter
		Listing.select_departure_march();
		Listing.click_accept();
		Listing.update_dayslength_filter();
		Listing.select_country_france();
		Listing.select_country_italy();


		//Sorting 1
		Listing.sort_byLength();
		Listing.get_filter_text();

		//Assertions for filter and sorting
		Assert.assertTrue(Listing.firstFilter_contains_march());
		Assert.assertTrue(Listing.check_alltours_length());
		Assert.assertTrue(Listing.check_alltours_destinations());
		Assert.assertTrue(Listing.check_tourlength_sort());


		//Sorting 2

		Listing.sort_byReviews();
		Assert.assertTrue(Listing.firstFilter_contains_march());
		Assert.assertTrue(Listing.check_alltours_length());
		Assert.assertTrue(Listing.check_reviews_sort());

	}


}



