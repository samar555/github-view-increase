package app.netlify.sachin1008.controller;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.netlify.sachin1008.Dto.UserData;
import app.netlify.sachin1008.service.WebDrivers;

@RestController
@RequestMapping("api/v1/user")
public class IncreaseViewController {
@Autowired
private WebDrivers drivers;
	
	
	@PostMapping("/views")
	public ResponseEntity<String> increseView(@RequestBody UserData data){
		if(data.getGitHubUrl().isEmpty()||data.getGitHubUrl()==null) {
			return ResponseEntity.badRequest().body("github url is empty");
			
		}
		if(data.getNumber()==0) {
			return ResponseEntity.badRequest().body("no of view is empty");
			
		}else {
			Thread thread = new Thread(() -> {
			    WebDriver driver = drivers.getChromeDriver();
			    try {
			        for (int i = 0; i < data.getNumber(); i++) {
			            driver.get("https://www.github.com/" + data.getGitHubUrl().trim());
			            Thread.sleep(100); // Pause for a short time
			            System.out.println("Waiting iteration: " + (i + 1));
			        }
			    } catch (Exception e) {
			        e.printStackTrace();
			    } finally {
			        driver.quit();
			    }
			});

			thread.start(); // Start the thread
			try {
			    thread.join(); // Wait for the thread to finish
			} catch (InterruptedException e) {
			    e.printStackTrace();
			    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Thread was interrupted.");
			}

			return ResponseEntity.ok().body("Increased views to https://www.github.com/" + data.getGitHubUrl().trim() + " with " + data.getNumber());

		}
		
	}
}
