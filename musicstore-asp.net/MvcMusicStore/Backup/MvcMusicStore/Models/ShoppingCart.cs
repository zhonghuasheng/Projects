using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MvcMusicStore.Models
{
    public class ShoppingCart
    {
        //创建上下文对象
        MusicStoreEntities storeDB = new MusicStoreEntities();
        //设置ShoppingCartId属性
        string ShoppingCartId { get; set; }
        //设置全局变量，用于记录CartId的值，这里好像是该表的主键
        public const string CartSessionKey = "CartId";
        //取得购物车
        public static ShoppingCart GetCart(HttpContextBase context)
        {
            var cart = new ShoppingCart();
            cart.ShoppingCartId = cart.GetCartId(context);
            return cart;
        }
        //登录之后的购物车CartId
        public static ShoppingCart GetCart(Controller controller)
        {
            return GetCart(controller.HttpContext);
        }
        //实现生成GetCartId
        public string GetCartId(HttpContextBase context)
        {
            if (context.Session[CartSessionKey] == null)
            {
                if (!string.IsNullOrWhiteSpace(context.User.Identity.Name))
                {
                    context.Session[CartSessionKey] = context.User.Identity.Name;
                }
                else
                {
                    //生成全局唯一标识符作为CartId
                    Guid tempCartId = Guid.NewGuid();
                    context.Session[CartSessionKey] = tempCartId.ToString();
                }
            }
            return context.Session[CartSessionKey].ToString();
        }
        //添加到购物车
        public void AddToCart(Album album)
        {
            //购物车中是否存在该商品
            var cartItem = storeDB.Carts.SingleOrDefault(c=>c.CartId==ShoppingCartId&&c.AlbumId==album.AlbumId);
            if (cartItem == null)
            {
                cartItem = new Cart
                {
                    AlbumId = album.AlbumId,
                    CartId = ShoppingCartId,
                    Count = 1,
                    DateCreated = DateTime.Now
                };
                storeDB.Carts.Add(cartItem);
            }
            else
            {
                cartItem.Count++;
            }
            storeDB.SaveChanges();
        }
        //将商品从购物车中移除
        public int RemoveFromCart(int id)
        {
            //判断购物车中是否存在该商品
            var cartItem = storeDB.Carts.Single(cart=>cart.CartId==ShoppingCartId&&cart.RecondId==id);
            int itemCount = 0;
            if (cartItem != null)
            {
                if (cartItem.Count > 1)
                {
                    cartItem.Count--;
                    itemCount = cartItem.Count;
                }
                else
                {
                    storeDB.Carts.Remove(cartItem);
                }
                storeDB.SaveChanges();
            }
            return itemCount;
        }
        //清空购物车
        public void EmptyCart()
        {
            var cartItems = storeDB.Carts.Where(cart => cart.CartId == ShoppingCartId);
            foreach (var cartItem in cartItems)
            {
                storeDB.Carts.Remove(cartItem);
            }
            storeDB.SaveChanges();
        }
        //获取购物车中的详细信息
        public List<Cart> GetCartItems()
        {
            return storeDB.Carts.Where(cart=>cart.CartId==ShoppingCartId).ToList();
        }
        //获取购物数量
        public int GetCount()
        {
            int? count = (from cartItems in storeDB.Carts
                          where cartItems.CartId == ShoppingCartId
                          select (int?)cartItems.Count).Sum();
            return count ?? 0;
        }
        //获取总价
        public decimal GetTotal()
        {
            decimal? total = (from cartItems in storeDB.Carts
                              where cartItems.CartId == ShoppingCartId
                              select (int?)cartItems.Count * cartItems.Album.Price).Sum();
            return total ?? decimal.Zero;
        }

        public int CreateOrder(Order order)
        {
            decimal orderTotal = 0;
            var cartItems = GetCartItems();
            foreach (var item in cartItems)
            {
                var orderDetail = new OrderDetail 
                {
                    AlbumId=item.AlbumId,
                    OrderId=order.OrderId,
                    UnitPrice=item.Album.Price,
                    Quantity=item.Count
                };
                orderTotal += (item.Count * item.Album.Price);
                storeDB.OrderDetail.Add(orderDetail);
            }
            order.Total = orderTotal;
            storeDB.SaveChanges();
            EmptyCart();
            return order.OrderId;
        }

        public void MigrateCart(string userName)
        {
            var shoppingCart = storeDB.Carts.Where(c=>c.CartId==ShoppingCartId);
            foreach (Cart item in shoppingCart)
            {
                item.CartId = userName;
            }
            storeDB.SaveChanges();
        }
    }
}