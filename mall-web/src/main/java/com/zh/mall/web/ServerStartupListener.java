package com.zh.mall.web;

import com.mall.manager.api.service.GoodsCategoryService;
import com.mall.portal.api.service.GoodsService;
import com.zh.mall.common.bean.Goods;
import com.zh.mall.common.bean.GoodsCategory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerStartupListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 获取web应用对象
        ServletContext application = sce.getServletContext();

        // 获取当前的上下文路径
        String path = application.getContextPath();

        // 保存路径到web应用范围中，让所有的用户访问
        application.setAttribute("APP_PATH", path);

        // 查询热点数据
        // 获取项目分类信息
        // 获取项目信息
        // 组合项目和分类的关系

        // 获取Spring环境对象
        ApplicationContext context =
                (ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);

        //WebApplicationContextUtils.getWebApplicationContext(application);

        GoodsCategoryService service = context.getBean(GoodsCategoryService.class);
        List<GoodsCategory> gcs = service.queryAll();
        Map<Integer, GoodsCategory> gcMap = new HashMap<Integer, GoodsCategory>();
        for ( GoodsCategory gc : gcs ) {
            gcMap.put(gc.getId(), gc);
        }

        GoodsService goodsService = context.getBean(GoodsService.class);
        List<Goods> goodsDatas = goodsService.queryAll();
        for ( Goods goods : goodsDatas ) {
            int cid = goods.getCategoryid();
            GoodsCategory gc = gcMap.get(cid);
            gc.getGoodsDatas().add(goods);
        }

        application.setAttribute("APP_GCS", gcs);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
