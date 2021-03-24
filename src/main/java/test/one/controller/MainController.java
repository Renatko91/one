package test.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import test.one.entity.History;
import test.one.service.ServiceDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    ServiceDAO service;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "redirect:/exchange";
    }

    @GetMapping("/exchange")
    public String exchangePage(Model model) {
        List<String> charCodeList = service.getCharCodeList();
        model.addAttribute("charCodes", charCodeList);
        return "exchange";
    }

    @PostMapping("/exchange")
    public String exchange(@RequestParam String code, @RequestParam String codeTwo, @RequestParam String need, RedirectAttributes redirectAttributes) {
        if (service.getMaxDate().isBefore(LocalDate.now())) service.updateRateDB();
        double total = service.calculate(code, codeTwo, need);

        redirectAttributes.addFlashAttribute("total", total);
        return "redirect:/exchange";
    }

    @GetMapping("/history")
    public String historyPage(Model model) {
        String code = (String) model.getAttribute("code");
        String codeTwo = (String) model.getAttribute("codeTwo");
        String need = (String) model.getAttribute("need");
        List<History> historieList;
        if (code != null) {
            historieList = service.getHistoryAfterFilter(code, codeTwo, need);
        } else {
            historieList = service.getHistoryList();
        }
        List<String> charCodeList = service.getCharCodeList();
        model.addAttribute("historys", historieList);
        model.addAttribute("charCodes", charCodeList);
        return "history";
    }

    @PostMapping("/history")
    public String history(@RequestParam String code, @RequestParam String codeTwo, @RequestParam String need, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("code", code);
        redirectAttributes.addFlashAttribute("codeTwo", codeTwo);
        redirectAttributes.addFlashAttribute("need", need);
        return "redirect:/history";
    }
}
