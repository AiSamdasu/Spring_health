package org.example.spring_caw_ktk.controller;

import org.example.spring_caw_ktk.dao.RankRepository;
import org.example.spring_caw_ktk.dto.Rank;
import org.example.spring_caw_ktk.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RankController {

    private final RankRepository rankRepo = new RankRepository();

    // 점수 제출
    @PostMapping("/submitScore")
    public String submitScore(@RequestParam("score") int score,
                              HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        if (user == null) return "redirect:/login";

        rankRepo.saveOrUpdateRank(user.getUserid(), score);
        return "redirect:/rank";
    }

    // 랭킹 보기
    @GetMapping("/rank")
    public String showRank(Model model) {
        List<Rank> rankList = rankRepo.findAll();
        model.addAttribute("rankList", rankList);
        return "Rank/RankPage";
    }
}
