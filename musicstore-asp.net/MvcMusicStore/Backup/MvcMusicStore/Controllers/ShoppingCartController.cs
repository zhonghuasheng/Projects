using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
//添加命名空间
using MvcMusicStore.Models;
using MvcMusicStore.ViewModels;

namespace MvcMusicStore.Controllers
{
    public class ShoppingCartController : Controller
    {
        
        MusicStoreEntities storeDB = new MusicStoreEntities();
        public ActionResult Index()
        {
            var cart = ShoppingCart.GetCart(this.HttpContext);
            var viewModel = new ShoppingCartViewModel 
            {
                CartItems=cart.GetCartItems(),
                CartTotal=cart.GetTotal()
            };
            return View(viewModel);
        }
        //将商品添加到购物车
        public ActionResult AddToCart(int id)
        {
            var addedAlbum = storeDB.Albums.Single(album=>album.AlbumId==id);
            var cart = ShoppingCart.GetCart(this.HttpContext);
            cart.AddToCart(addedAlbum);
            return RedirectToAction("Index");
        }
        //将存在的商品从购物车中移除
        [HttpPost]
        public ActionResult RemoveFromCart(int id)
        {
            var cart = ShoppingCart.GetCart(this.HttpContext);
            string albumName = storeDB.Carts.Single(item=>item.RecondId==id).Album.Title;
            int itemCount = cart.RemoveFromCart(id);
            var results = new ShoppingCartRemoveViewModel 
            {
                Message=Server.HtmlEncode(albumName)+"已经从你的购物车中移除",
                CartTotal=cart.GetTotal(),
                CartCount=cart.GetCount(),
                ItemCount=itemCount,
                DeleteId=id
            };
            return Json(results);
        }

        //该操作作为子操作来进行
        [ChildActionOnly]
        public ActionResult CartSummary()
        {
            var cart = ShoppingCart.GetCart(this.HttpContext);
            ViewData["CartCount"] = cart.GetCount();
            return PartialView("CartSummary");
        }

    }
}
