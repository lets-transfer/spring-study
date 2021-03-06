package lets.transfer.controller;

import lets.transfer.domain.sample.Sample;
import lets.transfer.domain.sample.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/sample")
public class SampleController {
	private final SampleService sampleService;

	@Autowired
	public SampleController(SampleService sampleService) {
		this.sampleService = sampleService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String viewIndex(Model model) {
		model.addAttribute("samples",sampleService.list());
		return "sample/index";
	}

	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public String editSample(@PathVariable long id, Model model) {
		model.addAttribute("sample", sampleService.get(id));
		return "sample/insertEdit";
	}

	@RequestMapping(value ="/new", method = RequestMethod.GET)
	public String newSample(Model model) {
		model.addAttribute("sample", new Sample());
		return "sample/insertEdit";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String saveSample(@ModelAttribute Sample sample, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("result", "saved");
		sampleService.save(sample);
		return "redirect:/sample";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteSample(@PathVariable long id, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("result", "Deleted");
		sampleService.remove(id);
		return "redirect:/sample";
	}
}
