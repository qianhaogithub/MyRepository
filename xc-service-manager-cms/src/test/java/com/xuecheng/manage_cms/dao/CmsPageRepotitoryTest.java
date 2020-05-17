package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * @author qianhao
 * @create 2020/5/10-22:30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepotitoryTest {

    @Autowired
    private CmsPageRepository cmsPageRepository;

    @Test
    public void testFindAll() {
        List<CmsPage> all = cmsPageRepository.findAll();
        System.out.println(all);
    }

    @Test
    public void testFindPage() {
        //分页参数
        int page = 1;//从0开始
        int size = 10;
        Pageable pageable = PageRequest.of(page,size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println(all);

    }

    @Test
    public void testUpdate() {
        Optional<CmsPage> byId = cmsPageRepository.findById("5abefd525b05aa293098fca6");
        if(byId.isPresent()) {
            CmsPage cmsPage = byId.get();
            cmsPage.setPageAliase("test01");

            cmsPageRepository.save(cmsPage);
        }
    }
}
