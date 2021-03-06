package org.myoranges.sotwo.admin.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.myoranges.sotwo.admin.annotation.LoginAdmin;
import org.myoranges.sotwo.core.util.ResponseUtil;
import org.myoranges.sotwo.db.domain.SotwoCategory;
import org.myoranges.sotwo.db.service.SotwoCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {
    private final Log logger = LogFactory.getLog(CategoryController.class);

    @Autowired
    private SotwoCategoryService categoryService;

    @GetMapping("/list")
    public Object list(
                       String id, String name,
                       @RequestParam(value = "page", defaultValue = "1") Integer page,
                       @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                       String sort, String order){
        List<SotwoCategory> collectList = categoryService.querySelective(id, name, page, limit, sort, order);
        int total = categoryService.countSelective(id, name, page, limit, sort, order);
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("items", collectList);

        return ResponseUtil.ok(data);
    }

    @PostMapping("/create")
    public Object create(@LoginAdmin Integer adminId, @RequestBody SotwoCategory category){
        if(adminId == null){
            return ResponseUtil.unlogin();
        }
        categoryService.add(category);
        return ResponseUtil.ok();
    }

    @GetMapping("/read")
    public Object read(@LoginAdmin Integer adminId, Integer id){
        if(adminId == null){
            return ResponseUtil.unlogin();
        }

        if(id == null){
            return ResponseUtil.badArgument();
        }

        SotwoCategory category = categoryService.findById(id);
        return ResponseUtil.ok(category);
    }

    @PostMapping("/update")
    public Object update(@LoginAdmin Integer adminId, @RequestBody SotwoCategory category){
        if(adminId == null){
            return ResponseUtil.unlogin();
        }
        categoryService.updateById(category);
        return ResponseUtil.ok();
    }

    @PostMapping("/delete")
    public Object delete(@LoginAdmin Integer adminId, @RequestBody SotwoCategory category){
        if(adminId == null){
            return ResponseUtil.unlogin();
        }
        categoryService.deleteById(category.getId());
        return ResponseUtil.ok();
    }

    @GetMapping("/l1")
    public Object catL1(@LoginAdmin Integer adminId) {
        if (adminId == null) {
            return ResponseUtil.unlogin();
        }

        // 所有一级分类目录
        List<SotwoCategory> l1CatList = categoryService.queryL1();
        HashMap<Integer, String> data = new HashMap<>(l1CatList.size());
        for(SotwoCategory category : l1CatList){
            data.put(category.getId(), category.getName());
        }
        return ResponseUtil.ok(data);
    }

}
