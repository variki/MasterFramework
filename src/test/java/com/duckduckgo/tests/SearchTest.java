package com.duckduckgo.tests;

import com.duckduckgo.pages.SearchPage;
import com.master.tests.webBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends webBase {
    private String keyword;

    @BeforeTest
    @Parameters({"keyword"})
    public void testSetup(String keyword){
        this.keyword = keyword;
    }

    @Test
    public void searchPage(){
        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.goTo();
        searchPage.doSearch(this.keyword);
        searchPage.goToVideos();
        int size = searchPage.getResult();
        Assert.assertTrue(size>0);
    }
}
