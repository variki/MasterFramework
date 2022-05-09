package com.duckduckgo.tests;

import com.duckduckgo.pages.SearchPage;
import com.master.driver.DriverManager;
import com.master.tests.web.base.WebBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends WebBase {
    private String keyword;

    @BeforeTest
    @Parameters({"keyword"})
    public void testSetup(String keyword){
        this.keyword = keyword;
    }

    @Test
    public void searchPage(){
        SearchPage searchPage = new SearchPage(DriverManager.getDriver());
        searchPage.goTo();
        searchPage.doSearch(this.keyword);
        searchPage.goToVideos();
        int size = searchPage.getResult();
        Assert.assertTrue(size>0);
    }
}
