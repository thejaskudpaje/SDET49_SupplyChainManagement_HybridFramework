package com.scm.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminHomePage {

@FindBy(xpath = "//a[text()='Add Products']") private WebElement addProductsLink;
@FindBy(xpath="//a[text()='Add Retailers']") private WebElement addRetailerLink;
@FindBy(xpath="//a[text()='Add Manufacturer']") private WebElement addManufacturerLink;
@FindBy(xpath="//a[text()='Add Distributor']") private WebElement addDistributorLink;
@FindBy(xpath="//a[text()='Manage Category']") private WebElement manageCategoryLink;
@FindBy(xpath="//a[text()='Manage Area']") private WebElement manageAreaLink;
@FindBy(xpath="//a[text()='Change Password']") private WebElement changePasswordlink;
@FindBy(xpath="//a[text()='Retailers']") private WebElement retailerlink;
@FindBy(xpath="//a[text()='Manufacturers']") private WebElement Manufacturerslink;



}
