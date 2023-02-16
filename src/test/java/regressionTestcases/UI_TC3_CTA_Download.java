package regressionTestcases;

import org.testng.Assert;

import org.testng.annotations.Test;

import base.Base;
import pages.TourListingPage;






public class UI_TC3_CTA_Download extends Base 
{
	@Test

	public void TC3() throws Exception
	{

		TourListingPage Listing = new TourListingPage(driver);
		Assert.assertTrue(Listing.validate_title());


		Listing.select_departure_march();
		Listing.click_accept();
		Listing.update_dayslength_filter();
		Listing.select_country_france();
		Listing.select_country_italy();
		Listing.select_country_spain();
		Listing.get_filter_text();


		//Download brochure and  download confirmation
		Listing.click_downloadbrochure();
		Assert.assertTrue(Listing.validate_popup_header());
		Listing.get_popup_email();
		Listing.clck_popup_submit();
		Assert.assertTrue(Listing.validate_download_success());


	}


}



