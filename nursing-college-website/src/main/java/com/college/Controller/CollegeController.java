package com.college.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.college.Entity.Admission;
import com.college.Entity.Course;
import com.college.Repository.AdmissionRepository;
import com.college.Service.CourseService;

@Controller
public class CollegeController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private AdmissionRepository admissionRepository;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("newsTicker", "Admissions Open for B.Sc, GNM, and M.Sc Nursing | Apply Now!");
		return "index";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}

	@GetMapping("/courses")
	public String showCourses(Model model) {
	    List<Course> courseList = courseService.getAllCourses();
	    model.addAttribute("courses", courseList);
	    
	    // ✅ Add this line to help highlight the ACADEMICS navbar
	    model.addAttribute("activePage", "courses");

	    return "courses";
	}
	

	@GetMapping("/admission")
	public String admission(Model model) {
	    model.addAttribute("activePage", "admission");
	    return "admission";
	}
	

	@PostMapping("/admission/save")
	public String saveAdmission(@ModelAttribute Admission admission) {
		admissionRepository.save(admission);
		return "redirect:/admission?success";
	}

	@GetMapping("/gallery")
	public String gallery() {
		return "gallery";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

	@GetMapping("/academic")
	public String academicPage() {
		return "academic"; // this should match the filename
	}

	@GetMapping("/events")
	public String showEventsPage() {
		return "events"; // this matches events.html file name
	}
	 @GetMapping("/research")
	    public String showResearchPage() {
	        return "research"; // loads research.html
	    }


	@GetMapping("/publications")
	public String showPublicationsPage() {
		return "publications";
	}

	@GetMapping("/research-list")
	public String showResearchListPage() {
		return "research-list";
	}

	@GetMapping("/thesis")
	public String showThesisPage() {
		return "thesis";
	}
	@GetMapping("/people")
    public String showPeoplePage() {
        return "people";  // It will look for people.html in src/main/resources/templates/
    }
	@GetMapping("/administration")
	public String administration() {
	    return "administration";
	}
	@GetMapping("/faculty")
	public String faculty() {
	    return "faculty";
	}
	@GetMapping("/board-of-studies")
	public String boardOfStudies() {
	    return "board-of-studies";
	}
	
	@GetMapping("/tours")
	public String showToursPage() {
	    return "tours"; // must match templates/tours.html
	}
	@GetMapping("/aluminipage")
    public String aluminiPage() {
        return "aluminipage"; // looks for alumnipage.html inside templates folder
    }
	 @GetMapping("/quickhelp")
	    public String quickHelpPage() {
	        return "quick-help"; // Thymeleaf will look for quick-help.html in templates/
	    }
	 @GetMapping("/sports")
	 public String sportsPage() {
	     return "sports";
	 }
	 @GetMapping("/facility")
	 public String facilityPage() {
	     return "facility";
	 }
	 @GetMapping("/admission-2025")
	    public String showAdmissionPage() {
	        return "admission-2025";  // returns admission-2025.html from templates folder
	    }
	 
	 

}
