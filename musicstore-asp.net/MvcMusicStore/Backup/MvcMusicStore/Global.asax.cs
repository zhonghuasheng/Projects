using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace MvcMusicStore
{
    // 注意: 有关启用 IIS6 或 IIS7 经典模式的说明，
    // 请访问 http://go.microsoft.com/?LinkId=9394801

    public class MvcApplication : System.Web.HttpApplication
    {
        public static void RegisterGlobalFilters(GlobalFilterCollection filters)
        {
            filters.Add(new HandleErrorAttribute());
        }

        public static void RegisterRoutes(RouteCollection routes)
        {
            routes.IgnoreRoute("{resource}.axd/{*pathInfo}");

            routes.MapRoute(
                "Default", // 路由名称--默认路由配置
                "{controller}/{action}/{id}", // 带有参数的 URL--第一部分是控制器，如果没有提供的话，默认是home，第二部分是Action方法，如果没有提供的话，默认是Index，第三部分是id，通常用来提供数据的标识，没有默认值。
                new { controller = "Home", action = "Index", id = UrlParameter.Optional } // 参数默认值
                //
            );

        }
        //cy-一般用来进行网站的初始化
        protected void Application_Start()
        {
            //初始化数据
            System.Data.Entity.Database.SetInitializer(new MvcMusicStore.Models.SampleData());
            AreaRegistration.RegisterAllAreas();
            RegisterGlobalFilters(GlobalFilters.Filters);
            RegisterRoutes(RouteTable.Routes);
        }
    }
}