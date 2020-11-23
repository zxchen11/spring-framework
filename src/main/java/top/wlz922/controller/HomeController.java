package top.wlz922.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.wlz922.service.HomeService;

import java.util.Map;
import java.util.Properties;

/**
 * @author Eddie
 */
@Controller
public class HomeController {
	@Autowired
	private HomeService homeService;

	@GetMapping("index")
	public String toIndex() {
		return "index";
	}

	@GetMapping("/props")
	@ResponseBody
	public Properties props() {
		return System.getProperties();
	}

	@ResponseBody
	@PostMapping(value = "/mirror", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> mirror(@RequestBody Map<String, Object> paramMap) {
		return paramMap;
	}

	@ResponseBody
	@PostMapping(value = "/serviceMirror", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> serviceMirror(@RequestBody Map<String, Object> paramMap) {
		return homeService.serviceMirror(paramMap);
	}

	@RequestMapping("/throwException")
	public Object throwException(@RequestParam("msg") String msg) {
		throw new RuntimeException(msg);
	}
}
