package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Genericutil;
import util.Upload;

public class Stream extends Genericutil {
    WebDriver driver;
    public Stream() {
        super();
        PageFactory.initElements(driver(), this);
    }
    @FindBy(xpath = "(//p[normalize-space()='Saniatenis'])[1]")
    WebElement Clickstream;
    @FindBy(xpath = "//button[@class='_buttonMain_199iz_1 _buttonTypePrimary_199iz_22  _button_1afhi_46 ']")
    WebElement addstream;
    @FindBy(css = "input[placeholder='Enter stream title']")
    WebElement streamtitle;
    @FindBy(xpath = "(//input[@role='combobox'])[1]")
    WebElement streamdropdown;
    @FindBy(xpath = "//div[@class='_iconWrapper_1scid_35']")
    WebElement streamthumbnail1;
    /**
     * Clicks on stream
     */
    public void streamClick() {
        JSClick(Clickstream);
    }
    /**
     *clicks on addstream button
     */
    public void addStreamButton() {
        JSClick(addstream);
    }
    /**
     * Enter the streamname
     */
    public void addStreamTitle(String streamName) {
        sendValueToTextfield(streamtitle,streamName);
    }
    public void streamType(String stype) {
       waitAndClick(streamdropdown);
       streamdropdown1(stype);
    }
    public void streamThumbnail1(){
        JSClick(streamthumbnail1);
    }
    public void uploadThamb1() {
        Upload.file("C:\\Users\\Coditas\\Downloads\\Thumb.jpg");
    }

    @FindBy(xpath = "//div[@title='Live']")
    private WebElement liveOption;

    @FindBy(xpath = "//div[@title='Archived']")
    private WebElement archivedOption;

    public void streamdropdown1(String option){
        WebElement optionElement = null;
        switch (option){
            case "Live":
                optionElement = liveOption;
                break;
            case "Archived":
            default:
                optionElement = archivedOption;
        }
        JSClick(wait.until(ExpectedConditions.visibilityOf(optionElement)));
    }
}
