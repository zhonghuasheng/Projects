using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
//添加命名空间
using MvcMusicStore.Models;

namespace MvcMusicStore.Controllers
{
    public class StoreController : Controller
    {
        #region 注释掉的代码-这些都是测试用的
        //public string Index()
        //{
        //    return "你好-此页面来自Store.Index()";
        //}
        //封装一个操作方法的结果并用于代表该操作方法执行框架级操作。
        //public string Browse(string genre)
        //{
        //    //这里使用HttpUtility.HtmlEncode方法来处理用户的输入，这样可以防止用户的脚本注入攻击
        //    string message = HttpUtility.HtmlEncode("Store.Browse,genre="+genre);
        //    return message;
        //} 
        #endregion
        MusicStoreEntities storeDB = new MusicStoreEntities();
        public ActionResult Index()
        {
            #region 测试数据代码
            //var genres = new List<Genre>
            //{
            //    new Genre{Name="中国风"},
            //    new Genre{Name="伤感怀旧"},
            //    new Genre{Name="流行新曲"}
            //    return View(genres);
            //}; 
            #endregion
            var genres = storeDB.Genres.ToList();
            return View(genres);
        }

            #region 注释代码
        //public ActionResult Browse(string genre)
        //{
        //    var genreModel = new Genre { Name=genre};
        //    return View(genreModel);
        //} 
        #endregion
        public ActionResult Browse(string genre)
        {
            //获取专辑名称
            var genreModel = storeDB.Genres.Include("Albums").Single(g=>g.Name==genre);
            return View(genreModel);
        }
        //返回详细信息，但是这里返回没有啊，报错！！！ 在浏览器中重定向到store/details
        public ActionResult Details(int id)
        {
            var album = storeDB.Albums.Find(id);
            return View(album);
        }
        [ChildActionOnly]
        public ActionResult GenreMenu()
        {
            //获取年代分类列表
            var genres = storeDB.Genres.ToList();
            //返回年代分类的列表，用于在视图中生成菜单
            return PartialView(genres);
        }
    }
}
