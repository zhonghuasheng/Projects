using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
//添加命名空间
using MvcMusicStore.Models;

namespace MvcMusicStore.Controllers
{
    public class HomeController : Controller
    {
        MusicStoreEntities storeDB = new MusicStoreEntities();
        public ActionResult Index()//这些Action的作用就是处理请求
        {
            var albums = GetTopSellingAlbums(5);
            return View(albums);
        }

        /// <summary>
        /// 获得销售前count名的专辑
        /// </summary>
        /// <param name="count">数量</param>
        /// <returns></returns>
        public List<Album> GetTopSellingAlbums(int count)
        {
            return storeDB.Albums
                   .OrderByDescending(a => a.OrderDetails.Count())
                   .Take(count)
                   .ToList();
        }
    }
}
