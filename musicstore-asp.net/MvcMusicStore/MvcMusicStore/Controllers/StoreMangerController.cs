using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using MvcMusicStore.Models;
using System.Data;
using System.Data.Entity;

namespace MvcMusicStore.Controllers
{
    //设置用户角色，只有用户是Administrator时才能登陆
    [Authorize(Roles="Administrator")]
    public class StoreMangerController : Controller
    {
        MvcMusicStore.Models.MusicStoreEntities storeDB = new Models.MusicStoreEntities();
        public ActionResult Index()
        {
            var albums = storeDB.Albums.Include("Genre").Include("Artist");
            return View(albums.ToList());
        }
        //返回详细信息
        public ActionResult Details(int id)
        {
            MvcMusicStore.Models.Album album = storeDB.Albums.Find(id);
            return View(album);
        }
        //创建新的专辑类型
        public ActionResult Create()
        {
            ViewBag.GenreId = new SelectList(storeDB.Genres,"GenreId","Name");
            ViewBag.ArtistId = new SelectList(storeDB.Artists, "ArtistId", "Name");
            return View();
        } 
        //处理用户请求
        [HttpPost]
        public ActionResult Create(Album album)
        {
            try
            {
                // TODO: Add insert logic here
                if (ModelState.IsValid)
                {
                    storeDB.Albums.Add(album);
                    storeDB.SaveChanges();
                    return RedirectToAction("Index");
                }
                ViewBag.GenreId = new SelectList(storeDB.Genres,"GenreId","Name",album.GenreId);
                ViewBag.ArtistId = new SelectList(storeDB.Artists, "ArtistId", "Name", album.ArtistId);
                return View(album);
            }
            catch
            {
                return View();
            }
        }
        //编辑
        public ActionResult Edit(int id)
        {
            MvcMusicStore.Models.Album album = storeDB.Albums.Find(id);
            ViewBag.GenreId = new SelectList(storeDB.Genres,"GenreId","Name",album.GenreId);
            ViewBag.ArtistId = new SelectList(storeDB.Artists, "ArtistId", "Name", album.ArtistId);
            return View(album);
        }

        [HttpPost]  //当请求类型为Post的时候由此方法处理请求
        public ActionResult Edit(Album album)
        {
            if (ModelState.IsValid)
            {
                storeDB.Entry(album).State = System.Data.EntityState.Modified;//这个要添加引用
                storeDB.SaveChanges();
                //重定向制定到Index()方法
                return RedirectToAction("Index");
            }
            ViewBag.GemreId = new SelectList(storeDB.Genres,"GenreId","Name",album.GenreId);
            ViewBag.ArtistId = new SelectList(storeDB.Artists, "ArtistId", "Name", album.ArtistId);
            return View(album);
        }

        /// <summary>
        /// 删除操作
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public ActionResult Delete(int id)
        {
            MvcMusicStore.Models.Album album = storeDB.Albums.Find(id);
            return View(album);
        }
        
        //处理用户发送的请求的删除操作
        [HttpPost,ActionName("Delete")]
        public ActionResult DeleteConfirmed(int id)
        {
            try
            {
                MvcMusicStore.Models.Album album = storeDB.Albums.Find(id);
                storeDB.Albums.Remove(album);
                storeDB.SaveChanges();
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
