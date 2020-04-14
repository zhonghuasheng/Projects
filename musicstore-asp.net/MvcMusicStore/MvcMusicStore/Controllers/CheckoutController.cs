using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
//添加命名空间
using MvcMusicStore.Models;

namespace MvcMusicStore.Controllers
{
    //授权标注[Authorize]，用户在登录之后才能访问
    [Authorize]
    public class CheckoutController : Controller
    {
        MusicStoreEntities storeDB = new MusicStoreEntities();
        const string PromoCode = "FREE";
        //用来显示用户输入的信息表单
        public ActionResult AddressAndPayment()
        {
            return View();
        }

        //验证用户输入，处理订单
        [HttpPost]
        public ActionResult AddressAndPayment(FormCollection vaules)
        {
            var order = new Order();
            //更新模型实例
            TryUpdateModel(order);
            try
            {
                //在忽略大小写的情况下
                if (string.Equals(vaules["PromoCode"], PromoCode, StringComparison.OrdinalIgnoreCase) == false)
                {
                    return View(order);
                }
                else
                {
                    order.UserName = User.Identity.Name;
                    order.OrderDate = DateTime.Now;
                    //保存订单信息
                    storeDB.Order.Add(order);
                    storeDB.SaveChanges();
                    //处理订单
                    var cart = ShoppingCart.GetCart(this.HttpContext);
                    cart.CreateOrder(order);
                    return RedirectToAction("Complete", new { id=order.OrderId});
                }
            }
            catch
            {
                return View(order);
            }
        }

        //
        public ActionResult Complete(int id)
        {
            //检查当前订单是否属于当前用户
            bool isValid = storeDB.Order.Any(p=>p.OrderId==id&&User.Identity.Name==p.UserName);
            if (isValid)
            {
                return View(id);
            }
            else
            {
                //返回错误视图
                return View("Error");
            }
        }
    }
}
