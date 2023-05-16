package therapy.session.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import therapy.session.Model.PatientsModel;
import therapy.session.Service.PatientsService;

@Controller
public class PatientsController {

    private final PatientsService patientsService;

    public PatientsController(PatientsService patientsService) {
        this.patientsService = patientsService;
    }


    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }
    @GetMapping("/register")
    public  String getRegisterPage(Model model){
    model.addAttribute("registerRwquest", new PatientsModel());

        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginpage(Model model){
        model.addAttribute("loginRequest", new PatientsModel());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute PatientsModel patientsModel){
        System.out.println("register request:" + patientsModel);
        PatientsModel registerPatient = patientsService.registerPatient(patientsModel);
        return "redirect:/login";
//        PatientsModel authenticated = patientsService.registerPatient(patientsModel.getEmail(), patientsModel.getPassword());
//        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute PatientsModel patientsModel, Model model){
        System.out.println("login request :" + patientsModel);
//        PatientsModel p = patientsService.authenticate(patientsModel.getEmail(),patientsModel.getPassword());
        PatientsModel authenticate = patientsService.authenticate(patientsModel);
        if(authenticate !=null){
            model.addAttribute("userLogin", authenticate.getEmail());
            return "signup";
        }else{
            return "error_page";
        }
//        PatientsModel p = patientsService.

    }
}
