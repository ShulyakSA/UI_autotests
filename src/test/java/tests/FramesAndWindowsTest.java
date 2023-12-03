package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Epic(value = "Форма Frames And Windows")
@Feature(value = "Переключение окон")
public class FramesAndWindowsTest extends BaseTest {
    String firstHandle;
    String secondHandle;

    @BeforeClass
    public void openPage() {
        framesAndWindowsPage.openFramesAndWindowsPage();
        firstHandle = driver.get().getWindowHandle();
    }

    @Story(value = "Проверка перехода между страницами")
    @Severity(CRITICAL)
    @Test(description = "Проверка перехода по ссылке с переключением на текущее окно")
    public void checkFrameAndWindows() {
        framesAndWindowsPage.switchToWindowsFrame()
                .clickNewBrowserTabLink().switchToNextWindow(firstHandle);
        secondHandle = driver.get().getWindowHandle();
        framesAndWindowsPage.clickNewBrowserTabLink().switchToNextWindow(secondHandle);
        ArrayList<String> tabs = new ArrayList<>(driver.get().getWindowHandles());
        Assert.assertEquals(driver.get().getWindowHandle(), tabs.get(2));
    }
}
