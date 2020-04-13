using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
//添加命名空间
using System.Data.Entity;

namespace MvcMusicStore.Models
{
    public class MusicStoreEntities:DbContext
    {
        public DbSet<Album> Albums { get; set; }
        public DbSet<Genre> Genres { get; set; }
        public DbSet<Artist> Artists { get; set; }
        public DbSet<Cart> Carts { get; set; }
        public DbSet<Order> Order { get; set; }
        public DbSet<OrderDetail> OrderDetail { get; set; }

    }
}