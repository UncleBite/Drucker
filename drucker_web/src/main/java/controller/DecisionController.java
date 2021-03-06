package controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import model.ExcelAnalysis;
import model.ExcelModify;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class DecisionController {

    ExcelAnalysis analysis = new ExcelAnalysis();
    ExcelModify modify = new ExcelModify();

    @GetMapping("/decision")
    public String servePage(@RequestParam(name="token", required=false, defaultValue="no-token") String token, Model model) {
        /////////////////////////////////////////////////
        // Handle login check, do not touch
        String path = LoginManagement.validateUser("decision", token, model);
        if (path != null) return path;
        /////////////////////////////////////////////////



        return "decision";
    }

    @GetMapping("/decision-choice")
    public String choicePage(@RequestParam(name="token", required=false, defaultValue="no-token") String token, Model model) {
        /////////////////////////////////////////////////
        // Handle login check, do not touch
        String path = LoginManagement.validateUser("decision-choice", token, model);
        if (path != null) return path;
        /////////////////////////////////////////////////

        return "decision-choice";
    }

    @RequestMapping(value="/lightning-model", method=RequestMethod.POST)
    public String validateLogin(@RequestParam(name="token", required=false, defaultValue="no-token") String token,
                                @RequestParam Double x1, @RequestParam Double x2, @RequestParam Double x3,
                                @RequestParam String s1, @RequestParam Double x4, @RequestParam Double x5,
                                @RequestParam Double x6, @RequestParam Double x7, @RequestParam Double x8,
                                @RequestParam Double x9, @RequestParam Double x10, @RequestParam String s2,
                                @RequestParam Double x11, @RequestParam Double x12, @RequestParam Double x13,
                                @RequestParam Double x14, @RequestParam Double x15, @RequestParam Double x16,
                                @RequestParam Double x17, @RequestParam Double x18,
                                Model model) {

        try {
            modify.Light(analysis, x1, x2, x3, s1, x4, x5, x6, x7, x8, x9, x10, s2, x11, x12, x13, x14, x15, x16, x17, x18);
            System.out.println("MODIFY SUCCESsS.");
        }
        catch(IOException e) {
            e.printStackTrace();
        } catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
            e.printStackTrace();
        }

        return "decision";
    }

    @GetMapping("/lightning-analysis")
    public String lightningResult(@RequestParam(name="token", required=false, defaultValue="no-token") String token, Model model) {
        /////////////////////////////////////////////////
        // Handle login check, do not touch
        String path = LoginManagement.validateUser("lightning-analysis", token, model);
        if (path != null) return path;
        /////////////////////////////////////////////////

        Double npv = 0.0;
        Double irr = 0.0;
        Double spr = 0.0;

        try {
            ArrayList<Double> result = analysis.LightAnalyse();
            npv = result.get(0);
            irr = result.get(1);
            spr = result.get(2);

            System.out.println(npv);
            System.out.println(irr);
            System.out.println(spr);

            System.out.println("LIGHTNING OUTPUT SUCCESS.");
        }
        catch(IOException e) {
            e.printStackTrace();
        } catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
            e.printStackTrace();
        }

        String npv_str = String.format("%.2f", npv);
        String irr_str = String.format("%.2f", irr);
        String spr_str = String.format("%.2f", spr);

        model.addAttribute("npv", npv_str);
        model.addAttribute("irr", irr_str);
        model.addAttribute("spr", spr_str);

        return "light-analysis";
    }


    // PLUMBING MODEL.
    @RequestMapping(value="/plumbing-model", method=RequestMethod.POST)
    public String plumbingModel(@RequestParam(name="token", required=false, defaultValue="no-token") String token,
                                @RequestParam Double y1, @RequestParam Double y2, @RequestParam Double y3,
                                @RequestParam String t1, @RequestParam Double y4, @RequestParam Double y5,
                                @RequestParam Double y6, @RequestParam Double y7, @RequestParam Double y8,
                                @RequestParam Double y9, @RequestParam Double y10, @RequestParam String t2,
                                @RequestParam Double y11, @RequestParam Double y12,
                                Model model) {

        try {
            modify.Plumbing(analysis, y1, y2, y3, t1, y4, y5, y6, y7, t2, y8, y9, y10, y11, y12);
            System.out.println("PLUMBING MODIFY SUCCESS.");
        }
        catch(IOException e) {
            e.printStackTrace();
        } catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
            e.printStackTrace();
        }

        return "decision";
    }

    @GetMapping("/plumbing-analysis")
    public String plumbningResult(@RequestParam(name="token", required=false, defaultValue="no-token") String token, Model model) {
        /////////////////////////////////////////////////
        // Handle login check, do not touch
        String path = LoginManagement.validateUser("plumbing-analysis", token, model);
        if (path != null) return path;
        /////////////////////////////////////////////////

        Double npv = 0.0;
        Double irr = 0.0;
        Double ppp = 0.0;

        try {
            ArrayList<Double> result = analysis.PlumbingAnalyse();
            npv = result.get(0);
            irr = result.get(1);
            ppp = result.get(2);

            System.out.println(npv);
            System.out.println(irr);
            System.out.println(ppp);

            System.out.println("LIGHTNING OUTPUT SUCCESS.");
        }
        catch(IOException e) {
            e.printStackTrace();
        } catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
            e.printStackTrace();
        }

        String npv_str = String.format("%.2f", npv);
        String irr_str = String.format("%.2f", irr);
        String ppp_str = String.format("%.2f", ppp);

        model.addAttribute("npv", npv_str);
        model.addAttribute("irr", irr_str);
        model.addAttribute("ppp", ppp_str);

        return "plumbing-analysis";
    }

}
