package com.wpl.tomarkdownserver;//package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaiduSearchTest {

    public static void main(String[] args) {
        // 使用 WebDriverManager 自动管理 ChromeDriver
        WebDriverManager.chromedriver().setup();

        // 配置 Chrome 选项
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");  // 无头模式
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox"); // 解决 Docker 环境下的错误

        // 初始化 WebDriver
        WebDriver driver = new ChromeDriver(options);
//        WebDriver driver = new ChromeDriver();

        try {
            // 打开百度首页
            driver.get("https://www.baidu.com");

            // 等待搜索框元素加载完成
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kw")));

            // 输入搜索关键词并提交
            searchBox.sendKeys("Spring Boot");
            searchBox.submit();

            // 等待搜索结果加载完成
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content_left")));

            // 获取搜索结果
            List<WebElement> results = driver.findElements(By.cssSelector(".result.c-container"));

            // 输出搜索结果的标题和链接
            for (WebElement result : results) {
                String title = result.findElement(By.cssSelector("h3")).getText();
                String link = result.findElement(By.cssSelector("a")).getAttribute("href");
                System.out.println("Title: " + title);
                System.out.println("Link: " + link);
                System.out.println("---------------------------------");
            }

        } finally {
            // 退出浏览器
            driver.quit();
        }
    }
}