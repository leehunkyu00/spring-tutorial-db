package com.springtutorial;
/*
package com.springtutorial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springtutorial.domain.Member;
import com.springtutorial.repository.MemberRepository;

@Controller
@RequestMapping("/member")
public class SpringtutorialfordbController {

    //rest
    @Autowired
    private MemberRepository memberDao;

    @RequestMapping("/add")
    @ResponseBody
    public Member add(Member member) {
        Member memberData = memberDao.save(member);
        return memberData;
    }

    @RequestMapping("/view/{id}")
    @ResponseBody
    public Member view(@PathVariable int id) {
        Member memberData = memberDao.findOne(id);
        return memberData;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Member> list() {
        List<Member> memberList = memberDao.findAll();
        return memberList;
    }

    @RequestMapping("/del/{id}")
    @ResponseBody
    public String delete(@PathVariable int id) {
        System.out.println("id = " + id);
        memberDao.delete(id);
        return "redirect:/member/list";
    }

    @RequestMapping("/edit/{id}")
    @ResponseBody
    public Member edit(Member member) {
        Member memberData = memberDao.save(member);
        return memberData;
    }

    // just test
    @RequestMapping("/test")
    @ResponseBody
    public int test() {
        return 1004;
    }

    // web ::
    @RequestMapping("/jsp")
    public String jspPage(Model model) {
        model.addAttribute("name", "hello springBoot!!");
        return "hello";
    }

    @RequestMapping("/")
    public String index() {
        return "hello world!!";
    }
}
*/
