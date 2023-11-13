package helpers;

import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.ashot.AShot;

import tests.BaseTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Slf4j
public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        log.info("Test {} ~ FAILED", result.getTestContext().getName());
        String screenshotName = result.getTestContext().getName() +
                String.valueOf(System.currentTimeMillis()).substring(9, 13);
        log.info("Trying to trace screenShot...");
        WebDriver webDriver = ((BaseTest) result.getInstance()).driver;
        BufferedImage screenshot = new AShot().takeScreenshot(webDriver).getImage();
        String format = "PNG";
        try {
            ImageIO.write(screenshot, format, new File("build/reports/tests/" + screenshotName + ".png"));
            attachScreenshotToAllure(screenshot, format);
        } catch (IOException e) {
            log.info("Exception on saving screenshot!");
            e.printStackTrace();
        }
    }

    @Attachment
    public byte[] attachScreenshotToAllure(BufferedImage screenshot, String format) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(screenshot, format, baos);
        byte[] bytes=baos.toByteArray();
        baos.close();
        baos.flush();
        return bytes;
    }
}
