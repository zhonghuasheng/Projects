using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
//添加命名空间
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Web.Mvc;

namespace MvcMusicStore.Models
{
    /// <summary>
    /// 艺术家类
    /// </summary>
    public class Artist
    {
        [DisplayName("艺术家")]
        public int ArtistId { get; set; }
        public string Name { get; set; }
    }
}