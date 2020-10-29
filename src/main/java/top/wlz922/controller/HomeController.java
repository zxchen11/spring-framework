package top.wlz922.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Properties;

/**
 * @author Eddie
 */
@Controller
public class HomeController {
	@GetMapping("index")
	public String toIndex() {
		return "index";
	}

	@GetMapping("props")
	@ResponseBody
	public Properties props() {
		return System.getProperties();
	}

	@ResponseBody
	@PostMapping(value = "/mirror", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> mirror(@RequestBody Map<String, Object> paramMap) {
		return paramMap;
	}
}
