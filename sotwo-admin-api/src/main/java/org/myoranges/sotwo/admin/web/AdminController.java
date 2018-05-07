package org.myoranges.sotwo.admin.web;

import org.myoranges.sotwo.admin.annotation.LoginAdmin;
import org.myoranges.sotwo.admin.service.AdminTokenManager;
import org.myoranges.sotwo.core.util.ResponseUtil;
import org.myoranges.sotwo.core.util.bcrypt.BCryptPasswordEncoder;
import org.myoranges.sotwo.db.domain.sotwoAdmin;
import org.myoranges.sotwo.db.service.sotwoAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/admin")
public class AdminController {
    @Autowired
    private sotwoAdminService adminService;

    @GetMapping("/info")
    public Object info(String token){
        Integer adminId = AdminTokenManager.getUserId(token);
        if(adminId == null){
            return ResponseUtil.badArgumentValue();
        }
        sotwoAdmin admin = adminService.findById(adminId);
        if(admin == null){
            return ResponseUtil.badArgumentValue();
        }

        Map<String, Object> data = new HashMap<>();
        data.put("name", admin.getUsername());
        data.put("avatar", admin.getAvatar());

        // 目前roles不支持，这里简单设置admin
        List<String> roles = new ArrayList<>();
        roles.add("admin");
        data.put("roles", roles);
        data.put("introduction", "admin introduction");
        return ResponseUtil.ok(data);
    }

    @GetMapping("/list")
    public Object list(@LoginAdmin Integer adminId,
                       String username,
                       @RequestParam(value = "page", defaultValue = "1") Integer page,
                       @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                       String sort, String order){
        if(adminId == null){
            return ResponseUtil.unlogin();
        }

        List<sotwoAdmin> adminList = adminService.querySelective(username, page, limit, sort, order);
        int total = adminService.countSelective(username, page, limit, sort, order);
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("items", adminList);

        return ResponseUtil.ok(data);
    }

    @PostMapping("/create")
    public Object create(@LoginAdmin Integer adminId, @RequestBody sotwoAdmin admin){
        if(adminId == null){
            return ResponseUtil.unlogin();
        }

        String rawPassword = admin.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(rawPassword);
        admin.setPassword(encodedPassword);

        adminService.add(admin);
        return ResponseUtil.ok(admin);
    }

    @GetMapping("/read")
    public Object read(@LoginAdmin Integer adminId, Integer id){
        if(adminId == null){
            return ResponseUtil.unlogin();
        }

        if(id == null){
            return ResponseUtil.badArgument();
        }

        sotwoAdmin admin = adminService.findById(id);
        return ResponseUtil.ok(admin);
    }

    @PostMapping("/update")
    public Object update(@LoginAdmin Integer adminId, @RequestBody sotwoAdmin admin){
        if(adminId == null){
            return ResponseUtil.unlogin();
        }

        Integer anotherAdminId = admin.getId();
        if(anotherAdminId.intValue() == 1){
            return ResponseUtil.fail(403, "超级管理员不能修改");
        }

        adminService.updateById(admin);
        return ResponseUtil.ok(admin);
    }

    @PostMapping("/delete")
    public Object delete(@LoginAdmin Integer adminId, @RequestBody sotwoAdmin admin){
        if(adminId == null){
            return ResponseUtil.unlogin();
        }

        Integer anotherAdminId = admin.getId();
        if(anotherAdminId.intValue() == 1){
            return ResponseUtil.fail(403, "超级管理员不能删除");
        }
        adminService.deleteById(anotherAdminId);
        return ResponseUtil.ok();
    }
}